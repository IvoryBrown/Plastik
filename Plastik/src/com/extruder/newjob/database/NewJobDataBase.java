package com.extruder.newjob.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class NewJobDataBase {

	public void addNewJob(Extruder extruder) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `extruder` (megrendelo_megrendelo_id, azonostio, allapot, felvetel_idopont, hatarido,"
					+ " alapanyag, tenyleges_meret, meret_szeleseg, meret_hossz, vastagsag, zsak_siklap, gramm_meter, megrendelt_kg, extruder_nev, megjegyzes, alapanyag_szamitas_alapanyag_id)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, extruder.getExtruderClientId());
			preparedStatement.setString(2, extruder.getExtruderIdentification());
			preparedStatement.setString(3, extruder.getExtruderStatus());
			preparedStatement.setString(4, extruder.getExtruderAddDate());
			preparedStatement.setString(5, extruder.getExtruderEndDate());
			preparedStatement.setString(6, extruder.getExtruderCommodity());
			preparedStatement.setString(7, extruder.getExtruderActualSize());
			preparedStatement.setString(8, extruder.getExtruderWidth());
			preparedStatement.setString(9, extruder.getExtruderLength());
			preparedStatement.setString(10, extruder.getExtruderThickness());
			preparedStatement.setString(11, extruder.getExtruderFlatPlateBag());
			preparedStatement.setString(12, extruder.getExtruderGrammMeter());
			preparedStatement.setString(13, extruder.getExtruderOrderedKg());
			preparedStatement.setString(14, extruder.getExtruderName());
			preparedStatement.setString(15, extruder.getExtruderComment());
			preparedStatement.setString(16, extruder.getExtruderComodityId());
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
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
			}
		}
	}
}
