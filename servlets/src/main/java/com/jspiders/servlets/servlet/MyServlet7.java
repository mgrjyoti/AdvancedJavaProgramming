package com.jspiders.servlets.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class MyServlet7 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		System.out.println(name);
		String email=req.getParameter("email");
		System.out.println(email);
		long contact=Long.parseLong(req.getParameter("contact"));
		System.out.println(contact);
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println(age);
		double fees=Double.parseDouble(req.getParameter("fees"));
		System.out.println(fees);
		String[] course= req.getParameterValues("course");
		for (String courses : course) {
			System.out.println(courses);
		}
		
		
	}
	
}
