package com.jspiders.SystemManagement.main;

import java.util.Scanner;

import com.jspiders.SystemManagement.DAO.UserAdminDao;
import com.jspiders.SystemManagement.DTO.Admin;
import com.jspiders.SystemManagement.DTO.User;
// I want to add it on the git hub can i add this.
public class LoginMain {

	private static UserAdminDao userAdminDao=new UserAdminDao();
	
	public static void main(String[] args) {
		System.out.println(" *********** WELCOME TO MANAGEMENT SYSTEM ***********");
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			
			System.out.println("Select your login type.");
			System.out.println("1. Enter 1 for Admin. \n2. Enter 2 for User. \n3. Enter 3 for Exit Application.");
			int key=scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("****** WELCOME TO ADMIN SYSTEM ******");
				boolean adminFlag=true;
				while (adminFlag) {
					System.out.println("Select admin type.");
					System.out.println("1. Enter 1 for New Admin. \n2. Enter 2 for Existing Admin. \n3. Enter 3 for Exit.");
					int key1=scanner.nextInt();
					Admin admin=new Admin();
					switch (key1) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter Admin Name.");
						admin.setAdminName(scanner.nextLine());
						System.out.println("Enter Admin Email.");
						admin.setEmail(scanner.nextLine());
						System.out.println("Enter Admin Address.");
						admin.setAddress(scanner.nextLine());
						System.out.println("Enter Admin Contact.");
						admin.setContact(scanner.nextLong());
						scanner.nextLine();
						System.out.println("Enter Admin Password.");
						admin.setPassword(scanner.nextLine());
						userAdminDao.createAdmin(admin);
						System.out.println("Admin account created sucessfully.... ");
						break;
					case 2:
						userAdminDao.getAllAdmin();
						 boolean adminflag2=true;
						 while (adminflag2) {
							System.out.println("Select your choice.");
							System.out.println("1. Enter 1 for Update Admin. \n2. Enter 2 for delete Admin.\n3. Enter 3 for Continue. \n4. Enter 4 for LogIn");
							int akey=scanner.nextInt();
							switch (akey) {
							case 1:
								System.out.println("Enter Id to update Admin.");
								userAdminDao.updateAdmin(scanner.nextInt(), scanner);
								System.out.println("Admin updated sucessfully...");
								break;
							case 2:
								System.out.println("Enter Id to delete Admin.");
								userAdminDao.removeAdmin(scanner.nextInt());
								System.out.println("Admin deleted successfully....");
								break;
								case 3:
									adminflag2=false;
									break;
								case 4:
									userAdminDao.adminLogin();
									System.out.println("Admin Account Log in Successfully.....");
									break;
							default:
								System.out.println("Invalid Choice...");
								break;
							}
						}
						break;
					case 3:
						System.out.println("Out of the Admin System.");
						adminFlag=false;
						break;
					default:
						System.out.println("Invalid choice....");
						break;
					}
				}
				
				break;
			case 2:
				System.out.println("****** WELCOME TO USER SYSTEM ******");
				boolean userFlag=true;
				while (userFlag) {
					System.out.println("Select User type.");
					System.out.println("1. Enter 1 for New User. \n2. Enter 2 for Existing User. \n3. Enter 3 for Exit.");
					int key1=scanner.nextInt();
					User user= new User();
					switch (key1) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter User Name.");
						user.setUserName(scanner.nextLine());
						System.out.println("Enter User Email.");
						user.setEmail(scanner.nextLine());
						System.out.println("Enter User Address.");
						user.setAddress(scanner.nextLine());
						System.out.println("Enter User Contact.");
						user.setContact(scanner.nextLong());
						scanner.nextLine();
						System.out.println("Enter User Password.");
						user.setPassword(scanner.nextLine());
						userAdminDao.createUser(user);
						System.out.println("User account created sucessfully.... ");
						break;
					case 2:
						userAdminDao.getAllUser();
						 boolean userflag2=true;
						 while (userflag2) {
							System.out.println("Select your choice.");
							System.out.println("1. Enter 1 for Update User. \n2. Enter 2 for delete User.\n3. Enter 3 for Continue.");
							int akey=scanner.nextInt();
							switch (akey) {
							case 1:
								System.out.println("Enter Id to update User.");
								userAdminDao.updateUser(scanner.nextInt(), scanner);
								System.out.println("Admin updated sucessfully...");
								break;
							case 2:
								System.out.println("Enter Id to delete User.");
								userAdminDao.removeUser(scanner.nextInt());
								System.out.println("User deleted successfully....");
								break;
								case 3:
									userflag2=false;
									break;
							default:
								System.out.println("Invalid Choice...");
								break;
							}
						}
						
						break;
					case 3:
						System.out.println("Out of the User System.");
						userFlag=false;
						break;
					default:
						System.out.println("Invalid choice....");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Thank you !!!!!!");
				flag=false;
				break;
			default:
				System.out.println("Invalid choise....");
				break;
			}	
		}
		scanner.close();
	}
}
