package com.kliens.message.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kliens.message.pojo.Message;
import com.setting.database.DataBaseLocal;
import com.setting.file.DBFileWriter;
import com.setting.showinfo.ShowInfo;

public class MessageDataBase {

	public ArrayList<Message> getAllMessage() {
		String sql = "SELECT * FROM `kliens_message` ";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<Message> message = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			message = new ArrayList<>();

			while (rs.next()) {
				Message actualMessage = new Message(rs.getInt("kliens_message_id"), rs.getString("message"),
						rs.getBoolean("kliens_1"), rs.getBoolean("kliens_2"), rs.getBoolean("kliens_3"),
						rs.getBoolean("kliens_4"), rs.getBoolean("kliens_5"), rs.getBoolean("kliens_6"),
						rs.getBoolean("kliens_7"), rs.getBoolean("kliens_8"), rs.getBoolean("kliens_9"),
						rs.getBoolean("kliens_10"));
				message.add(actualMessage);
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
		return message;
	}

	public void updateClient(String id, boolean kliens_1) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `kliens_message` SET  " + DBFileWriter.outputKliensName()
					+ " = ? WHERE kliens_message_id = ?";

			pr = conn.prepareStatement(sqlClient);
			pr.setBoolean(1, kliens_1);
			pr.setInt(2, Integer.parseInt(id));
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
