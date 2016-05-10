package com.gcproject.ezpz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EZPZDao {

	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static Connection readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezpz", "root", "sesame");

			return connect;

		} catch (Exception e) {
			throw e;
		}

	}
	
	public static Statement getStatement() throws Exception, SQLException {
		connect = readDataBase();
		statement = connect.createStatement();
		return statement;
	}

	public static String getMeals(String query) throws Exception {

		statement = getStatement();
		resultSet = statement.executeQuery("select * from ezpz.ezpz_table where Meat = '" + query + "'");
		// writeResultSet(resultSet);
		resultSet.next();
		String results = resultSet.getString("Meal");

		return results;

	}


	public static  String getVeggies(String query) throws Exception{
		statement = getStatement();
		resultSet = statement.executeQuery("select * from ezpz.ezpz_table where Veggie = '" + query + "'");
		resultSet.next();
		String results = resultSet.getString("Veggie");
		
		return results;
	}
	
	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
