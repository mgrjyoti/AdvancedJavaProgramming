package com.jspiders.servlet1.servlet1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Sevlet11 implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet is distroyed....");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		
		System.out.println("hii from getServletConfig method.");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("hello from getSevletInfo method.");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Servlet is initialized..");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to servlet...");
		getServletConfig();
		getServletInfo();
		//destroy();
	}

	
}
