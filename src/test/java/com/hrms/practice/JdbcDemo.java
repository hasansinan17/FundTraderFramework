package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
//jdbc : type driver : host :port/name of the data
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void getDataFromDatabase() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("Connection is created");

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");

		rs.next();
		String firstname=rs.getString("emp_firstname");
		System.out.println(firstname);
		
		rs.next();
		String fname2=rs.getString("emp_firstname");
		System.out.println(fname2);
		
		while (rs.next()) {
			String allData=rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		
		rs.close();
		st.close();
		connection.close();
//		rsetNationality.next();
//		String firstRowData = rsetNationality.getString("name");
//		System.out.println(firstRowData);
//		
//		rsetNationality.next();
//		String SecondRowData = rsetNationality.getObject("name").toString();
//		System.out.println(SecondRowData);
//		
//		while(rs.next()) {
//			String data=rs.getObject("name").toString();
//			System.out.println(data);
//		}
//		rs.close(); // bunu kapatmazsan diger table a gecemiyorsun 
//		st.close();  // bunu kapatmazsan diger table a gecemiyorsun
//		connection.close(); // bunu kapatmazsan diger table a gecemiyorsun
	}
}

