package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.Mobile;

public class MobileMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("MobileConfig.xml");
		
		Mobile mobile=(Mobile) applicationContext.getBean("mobile");
		System.out.println(mobile);
		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
