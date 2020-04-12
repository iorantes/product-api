package com.test.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.service.UserService;

@RestController
@RequestMapping(value = "/pass")
public class PassController {
	
	static final Logger logger = LoggerFactory.getLogger(PassController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/resetpwd")
	public ResponseEntity<?> resetPass(@RequestParam String userName, @RequestParam String pwd) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = userService.resetPWD(userName, pwd);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
