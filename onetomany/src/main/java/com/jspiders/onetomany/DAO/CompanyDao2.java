package com.jspiders.onetomany.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.Company;
import com.jspiders.onetomany.DTO.Employee;


public class CompanyDao2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Employee employee=new Employee();
		employee.setName("Jyoti");
		employee.setAddress("Pune");
		employee.setEmail("jyoti@gmail.com");
		employee.setSalary(23000);
		entityManager.persist(employee);
				
		Employee employee1=new Employee();
		employee1.setName("Swati");
		employee1.setAddress("Pune");
		employee1.setEmail("swati@gmail.com");
		employee1.setSalary(25000);
		entityManager.persist(employee1);

		Employee employee2=new Employee();
		employee2.setName("Jagruti");
		employee2.setAddress("tane");
		employee2.setEmail("jagruti@gmail.com");
		employee2.setSalary(23000);
		entityManager.persist(employee2);
		
		List<Employee>employees=new ArrayList<>();
		employees.add(employee);
		employees.add(employee1);
		employees.add(employee2);

		Company company=new Company();
		company.setName("'Tata");
		company.setAddress("Pune");
		company.setEmployees(employees);;
		
		entityManager.persist(company);
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
