package com.project.setting.worker.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.setting.worker.pojo.Workers;
import com.setting.database.DataBaseLocal;

public class WorkersDataBase {

	public ArrayList<Workers> searchAllWorkers(String search) {
		String sql = "SELECT * FROM `dolgozok` WHERE (`dolgozok_azonosito`)=" + search;
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Workers> client = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			client = new ArrayList<>();

			while (rs.next()) {
				Workers actualWorkers = new Workers(rs.getInt("dolgozok_id"), rs.getString("dolgozok_nev"),
						rs.getString("dolgozok_azonosito"), rs.getString("dolgozok_aktiv"));
				client.add(actualWorkers);
			}
		} catch (SQLException ex) {
			System.out.println("Valami baj van a userek kiolvasásakor");
			System.out.println("" + ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (createStatement != null) {
					createStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasásakor");
				System.out.println("" + e);
			}
		}
		return client;
	}
}
