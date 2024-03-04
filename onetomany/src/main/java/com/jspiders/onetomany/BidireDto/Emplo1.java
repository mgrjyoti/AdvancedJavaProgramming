package com.jspiders.onetomany.BidireDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Emplo1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	private double salary;
	private String address;
	@ManyToOne
	private Comp1 comp1;
}
