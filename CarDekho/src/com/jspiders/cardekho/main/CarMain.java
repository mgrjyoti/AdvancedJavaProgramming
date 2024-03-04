package com.jspiders.cardekho.main;

import java.util.Scanner;

import com.jspiders.cardekho.methods.CarMethod;

public class CarMain {
	private  static CarMethod carMethod =new CarMethod();

	public static void main(String[] args) {
		
		System.out.println("******************* WEL-COME TO CAR DEKHO APPLICATION ***********************");
		
		System.out.println(" Select Your Chooice !!!");
		System.out.println(" 1. Enter 1 for Add Car. \n 2. Enter 2 for Show Cars. \n 3. Enter 3 for Update Car. \n 4. Enter 4  for Delete Car.");
		System.out.println(" 5. Enter 5 for Exit.");
		Scanner scanner= new Scanner(System.in);
		int choice=scanner.nextInt();
		scanner.close();
		
		boolean flage=true;
		while (flage) {
			
			switch (choice) {
			case 1: {
					carMethod.addCar();
					break;
					}
			
			case 2: {
					carMethod.showCar();
				break;
			}
			case 3: {
				carMethod.updateCar();
			break;	
			}
			case 4: {
				carMethod.deleteCar();
				break;
			}
			case 5: {
				System.out.println("Thank you !!!");
				flage=false;
				break;
			}
			default:
				System.out.println("Wrong Chooice..........");
				System.out.println("Plese provide valid choice.");
				//throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
}
