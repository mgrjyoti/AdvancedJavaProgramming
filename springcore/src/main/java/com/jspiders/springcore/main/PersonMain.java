package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.Person;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("AdharConfig.xml");
		
	Person person= (Person) applicationContext.getBean("person");
	System.out.println(person);
	
	((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
}

