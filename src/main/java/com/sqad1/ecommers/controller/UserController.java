package com.sqad1.ecommers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqad1.ecommers.dto.ResponseMessageDto;
import com.sqad1.ecommers.dto.UserDto;
import com.sqad1.ecommers.service.UserServiceImpl;



@RestController
@RequestMapping("/users")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("/login")
	public ResponseEntity<ResponseMessageDto> login(@RequestBody UserDto userDto)  {
		logger.info("<<------------In login Method------------>>");
		ResponseMessageDto	responseMessageDto=	userServiceImpl.login(userDto);
	    return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);

	}



}
