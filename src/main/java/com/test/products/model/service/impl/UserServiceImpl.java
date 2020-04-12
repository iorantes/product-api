package com.test.products.model.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.dto.UserDTO;
import com.test.products.model.entity.Template;
import com.test.products.model.entity.User;
import com.test.products.model.repository.TemplateRepository;
import com.test.products.model.repository.UserRepository;
import com.test.products.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepo;

	@Autowired
	TemplateRepository templateRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.pwd.encrypt}")
	private String pwdEncrypt;

	@Value("${smtp.template}")
	private String smtpTemplate;
	
	@Value("${reset.mins}")
	private Integer resetMins;

	@Override
	public ResponseDTO saveUser(UserDTO usuaInfo) {

		ResponseDTO response = new ResponseDTO();

		try {

			User usua = new User();
			usua = userRepo.findByUserNick(usuaInfo.getNick());
			if (null != usua) {
				logger.info("Obteniendo usuario registrado");
				response = new ResponseDTO(ResponseDTO.CODE_USER_EXIST, ResponseDTO.MSG_USER_EXIST);
			} else {
				usua = userRepo.findByMail(usuaInfo.getMail());
				if (null != usua) {
					response = new ResponseDTO(ResponseDTO.CODE_MAIL_EXIST, ResponseDTO.MSG_MAIL_EXIST);
				} else {

					Date bornDate = new SimpleDateFormat("dd-MM-yyyy").parse(usuaInfo.getBornDate());

					usua = new User(null, usuaInfo.getName(), usuaInfo.getTel(), usuaInfo.getNick(), bornDate,
							usuaInfo.getMail(), pwdEncrypt + BCrypt.hashpw(usuaInfo.getPwd(), BCrypt.gensalt(12)), 1,
							null, usuaInfo.getRol());
					userRepo.save(usua);
					logger.info("Usuario guardado");
					response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK, null, null);
				}
			}
		} catch (Exception e) {
			logger.error("Error al guardar Usuario", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL, e.getCause(), null);
		}
		return response;
	}

	@Override
	public ResponseDTO getUser(Integer page, Integer size) {
		ResponseDTO response = new ResponseDTO();

		try {
			Pageable firstPageWithTwoElements = PageRequest.of((page - 1), size);
			Page<User> usua = userRepo.findAll(firstPageWithTwoElements);
			logger.info("Obteniendo la lista plegable de Usuarios");
			response.setCode(ResponseDTO.CODE_OK);
			response.setMessage(ResponseDTO.MSG_OK);
			response.setResponse(usua);
			return response;
		} catch (Exception e) {
			logger.error("Error obteniendo la lista de usuarios", e);
			return response;
		}
	}

	@Override
	public ResponseDTO deleteUser(Long userId) {
		ResponseDTO response = new ResponseDTO();

		try {

			User usua = new User();
			usua = userRepo.findById(userId).orElse(null);
			if (null != usua) {
				logger.info("Procediendo a eliminacion del usuario");
				usua.setUserActive(0);
				userRepo.save(usua);
				logger.info("Usuario eliminado");
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);
			} else {
				response = new ResponseDTO(ResponseDTO.CODE_USER_NOTFOUND, ResponseDTO.MSG_USER_NOTFOUND);
			}
		} catch (Exception e) {
			logger.error("Error al eliminar Usuario");
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO putUser(UserDTO usuaInfo, Long userId) {
		ResponseDTO response = new ResponseDTO();

		try {

			User usua = new User();
			usua = userRepo.findById(userId).orElse(null);
			if (null != usua) {
				logger.info("Obteniendo usuario registrado");

				Date bornDate = new SimpleDateFormat("dd-MM-yyyy").parse(usuaInfo.getBornDate());

				usua.setUserBornDate(bornDate);
				usua.setUserMail(usuaInfo.getMail());
				usua.setUserNick(usuaInfo.getNick());
				usua.setUserNomb(usuaInfo.getName());
				usua.setUserPWD(pwdEncrypt + BCrypt.hashpw(usuaInfo.getPwd(), BCrypt.gensalt(12)));
				usua.setUserTel(usuaInfo.getTel());
				usua.setUserActive(usuaInfo.getActive());
				userRepo.save(usua);
				logger.info("Usuario actualizado");
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);
			} else {
				response = new ResponseDTO(ResponseDTO.CODE_USER_NOTFOUND, ResponseDTO.MSG_USER_NOTFOUND);
			}
		} catch (Exception e) {
			logger.error("Error al guardar Usuario");
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO resetPWD(String userName) {

		ResponseDTO response = new ResponseDTO();

		try {
			User usua = new User();
			usua = userRepo.findByUserNick(userName);
			if (null != usua) {
				logger.info("Obteniendo Template para mandar correo");
				Template template = new Template();
				template = templateRepo.findTemplateByIden(smtpTemplate);
				String replaceLink=template.getTemplateBody().replaceFirst("\\{link\\}","resetpws/"+userName);
				
				String replaceUserName=replaceLink.replaceFirst("\\{userName\\}",userName);
				
				MimeMessage msg = javaMailSender.createMimeMessage();

				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(usua.getUserMail());
				helper.setFrom("irvinldt@gmail.com");

				helper.setSubject("Reset contraseña");

				helper.setText(replaceUserName, true);

				javaMailSender.send(msg);
				usua.setUserReset(new Date());
				userRepo.save(usua);
				logger.info("Guardando fecha para reinicio de correo");
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);

			} else {
				logger.info("Usuario no existe");
				response = new ResponseDTO(ResponseDTO.CODE_USER_NOTFOUND, ResponseDTO.MSG_USER_NOTFOUND);
			}
		} catch (Exception e) {
			logger.error("Error al resetear PWD del usuario", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL, e, null);
		}
		return response;
	}

	@Override
	public ResponseDTO resetPWD(String userName, String pwd) {
		
		ResponseDTO response = new ResponseDTO();
		
		try {
			User usua = new User();
			usua = userRepo.findByUserNick(userName);
			logger.info("Obteniendo la informacion del usuario");
			
			int minutes = (int)(((new Date().getTime()/60000) - usua.getUserReset().getTime()/60000));
			if (resetMins >= minutes) {
				logger.info("Procediendo a colocar la nueva contraseña");
				usua.setUserPWD(pwdEncrypt + BCrypt.hashpw(pwd, BCrypt.gensalt(12)));
				userRepo.save(usua);
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);
			}
			else {
				logger.info("Tiempo limite para reinicio de contraseña sobrepasado");
				response = new ResponseDTO(ResponseDTO.CODE_RESET_PWD, ResponseDTO.MSG_RESET_PWD);
			}
		} catch (Exception e) {
			logger.error("Error al reiniciar la contraseña", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		
		return response;
	}

}
