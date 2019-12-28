package com.august.v1.service.impl;

import org.springframework.stereotype.Service;

import com.august.v1.domain.User;
import com.august.v1.domain.response.dto.UserSignUpResponse;
import com.august.v1.service.SignUpService;
@Service("SignUpService")
public class SignUpServiceImpl implements SignUpService{

	@Override
	public UserSignUpResponse signup(User user) {
		System.out.println("Inside Serivice Impl");
		System.out.println(user.toString());
		return null;
	}

}
