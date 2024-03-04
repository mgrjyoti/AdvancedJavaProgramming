package com.jspiders.manytoone.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.DTO.Company;
import com.jspiders.manytoone.DTO.Employee;

public class EmployeeDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Company company=new Company();
		company.setName("TCS");
		company.setAddress("hinjewadi");
		company.setWebside("www.nextsteptcs.com");
		entityManager.persist(company);
		
		Employee employee=new Employee();
		employee.setName("Jyoti");
		employee.setEmail("jyoti1304@2gmail.com");
		employee.setSal(25000);
		employee.setAge(22);
		employee.setAddress("Pune");
		employee.setCompany(company);
		entityManager.persist(employee);
		
		Employee employee1=new Employee();
		employee1.setName("Swati");
		employee1.setEmail("swati1304@2gmail.com");
		employee1.setSal(20000);
		employee1.setAge(32);
		employee1.setAddress("Tane");
		employee1.setCompany(company);
		entityManager.persist(employee1);
		
		Employee employee2=new Employee();
		employee2.setName("Jagruti");
		employee2.setEmail("jarutiti1304@2gmail.com");
		employee2.setSal(200000);
		employee2.setAge(25);
		employee2.setAddress("Nagpur");
		employee2.setCompany(company);
		entityManager.persist(employee2);
		

		
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








