package com.jspiders.springcore.Beans;

import java.util.List;

import lombok.Data;

@Data
public class Costomer {

	private int id;
	private String name;
	private long contact;
	private List<Product>products;
}
