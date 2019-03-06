package com.commoditycalculation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.commoditycalculation.pojo.CommodityCalculation;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class CalculationDataBase {

	public ArrayList<CommodityCalculation> getAllCommodityCalculation() {
		String sql = "SELECT * FROM `alapanyag_szamitas`";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<CommodityCalculation> commodityCalculation = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			commodityCalculation = new ArrayList<>();

			while (rs.next()) {
				CommodityCalculation actualCommodityCalculation = new CommodityCalculation(rs.getInt("alapanyag_id"),
						rs.getString("alapanyag_nev"), rs.getString("ossz_kg"), rs.getString("alap_nev_a"),
						rs.getString("alap_nev_b"), rs.getString("alap_nev_c"), rs.getString("alap_nev_d"),
						rs.getString("alap_nev_e"), rs.getString("alap_nev_f"), rs.getString("alap_nev_g"),
						rs.getString("alap_nev_h"), rs.getString("alap_szazalek_a"), rs.getString("alap_szazalek_b"),
						rs.getString("alap_szazalek_c"), rs.getString("alap_szazalek_d"),
						rs.getString("alap_szazalek_e"), rs.getString("alap_szazalek_f"),
						rs.getString("alap_szazalek_g"), rs.getString("alap_szazalek_h"), rs.getString("alap_kg_a"),
						rs.getString("alap_kg_b"), rs.getString("alap_kg_c"), rs.getString("alap_kg_d"),
						rs.getString("alap_kg_e"), rs.getString("alap_kg_f"), rs.getString("alap_kg_g"),
						rs.getString("alap_kg_h"));
				commodityCalculation.add(actualCommodityCalculation);
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
		return commodityCalculation;
	}
	
	public ArrayList<CommodityCalculation> getAllCommodityCalculationExtruderTable(String id) {
		String sql = "SELECT * FROM `alapanyag_szamitas`WHERE "
				+ "(`alapanyag_id`) LIKE " + id ;
		Connection con = DataBaseLocal.getConnection();
		ArrayList<CommodityCalculation> commodityCalculation = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			commodityCalculation = new ArrayList<>();
			
			while (rs.next()) {
				CommodityCalculation actualCommodityCalculation = new CommodityCalculation(rs.getInt("alapanyag_id"),
						rs.getString("alapanyag_nev"), rs.getString("ossz_kg"), rs.getString("alap_nev_a"),
						rs.getString("alap_nev_b"), rs.getString("alap_nev_c"), rs.getString("alap_nev_d"),
						rs.getString("alap_nev_e"), rs.getString("alap_nev_f"), rs.getString("alap_nev_g"),
						rs.getString("alap_nev_h"), rs.getString("alap_szazalek_a"), rs.getString("alap_szazalek_b"),
						rs.getString("alap_szazalek_c"), rs.getString("alap_szazalek_d"),
						rs.getString("alap_szazalek_e"), rs.getString("alap_szazalek_f"),
						rs.getString("alap_szazalek_g"), rs.getString("alap_szazalek_h"), rs.getString("alap_kg_a"),
						rs.getString("alap_kg_b"), rs.getString("alap_kg_c"), rs.getString("alap_kg_d"),
						rs.getString("alap_kg_e"), rs.getString("alap_kg_f"), rs.getString("alap_kg_g"),
						rs.getString("alap_kg_h"));
				commodityCalculation.add(actualCommodityCalculation);
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
		return commodityCalculation;
	}

	public void addCommodityCalculation(CommodityCalculation commodityCalculation) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `alapanyag_szamitas` (alapanyag_nev, ossz_kg, alap_nev_a, alap_nev_b, alap_nev_c, alap_nev_d, alap_nev_e, alap_nev_f, alap_nev_g, alap_nev_h"
					+ ", alap_szazalek_a, alap_szazalek_b, alap_szazalek_c, alap_szazalek_d, alap_szazalek_e, alap_szazalek_f, alap_szazalek_g, alap_szazalek_h"
					+ ", alap_kg_a, alap_kg_b, alap_kg_c, alap_kg_d, alap_kg_e, alap_kg_f, alap_kg_g, alap_kg_h)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, commodityCalculation.getCalculationName());
			preparedStatement.setString(2, commodityCalculation.getCommodityQuantity());
			preparedStatement.setString(3, commodityCalculation.getCommodityName1());
			preparedStatement.setString(4, commodityCalculation.getCommodityName2());
			preparedStatement.setString(5, commodityCalculation.getCommodityName3());
			preparedStatement.setString(6, commodityCalculation.getCommodityName4());
			preparedStatement.setString(7, commodityCalculation.getCommodityName5());
			preparedStatement.setString(8, commodityCalculation.getCommodityName6());
			preparedStatement.setString(9, commodityCalculation.getCommodityName7());
			preparedStatement.setString(10, commodityCalculation.getCommodityName8());
			preparedStatement.setString(11, commodityCalculation.getCommodityPercentage1());
			preparedStatement.setString(12, commodityCalculation.getCommodityPercentage2());
			preparedStatement.setString(13, commodityCalculation.getCommodityPercentage3());
			preparedStatement.setString(14, commodityCalculation.getCommodityPercentage4());
			preparedStatement.setString(15, commodityCalculation.getCommodityPercentage5());
			preparedStatement.setString(16, commodityCalculation.getCommodityPercentage6());
			preparedStatement.setString(17, commodityCalculation.getCommodityPercentage7());
			preparedStatement.setString(18, commodityCalculation.getCommodityPercentage8());
			preparedStatement.setString(19, commodityCalculation.getCommodityPercentageKg1());
			preparedStatement.setString(20, commodityCalculation.getCommodityPercentageKg2());
			preparedStatement.setString(21, commodityCalculation.getCommodityPercentageKg3());
			preparedStatement.setString(22, commodityCalculation.getCommodityPercentageKg4());
			preparedStatement.setString(23, commodityCalculation.getCommodityPercentageKg5());
			preparedStatement.setString(24, commodityCalculation.getCommodityPercentageKg6());
			preparedStatement.setString(25, commodityCalculation.getCommodityPercentageKg7());
			preparedStatement.setString(26, commodityCalculation.getCommodityPercentageKg8());
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
