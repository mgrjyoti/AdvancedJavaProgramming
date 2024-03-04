package com.jspiders.manytoone.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Vehical {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false ,unique = true)
	private String name;
	@Column(nullable = false)
	private String vno;
	@Column(nullable = false)
	private double price;
	@ManyToOne
	private Person person;

}
