package com.sqad1.ecommers.service;

import com.sqad1.ecommers.dto.ResponseMessageDto;
import com.sqad1.ecommers.dto.UserDto;

public interface UserService {
	ResponseMessageDto login(UserDto userDto);

}
