package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.User;

public class UserMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("userConfig.xml");
		User user=applicationContext.getBean(User.class);
		System.out.println(user);
		((ClassPathXmlApplicationContext ) applicationContext).close();
	}
}
