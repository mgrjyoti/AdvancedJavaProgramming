package com.jspiders.SystemManagement.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.SystemManagement.DTO.Admin;
import com.jspiders.SystemManagement.DTO.User;

public class UserAdminDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("login");
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
	public void createAdmin(Admin admin) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(admin);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	public void createUser(User user) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(user);
		
		entityTransaction.commit();
		closeConnection();
		
	}
		
	@SuppressWarnings("unchecked")
	public void getAllAdmin() {
		openConnection();
		entityTransaction.begin();
		
		Query query=entityManager.createQuery("SELECT admin from Admin admin");
		List<Admin> admins=query.getResultList();
		for (Admin admin : admins) {
			System.out.println(admin);
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	public void getAllUser() {
		openConnection();
		entityTransaction.begin();
		Query query=entityManager.createQuery("SELECT user from User user");
		@SuppressWarnings("unchecked")
		List<User> users=query.getResultList();
		for (User user : users) {
			System.out.println(user);
		}
		entityTransaction.commit();
		closeConnection();
	}

	public void removeAdmin(int id) {
		openConnection();
		entityTransaction.begin();
		Admin admin=entityManager.find(Admin.class,id);
		entityManager.remove(admin);
		entityTransaction.commit();
		closeConnection();
	}

	public void removeUser(int id) {
		openConnection();
		entityTransaction.begin();
		User user=entityManager.find(User.class, id);
		entityManager.remove(user);
		entityTransaction.commit();
		closeConnection();
	}

	public void updateAdmin(int id,Scanner scanner) {
		openConnection();
		entityTransaction.begin();
		Admin admin=entityManager.find(Admin.class, id);
		scanner.nextLine();
		System.out.println("Enter new Admin Name.");
		admin.setAdminName(scanner.nextLine());
		System.out.println("Enter new Admin Email.");
		admin.setEmail(scanner.nextLine());
		System.out.println("Enter new Admin Address.");
		admin.setAddress(scanner.nextLine());
		System.out.println("Enter new Admin Contact.");
		admin.setContact(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter new Admin Password.");
		admin.setPassword(scanner.nextLine());
		entityManager.persist(admin);
		entityTransaction.commit();
		closeConnection();
	}
	public void updateUser(int id, Scanner scanner) {
		openConnection();
		entityTransaction.begin();
		User user=entityManager.find(User.class,id);
		scanner.nextLine();
		System.out.println("Enter new User Name.");
		user.setUserName(scanner.nextLine());
		System.out.println("Enter new User Email.");
		user.setEmail(scanner.nextLine());
		System.out.println("Enter new User Address.");
		user.setAddress(scanner.nextLine());
		System.out.println("Enter new User Contact.");
		user.setContact(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter new User Password.");
		user.setPassword(scanner.nextLine());
		entityManager.persist(user);
		entityTransaction.commit();
		closeConnection();
	}


	public void getAdminByName() {
		openConnection();
		entityTransaction.begin();
		
		
		entityTransaction.commit();
		closeConnection();
		
	}
	public void adminLogin() {
		
		System.out.println("Enter Admin Name.");
		//admin.getAdminName();
		System.out.println("Enter Admin Password.");
		//admin.getPassword();
		
	}

}

