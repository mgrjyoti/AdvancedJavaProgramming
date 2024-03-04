package com.jspiders.onetoone.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.DTO.Aadhar;
import com.jspiders.onetoone.DTO.Person;

public class PersonDao2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	
		openConnection();
		entityTransaction.begin();
		
		Scanner scanner=new Scanner(System.in);
		Aadhar aadhar=new Aadhar();
		System.out.println("Enter Aadhar no.");
		aadhar.setNo(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter Date of Issue.");
		aadhar.setDateOfIssue(scanner.nextLine());
		entityManager.persist(aadhar);
		
		Person person=new Person();
		scanner.nextLine();
		System.out.println("Enter person name.");
		person.setName(scanner.nextLine());
		System.out.println("Enter Person email.");
		person.setEmail(scanner.nextLine());
		System.out.println("Enter person address.");
		person.setAddress(scanner.nextLine());
		System.out.println("Enter date of Birth.");
		person.setDob(scanner.nextLine());
		person.setAadhar(aadhar);
		
		entityManager.persist(person);
		
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
