package com.jspiders.studentManagementSystem.servler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentManagementSystem.djbc.StudentJDBC;

@WebServlet("/student")
public class StudentServlete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	StudentJDBC studentJDBC=new StudentJDBC();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		Double fees= Double.parseDouble(req.getParameter("fess"));
		studentJDBC.addStudent(id,name,email,contact,fees);
	}
}
