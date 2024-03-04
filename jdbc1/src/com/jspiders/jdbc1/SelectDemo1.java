package com.jspiders.jdbc1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SelectDemo1 {

	private static Connection connection;
	private static Statement statement;
	private static String query;
	private static ResultSet resultSet;
	
	
	public static void main(String[] args) throws SQLException {
		
		try {
			connection =openConnection();
			statement=connection.createStatement();
			query="select * from student";
			statement.execute(query);
			 resultSet=statement.getResultSet();
			while (resultSet.next()) {
			 System.out.println(resultSet.getInt(1));
			 System.out.println(resultSet.getString(2));
			 System.out.println(resultSet.getString(3));
			 System.out.println(resultSet.getInt(4));
			System.out.println(resultSet.getLong(5));
			System.out.println(resultSet.getString(6));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

	private static void closeConnection() throws SQLException {
		if (resultSet !=null) {
			resultSet.close();
		}
		if (statement!=null) {
			statement.close();
		}
		if (connection !=null) {
			connection.close();
		}
		
	}

	private static Connection openConnection() throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		File file=new File("D:\\J2EE/db.txt");
		FileReader fileReader=new FileReader(file);
		Properties properties=new Properties();
		properties.load(fileReader);
		return DriverManager.getConnection(properties.getProperty("url"), properties);
	}
	
}
