package com.test.products.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CODE_OK = "00";
	public static final String MSG_OK = "Operacion Realizada con Exito";

	public static final String CODE_FATAL = "99";
	public static final String MSG_FATAL = "Procesamiento Incorrecto";

	private String code;
	private String message;
	private Object response;

	public AbstractResponseDTO() {
		super();
	}
	
	public AbstractResponseDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public AbstractResponseDTO(String code, String message, Object response) {
		super();
		this.code = code;
		this.message = message;
		this.response = response;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
