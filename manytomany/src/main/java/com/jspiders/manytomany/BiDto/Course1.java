package com.jspiders.manytomany.BiDto;

import java.util.List;

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

public class Course1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double fees;
	@ManyToMany
	private List<Student1>student1s;
	@Override
	public String toString() {
		return "Course1 [id=" + id + ", name=" + name + ", fees=" + fees +  "]";
	}
}
