package com.jspiders.GrosseryManagementSystem.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false, unique = true)
	private String userEmail;
	@Column(nullable = false,unique = true)
	private String userPassword;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false,unique = true)
	private long contct;
}
