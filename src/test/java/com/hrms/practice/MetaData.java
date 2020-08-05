package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";

	//String dbUrl= "jdbc:type driver:host:port/name of the database";

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
//
//	@Test
//	public void getMetaData() throws SQLException {
//
//		Connection c = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//		DatabaseMetaData dbData = c.getMetaData();
//		String dbName = dbData.getDatabaseProductName();
//		String dbVersion = dbData.getDatabaseProductVersion();
//
//		System.out.println(dbName);
//		System.out.println(dbVersion);
//
//		Statement s = c.createStatement();
//
//		ResultSet rset = s.executeQuery("select * from hs_hr_employees where emp_number=14688");
//
//		ResultSetMetaData resultdata = rset.getMetaData();
//		int cols = resultdata.getColumnCount();
//		System.out.println(cols);
//		
//		String colName=resultdata.getColumnClassName(1);
//		System.out.println(colName);
//		
//		for (int i=1; i<cols;i++) {
//		String col=resultdata.getColumnName(i);
//		System.out.println(col);
//		}
//	}
	@Test
	public void rsMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where emp_number = 14688");
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int colNumbers = rsMetadata.getColumnCount();
		System.out.println(colNumbers);
		String colName1 =rsMetadata.getColumnName(1);
		System.out.println(colName1);
		
		for (int i=1; i<=colNumbers;i++) {
			String colName=rsMetadata.getColumnName(i);
			System.out.println(colName);
		}
	}
}
