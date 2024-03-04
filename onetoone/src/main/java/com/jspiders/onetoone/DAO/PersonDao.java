package com.jspiders.onetoone.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.DTO.Aadhar;
import com.jspiders.onetoone.DTO.Person;

public class PersonDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	
		openConnection();
		entityTransaction.begin();
		
		Aadhar aadhar=new Aadhar();
		aadhar.setNo(637144144339l);
		entityManager.persist(aadhar);
		
		Person person=new Person();
		person.setName("jyoti");
		person.setEmail("jyori1304@gmail.com");
		person.setAddress("pune");
		person.setAadhar(aadhar);
		
		entityManager.persist(person);
		
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
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











