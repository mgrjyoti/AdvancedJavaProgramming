package com.jspiders.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCInsert {

	public static void main(String[] args) {
		try {
			//register the driver or Load the driver class
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Open the connection 
			Connection connection= DriverManager.getConnection();
			
		} catch (Exception e) {
			
			
		}
	}
}
