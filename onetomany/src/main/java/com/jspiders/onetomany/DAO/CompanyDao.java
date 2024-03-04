package com.jspiders.onetomany.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.Company;
import com.jspiders.onetomany.DTO.Employee;

public class CompanyDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter how many employee you want to add.");
		int how =scanner.nextInt();
		
		for (int i = 1; i < how; i++) {
			
			Employee employee=new Employee();
			System.out.println("Enter Employee Name.");
			scanner.nextLine();
			employee.setName(scanner.nextLine());
			System.out.println("Enter Employee Address.");
			employee.setAddress(scanner.nextLine());
			System.out.println("Enter Employee email");
			employee.setEmail(scanner.nextLine());
			System.out.println("Enter Employee Salary.");
			employee.setSalary(scanner.nextDouble());
			//entityManager.persist(employee);
		}
		List<Employee>employees=new ArrayList<>();
		
		Company company=new Company();
		company.setName("'Tata");
		company.setAddress("Pune");
		company.setEmployees(employees);;
		
		entityManager.persist(company);
		
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
