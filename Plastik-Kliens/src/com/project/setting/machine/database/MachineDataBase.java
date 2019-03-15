package com.project.setting.machine.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.setting.machine.pojo.Machine;
import com.setting.database.DataBaseLocal;

public class MachineDataBase {

	public ArrayList<Machine> getAllMachine() {
		String sql = "SELECT * FROM `extruder_nev`";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Machine> machine = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			machine = new ArrayList<>();

			while (rs.next()) {
				Machine actualMachine = new Machine(rs.getInt("extruder_id"), rs.getString("extruder_nev"));
				machine.add(actualMachine);
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
		return machine;
	}
}
