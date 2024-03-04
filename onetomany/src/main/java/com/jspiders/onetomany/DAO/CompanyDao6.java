package com.jspiders.onetomany.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.Company;
import com.jspiders.onetomany.DTO.Employee;

public class CompanyDao6 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter ID of Company.");
		int id=scanner.nextInt();
		Company company=entityManager.find(Company.class,id );
		List<Employee>employees=company.getEmployees();
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employees.remove(employee);
			}
		}
		 company.setEmployees(employees);
		 entityManager.persist(employees);
		 
		 Employee employee=entityManager.find(Employee.class, id);
		entityManager.remove(employee);

		scanner.close();
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if (entityManagerFactory !=null ) {
			entityManagerFactory.close();;
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction !=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

}








