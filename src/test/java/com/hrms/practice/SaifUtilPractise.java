package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hrms.utils.ConfigsReader;

public class SaifUtilPractise {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static List<Map<String, String>> dataList;

	

	public static void connectiontoDB() {

		try {
			connection = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static List<Map<String, String>> dbDataStore(String sqlQuery) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			ResultSetMetaData rsetData = resultSet.getMetaData();
			dataList = new ArrayList<>();

			while (resultSet.next()) {
				Map<String, String> rowMap = new LinkedHashMap<>();
				for (int i = 1; i <= rsetData.getColumnCount(); i++) {
					rowMap.put(rsetData.getColumnLabel(i), resultSet.getObject(i).toString());
				}
				dataList.add(rowMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public static void tearDownDB() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
//			if (statement != null) {a
//				statement.close();
//			}
			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
