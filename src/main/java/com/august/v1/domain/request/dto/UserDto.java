package com.august.v1.domain.request.dto;

import lombok.Data;

@Data
public class UserDto {
	private String userName;
	
	private String password;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Long phone;
	
	private UserRoleType userRoleType;
}
