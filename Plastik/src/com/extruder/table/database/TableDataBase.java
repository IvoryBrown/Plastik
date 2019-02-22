package com.extruder.table.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class TableDataBase {

	public ArrayList<Extruder> getAllExtruder(String extruderName, String filter, boolean check) {
		String s = "1";
		if (check) {
			s = "Folyamatban";
		} else {
			s = "";
		}
		System.out.println(s);
		String sql = "SELECT * FROM `megrendelo` JOIN `extruder` ON megrendelo_id = megrendelo_megrendelo_id WHERE extruder_nev LIKE '"
				+ extruderName + "'&& (`megrendelo_nev`) LIKE '%" + filter + "%'" + " || extruder_nev LIKE '"
				+ extruderName + "'" + "&& (`azonostio`) LIKE '%" + filter + "%'"
				+"' || allapot LIKE '" + s + "';"
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
				Extruder actualExtruder = new Extruder(rs.getInt("extruder_id"), rs.getInt("megrendelo_megrendelo_id"),
						rs.getString("megrendelo_nev"), rs.getString("azonostio"), rs.getString("allapot"),
						rs.getString("felvetel_idopont"), rs.getString("hatarido"), rs.getString("alapanyag"),
						rs.getString("tenyleges_meret"), rs.getString("meret_szeleseg"), rs.getString("meret_hossz"),
						rs.getString("vastagsag"), rs.getString("zsak_siklap"), rs.getString("gramm_meter"),
						rs.getString("megrendelt_kg"), rs.getString("extruder_nev"), rs.getString("megjegyzes"));
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

	public void updateExtruder(Extruder extruder) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `extruder` SET allapot = ?, extruder_nev = ?, megjegyzes = ? WHERE extruder_id = ?";
			pr = conn.prepareStatement(sqlClient);
			pr.setString(1, extruder.getExtruderStatus());
			pr.setString(2, extruder.getExtruderName());
			pr.setString(3, extruder.getExtruderComment());
			pr.setInt(4, Integer.parseInt(extruder.getExtruderId()));
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
