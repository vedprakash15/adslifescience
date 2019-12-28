package com.august.v1.service;

import com.august.v1.domain.User;
import com.august.v1.domain.response.dto.UserSignUpResponse;


public interface SignUpService {
	public UserSignUpResponse signup(User user);
}
