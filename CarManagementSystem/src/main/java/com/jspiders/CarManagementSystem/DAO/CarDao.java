package com.jspiders.CarManagementSystem.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.CarManagementSystem.DTO.Car;

public class CarDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("Car");
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
		if (entityTransaction!= null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	public void addCar(Car car) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(car);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	public void updateCar( int id) {
		Scanner scanner=new Scanner(System.in);
		Car car=new Car();
		scanner.nextLine();
		System.out.println("Enter new Car Name.");
		car.setName(scanner.nextLine());
		System.out.println("Enter Car Brand.");
		car.setBrand(scanner.nextLine());
		System.out.println("Enter FuleType.");
		car.setFuletype(scanner.nextLine());
		System.out.println("Enter Car Price.");
		car.setPrice(scanner.nextDouble());
		entityManager.persist(car);
		scanner.close();
	}

}








