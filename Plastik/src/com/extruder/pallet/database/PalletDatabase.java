package com.extruder.pallet.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.extruder.pallet.pojo.Pallet;
import com.setting.database.DataBaseLocal;

public class PalletDatabase {

	public ArrayList<Pallet> getAllPallet(String id) {
		String sql = "SELECT * FROM `csomagolas` WHERE " + "(`csomagolas_id`) LIKE " + id;
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Pallet> pallet = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			pallet = new ArrayList<>();

			while (rs.next()) {
				Pallet actualPallet = new Pallet(rs.getInt("csomagolas_id"), rs.getString("cseve_tipus"),
						rs.getString("cseve_hossz"), rs.getString("cseve_vastagsag"), rs.getString("tekercs_atmero"),
						rs.getString("tekercs_tomeg"), rs.getString("tekercs_hossz"),
						rs.getString("tekrecs_atmero_min"), rs.getString("tekercs_tomeg_min"),
						rs.getString("tekercs_hossz_min"), rs.getString("egyedi_vevo"), rs.getString("raklap_tipus"),
						rs.getString("tekercs_szama"), rs.getString("b_raklaptomeg"), rs.getString("n_raklaptomeg"),
						rs.getString("nn_raklaptomeg"), rs.getString("tekercs_helyezes"),
						rs.getString("egyeb_megjegyzes"), rs.getString("raklap_csomagolas"),
						rs.getString("raklap_megjegyzes"));
				pallet.add(actualPallet);
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
		return pallet;
	}
}
