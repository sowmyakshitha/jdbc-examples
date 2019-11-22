package com.training.myapp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateDemo {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement insert = connection.prepareStatement(sql1);
				PreparedStatement update = connection.prepareStatement(sql2)) {

			connection.setAutoCommit(false);

			insert.setInt(1, 101);
			insert.setString(2, "Sowmya");
			insert.addBatch();

			insert.setInt(1, 102);
			insert.setString(2, "Pinky");
			insert.addBatch();
			insert.executeBatch();
			update.setString(1, "Manu");
			update.setInt(2, 101);

			update.setString(1, "Karthik");
			update.setInt(2, 102);

			update.addBatch();
			update.executeBatch();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static final String sql1 = "INSERT INTO names VALUES (?,?)";
	private static final String sql2 = "UPDATE names SET name=? WHERE id=?";

}
