package com.sqad1.ecommers.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sqad1.ecommers.dto.ResponseMessageDto;
import com.sqad1.ecommers.dto.UserDto;
import com.sqad1.ecommers.entity.User;
import com.sqad1.ecommers.exception.UserNotfoundException;
import com.sqad1.ecommers.service.UserServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserControllerTest {
	@InjectMocks
	UserController userController;
	@Mock
	UserServiceImpl userServiceImpl;
	@Test
	public void testFindByUserNameAndPasswordForPositive() throws UserNotfoundException {
		ResponseMessageDto userLogin = new ResponseMessageDto();
		UserDto userDto = new UserDto();
		Mockito.when(userServiceImpl.login(userDto)).thenReturn(userLogin);
		ResponseEntity<ResponseMessageDto> user1 = userController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());

	}

	@Test
	public void testFindByCustomerIdAndPasswordForNegative() throws UserNotfoundException {
		User userLogn = new User();
		UserDto userDto = new UserDto();
		ResponseMessageDto userLogin = new ResponseMessageDto();
		Mockito.when(userServiceImpl.login(userDto)).thenReturn(userLogin);
		ResponseEntity<ResponseMessageDto> user1 = userController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());

	}



	

}
