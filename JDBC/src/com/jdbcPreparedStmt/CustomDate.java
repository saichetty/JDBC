package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class CustomDate {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement pscd = con.prepareStatement("update employee set dob=? where id=? ");
		
			String s = "16-07-1995";
			SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date date= sd.parse(s);
			java.sql.Date fd = new java.sql.Date(date.getTime());
			
			pscd.setDate(1, fd);
			pscd.setInt(2, 2);
			
			
			int result = pscd.executeUpdate();
			System.out.println("Affected rows "+ result);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}

}
