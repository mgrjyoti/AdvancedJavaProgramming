package com.jspiders.StudentMethod;

import java.util.Scanner;

public class Login {

	private static String user;
	private static String admin;
	Scanner scanner=new Scanner(System.in);
	public void userLogin() {
		System.out.println("Enter yor login  \n 1. Enter 1 for USER \n 2. Enter 2 for ADMIN");
		int key=scanner.nextInt();
		
	switch (key) {
	case 1: {
		uLogin();
	}
	case 2: {
		aLogin();
	}

	default:
		System.out.println( key +"Invalid key is enterd..");
		//throw new IllegalArgumentException("Unexpected value: " + key);
	}
		
	}
	private void aLogin() {
		
		System.out.println("Enter Admin name.");
		String admin=scanner.nextLine();
		System.out.println("Enter password.");
		String pass=scanner.nextLine();
		
		if (admin==admin) {
			
			if (pass==pass) {
				
			} else {
				System.out.println("Enter Valid password.");
			}
		}
		else {
			System.out.println("Enter valid Email and Password.");
		}
		
				
	}
	private void uLogin() {
		System.out.println("Enter Admin name.");
		String user=scanner.nextLine();
		System.out.println("Enter password.");
		String pass=scanner.nextLine();

		
	}

	
	
}
















