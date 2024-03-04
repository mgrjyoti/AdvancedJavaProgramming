package com.jspiders.manytoone.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.DTO.Person;
import com.jspiders.manytoone.DTO.Vehical;

public class VehicalDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Person person=new Person();
		person.setName("Jyori");
		person.setEmail("jyoti1304@gmail.com");
		person.setAddress("Pune");
		person.setAge(22);
		entityManager.persist(person);
		
		Vehical vehical=new Vehical();
		vehical.setName("Thar");
		vehical.setVno("MH 25 WA 1213");
		vehical.setPrice(20000000);
		vehical.setPerson(person);
		entityManager.persist(vehical);
		
		Vehical vehical1=new Vehical();
		vehical1.setName("Lambo");
		vehical1.setVno("MH 25 BH 1414");
		vehical1.setPrice(22000000);
		vehical1.setPerson(person);
		entityManager.persist(vehical1);
		
		Vehical vehical2=new Vehical();
		vehical2.setName("Nano");
		vehical2.setVno("MH 20 PA 1213");
		vehical2.setPrice(25000000);
		vehical2.setPerson(person);
		entityManager.persist(vehical2);

		
		entityTransaction.commit();
		closeConnection();
		
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
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
