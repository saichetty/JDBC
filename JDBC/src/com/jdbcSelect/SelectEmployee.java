package com.jdbcSelect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;

public class SelectEmployee {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "saikumar");
		System.out.println(connection);
		String selectQuery = "select * from employee";
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(selectQuery);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getDouble(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
		}
		rs.close();
		statement.close();
		connection.close();
		
		
	}

}
