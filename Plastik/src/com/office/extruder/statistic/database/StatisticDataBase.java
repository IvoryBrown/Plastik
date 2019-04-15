package com.office.extruder.statistic.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.production.transmission.extruder.pojo.TransmissionExtruder;
import com.setting.database.DataBaseLocal;

public class StatisticDataBase {
	public ArrayList<TransmissionExtruder> getAllStatistic() {
		String sql = "SELECT * FROM `jo_leadas_extruder` WHERE datum > DATE_SUB(NOW(), INTERVAL 1 MONTH)";
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
