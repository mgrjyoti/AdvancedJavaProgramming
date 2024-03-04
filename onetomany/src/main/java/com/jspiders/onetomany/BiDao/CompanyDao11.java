package com.jspiders.onetomany.BiDao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.BidireDto.Comp1;
import com.jspiders.onetomany.BidireDto.Emplo1;

public class CompanyDao11 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Emplo1 emplo1=new Emplo1();
		emplo1.setName("Raju");
		emplo1.setEmail("raju@gmail.com");
		emplo1.setAddress("Pune");
		emplo1.setSalary(25000);
		
		Emplo1 emplo2=new Emplo1();
		emplo2.setName("Varsha");
		emplo2.setEmail("varsha@gmail.com");
		emplo2.setAddress("Nagar");
		emplo2.setSalary(25000);

		Emplo1 emplo3=new Emplo1();
		emplo3.setName("Swati");
		emplo3.setEmail("swati@gmail.com");
		emplo3.setAddress("Tane");
		emplo3.setSalary(35000);

		Emplo1 emplo4=new Emplo1();
		emplo4.setName("Jyoti");
		emplo4.setEmail("jyoti@gmail.com");
		emplo4.setAddress("Pangri");
		emplo4.setSalary(45000);

		Comp1 comp1=new Comp1();
		comp1.setName("TCS");
		comp1.setAddress("Hinjewadi");
		emplo1.setComp1(comp1);
		emplo2.setComp1(comp1);
		emplo3.setComp1(comp1);
		emplo4.setComp1(comp1);
		
		comp1.setEmplo1s(Arrays.asList(emplo1,emplo2,emplo3,emplo4));
		
		entityManager.persist(comp1);
		
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
