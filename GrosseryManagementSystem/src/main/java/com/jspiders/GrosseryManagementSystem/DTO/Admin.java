package com.jspiders.GrosseryManagementSystem.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, unique = true)
	private String adminName;
	@Column(nullable = false, unique = true)
	private String adminEmail;
	@Column(nullable = false,unique = true)
	private String adminPassword;
	@Column(nullable = false)
	private String shopname;
	@Column(nullable = false)
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> users;
}
