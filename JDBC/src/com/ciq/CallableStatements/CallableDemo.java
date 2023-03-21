package com.ciq.CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {
	public static void main(String[] args) {	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			System.out.println(con);
			CallableStatement csadd = con.prepareCall("{call add_two_num(?,?,?)}");
			
			csadd.setInt(1, 40);
			csadd.setInt(2, 20);
			csadd.registerOutParameter(3, Types.INTEGER);
//			csadd.setInt(3, 1);
			csadd.executeUpdate();
			System.out.println(csadd.getInt(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
