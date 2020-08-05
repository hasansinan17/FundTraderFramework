package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {
String dbUsername="syntax_hrm";
    
    String dbPassword="syntaxhrm123";
    
    //jdbc:type driver:host:port/name of the database
    
    String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
    @Test
    public void getAndStoreData () throws SQLException {
    	  Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    	  
    	     
          Statement st=con.createStatement();
          
          ResultSet rslt=st.executeQuery("select * from ohrm_location;");
          List<Map<String,String>>listData=new ArrayList <>();
          while (rslt.next()) {
        	  Map<String,String>map=new LinkedHashMap<>();
        	  map.put("id", rslt.getObject("id").toString());
        	  map.put("name", rslt.getObject("name").toString());
        	  map.put("country_code", rslt.getObject("country_code").toString());
        	  map.put("city", rslt.getObject("city").toString() );
        	  listData.add(map);
     
          Iterator<Map<String,String>>it=listData.iterator();
          while(it.hasNext()) {
        	  System.out.println(it.next());
          }
        
          }
    }
    @Test
	public void getAndStoreDataEnhanced() throws SQLException {
		Connection connection=DriverManager.getConnection(dbUrl,dbUsername , dbPassword);
		Statement st=connection.createStatement();
		ResultSet rset=st.executeQuery("select id,name,country_code,city from ohrm_location;");
		
		ResultSetMetaData rsetMetaData=rset.getMetaData();
		List<Map<String,String>>listData=new ArrayList<>();
		
		Map<String,String> rowMap;
		
		while(rset.next()) {
			rowMap=new LinkedHashMap<>();
			for(int i=1;i<=rsetMetaData.getColumnCount(); i++) {
			rowMap.put(rsetMetaData.getColumnName(i), rset.getObject(i).toString());
			listData.add(rowMap);
			}
		}
	System.out.println(listData);
	
	}
    }
    

