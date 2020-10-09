package application.client.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.client.pojo.Client;
import application.setting.database.DataBaseConnect;

public class ClientDB {

	// adatbazis lekerdezes
	public ArrayList<Client> getAllClient(String clientName) {
		Connection con = DataBaseConnect.getConnection();
		String sql = null;
		sql = "SELECT * FROM `client` WHERE CONCAT (`" + "client_company" + "`) LIKE '%" + clientName + "%' " + "OR"
				+ " (`" + "client_name" + "`) LIKE '%" + clientName + "%'";

		ArrayList<Client> client = null;
		Statement createStatement = null;
		ResultSet rs = null;
		try {
			createStatement = con.createStatement();
			rs = createStatement.executeQuery(sql);
			client = new ArrayList<>();
			while (rs.next()) {
				Client actualCLient = new Client(rs.getInt("client_id"), rs.getString("client_company"),
						rs.getString("client_county"), rs.getString("client_zipcode"), rs.getString("client_city"),
						rs.getString("client_address"), rs.getString("client_s_county"),
						rs.getString("client_s_zipcode"), rs.getString("client_s_city"),
						rs.getString("client_s_address"), rs.getString("client_name"), rs.getString("client_phone"),
						rs.getString("client_mail"), rs.getString("client_comment"));
				client.add(actualCLient);
			}
		} catch (SQLException e) {
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
			}
		}
		return client;
	}

	// Ugyfel adatbazis feltoltve
	public void addClient(Client client) {
		Connection con = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO `client` (client_company, client_county, client_zipcode, client_city,"
					+ " client_address, client_s_county, client_s_zipcode, client_s_city, client_s_address, client_name,"
					+ " client_phone, client_mail, client_comment) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientCompany());
			preparedStatement.setString(2, client.getClientCounty());
			preparedStatement.setString(3, client.getClientZipCode());
			preparedStatement.setString(4, client.getClientCity());
			preparedStatement.setString(5, client.getClientAddress());
			preparedStatement.setString(6, client.getClientSCounty());
			preparedStatement.setString(7, client.getClientSZipCode());
			preparedStatement.setString(8, client.getClientSCity());
			preparedStatement.setString(9, client.getClientSAddress());
			preparedStatement.setString(10, client.getClientName());
			preparedStatement.setString(11, client.getClientPhone());
			preparedStatement.setString(12, client.getClientEmail());
			preparedStatement.setString(13, client.getClientComment());
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
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

	// adatbazis javitas
	public void updateClient(Client client) {
		Connection conn = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sqlClient = "UPDATE `client` SET client_company = ?, client_county = ?, client_zipcode = ?,"
					+ "client_city = ?, client_address = ?, client_s_county = ?, client_s_zipcode = ?, client_s_city = ?,"
					+ " client_s_address = ?, client_name = ?, client_phone = ?, client_mail = ?, client_comment = ? WHERE client_id = ?";

			preparedStatement = conn.prepareStatement(sqlClient);
			preparedStatement.setString(1, client.getClientCompany());
			preparedStatement.setString(2, client.getClientCounty());
			preparedStatement.setString(3, client.getClientZipCode());
			preparedStatement.setString(4, client.getClientCity());
			preparedStatement.setString(5, client.getClientAddress());
			preparedStatement.setString(6, client.getClientSCounty());
			preparedStatement.setString(7, client.getClientSZipCode());
			preparedStatement.setString(8, client.getClientSCity());
			preparedStatement.setString(9, client.getClientSAddress());
			preparedStatement.setString(10, client.getClientName());
			preparedStatement.setString(11, client.getClientPhone());
			preparedStatement.setString(12, client.getClientEmail());
			preparedStatement.setString(13, client.getClientComment());
			preparedStatement.setInt(14, Integer.parseInt(client.getClientId()));
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
			}
		}
	}

	public void removeClient(String clientId) {
		Connection conn = DataBaseConnect.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = null;
			sql = "DELETE FROM `client` WHERE client_id = ?";

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(clientId));
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
			}
		}
	}

}
