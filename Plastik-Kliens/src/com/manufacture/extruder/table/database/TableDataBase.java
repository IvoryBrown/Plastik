package com.manufacture.extruder.table.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.manufacture.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;

public class TableDataBase {

	public ArrayList<Extruder> getAllExtruder(String extruderName, String filter, boolean check) {
		String s = "1";
		if (check) {
			s = "Folyamatban";
		} else {
			s = "";
		}
		String sql = "SELECT * FROM `megrendelo` JOIN `extruder` ON megrendelo_id = megrendelo_megrendelo_id WHERE "
				+ "(`extruder_nev`) LIKE '%" + extruderName + "'&& (`allapot`) LIKE '%" + s + "%'"
				+ "&& (`megrendelo_nev`) LIKE '%" + filter + "%'" + " || (`extruder_nev`) LIKE '%" + extruderName + "'"
				+ "&& (`allapot`) LIKE '%" + s + "%'" + "&& (`azonostio`) LIKE '%" + filter + "%'"
				+ "ORDER BY prioritas ASC"

		;
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Extruder> extruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			extruder = new ArrayList<>();

			while (rs.next()) {
				Extruder actualExtruder = new Extruder(rs.getInt("extruder_id"), rs.getString("megrendelo_nev"),
						rs.getString("azonostio"), rs.getString("hatarido"), rs.getString("alapanyag"),
						rs.getString("tenyleges_meret"), rs.getString("meret_szeleseg"), rs.getString("meret_hossz"),
						rs.getString("vastagsag"), rs.getString("zsak_siklap"), rs.getString("megrendelt_kg"),
						rs.getString("megjegyzes"), rs.getInt("receptura_alapanyag_id"),
						rs.getInt("csomagolas_csomagolas_id"));
				extruder.add(actualExtruder);
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
		return extruder;
	}

}
