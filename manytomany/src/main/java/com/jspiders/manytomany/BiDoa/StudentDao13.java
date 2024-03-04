package com.jspiders.manytomany.BiDoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.BiDto.Course1;
import com.jspiders.manytomany.BiDto.Student1;


public class StudentDao13 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
				Student1 student1 = entityManager.find(Student1.class, 1);
				System.out.println(student1);
		
				Course1 course1 = entityManager.find(Course1.class, 2);
				System.out.println(course1);
				
		entityTransaction.commit();
		closeConnectionn();
	}

	private static void closeConnectionn() {
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

	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}

}
