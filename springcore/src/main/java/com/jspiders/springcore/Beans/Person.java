package com.jspiders.springcore.Beans;

import lombok.Data;

@Data
public class Person {

	private int id;
	private String name;
	private String email;
	private String address;
	private int age;
	private AdharCard adharCard;
}
