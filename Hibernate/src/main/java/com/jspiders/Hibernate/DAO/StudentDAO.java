package com.jspiders.Hibernate.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.Hibernate.DTO.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1);
		studentDTO.setName("Jyoti");
		studentDTO.setAge(22);
		studentDTO.setEmail("jyotis123@gmail.com");
		studentDTO.setContact(8805489109l);
		studentDTO.setFees(450000);
		studentDTO.setGender('F');
		
		entityManager.persist(studentDTO);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	private static void openConnection() {
		
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if (entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if (entityManager !=null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}

		
	}
}

























