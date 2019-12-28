package com.august.v1.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "myguests")
public class GuestEntityBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1174092805810749364L;

	@Id
	@Column(name = "ParentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "firstName")
    private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "reg_date")
	private Date regDate;
	
	@Column(name = "VerifyStatus")
	private String VerifyStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ParentId")
	private List<GuestChildEntity> guestChildEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ParentId")
	private List<ServentEntityBean> serventEntityBean;
}
