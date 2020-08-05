package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class Task {

String dbUsername="syntax_hrm";
    
    String dbPassword="syntaxhrm123";
    
    //jdbc:type driver:host:port/name of the database
    
    String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
    
    @Test
    public void AlijonTask() throws SQLException {
        
        Connection c=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        
        Statement st=c.createStatement();
        
        ResultSet rslt=st.executeQuery("select * from ohrm_job_title");
        
        LinkedList <String> arrData = new LinkedList<String>();
        
        while(rslt.next()){
            arrData.add(rslt.getString("job_title"));
        }
        System.out.println(arrData.toString());
        
        for(String data:arrData) {
            System.out.println(data);
        }
        
    }
}
