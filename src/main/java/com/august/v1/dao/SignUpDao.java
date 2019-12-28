package com.august.v1.dao;

import com.august.v1.domain.entity.UserEntity;
import com.august.v1.domain.response.dto.UserSignUpResponse;

public interface SignUpDao {
	public UserSignUpResponse saveUser(UserEntity userEntity);
}
