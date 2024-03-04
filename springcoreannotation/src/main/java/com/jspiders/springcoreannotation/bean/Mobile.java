package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Mobile {

	private int id;
	private String name;
	private double price;
	
	@Value("1")
	public void setId(int id) {
		this.id = id;
	}
	@Value("Vivo v11")
	public void setName(String name) {
		this.name = name;
	}
	@Value("34000")
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
