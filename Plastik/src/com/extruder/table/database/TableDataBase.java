package com.extruder.table.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;

public class TableDataBase {

	public ArrayList<Extruder> getAllExtruder(String search) {
		String sql = "SELECT * FROM `extruder` WHERE (`azonostio`) LIKE '%" + search
				+ "%' OR (`azonostio`) LIKE '%" + search + "%' OR (`azonostio`) LIKE '%" + search
				+ "%'";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Extruder> extruder = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			extruder = new ArrayList<>();

			while (rs.next()) {
				Extruder actualExtruder = new Extruder(rs.getInt("extruder_id"), rs.getInt("megrendelo_megrendelo_id"),
						rs.getString("azonostio"), rs.getString("allapot"), rs.getString("felvetel_idopont"),
						rs.getString("hatarido"), rs.getString("alapanyag"), rs.getString("tenyleges_meret"),
						rs.getString("meret_szeleseg"), rs.getString("meret_hossz"), rs.getString("vastagsag"),
						rs.getString("zsak_siklap"), rs.getString("gramm_meter"), rs.getString("megrendelt_kg"),
						rs.getString("legyartott_kg"), rs.getString("extruder_nev"), rs.getString("megjegyzes"));
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
