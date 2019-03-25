package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.client.Client;
import com.main.database.DBConnect;
import com.main.extruder.Extruder;
import com.main.leextruder.LeExtruder;

public class Main {
	static Client nclient = new Client();
	static Extruder extruder = new Extruder();
	static LeExtruder leExtruder = new LeExtruder();

	static int idClient;
	static int idExtruder;

	public static void main(String[] args) {
		runTask();
	}

	private static void runTask() {
		try {
			while (true) {
				upDataBase();

				Thread.sleep(300000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void upDataBase() {
		idClient++;
		idExtruder++;
		System.out.println(idClient +"<- ClientID");
		String extruderIdentification = extruder.getExtruderIdentification();
		String extruderName = extruder.getExtruderName();
		String clientName = nclient.getFullName();
		Connection con = DBConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `megrendelo` (megrendelo_id, megrendelo_nev, megrendelo_iranyitoszam, megrendelo_helyseg, megrendelo_utca,"
					+ " megrendelo_mobil, megrendelo_email) VALUES (?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			nclient.getFirstName();
			nclient.getLastName();
			preparedStatement.setInt(1, idClient);
			preparedStatement.setString(2, clientName);
			preparedStatement.setString(3, String.valueOf(nclient.getClientPostcode()));
			preparedStatement.setString(4, nclient.getClientCity());
			preparedStatement.setString(5, nclient.getClientStreet());
			preparedStatement.setString(6, nclient.getClientMobil());
			preparedStatement.setString(7, nclient.getClientemail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Automatikusan előállított elfogási blokk
			e.printStackTrace();

		}

		try {
			String sql = "INSERT INTO `extruder` (extruder_id,megrendelo_megrendelo_id, azonostio, allapot, felvetel_idopont, hatarido,"
					+ " alapanyag, tenyleges_meret, meret_szeleseg, meret_hossz, vastagsag, zsak_siklap, gramm_meter, megrendelt_kg, extruder_nev, megjegyzes,prioritas)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, idExtruder);
			preparedStatement.setInt(2, idClient);
			preparedStatement.setString(3, extruderIdentification);
			preparedStatement.setString(4, extruder.getExtruderStatus());
			preparedStatement.setString(5, extruder.getExtruderAddDate());
			preparedStatement.setString(6, extruder.getExtruderEndDate());
			preparedStatement.setString(7, extruder.getExtruderCommodity());
			preparedStatement.setString(8, extruder.getExtruderActualSize());
			preparedStatement.setString(9, extruder.getExtruderWidth());
			preparedStatement.setString(10, extruder.getExtruderLength());
			preparedStatement.setString(11, extruder.getExtruderThickness());
			preparedStatement.setString(12, extruder.getExtruderFlatPlateBag());
			preparedStatement.setString(13, extruder.getExtruderGrammMeter());
			preparedStatement.setString(14, extruder.getExtruderOrderedKg());
			preparedStatement.setString(15, extruderName);
			preparedStatement.setString(16, extruder.getExtruderComment());
			preparedStatement.setString(17, extruder.getExtruderPriority());
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);

		}
		try {
			
			for (int i = 0; i < 10; i++) {
				String sql = "INSERT INTO `jo_leadas_extruder` (gyartas_azonosito,extruder_gep, megrendelo_nev,n_kg,extruder_extruder_id)"
						+ " VALUES (?,?,?,?,?)";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, extruderIdentification);
				preparedStatement.setString(2, extruderName);
				preparedStatement.setString(3, clientName);
				preparedStatement.setString(4, leExtruder.getNnKg());
				preparedStatement.setInt(5, idExtruder);
				preparedStatement.execute();
				Thread.sleep(30000);
			}
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
		} catch (InterruptedException e) {
			// TODO Automatikusan előállított elfogási blokk
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}

	}

	private static void clientGenerator() {

		System.out.println("--------------Ügyfél----------------");
		System.out.println("Vezeték-> " + nclient.getFirstName());
		System.out.println("Kereszt-> " + nclient.getLastName());
		System.out.println("Teljes-> " + nclient.getFullName());
		System.out.println("Irányítószám-> " + nclient.getClientPostcode());
		System.out.println("Város-> " + nclient.getClientCity());
		System.out.println("Utca/ház-> " + nclient.getClientStreet());
		System.out.println("Mobil-> " + nclient.getClientMobil());
		System.out.println("Email-> " + nclient.getClientemail());

	}

	private static void extruderGenerator() {

		System.out.println("--------------Extruder-----------------");
		System.out.println("Azonosító-> " + extruder.getExtruderIdentification());
		System.out.println("Státusz-> " + extruder.getExtruderStatus());
		System.out.println("Felvétel-> " + extruder.getExtruderAddDate());
		System.out.println("Határidő-> " + extruder.getExtruderEndDate());
		System.out.println("Alapanyag-> " + extruder.getExtruderCommodity());
		System.out.println("Méret-> " + extruder.getExtruderActualSize());
		System.out.println("Szélesség-> " + extruder.getExtruderWidth());
		System.out.println("Hossz-> " + extruder.getExtruderLength());
		System.out.println("Vastagság-> " + extruder.getExtruderThickness());
		System.out.println("Zsák/Sík-> " + extruder.getExtruderFlatPlateBag());
		System.out.println("g/m-> " + extruder.getExtruderGrammMeter());
		System.out.println("Megrenelt/kg-> " + extruder.getExtruderOrderedKg());
		System.out.println("ExtruderNév-> " + extruder.getExtruderName());
		System.out.println("Megjegyzés-> " + extruder.getExtruderComment());
		System.out.println("Prioritás-> " + extruder.getExtruderPriority());

	}

	private static void transmission() {
		System.out.println("Azonosító-> " + extruder.getExtruderIdentification());
	}

}
