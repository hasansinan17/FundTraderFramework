package com.hrms.utils;


public class Constants {

	
public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\configs\\config.properties";
	
	public static final String TEST_DATA_FILEPATH =System.getProperty("user.dir")+ "\\src\\test\\resources\\testData\\Book2.xlsx";
	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"\\target\\html-report\\HRMS.html";
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"\\screenshot";
	public static final String USER_NAME=System.getProperty("user.name");

	public static final String  CREATE_EMPLOYEE_FILEPATH = System.getProperty("user.dir")+"/src/test/resources/JSONFiles/createEmployee.json";
	
	public static final String CREATE_EMPLOYEE_URI = "http://18.232.148.34/syntaxapi/api/createEmployee.php";
	
	
}
