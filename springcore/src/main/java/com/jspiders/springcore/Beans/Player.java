package com.jspiders.springcore.Beans;

import lombok.Data;

@Data
public class Player {
	
	private int id;
	private String name;
	private String email;
	private int age;
	private Team team;

}