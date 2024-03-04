package com.jspiders.SystemManagement.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String adminName;
	@Column(nullable = false,unique = true)
	private String password;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false,unique = true)
	private long contact;
	@Column(nullable = false,unique = true)
	private  String email;
	@OneToMany
	private List<User> users;
}
