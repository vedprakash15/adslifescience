package com.august.v1.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "GuestServent")
@Data
@NoArgsConstructor
public class ServentEntityBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4253136326382477817L;

	@Id
	@Column(name = "ServentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ServentName")
	private String name;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="age")
	private Integer age;
	
	@Column(name ="approvalStatus")
	private String aprrovalStatus;
}
