package com.jspiders.GrosseryManagementSystem.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.GrosseryManagementSystem.DTO.Grossray;

public class GrosarryDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	Scanner scanner=new Scanner(System.in);
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("grosarry");
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
	public void addGrossery(Grossray grossray) {
	openConnection();
	entityTransaction.begin();
	
	entityManager.persist(grossray);
	
	entityTransaction.commit();
	closeConnection();
	}

	public Grossray getAllGrossery() {
		openConnection();
		entityTransaction.begin();
		
		Query query=entityManager.createQuery("select gross from Grossray gross");
		@SuppressWarnings("unchecked")
		List<Grossray>grossrays=query.getResultList();
		for (Grossray grossray : grossrays) {
			System.out.println(grossray);
		}
		
		entityTransaction.commit();
		closeConnection();
		return null;	
	}
	public void updateGrossery(int id) {
		openConnection();
		entityTransaction.begin();
		
		Grossray grossray=entityManager.find(Grossray.class, id);
		scanner.nextLine();
		System.out.println("Enter new Grossary Name.");
		grossray.setName(scanner.nextLine());
		System.out.println("Enter new Grossary Brand.");
		grossray.setBrand(scanner.nextLine());
		System.out.println("Enter new Grossary Price.");
		grossray.setPrice(scanner.nextDouble());
		System.out.println("Enter new Grossary Quantity. ");
		grossray.setPrice(scanner.nextDouble());
		entityManager.persist(grossray);
		
		entityTransaction.commit();
		closeConnection();
	}
	public void deleteGrossary(int id) {
		openConnection();
		entityTransaction.begin();
		
		Grossray grossray=entityManager.find(Grossray.class, id);
		entityManager.remove(grossray);
		
		entityTransaction.commit();
		closeConnection();
	}
	public void perches(int id) {
		
		
		
	}
	
	
	
	
}
