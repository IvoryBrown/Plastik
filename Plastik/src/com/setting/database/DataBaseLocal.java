package com.setting.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.setting.showinfo.ShowInfo;

public class DataBaseLocal {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/gi_plast?useUnicode=true&characterEncoding=UTF-8";
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null;
	static Statement createStatement = null;

	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException ex) {
			System.out.println("Valami baj van a connection." +ex);
			new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
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
				new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
				return null;
			}
		}
		return null;
	}
}
