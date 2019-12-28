package com.august.v1.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;

import com.august.v1.dao.AbstractDao;
import com.august.v1.dao.SignUpDao;
import com.august.v1.domain.entity.UserEntity;
import com.august.v1.domain.response.dto.UserSignUpResponse;

public class SignUpDaoImpl extends AbstractDao<Serializable, SignUpDaoImpl> implements SignUpDao {

	@Override
	public UserSignUpResponse saveUser(UserEntity userEntity) {
		Session session = null;
		Integer userId = null;
		String statusCode = null;

		UserSignUpResponse response = new UserSignUpResponse();
		try {
			session = getSession();
			if (userEntity != null) {
				userId = (Integer) session.save(userEntity);
				response.setUserId(userId);
				response.setStatusCode("200");
				return response;
			} else {
				response.setUserId(null);
				response.setStatusCode("500");
				throw new Exception("user data null");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return response;

	}

}
