package com.test.products.model.service;

import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.dto.UserDTO;

public interface UserService {

	public ResponseDTO saveUser(UserDTO usuaInfo);

	public ResponseDTO putUser(UserDTO usuaInfo, Long userId);

	public ResponseDTO getUser(Integer page, Integer size);

	public ResponseDTO deleteUser(Long userId);

	public ResponseDTO resetPWD(String userName);
	
	public ResponseDTO resetPWD(String userName, String pwd);

}
