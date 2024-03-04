package com.jspiders.GrosseryManagementSystem.main;
import java.util.Scanner;

import com.jspiders.GrosseryManagementSystem.DAO.GrosarryDAO;
import com.jspiders.GrosseryManagementSystem.DAO.LoginDao;
import com.jspiders.GrosseryManagementSystem.DTO.Admin;
import com.jspiders.GrosseryManagementSystem.DTO.Grossray;
import com.jspiders.GrosseryManagementSystem.DTO.User;

public class GrosseryMain {

	private static GrosarryDAO grosarryDAO = new GrosarryDAO();
	private static LoginDao loginDao= new LoginDao();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("********** WELCOME TO GROSSERY MANAGEMENT SYSTEM **********");
		boolean flag=true;
		while (flag) {
			System.out.println(" 1. Enter 1 for Admin LogIn. \n 2. Enter 2 for User LogIn. \n 3. Enter 3 for Exit.");
			System.out.println("Chooce your login type..");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("***** WELCOME TO ADMIN LOGIN *****");
				Admin admin=new Admin();
				scanner.nextLine();
				if (admin.getId() == 0 ) {
					System.out.println("Enter Admin Name.");
					admin.setAdminName(scanner.nextLine());
					System.out.println("Enter Admin Email.");
					admin.setAdminEmail(scanner.nextLine()); 
					System.out.println("Enter Admin Password.");
					admin.setAdminPassword(scanner.nextLine());
					System.out.println("Enter Shop name.");
					admin.setShopname(scanner.nextLine());
					System.out.println("Enter Shop Address.");
					admin.setAddress(scanner.nextLine());
					loginDao.adminLogin(admin);
					System.out.println("Admin Account added Successfully....");
					
				}else {
									
				boolean select=true;
				while (select) {
					System.out.println(" 1. Enter 1 for Add Grossay. \n 2. Enter 2 for Update Grossay. \n 3. Enter 3 for Remove Grossary. \n 4. Enter 4 for Exit.");
					System.out.println("Enter your Choice.");
					int key=scanner.nextInt();
					switch (key) {
					case 1:
						System.out.println("How many atom you want to add.");
						int how=scanner.nextInt();
						for (int i = 1; i <= how; i++) { 
							Grossray grossray=new Grossray();
							scanner.nextLine();
							System.out.println("Enter Grossray Name.");
							grossray.setName(scanner.nextLine());
							System.out.println("Enter Grossary Brand.");
							grossray.setBrand(scanner.nextLine());
							System.out.println("Enter Grossary Quantity.");
							grossray.setQuntity(scanner.nextDouble());
							System.out.println("Enter Grossary Price.");
							grossray.setPrice(scanner.nextDouble());
							grosarryDAO.addGrossery(grossray);
						}
						System.out.println(how +" atoms added sucessfully...");
						break;
					case 2:
						grosarryDAO.getAllGrossery();
						System.out.println("Enter Grossery ID to Update.");
						int id=scanner.nextInt();
						grosarryDAO.updateGrossery(id);
						System.out.println("Grossary updated Successfully..");
						break;
					case 3:
						System.out.println("Enter id to delete grossery.");
						int id1=scanner.nextInt();
						grosarryDAO.deleteGrossary(id1);
						System.out.println("Grossary deleted Successfully..");
						break;
					case 4:
						System.out.println("Thank you!!!!");
						select=false;
						break;
					default:
						System.out.println("Enter valid choise.");
						break;
					}
				}
				
				break;
		}
			case 2:
				System.out.println("***** WELCOME TO USER LOGIN *****");
				User user=new User();
				System.out.println("Create User Account if not exist.");
				if (user.getId() != 0 && user.getId() >= 1) {
					loginDao.showAllUser();
					System.out.println("Enter your user id to continue..");
					
				}
				else {
					System.out.println("Enter User Name.");
					user.setUserName(scanner.nextLine());
					System.out.println("Enter User Email.");
					user.setUserEmail(scanner.nextLine());
					System.out.println("Enter User Password.");
					user.setUserPassword(scanner.nextLine());
					System.out.println("Enter User Address.");
					user.setAddress(scanner.nextLine());
					System.out.println("Enter User Contact.");
					user.setContct(scanner.nextLong());
					loginDao.userLogin(user);
					System.out.println("User Added Successfully....");
				}
				
				boolean select2=true;
				while (select2) {
					System.out.println(" 1. Enter 1 for Perches Grossay. \n 2. Enter 2 for Exchange Grossay. \n 3. Enter 3 for Remove Grossary. \n 4. Enter 4 for Exit.");
					System.out.println("Enter your Choice.");
					int key=scanner.nextInt();
					switch (key) {
					case 1:
						System.out.println("Following Atoms are avaliable in Shop.");
						grosarryDAO.getAllGrossery();
						System.out.println("Enter Id to Perches atom.");
						int id=scanner.nextInt();
						grosarryDAO.perches(id);
						break;
					case 2:
						grosarryDAO.getAllGrossery();
						System.out.println("Enter Grossery ID to Exchange.");
						int id2=scanner.nextInt();
						grosarryDAO.updateGrossery(id2);
						System.out.println("Grossary Exchange Successfully..");
						break;
					case 3:
						System.out.println("Enter id to delete grossery.");
						int id1=scanner.nextInt();
						grosarryDAO.deleteGrossary(id1);
						System.out.println("Grossary deleted Successfully..");

						break;
					case 4:
						System.out.println("Thank you!!!!");
						select2=false;
						break;
					default:
						System.out.println("Enter valid choise.");
						break;
					}
				}
				break;
			case 3:
				flag=false;
				System.out.println("Thank You !!!!!");
				
				break;
			default:
				System.out.println("Invalid Choice....");
				System.out.println("Enter valid choice.");
				break;
			}
			
		}
		scanner.close();
		}
}
