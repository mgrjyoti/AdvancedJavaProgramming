package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Car {

	
	private int id;
	private String name;
	private Double price;
	private String color;
	
	public Car(@Value("1") int id, @Value("Thar")String name, @Value("2000000.00")Double price,@Value("Black") String color) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + "]";
	}

	
	
}