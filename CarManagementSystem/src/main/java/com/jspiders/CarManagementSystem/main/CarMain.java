package com.jspiders.CarManagementSystem.main;

import java.util.Scanner;

import com.jspiders.CarManagementSystem.DAO.CarDao;
import com.jspiders.CarManagementSystem.DTO.Car;

public class CarMain {

	private static CarDao carDao=new CarDao();
	
	public static void main(String[] args) {
		System.out.println("************** Wel-come to Cars Show room *************");
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			System.out.println("1. Enter 1 for Add Car. \n2. Enter 2 for update Car."
					+ " \n3. Enter 3 for Delete Car. \n4. Enter 4 for Buy car. \n5. Enter 5 for Exit. ");
			int key=scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("How Many car you want to add.");
				int how=scanner.nextInt();
				for (int i = 1; i <= how; i++) {
					Car car=new Car();
					scanner.nextLine();
					System.out.println("Enter Car Name.");
					car.setName(scanner.nextLine());
					System.out.println("Enter Car Brand.");
					car.setBrand(scanner.nextLine());
					System.out.println("Enter FuleType.");
					car.setFuletype(scanner.nextLine());
					System.out.println("Enter Car Price.");
					car.setPrice(scanner.nextDouble());
					carDao.addCar(car);
				}
				System.out.println( how +" Cars Added Successfully...");
				break;
			case 2:
				System.out.println("Enter Car Id to update car.");
				int id=scanner.nextInt();
				carDao.updateCar(id);
				System.out.println("Car Updated Sucessfully....");
				break;
			case 3:
	
				break;
			case 4:
	
				break;
			case 5:
				System.out.println("Thank You....");
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice....");
				break;
			}
		}
		
		scanner.close();
	}
}
