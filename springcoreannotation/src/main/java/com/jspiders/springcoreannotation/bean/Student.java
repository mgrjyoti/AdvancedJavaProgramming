package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Student {

	@Value("1")
	private int id;
	@Value("Jyoti")
	private String name;
	@Value("jyoti@gmail.com")
	private String email;
	@Value("22")
	private int age;
}