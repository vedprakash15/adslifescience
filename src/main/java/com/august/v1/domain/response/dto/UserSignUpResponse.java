package com.august.v1.domain.response.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignUpResponse {
	private Integer userId;
	
	private String statusCode;
	
	
}
