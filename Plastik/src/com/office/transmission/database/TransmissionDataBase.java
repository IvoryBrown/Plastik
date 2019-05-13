package com.office.transmission.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.office.transmission.pojo.TransmissionFinished;
import com.setting.database.DataBaseLocal;

public class TransmissionDataBase {

	// Table up
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
						rs.getDouble("n_kg"), rs.getString("cseveszam"), rs.getInt("extruder_extruder_id"));
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

	// delete tabel row

	public void removeTransmissionFinished(TransmissionFinished transmissionFinished) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "DELETE FROM `jo_leadas_extruder` WHERE leadas_id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(transmissionFinished.getTransmissionId()));
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact törlésekor");
			System.out.println("" + ex);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasásakor");
				System.out.println("" + e);
			}
		}
	}
}
