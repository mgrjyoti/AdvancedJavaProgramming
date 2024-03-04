package com.jspiders.StudentMain;

import java.util.Scanner;

import com.jspiders.StudentMethod.Login;
import com.jspiders.StudentMethod.StudentJDBC;

public class StudentMain {

	private static boolean flage=true;
	private static StudentJDBC studentJDBC=new StudentJDBC();
	private static Login login;
	
	public static void main(String[] args) {
		while (flage) {
			login.userLogin();
			studentMenu();
		}

	}
	private static void studentMenu() {
		
		System.out.println("*************** WEL-COME TO STUDENT MANAGEMENT SYSTEM ***************");
		System.out.println(" 1. Enter 1 to Add the Student \n 2. Enter 2 to Update the Student ");
		System.out.println(" 3. Enter 3 to Remove the student \n 4. Enter 4 to exit ");
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Choice ");
		int choise=scanner.nextInt();					
			switch (choise) {
			case 1: {
				
				System.out.println("Enter Student Data..");
			    studentJDBC.addStudent();
				break;
			}
			case 2: {
				System.out.println("Update Student Details..");
				studentJDBC.updateStudent();
				break;
			}

			case 3: {
				System.out.println("Remove Student From database...");
				studentJDBC.removeStudent();
				break;
			}

			case 4: {
				System.out.println("thank you.....");
				flage=false;
				scanner.close();
				break;
			}
			
			default:
				System.out.println("Invalid input " +choise);
			}		
	}	
}
	