package com.production.transmissionfinished.extruder.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.manufacture.commoditycalculation.pojo.CommodityCalculation;
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
						rs.getString("gyartas_azonosito"), rs.getString("extruder_gep"), rs.getString("datum"),
						rs.getString("dolgozo_nev"), rs.getString("megrendelo_nev"), rs.getString("tenyleges_meret"),
						rs.getDouble("b_kg"), rs.getDouble("n_kg"), rs.getString("cseveszam"),
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

	public ArrayList<TransmissionExtruder> getTransmisionNKg(Integer extruderId) {
		String sql = "SELECT * FROM `jo_leadas_extruder` WHERE `extruder_extruder_id` = " + extruderId + "";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<TransmissionExtruder> transmissionExtruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			transmissionExtruder = new ArrayList<>();

			while (rs.next()) {
				TransmissionExtruder actualTransmissionExtruder = new TransmissionExtruder(rs.getDouble("n_kg"),
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

	public void addTransmission(TransmissionFinished transmissionFinished) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `jo_leadas_extruder` (gyartas_azonosito, extruder_gep, datum, dolgozo_nev, megrendelo_nev, tenyleges_meret, b_kg, n_kg, cseveszam, extruder_extruder_id"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, transmissionFinished.getTransmissionExtruderIdentification());
			preparedStatement.setString(2, transmissionFinished.getTransmissionExtruderName());
			preparedStatement.setString(3, transmissionFinished.getTransmissionDate());
			preparedStatement.setString(4, transmissionFinished.getTransmissionWorkerName());
			preparedStatement.setString(5, transmissionFinished.getTransmissionClientName());
			preparedStatement.setString(6, transmissionFinished.getTransmissionExtruderActualSize());
			preparedStatement.setDouble(7, Double.valueOf(transmissionFinished.getTransmissionBKg()));
			preparedStatement.setDouble(8, Double.valueOf(transmissionFinished.getTransmissionNKg()));
			preparedStatement.setString(9, transmissionFinished.getTransmissionSpool());
			preparedStatement.setString(10, transmissionFinished.getExtruderId());

			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex.getMessage() + "/n" + ex.getSQLState());
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
}
