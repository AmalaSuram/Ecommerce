package com.sqad1.ecommers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqad1.ecommers.dto.ResponseMessageDto;
import com.sqad1.ecommers.dto.UserDto;
import com.sqad1.ecommers.entity.User;
import com.sqad1.ecommers.exception.UserNotfoundException;
import com.sqad1.ecommers.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseMessageDto login(UserDto userDto) {
		User login = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if (login==null) {
			throw new UserNotfoundException("User doesnot exists");
		}
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setMessage("user Logged in Sucessfully");
        return responseMessageDto;
		
	}

}
