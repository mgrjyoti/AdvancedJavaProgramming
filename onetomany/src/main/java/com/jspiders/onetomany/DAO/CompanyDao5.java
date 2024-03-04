package com.jspiders.onetomany.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.Company;
import com.jspiders.onetomany.DTO.Employee;

public class CompanyDao5 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		Scanner scanner=new Scanner(System.in);
		//System.out.println("Enter the Employee id.");
		
		Company company=entityManager.find(Company.class,2);
	List<Employee>employees=company.getEmployees();
	for (Employee employee : employees) {
		if (employee.getId() == 2) {
			employees.remove(employee);
		}
	}
	company.setEmployees(employees);
	entityManager.persist(company);
	
	Employee employee=entityManager.find(Employee.class, 8);
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
