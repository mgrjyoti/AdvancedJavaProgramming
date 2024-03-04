package com.jspiders.springcore.Beans;

import lombok.Data;

@Data
public class Employee {

	private int id;
	private String name;
	private String email;
	private int age;
	private Company company;
}
