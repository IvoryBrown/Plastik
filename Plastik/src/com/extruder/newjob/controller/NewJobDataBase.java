package com.extruder.newjob.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class NewJobDataBase {

	public void addNewJob(Extruder Extruder) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `extruder` (megrendelo_megrendelo_id, azonostio, allapot, felvetel_idopont, hatarido,"
					+ " alapanyag, tenyleges_meret, meret_szeleseg, meret_hossz, vastagsag, zsak_siklap, gramm_meter, megrendelt_kg, extruder_nev, megjegyzes) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, Extruder.getExtruderClientId());
			preparedStatement.setString(2, Extruder.getExtruderIdentification());
			preparedStatement.setString(3, Extruder.getExtruderStatus());
			preparedStatement.setString(4, Extruder.getExtruderAddDate());
			preparedStatement.setString(5, Extruder.getExtruderEndDate());
			preparedStatement.setString(6, Extruder.getExtruderCommodity());
			preparedStatement.setString(7, Extruder.getExtruderActualSize());
			preparedStatement.setString(8, Extruder.getExtruderWidth());
			preparedStatement.setString(9, Extruder.getExtruderLength());
			preparedStatement.setString(10, Extruder.getExtruderThickness());
			preparedStatement.setString(11, Extruder.getExtruderFlatPlateBag());
			preparedStatement.setString(12, Extruder.getExtruderGrammMeter());
			preparedStatement.setString(13, Extruder.getExtruderOrderedKg());
			preparedStatement.setString(14, Extruder.getExtruderName());
			preparedStatement.setString(15, Extruder.getExtruderComment());
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
