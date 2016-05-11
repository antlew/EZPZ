package com.site.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EZPZDao {

	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public static Connection readDataBase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject", "root", "sesame");
		
		return connect;
	}
	
	public static Statement getStatement() throws Exception, SQLException {
		connect = readDataBase();
		statement = connect.createStatement();

		return statement;
	}

	public static ArrayList<String> getMeals(String query) throws Exception {
		statement = getStatement();
		resultSet = statement.executeQuery("select * from new_table where Meat = '" + query + "'");
		
		ArrayList<String> meals = new ArrayList<String>();
		while(resultSet.next()){
			meals.add(resultSet.getString("Meal"));
		}
		return meals;
	}


	public static ArrayList<String> getVeggies(String query) throws Exception{
		statement = getStatement();
		resultSet = statement.executeQuery("select * from new_table where Meal = '" + query + "'");

		ArrayList<String> recipes = new ArrayList<String>();
		while(resultSet.next()){
			recipes.add(resultSet.getString("Veggie"));
		}
		return recipes;
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
