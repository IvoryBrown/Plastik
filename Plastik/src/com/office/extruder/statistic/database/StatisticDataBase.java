package com.office.extruder.statistic.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.setting.database.DataBaseLocal;

public class StatisticDataBase {

	// All kg statistic
	public double data(String name, String startDate, String endDate) {
		double value = 0.0;
		String sql = "SELECT  SUM(b_kg) FROM `jo_leadas_extruder` WHERE `delete` = 0 AND datum between '" + startDate
				+ "' AND '" + endDate + "' AND extruder_gep = '" + name + "'";
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			rs.next();
			String sum = rs.getString(1);
			System.out.println(sum + " : " + name + " ->" + startDate + " . " + endDate);
			if (sum != null && !sum.trim().isEmpty()) {
				value = Double.parseDouble(sum);

			}
		} catch (SQLException exc) {
			System.out.println(exc.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// System.out.println("Valami baj van a userek kiolvasásakor");
				// System.out.println("" + e);
			}
		}
		return value;
	}
}
