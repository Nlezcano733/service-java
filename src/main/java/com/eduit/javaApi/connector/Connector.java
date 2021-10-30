package com.eduit.javaApi.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String driver="com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/servicejava";
	private static String user = "root";
	private static String pass = "mainUser733dev";
	
	private Connector() {};
	public static Connection getConnection(){
		try {
            Class.forName(driver);
			return DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
