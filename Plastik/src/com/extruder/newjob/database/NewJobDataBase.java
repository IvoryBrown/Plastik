package com.extruder.newjob.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.commoditycalculation.pojo.CommodityCalculation;
import com.extruder.pallet.pojo.Pallet;
import com.extruder.pojo.Extruder;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class NewJobDataBase {

	public void addNewJob(Extruder extruder) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `extruder` (megrendelo_megrendelo_id, azonostio, allapot, felvetel_idopont, hatarido,"
					+ " alapanyag, tenyleges_meret, meret_szeleseg, meret_hossz, vastagsag, zsak_siklap, gramm_meter, megrendelt_kg, extruder_nev, megjegyzes, receptura_alapanyag_id, csomagolas_csomagolas_id)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			preparedStatement.setString(17, extruder.getExtruderPalletId());
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

	public void addCommodityCalculation(CommodityCalculation commodityCalculation) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `receptura` (alapanyag_id, alapanyag_nev, ossz_kg, alap_nev_a, alap_nev_b, alap_nev_c, alap_nev_d, alap_nev_e, alap_nev_f, alap_nev_g, alap_nev_h"
					+ ", alap_szazalek_a, alap_szazalek_b, alap_szazalek_c, alap_szazalek_d, alap_szazalek_e, alap_szazalek_f, alap_szazalek_g, alap_szazalek_h"
					+ ", alap_kg_a, alap_kg_b, alap_kg_c, alap_kg_d, alap_kg_e, alap_kg_f, alap_kg_g, alap_kg_h)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, commodityCalculation.getCommodityId());
			preparedStatement.setString(2, commodityCalculation.getCalculationName());
			preparedStatement.setString(3, commodityCalculation.getCommodityQuantity());
			preparedStatement.setString(4, commodityCalculation.getCommodityName1());
			preparedStatement.setString(5, commodityCalculation.getCommodityName2());
			preparedStatement.setString(6, commodityCalculation.getCommodityName3());
			preparedStatement.setString(7, commodityCalculation.getCommodityName4());
			preparedStatement.setString(8, commodityCalculation.getCommodityName5());
			preparedStatement.setString(9, commodityCalculation.getCommodityName6());
			preparedStatement.setString(10, commodityCalculation.getCommodityName7());
			preparedStatement.setString(11, commodityCalculation.getCommodityName8());
			preparedStatement.setString(12, commodityCalculation.getCommodityPercentage1());
			preparedStatement.setString(13, commodityCalculation.getCommodityPercentage2());
			preparedStatement.setString(14, commodityCalculation.getCommodityPercentage3());
			preparedStatement.setString(15, commodityCalculation.getCommodityPercentage4());
			preparedStatement.setString(16, commodityCalculation.getCommodityPercentage5());
			preparedStatement.setString(17, commodityCalculation.getCommodityPercentage6());
			preparedStatement.setString(18, commodityCalculation.getCommodityPercentage7());
			preparedStatement.setString(19, commodityCalculation.getCommodityPercentage8());
			preparedStatement.setString(20, commodityCalculation.getCommodityPercentageKg1());
			preparedStatement.setString(21, commodityCalculation.getCommodityPercentageKg2());
			preparedStatement.setString(22, commodityCalculation.getCommodityPercentageKg3());
			preparedStatement.setString(23, commodityCalculation.getCommodityPercentageKg4());
			preparedStatement.setString(24, commodityCalculation.getCommodityPercentageKg5());
			preparedStatement.setString(25, commodityCalculation.getCommodityPercentageKg6());
			preparedStatement.setString(26, commodityCalculation.getCommodityPercentageKg7());
			preparedStatement.setString(27, commodityCalculation.getCommodityPercentageKg8());
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

	public void addPallet(Pallet pallet) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `csomagolas` (csomagolas_id, cseve_tipus, cseve_hossz, cseve_vastagsag, tekercs_atmero,"
					+ " tekercs_tomeg, tekercs_hossz, tekrecs_atmero_min, tekercs_tomeg_min, tekercs_hossz_min, egyedi_vevo, raklap_tipus, tekercs_szama,"
					+ " b_raklaptomeg, n_raklaptomeg, nn_raklaptomeg, tekercs_helyezes, egyeb_megjegyzes, raklap_csomagolas, raklap_megjegyzes)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, pallet.getPalletId());
			preparedStatement.setString(2, pallet.getPalletSpoolType());
			preparedStatement.setString(3, pallet.getPalletSpoolLenght());
			preparedStatement.setString(4, pallet.getPalletSpoolSize());
			preparedStatement.setString(5, pallet.getPalletCoilDiameter());
			preparedStatement.setString(6, pallet.getPalletCoilOfSpools());
			preparedStatement.setString(7, pallet.getPalletColiLength());
			preparedStatement.setString(8, pallet.getPalletColiMinDiameter());
			preparedStatement.setString(9, pallet.getPalletColiMinOfSpools());
			preparedStatement.setString(10, pallet.getPalletColiMinLength());
			preparedStatement.setString(11, pallet.getPalletSpoolComment());
			preparedStatement.setString(12, pallet.getPalletType());
			preparedStatement.setString(13, pallet.getPalletRollsNumber());
			preparedStatement.setString(14, pallet.getPalletBCrowd());
			preparedStatement.setString(15, pallet.getPalletNCrowd());
			preparedStatement.setString(16, pallet.getPalletNNCrowd());
			preparedStatement.setString(17, pallet.getPalletLocation());
			preparedStatement.setString(18, pallet.getPalletComment());
			preparedStatement.setString(19, pallet.getPalletWrapping());
			preparedStatement.setString(20, pallet.getPalletWrappingComment());
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
