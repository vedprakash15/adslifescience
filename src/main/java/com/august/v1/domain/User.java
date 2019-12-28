package com.august.v1.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private Long id;
	
	private String name;
	
	private String password;
	
	private String email;
}
