package com.jspiders.hibernate1.EmployeeMain;

import java.util.Scanner;

import com.jspiders.hibernate1.EmployeeDAO.EmployeeDAO;
import com.jspiders.hibernate1.EmployeeDTO1.Employee;

public class EmployeeMain {

	private static EmployeeDAO employeeDAO=new EmployeeDAO();
	
	public static void main(String[] args) {
		
		boolean flag=true;
		Scanner scanner=new Scanner(System.in);

		while (flag) {
			System.out.println("1. Enter 1 for add Employee. \n2. Enter 2 for delete Employee.");
			System.out.println("3. Enter 3 for Update Employee. \n4. Enter 4 for search Employee.");
			System.out.println("5. Enter 5 for show all Employee. \n6. Enter 6 for Exit.");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				Employee employee=new Employee();
				scanner.nextLine();
				System.out.println("Enter Employee Name");
				employee.setName(scanner.nextLine());
				System.out.println("Enter Employee Email");
				employee.setEmail(scanner.nextLine());
				System.out.println("Enter Employee Salary");
				employee.setSal(scanner.nextDouble());
				employeeDAO.addEmployee(employee);
				break;
			case 2:
				employeeDAO.getAllEmployee();
				System.out.println("Enter Employee Id");
				employeeDAO.deleteEmployee(scanner.nextInt());
				System.out.println("Employee Deleted Successfully...");
				break;

			case 3:
				employeeDAO.getAllEmployee();
				System.out.println("Emnter Employee Id.");
				employeeDAO.updateEmployee(scanner.nextInt(),scanner);
				System.out.println("Employee Data Updated Successfully....");
				break;
				
			case 4:
				System.out.println("Enter employee id.");
				Employee employee2=employeeDAO.getEmployeeById(scanner.nextInt());
				if (employee2 != null) {
					System.out.println(employee2);
				}
				else {
					System.out.println("Employee not found...");
				}
				
				break;
			case 5:
				employeeDAO.getAllEmployee();
				break;
			case 6:
				System.out.println("Thank you!!!");
				flag = false;
				break;
				
			default:
				System.out.println("invalid choice....\n Enter valid choice.");
				throw new IllegalStateException();
			}
		}
		scanner.close();
	}
}
