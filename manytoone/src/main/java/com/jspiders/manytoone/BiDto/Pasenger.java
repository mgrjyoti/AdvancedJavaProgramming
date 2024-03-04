package com.jspiders.manytoone.BiDto;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Pasenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private double ticketprice;
	private String destion;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Bus bus;
}
