package com.production.transmissionfinished.extruder.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.production.transmissionfinished.extruder.pojo.TransmissionExtruder;
import com.production.transmissionfinished.extruder.pojo.TransmissionFinished;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class TransmissionExtruderDataBase {

	public ArrayList<TransmissionFinished> getAllTransmision(Integer extruderId) {
		String sql = "SELECT * FROM `jo_leadas_extruder` WHERE `extruder_extruder_id` = " + extruderId + "";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<TransmissionFinished> transmissionFinished = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			transmissionFinished = new ArrayList<>();

			while (rs.next()) {
				TransmissionFinished actualTransmissionFinished = new TransmissionFinished(rs.getInt("leadas_id"),
						rs.getString("gyartas_azonosito"), rs.getString("leadas_azonosito"),
						rs.getString("extruder_gep"), rs.getString("datum"), rs.getString("dolgozo_nev"),
						rs.getString("megrendelo_nev"), rs.getString("tenyleges_meret"), rs.getDouble("b_kg"),
						rs.getDouble("n_kg"), rs.getString("cseveszam"), rs.getBoolean("delete"),
						rs.getInt("extruder_extruder_id"));
				transmissionFinished.add(actualTransmissionFinished);
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
		return transmissionFinished;
	}

	// nkg data tabel
	public ArrayList<TransmissionExtruder> getTransmisionNKg(Integer extruderId) {

		String sql = "SELECT * FROM `jo_leadas_extruder` WHERE `extruder_extruder_id` = " + extruderId
				+ "&& `delete` = 0 || `delete` IS NULL ";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<TransmissionExtruder> transmissionExtruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			transmissionExtruder = new ArrayList<>();

			while (rs.next()) {
				TransmissionExtruder actualTransmissionExtruder = new TransmissionExtruder(rs.getDouble("b_kg"),
						rs.getInt("extruder_extruder_id"));
				transmissionExtruder.add(actualTransmissionExtruder);
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
		return transmissionExtruder;
	}

	// nkg data label print
	public ArrayList<TransmissionExtruder> getTransmisionLabelNKg(String extruderId, String min, String max) {

		String sql = "SELECT * FROM `jo_leadas_extruder` WHERE " + "leadas_id BETWEEN " + min + " AND " + max
				+ "&& `extruder_extruder_id` = " + extruderId + "&& `delete` = 0 || `delete` IS NULL ";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<TransmissionExtruder> transmissionExtruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			transmissionExtruder = new ArrayList<>();

			while (rs.next()) {
				TransmissionExtruder actualTransmissionExtruder = new TransmissionExtruder(rs.getInt("leadas_id"),
						rs.getDouble("b_kg"), rs.getInt("extruder_extruder_id"));
				transmissionExtruder.add(actualTransmissionExtruder);
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
		return transmissionExtruder;
	}

	public void addTransmission(TransmissionFinished transmissionFinished) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `jo_leadas_extruder` (gyartas_azonosito, leadas_azonosito, extruder_gep, datum, dolgozo_nev, megrendelo_nev, tenyleges_meret, b_kg, n_kg, cseveszam, extruder_extruder_id)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, transmissionFinished.getTransmissionExtruderIdentification());
			preparedStatement.setString(2, transmissionFinished.getTransmissionIdentification());
			preparedStatement.setString(3, transmissionFinished.getTransmissionExtruderName());
			preparedStatement.setString(4, transmissionFinished.getTransmissionDate());
			preparedStatement.setString(5, transmissionFinished.getTransmissionWorkerName());
			preparedStatement.setString(6, transmissionFinished.getTransmissionClientName());
			preparedStatement.setString(7, transmissionFinished.getTransmissionExtruderActualSize());
			preparedStatement.setDouble(8, Double.valueOf(transmissionFinished.getTransmissionBKg()));
			preparedStatement.setDouble(9, Double.valueOf(transmissionFinished.getTransmissionNKg()));
			preparedStatement.setString(10, transmissionFinished.getTransmissionSpool());
			preparedStatement.setString(11, transmissionFinished.getExtruderId());

			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex.getMessage());
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
				System.out.println("" + ex.getMessage());
			}
		}
	}

	// update (delete) tabel row

	public void removeTransmissionFinished(TransmissionFinished client) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = null;
			sqlClient = "UPDATE `jo_leadas_extruder` set `delete` = ?" + " WHERE `leadas_id` = ?";

			pr = conn.prepareStatement(sqlClient);
			pr.setBoolean(1, true);
			pr.setInt(2, Integer.parseInt(client.getTransmissionId()));
			pr.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				new ShowInfo("Adatbázis Hiba", "Szerver válasza: ", e.getMessage());
			}
		}
	}
}
