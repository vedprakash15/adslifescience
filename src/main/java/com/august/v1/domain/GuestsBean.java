package com.august.v1.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GuestsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8169236381139999147L;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date regDate;
}
