package com.jspiders.springcore.Beans;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mobile {

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	private int id;
	private double price;
	private String name;
	
}
