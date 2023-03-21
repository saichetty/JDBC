package com.jdbcPreparedStmt;

import java.sql.*;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

public class UpdateValues {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement psupdate=null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			
		    psupdate = con.prepareStatement("update student set  First_name=? where id=? ");
			
			psupdate.setString(1, "com");
			psupdate.setInt(2, 99);
			
			int result = psupdate.executeUpdate();
			System.out.println("Affected rows "+result);
			
			
			PreparedStatement psinsert = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			
			Student1 student = new Student1(109, "saikummar", "Ch", 25000.00, "ntpc1", "ssaichetty@gmail.com", 913883332l);
			
			psinsert.setInt(1, student.getId());
			psinsert.setString(2, student.getFirst_Name());
			psinsert.setString(3, student.getLast_name());
			psinsert.setDouble(4, student.getFee());
			psinsert.setString(5, student.getAddress());
			psinsert.setString(6, student.getEmail());
			psinsert.setLong(7, student.getMobile());
			
			int insertResult = psinsert.executeUpdate();
			System.out.println("Affected rows "+ insertResult);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Show an execption");
		}
		
	}
}
