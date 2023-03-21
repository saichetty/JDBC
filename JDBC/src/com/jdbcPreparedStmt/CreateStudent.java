package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateStudent {

	public static void main(String[] args)  {
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement pscreate = con.prepareStatement("create table Student ( id int(4), First_name varchar(100),Last_name varchar(100),Fee decimal(6,2), address varchar(100))");
			
			int result = pscreate.executeUpdate();
			System.out.println("Affected rows "+ result);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Throws exeception");
		}
		
	}
}
