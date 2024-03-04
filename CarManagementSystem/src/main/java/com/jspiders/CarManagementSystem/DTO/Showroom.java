package com.jspiders.CarManagementSystem.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Showroom {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String name;
	 private String address;
	 private String ownerName;
	 private String webside;
	 private long contact;
	 @OneToMany
	 private List<Car>cars;
}












