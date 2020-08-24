package com.sqad1.ecommers.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sqad1.ecommers.dto.ResponseMessageDto;
import com.sqad1.ecommers.dto.UserDto;
import com.sqad1.ecommers.entity.User;
import com.sqad1.ecommers.exception.UserNotfoundException;
import com.sqad1.ecommers.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserServiceImplTest {
	@InjectMocks
	UserServiceImpl userServiceImpl;
	@Mock
	UserRepository userRepository;
	@Test(expected = UserNotfoundException.class)
	public void testFindByEmailAndPasswordForException() throws UserNotfoundException {
		User user = new User();
		UserDto userDto = new UserDto();
		userDto.setPassword("srivalli");
		Mockito.when(userRepository.findByEmailAndPassword((String) "sri", "srivallik")).thenReturn(user);
		ResponseMessageDto user1 = userServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("sri", user1.getMessage());

	}
	@Test(expected = UserNotfoundException.class)
	public void testFindByEmailAndPasswordForException1() throws UserNotfoundException {
		User user = new User();

		UserDto userDto = new UserDto();
		userDto.setPassword("srivalli");

		Mockito.when(userRepository.findByEmailAndPassword((String) "srivalli", "srivallik")).thenReturn(user);
		ResponseMessageDto user1 = userServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("srivalli", user1.getMessage());

	}



}
