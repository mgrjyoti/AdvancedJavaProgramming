package com.jspiders.onetoone.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.DTO.Aadhar;
import com.jspiders.onetoone.DTO.Person;

public class PersonDeleteDao2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	
		openConnection();
		entityTransaction.begin();
		Scanner scanner=new Scanner(System.in);
	
		System.out.println("Enter Aadhar Id whiich you want to delete.");
		Aadhar aadhar=entityManager.find(Aadhar.class, scanner.nextInt());
		entityManager.remove(aadhar);
		scanner.nextLine();
		System.out.println("Enter Person Id whiich you want to delete.");
		Person person=entityManager.find(Person.class,scanner.nextInt());
		entityManager.remove(person);
		
		scanner.close();
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
