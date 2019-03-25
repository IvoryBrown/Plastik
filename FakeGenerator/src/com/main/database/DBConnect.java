package com.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.10.10.105/new_gi_plast";
	static final String USER = "test1";
	static final String PASS = "1234";

	static Connection conn = null;
	static Statement createStatement = null;

	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection( DB_URL
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					USER, PASS);
		} catch (SQLException ex) {
			System.out.println("Valami baj van a connection." + ex);
			
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
		if (conn != null) {
			try {
				createStatement = conn.createStatement();
				return conn;
			} catch (SQLException ex) {
				System.out.println("Valami baj van van a createStatament l�trehoz�sakor.");
				
				return null;
			}
		}
		return null;
	}
}
