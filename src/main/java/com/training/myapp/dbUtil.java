package com.training.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {
	
	private static final String dburl = "jdbc:mysql://localhost:3306/employee";
	private static final String username = "root";
	private static final String password = "root";
	
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(dburl, username, password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}		

}
