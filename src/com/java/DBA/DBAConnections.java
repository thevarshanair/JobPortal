package com.java.DBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.java.DBA.DBAConnections;

public class DBAConnections {
	private static Connection conn;

	// Private Constructor can only be accessed by the singleton class
	// using static factory method
	private DBAConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shoppingstore", "root",
					"mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Static Factory Method
	@SuppressWarnings("static-access")
	public static Connection getConnecton() {
		if (conn != null) {
			return conn;
		} else {
			return new DBAConnections().conn;
		}
	}
}
