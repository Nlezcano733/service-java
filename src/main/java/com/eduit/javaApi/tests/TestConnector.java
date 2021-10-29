package com.eduit.javaApi.tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eduit.javaApi.connector.Connector;

public class TestConnector {
	public static void main (String [] args) {
		try (ResultSet rs = Connector
				.getConnection()
				.createStatement()
				.executeQuery("select version()");
			){
			if(rs.next()) System.out.println(rs.getString(1));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
