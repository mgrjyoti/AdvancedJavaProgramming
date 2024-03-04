package com.jspiders.Hibernate.DTO;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentDTO {

	@Id
	private  int id;
	private  String name;
	private String email;
	private  int age;
	private  long contact;
	private double fees;
	private  char gender;
		
}
