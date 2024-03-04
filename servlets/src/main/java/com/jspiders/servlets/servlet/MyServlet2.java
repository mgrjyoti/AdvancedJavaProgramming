package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class MyServlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Generic Servlet...");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your name.");
		String str=scanner.nextLine();
		System.out.println("Your name is Magar "+str);
		scanner.close();
	}

}
