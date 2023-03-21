package com.jdbcSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateStudentTable {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","saikumar");
		Statement statement = connection.createStatement();
		String create = "create table vehicle(Rgst_no int(4),Bike varchar(100),Brand varchar(100),YOR int (4))";
		int result = statement.executeUpdate(create);
//		ResultSet rs = statement.executeQuery(create);
		System.out.println("Table Creation is succussfull");
		
//		while (rs.next()) {
//			System.out.println(rs.getInt(1));
//			System.out.println(rs.getString(2));
//		}
		
	}

}
