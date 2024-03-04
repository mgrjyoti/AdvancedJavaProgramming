package com.jspiders.Hibernate.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	private double sal;
	
}
