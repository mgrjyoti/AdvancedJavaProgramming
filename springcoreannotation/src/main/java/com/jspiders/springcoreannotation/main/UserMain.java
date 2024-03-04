package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.bean.Useer;

public class UserMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.jspiders.springcoreannotation.bean");
		Useer useer=applicationContext.getBean(Useer.class);
		System.out.println(useer);
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
