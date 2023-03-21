package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.*;

public class InsertValues {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
		
//		Date date = new Date(0);
//		String d = "dd-mm-yyyy";
		Date date = new Date();

		
//		By object creation entry
		Employee e = new Employee(2, "Sai", 23456.00, new java.sql.Date (date.getTime()));
		
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setDouble(3, e.getSalary());
		ps.setDate(4, e.getDob());
		int result = ps.executeUpdate();
		System.out.println("rows affected "+ result);
	
	}

}
