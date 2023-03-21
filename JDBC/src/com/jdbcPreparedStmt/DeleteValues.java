package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteValues {
	
	public static void main(String[] args) {
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "saikumar");
			PreparedStatement psdelete= con.prepareStatement("delete from employee where id=? limit 1" );
			
			psdelete.setInt(1, 100);
			
			int result = psdelete.executeUpdate();
			System.out.println("Affected rows "+ result);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Throw exeception");
		}
		
}
}
