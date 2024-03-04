package com.jspiders.manytomany.BiDoa;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.BiDto.Course1;
import com.jspiders.manytomany.BiDto.Student1;

public class StudentDao11 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Course1 course1=new Course1();
		course1.setName("SQL");
		course1.setFees(2500);
		
		
		Course1 course2=new Course1();
		course2.setName("JAVA");
		course2.setFees(3500);

		Course1 cours3=new Course1();
		cours3.setName("WEBTECH");
		cours3.setFees(2500);

		Course1 course4=new Course1();
		course4.setName("J2EE");
		course4.setFees(5000);

		Course1 course5=new Course1();
		course5.setName("REACT");
		course5.setFees(2000);

		Student1 student1=new Student1();
		student1.setName("Jyoti");
		student1.setEmail("jyoti123@gmail.com");
		student1.setAge(22);
		
		Student1 student2=new Student1();
		student2.setName("sumitra");
		student2.setEmail("sumitra123@gmail.com");
		student2.setAge(24);
		
		Student1 student3=new Student1();
		student3.setName("Swati");
		student3.setEmail("swati123@gmail.com");
		student3.setAge(23);
		
		Student1 student4=new Student1();
		student4.setName("Jagruti");
		student4.setEmail("jagruti123@gmail.com");
		student4.setAge(22);
		
		Student1 student5=new Student1();
		student5.setName("Renu");
		student5.setEmail("renu123@gmail.com");
		student5.setAge(22);
		
		course1.setStudent1s(Arrays.asList(student1,student2,student3));
		course2.setStudent1s(Arrays.asList(student5,student1,student2));
		cours3.setStudent1s(Arrays.asList(student5,student4));
		course4.setStudent1s(Arrays.asList(student1));
		course5.setStudent1s(Arrays.asList(student2,student5,student3,student1));
		
		student1.setCourse1s(Arrays.asList(course1,course2,course5,course4));
		entityManager.persist(student1);
		student2.setCourse1s(Arrays.asList(course1,course2,course5));
		entityManager.persist(student2);
		student3.setCourse1s(Arrays.asList(course1,course5));
		entityManager.persist(student3);
		student4.setCourse1s(Arrays.asList(cours3,course5));
		entityManager.persist(student4);
		student5.setCourse1s(Arrays.asList(course2,cours3,course5));
		entityManager.persist(student5);
		
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
		
	}
}
