package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MyServlet8")
public class MyServlet8 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("Text/html");
		PrintWriter writer=resp.getWriter();
		writer.println("<h1>Responce from MyServlet8</h1>");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("MyServlet9");
		requestDispatcher.include(req, resp);
	}
}