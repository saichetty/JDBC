package com.ciq.CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CallableEmployee {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			CallableStatement cs = con.prepareCall("{call in_data(?,?,?,?,?,?,?)}");
			
			cs.setInt(1, 102);
			cs.setString(2, "pradeep");
			cs.setString(3, "k");
			cs.setDouble(4, 2000.00);
			cs.setString(5, "rdm");
			cs.setString(6, "pradeep@gmail.com");
			cs.setLong(7, 888983332l);
			
			int result = cs.executeUpdate();
			System.out.println("Affected rows "+result);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
