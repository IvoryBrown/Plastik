package com.project.setting.commodityname.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.setting.commodityname.pojo.CommodityName;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class CommodityNameDataBase {

	public ArrayList<CommodityName> getAllCommodityName() {
		String sql = "SELECT * FROM `alapanyag`";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<CommodityName> commodityName = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			commodityName = new ArrayList<>();

			while (rs.next()) {
				CommodityName actualCommodityName = new CommodityName(rs.getInt("alapanyag_id"), rs.getString("name"));
				commodityName.add(actualCommodityName);
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
		return commodityName;
	}

	public void addCommodityName(CommodityName commodityName) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `alapanyag` (name) VALUES (?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, commodityName.getCommodityName());
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
	
	public void updateCommodityName(CommodityName commodityName) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `alapanyag` SET name = ? WHERE alapanyag_id = ?";

			pr = conn.prepareStatement(sqlClient);
			pr.setString(1, commodityName.getCommodityName());
			pr.setInt(2, Integer.parseInt(commodityName.getCommodityNameId()));
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
