package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentValues {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement pscreate = con.prepareStatement("create table Student ( id int(10), First_name varchar(100),"
					+ "Last_name varchar(100),Fee decimal(10,2), address varchar(100),Email varchar(100), mobile BIGINT(100) )");
			int result =	pscreate.executeUpdate();
			System.out.println("Affected rows "+ result);
		
			Student1 student = new Student1(1000, "saikumar", "Ch", 25000.00, "ntpc", "saichetty@gmail.com", 9133883332l);

			PreparedStatement psinsert = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			
			psinsert.setInt(1, student.getId());
			psinsert.setString(2, student.getFirst_Name());
			psinsert.setString(3, student.getLast_name());
			psinsert.setDouble(4, student.getFee());
			psinsert.setString(5, student.getAddress());
			psinsert.setString(6, student.getEmail());
			psinsert.setLong(7, student.getMobile());
			
			int insertResult = psinsert.executeUpdate();
			System.out.println("Affected rows "+ insertResult);
			
//			psinsert.setInt(1, 1000);
//			psinsert.setString(2, "Saikumar");
//			psinsert.setString(3, "ch");
//			psinsert.setDouble(4, 25000.00);
//			psinsert.setString(5, "ntpc");
//			psinsert.setString(6, "saichetty44@gmail.com");
//			psinsert.setLong(7, 9133883332L);
//			
//			int result = psinsert.executeUpdate();
//			System.out.println("Affected rows "+ result);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Throws my exeception");
		}
		
	}

}
