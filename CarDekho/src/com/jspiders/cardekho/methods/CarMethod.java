package com.jspiders.cardekho.methods;

import java.util.Scanner;

import com.jspiders.cardekho.entity.CarEntity;

public class CarMethod {

	private static CarEntity carEntity;
	public void addCar() {
		System.out.println("How many Car you want to add??");
		Scanner scanner=new Scanner(System.in);
		try {
			
			int choice=scanner.nextInt();
			for (int i = 1; i <=choice; i++) {
				System.out.println("Enter Car ID. ");
				int id=carEntity.getId();
				System.out.println("Enter Car name.");
				String name=carEntity.getCarName();
				System.out.println("Enter Owner Name.");
				String oname=carEntity.getOwenrName();
				System.out.println("Enter Model type. ");
				String model=carEntity.getModel();
				System.out.println("Enter Flue type. ");
				String fluetype=carEntity.getFeulType();
				System.out.println("Enter Car Color. ");
				String color=carEntity.getColor();
				System.out.println("Enter Car Price. ");
				double price=carEntity.getPrice();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		scanner.close();
	}

	public void showCar() {
		System.out.println("Added cars are follow....");
		
		
	}

	public void updateCar() {
		System.out.println("Enter Car Id which you want to update.");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter car id.");
		int id=carEntity.getId();
		if (id != 0) {
			carEntity.setId(id);
			
		}
		scanner.close();
	}

	public void deleteCar() {
		System.out.println("Enter Car Id which tou want to delete.");		
	}

}











