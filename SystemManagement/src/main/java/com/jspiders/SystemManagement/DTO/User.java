package com.jspiders.SystemManagement.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false,unique = true)
	private String password;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false,unique = true)
	private long contact;
	@Column(nullable = false,unique = true)
	private  String email;
}
