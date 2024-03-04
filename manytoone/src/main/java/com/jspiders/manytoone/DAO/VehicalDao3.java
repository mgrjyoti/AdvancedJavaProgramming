package com.jspiders.manytoone.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.DTO.Vehical;

public class VehicalDao3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnectio();
		entityTransaction.begin();
		
		Vehical vehical=entityManager.find(Vehical.class, 1);
		entityManager.remove(vehical);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnectio() {
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
