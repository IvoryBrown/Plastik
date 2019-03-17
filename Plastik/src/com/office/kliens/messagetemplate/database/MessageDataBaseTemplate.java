package com.office.kliens.messagetemplate.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.office.kliens.messagetemplate.pojo.MessageTemplate;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class MessageDataBaseTemplate {

	public ArrayList<MessageTemplate> getAllMessage() {
		String sql = "SELECT * FROM `kliens_message_template` ";
		Connection con = DataBaseLocal.getConnection();
		ArrayList<MessageTemplate> message = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			message = new ArrayList<>();

			while (rs.next()) {
				MessageTemplate actualMessage = new MessageTemplate(rs.getInt("kliens_message_id"), rs.getString("message"));
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

	public void addMessage(MessageTemplate message) {
		Connection con = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `kliens_message_template` (message)" + " VALUES (?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, message.getMessage());

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

	public void removeMessage(MessageTemplate message) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = null;
			sql = "DELETE FROM `kliens_message_template` WHERE kliens_message_id = ?";

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(message.getMessageId()));
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a eszköz törlésekor");
			System.out.println("" + ex);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				new ShowInfo("Adatbázis Hiba", "Szerver válasza: ", e.getMessage());
			}
		}
	}
}
