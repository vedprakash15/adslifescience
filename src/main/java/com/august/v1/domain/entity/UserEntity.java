package com.august.v1.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.august.v1.domain.request.dto.UserRoleType;

import lombok.Data;

@Data
@Entity
@Table(name="USER")
public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6415040024537224483L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="USER_ID")
	private Integer userId;
	
	@Column(name ="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private Long phone;
	
	@Column(name = "USER_ROLE")
	private UserRoleType userRoleType;
	
}
