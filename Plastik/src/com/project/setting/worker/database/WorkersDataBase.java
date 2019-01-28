package com.project.setting.worker.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.setting.worker.pojo.Workers;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class WorkersDataBase {

	public ArrayList<Workers> searchAllWorkers(String search) {
		String sql = "SELECT * FROM `dolgozok` WHERE (`dolgozok_nev`) LIKE '%" + search
				+ "%' OR (`dolgozok_azonosito`) LIKE '%" + search + "%'";
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

	public void addWorker(Workers workers) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `dolgozok` (dolgozok_nev, dolgozok_azonosito, dolgozok_aktiv "
					+ ") VALUES (?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, workers.getWorkersName());
			preparedStatement.setString(2, workers.getWorkersPassword());
			preparedStatement.setString(3, workers.getWorkersStatus());
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
			new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
			}
		}
	}

	public void updateWorker(Workers workers) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `dolgozok` SET dolgozok_aktiv = ? WHERE dolgozok_id = ?";
			pr = conn.prepareStatement(sqlClient);
			pr.setString(1, workers.getWorkersStatus());
			pr.setInt(2, Integer.parseInt(workers.getWorkersId()));
			pr.execute();
		} catch (SQLException ex) {
			System.out.println(ex);
			new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				new ShowInfo("Adatbázis Hiba", "", ex.getMessage());
			}
		}
	}
}
