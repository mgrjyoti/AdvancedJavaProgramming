package com.jspiders.Hibernate.anather;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("How many student you want to add");
		int how=scanner.nextInt();
		for (int i = 1; i <= how; i++) {
			StudentDto studentDto=new StudentDto();
			System.out.println("Enter Student Name.");
			scanner.nextLine();
			studentDto.setName(scanner.nextLine());
			System.out.println("Enter Student email.");
			studentDto.setEmail(scanner.nextLine());
			System.out.println("Enter Student age.");
			studentDto.setAge(scanner.nextInt());
			System.out.println("Enter Student fees.");
			studentDto.setFees(scanner.nextDouble());
			entityManager.persist(studentDto);
		}
		scanner.close();
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("stud");
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
















