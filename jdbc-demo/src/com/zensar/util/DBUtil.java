package com.zensar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection conn;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception Caught :" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Exception Caught :" + e.getMessage());
		}
		return conn;
	}

	public static void closeResource() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Exception Caught :" + e.getMessage());
			}
		}

	}

}