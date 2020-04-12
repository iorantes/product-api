package com.test.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.dto.UserDTO;
import com.test.products.model.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/saveusers")
	public ResponseEntity<?> saveUsers(@RequestBody UserDTO usuaInfo) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.saveUser(usuaInfo);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getallusers")
	public ResponseEntity<?> getUsers(@RequestParam Integer page, @RequestParam Integer size) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.getUser(page, size);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/putusers")
	public ResponseEntity<?> putUsers(@RequestBody UserDTO usuaInfo, @RequestParam Long userId) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.putUser(usuaInfo, userId);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/deleteusers")
	public ResponseEntity<?> deleteUsers(@RequestParam Long userId) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.deleteUser(userId);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/resetpwd")
	public ResponseEntity<?> resetPass(@RequestParam String userName) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.resetPWD(userName);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
