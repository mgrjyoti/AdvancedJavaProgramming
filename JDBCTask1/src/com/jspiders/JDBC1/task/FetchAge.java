package com.jspiders.JDBC1.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAge {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection=openConnection();
			query=" select * from student3 where age between 18 and 28";
			
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " || " +
									resultSet.getString(2) +" || "+
									resultSet.getString(3) +" || "+ 
									resultSet.getInt(4) +" || "+ 
									resultSet.getDouble(5) +" || "+
									resultSet.getString(6));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
	}
	private static void closeConnection() throws SQLException {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		if (connection !=null) {
			connection.close();
		}
	}

}
