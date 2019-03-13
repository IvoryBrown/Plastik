package com.office.client.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.office.client.pojo.Client;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class ClientDataBase {

	public ArrayList<Client> getAllClient() {
		String sql = "SELECT * FROM `megrendelo`";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Client> client = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			client = new ArrayList<>();

			while (rs.next()) {
				Client actualClient = new Client(rs.getInt("megrendelo_id"), rs.getString("megrendelo_nev"),
						rs.getString("megrendelo_iranyitoszam"), rs.getString("megrendelo_helyseg"),
						rs.getString("megrendelo_utca"), rs.getString("megrendelo_mobil"),
						rs.getString("megrendelo_email"), rs.getString("megrendelo_megjegyzes"));
				client.add(actualClient);
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

	public ArrayList<Client> searchAllClient(String search) {
		String sql = "SELECT * FROM `megrendelo` WHERE (`megrendelo_nev`) LIKE '%" + search
				+ "%' OR (`megrendelo_helyseg`) LIKE '%" + search + "%' OR (`megrendelo_mobil`) LIKE '%" + search
				+ "%'";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Client> client = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			client = new ArrayList<>();

			while (rs.next()) {
				Client actualClient = new Client(rs.getInt("megrendelo_id"), rs.getString("megrendelo_nev"),
						rs.getString("megrendelo_iranyitoszam"), rs.getString("megrendelo_helyseg"),
						rs.getString("megrendelo_utca"), rs.getString("megrendelo_mobil"),
						rs.getString("megrendelo_email"), rs.getString("megrendelo_megjegyzes"));
				client.add(actualClient);
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

	public void addClient(Client client) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `megrendelo` (megrendelo_nev, megrendelo_iranyitoszam, megrendelo_helyseg, megrendelo_utca,"
					+ " megrendelo_mobil, megrendelo_email, megrendelo_megjegyzes) VALUES (?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientName());
			preparedStatement.setString(2, client.getClientPostcode());
			preparedStatement.setString(3, client.getClientCity());
			preparedStatement.setString(4, client.getClientStreet());
			preparedStatement.setString(5, client.getClientPhone());
			preparedStatement.setString(6, client.getClientMail());
			preparedStatement.setString(7, client.getClientComment());
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

	public void updateClient(Client client) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `megrendelo` SET megrendelo_nev = ?, megrendelo_iranyitoszam = ?, megrendelo_helyseg = ?,"
					+ "megrendelo_utca = ?, megrendelo_mobil = ?, megrendelo_email = ?, megrendelo_megjegyzes = ? WHERE megrendelo_id = ?";

			pr = conn.prepareStatement(sqlClient);
			pr.setString(1, client.getClientName());
			pr.setString(2, client.getClientPostcode());
			pr.setString(3, client.getClientCity());
			pr.setString(4, client.getClientStreet());
			pr.setString(5, client.getClientPhone());
			pr.setString(6, client.getClientMail());
			pr.setString(7, client.getClientComment());
			pr.setInt(8, Integer.parseInt(client.getClientId()));
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
