package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
 
 private static Connection con;
private	String url="jdbc:mysql://localhost:3306/demo";
 private String name="root";
 private	String password="8374@Naveen";
public static Connection connector() {
	
	 try {
		 String url="jdbc:mysql://localhost:3306/demo";
			
			String dbun="root";
			String dppws="8374@Naveen";
			  Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,dbun,dppws);
				System.out.println("DataBase Connection "+con+"Established");
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return con;
	 }
}

