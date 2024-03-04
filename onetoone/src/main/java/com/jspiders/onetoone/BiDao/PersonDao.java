package com.jspiders.onetoone.BiDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.BiDto.AadharCard;
import com.jspiders.onetoone.BiDto.Person1;

public class PersonDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
	Person1 person1=new Person1();
	person1.setName("jyoti");
	person1.setEmail("jyoti@gmail.com");
	person1.setAge(22);
	
	AadharCard aadharCard=new AadharCard();
	aadharCard.setAdharno(637144144339l);
	aadharCard.setPerson1(person1);
	entityManager.persist(aadharCard);
	
	person1.setAadharCard(aadharCard);
	entityManager.persist(person1);
		
	Person1 person2=new Person1();
	person2.setName("Swati");
	person2.setEmail("swatigmil.com");
	person2.setAge(23);

	AadharCard aadharCard2=new AadharCard();
	aadharCard2.setAdharno(123456789011l);
	aadharCard2.setPerson1(person2);
	entityManager.persist(aadharCard2);
	
	person2.setAadharCard(aadharCard2);
	entityManager.persist(person2);
	
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
