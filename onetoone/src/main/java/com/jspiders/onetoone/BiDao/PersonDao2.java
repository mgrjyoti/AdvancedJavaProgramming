package com.jspiders.onetoone.BiDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.BiDto.AadharCard;
import com.jspiders.onetoone.BiDto.Person1;

public class PersonDao2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		AadharCard aadharCard=entityManager.find(AadharCard.class, 1);
		entityManager.remove(aadharCard);
		
		Person1 person1=entityManager.find(Person1.class, 1);
		entityManager.remove(person1);
		
		
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person1");
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
