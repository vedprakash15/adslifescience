package com.august.v1.domain.request.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1417527503028528492L;

	private int id;
	
	private String name;
	
	private String pwd;
	
	private String email;

}
