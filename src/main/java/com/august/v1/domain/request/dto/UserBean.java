package com.august.v1.domain.request.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBean implements Serializable{	

	private String username;
	
	private String email;

}
