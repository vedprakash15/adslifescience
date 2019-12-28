package com.august.v1.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "guestchild")
public class GuestChildEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2336297059236701708L;

	@Id
	@Column(name = "ChildId")
	private Long id;
	
	@Column(name = "ChildName")
	private String childName;
	
	@Column(name = "email")
	private String emailId;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "approvalStatus")
	private String approvalStatus;
	
}
