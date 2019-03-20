package com.production.transmissionfinished.extruder.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.production.transmissionfinished.extruder.pojo.TransmissionExtruder;
import com.production.transmissionfinished.extruder.pojo.TransmissionFinished;
import com.setting.database.DataBaseLocal;

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
}
