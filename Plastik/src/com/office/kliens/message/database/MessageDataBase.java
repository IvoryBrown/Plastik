package com.office.kliens.message.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.office.kliens.message.pojo.Message;
import com.setting.database.DataBaseLocal;
import com.setting.showinfo.ShowInfo;

public class MessageDataBase {

	public void updateClient(Message message) {
		Connection conn = DataBaseLocal.getConnection();
		PreparedStatement pr = null;
		try {
			String sqlClient = "UPDATE `kliens_message` SET message = ?, kliens_1 = ?, kliens_2 = ?,"
					+ "kliens_3 = ?, kliens_4 = ?, kliens_5 = ?, kliens_6 = ?, kliens_7 = ?, kliens_8 = ?, kliens_9 = ?, kliens_10 = ? WHERE kliens_message_id = ?";

			pr = conn.prepareStatement(sqlClient);
			pr.setString(1, message.getMessage());
			pr.setBoolean(2, message.getKliens1());
			pr.setBoolean(3, message.getKliens2());
			pr.setBoolean(4, message.getKliens3());
			pr.setBoolean(5, message.getKliens4());
			pr.setBoolean(6, message.getKliens5());
			pr.setBoolean(7, message.getKliens6());
			pr.setBoolean(8, message.getKliens7());
			pr.setBoolean(9, message.getKliens8());
			pr.setBoolean(10, message.getKliens9());
			pr.setBoolean(11, message.getKliens10());
			pr.setInt(12, Integer.parseInt(message.getMessageId()));
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
