package com.jspiders.manytomany.DAO;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.DTO.Course;
import com.jspiders.manytomany.DTO.Student;

public class StudentDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Course course=new Course();
		course.setName("Core JAVA");
		course.setFees(3000);
		
		Course course1=new Course();
		course1.setName("J2EE");
		course1.setFees(3000);

		Course course2=new Course();
		course2.setName("SQL");
		course2.setFees(3000);

		Course course3=new Course();
		course3.setName("WEB-TECH");
		course3.setFees(3000);

		Student student=new Student();
		student.setName("Jyoti");
		student.setEmail("jyoti@gmail.com");
		student.setAge(22);
		student.setCourses(Arrays.asList(course,course1));
		entityManager.persist(student);
		
		Student student1=new Student();
		student1.setName("swati");
		student1.setEmail("swati@gmail.com");
		student1.setAge(23);
		student1.setCourses(Arrays.asList(course,course1,course2));
		entityManager.persist(student1);
		
		Student student3=new Student();
		student3.setName("jaruti");
		student3.setEmail("jagriti@gmail.com");
		student3.setAge(30);
		student3.setCourses(Arrays.asList(course3,course1,course2));
		entityManager.persist(student3);
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();	
	}
	private static void closeConnection() {
		if (entityManagerFactory!= null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction!= null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}








