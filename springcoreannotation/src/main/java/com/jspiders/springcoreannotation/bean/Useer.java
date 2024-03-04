package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Useer {

	@Value("1")
	private int id;
	@Value("Jyoti")
	private String name;
	@Value("jyoti@gmail.com")
	private String email;
	@Value("22")
	private int age;
	@Value("jyoti#1234")
	private String pass;
	
}
