package com.test.products.model.dto;

public class ResponseDTO extends AbstractResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CODE_MAIL_EXIST = "01";
	public static final String MSG_MAIL_EXIST = "Correo ya registrado";

	public static final String CODE_USER_EXIST = "02";
	public static final String MSG_USER_EXIST = "Usuario ya registrado";
	
	public static final String CODE_USER_NOTFOUND = "03";
	public static final String MSG_USER_NOTFOUND = "Usuario no existe";
	
	public static final String CODE_RESET_PWD = "04";
	public static final String MSG_RESET_PWD = "Tiempo de reinicio de contraseña exedido";

	public ResponseDTO() {
	}

	public ResponseDTO(String code, String message) {
		super(code, message);
	}

	public ResponseDTO(String code, String message, Object errors, Object response) {
		super(code, message, response);
	};
}
