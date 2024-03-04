package com.jspiders.GrosseryManagementSystem.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.GrosseryManagementSystem.DTO.Admin;
import com.jspiders.GrosseryManagementSystem.DTO.User;

public class LoginDao {
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
	public static void adminLogin(Admin admin) {
		openConnection();
		entityTransaction.begin();
		
		
		entityManager.persist(admin);

		entityTransaction.commit();
		closeConnection();
	}
	
	public void userLogin(User user) {
		
		openConnection();
		entityTransaction.begin();
		
				entityManager.persist( user);
		
		entityTransaction.commit();
		closeConnection();

	}
	public void showAllUser() {
		openConnection();
		entityTransaction.begin();
		
		Query query=entityManager.createQuery("select user from User user");
		@SuppressWarnings("unchecked")
		List<User>users=query.getResultList();
		for (User user : users) {
			System.out.println(user);
		}		
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	
}

