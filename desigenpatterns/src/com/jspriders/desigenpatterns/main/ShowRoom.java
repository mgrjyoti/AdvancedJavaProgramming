package com.jspriders.desigenpatterns.main;

import java.util.Scanner;

import com.jspriders.desigenpatterns.car.Bmw;
import com.jspriders.desigenpatterns.car.Car;
import com.jspriders.desigenpatterns.car.Irtiga;
import com.jspriders.desigenpatterns.car.Maruti;
import com.jspriders.desigenpatterns.car.Nano;
import com.jspriders.desigenpatterns.car.Thar;

public class ShowRoom {

	private static Car car;
	public static void main(String[] args) {
		try {
			carShow().Order();
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static Car carShow() {
		System.out.println("Which car you want to order");
		Scanner scanner =new Scanner(System.in);
		System.out.println("1. Thar \n 2.Iriga \n 3. Nano \n 4. Maruti \n 5. BMW ");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1: {
			
			car=new Thar();
			break;
		}
		case 2: {
			
			car=new Irtiga();
			break;
		}

		case 3: {
	
			car=new Nano();
			break;
		}

		case 4: {
	
			car=new Maruti();
			break;
		}

		case 5: {
	
			car=new Bmw();
			break;
		}

		default:
			//throw new IllegalArgumentException("Unexpected value: " + choice);
			System.out.println("No Car Order.....");
		}
		return car;
	}
}
