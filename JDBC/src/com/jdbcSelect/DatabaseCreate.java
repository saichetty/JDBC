package com.jdbcSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class DatabaseCreate {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","saikumar");
		Statement stat = con.createStatement();
		String createDB= "create database SAIKUMAR1";
		int result = stat.executeUpdate(createDB);
		System.out.println("Database created successfully");
		con.close();
		
	}

}
