package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.bean.Car;

public class CarMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.jspiders.springcoreannotation.bean");
		Car car=applicationContext.getBean(Car.class);
		System.out.println(car);
		Car car2= (Car) applicationContext.getBean("car");
		System.out.println(car2);
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
