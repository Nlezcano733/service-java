package com.eduit.javaApi.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static String url = "jdbc:mysql://localhost:3306/servicejava";
	private static String user = "root";
	private static String pass = "mainUser733dev";
	
	private Connector() {};
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
