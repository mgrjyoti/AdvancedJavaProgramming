package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.Costomer;

public class CostomerMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("ConsumerConfig.xml");
		Costomer costomer=(Costomer) applicationContext.getBean("costomer1");
		System.out.println(costomer);
		Costomer costomer1=(Costomer) applicationContext.getBean("costomer2");
		System.out.println(costomer1);
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
