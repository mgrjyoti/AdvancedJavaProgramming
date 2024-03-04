package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.Student;

public class StudentMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("StudentConfig.xml");
		Student student1=(Student) applicationContext.getBean("student1");
		System.out.println(student1);
		Student student2 =(Student) applicationContext.getBean("student2");
		System.out.println(student2);
		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
