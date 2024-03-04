package com.jspiders.manytomany.BiDto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Student1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private int age;
	
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", course1s=" + course1s
				+ "]";
	}

	@ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "student1s")
	private List<Course1>course1s;
}
