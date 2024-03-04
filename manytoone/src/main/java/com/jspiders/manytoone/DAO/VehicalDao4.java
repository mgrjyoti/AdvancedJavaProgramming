package com.jspiders.manytoone.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.DTO.Vehical;

public class VehicalDao4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Vehical vehical = entityManager.find(Vehical.class, 3);
		vehical.setName("Enova");
		vehical.setVno("MH 12 VB 1716");
		vehical.setPrice(3500000);
		entityManager.persist(vehical);
		
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	private static void closeConnection() {
		if (entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();
		}
		if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
