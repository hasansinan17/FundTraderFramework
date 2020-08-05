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

import org.junit.Test;

public class HW {
	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";



	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	@Test
	public void rsMetadata() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM syntaxhrm_mysql.hs_hr_emp_language");
		ResultSetMetaData rsdata = result.getMetaData();
		int colNum = rsdata.getColumnCount();
		
		
		for (int i=1; i<=colNum;i++) {
			String colName=rsdata.getColumnName(i);
			System.out.println(colName);
		}
		
	}
		@Test
		public void getAndStoreData() throws SQLException {
			Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ohrm_nationality");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			List<Map<String, String>> listOfData = new ArrayList<>();
			Map<String, String> mapData;
			while(rs.next()) {
				mapData = new LinkedHashMap<>();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					if(rsMetaData.getColumnName(i).equalsIgnoreCase("id")) {
						mapData.put("Nationality ID", rs.getObject(i).toString());
					}else if(rsMetaData.getColumnName(i).equalsIgnoreCase("name")) {
						mapData.put("Nationality", rs.getObject(i).toString());
					}
				}
				listOfData.add(mapData);
			}
		
}
}
