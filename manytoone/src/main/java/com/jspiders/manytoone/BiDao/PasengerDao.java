package com.jspiders.manytoone.BiDao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.BiDto.Bus;
import com.jspiders.manytoone.BiDto.Pasenger;

public class PasengerDao {

	private static EntityManagerFactory emfEntityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	openConnection();
	entityTransaction.begin();
	
	Bus bus=new Bus();
	bus.setName("Shivshahi");
	bus.setNo("MH 12 WA 1112");

	Pasenger pasenger=new Pasenger();
	pasenger.setName("jyoti");
	pasenger.setEmail("jyoti123@gamil.com");
	pasenger.setTicketprice(200);
	pasenger.setDestion("Pargon");
	
	Pasenger pasenger1=new Pasenger();
	pasenger1.setName("Pratiksha");
	pasenger1.setEmail("pratiksha123@gamil.com");
	pasenger1.setTicketprice(200);
	pasenger1.setDestion("Pargon");
	
	Pasenger pasenger2=new Pasenger();
	pasenger2.setName("Pranita");
	pasenger2.setEmail("pranita23@gamil.com");
	pasenger2.setTicketprice(300);
	pasenger2.setDestion("Pangri");
	
	Pasenger pasenger3=new Pasenger();
	pasenger3.setName("Rernuka");
	pasenger3.setEmail("Renu123@gamil.com");
	pasenger3.setTicketprice(400);
	pasenger3.setDestion("Bhum");
	
	Pasenger pasenger4=new Pasenger();
	pasenger4.setName("Ambika");
	pasenger4.setEmail("ambi123@gamil.com");
	pasenger4.setTicketprice(400);
	pasenger4.setDestion("Bhoom");
	
	Pasenger pasenger5=new Pasenger();
	pasenger5.setName("Shankar");
	pasenger5.setEmail("shankar@gamil.com");
	pasenger5.setTicketprice(600);
	pasenger5.setDestion("Pangri");
	
	Pasenger pasenger6=new Pasenger();
	pasenger6.setName("varsha");
	pasenger6.setEmail("varsha123@gamil.com");
	pasenger6.setTicketprice(100);
	pasenger6.setDestion("Nagar");
	
	
	pasenger.setBus(bus);
	pasenger1.setBus(bus);
	pasenger2.setBus(bus);
	pasenger3.setBus(bus);
	pasenger4.setBus(bus);
	pasenger5.setBus(bus);
	pasenger6.setBus(bus);
	
	bus.setPasengers(Arrays.asList(pasenger,pasenger1,pasenger2,pasenger3,pasenger4,pasenger5,pasenger6));
	entityManager.persist(bus);
	
	
	entityTransaction.commit();
	closeConnection();
	}

	private static void closeConnection() {
		if (emfEntityManagerFactory != null) {
			emfEntityManagerFactory.close();          
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

	private static void openConnection() {
		emfEntityManagerFactory=Persistence.createEntityManagerFactory("bus");
		entityManager=emfEntityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();	
	}
	
}
