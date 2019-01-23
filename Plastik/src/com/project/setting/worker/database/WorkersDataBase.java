package com.project.setting.worker.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.setting.worker.pojo.Workers;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class WorkersDataBase {

	public void addWorker(Workers workers) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `dolgozok` (dolgozok_nev, dolgozok_azonosito, dolgozok_aktiv "
					+ ") VALUES (?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, workers.getWorkersName());
			preparedStatement.setString(2, workers.getWorkersPassword());
			preparedStatement.setString(3, workers.getWorkersStatus());
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
