package com.jdbcPreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
	
	static String insert="insert into employe values(?,?,?)";
	
	public static void main(String[] args) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			//System.out.println(con);
			PreparedStatement ps=con.prepareStatement(insert);
			Employee e=new Employee();
			Employee e1=new Employee();
			
			//if we want to add more employee details at one time use 
			Employee [] emp= {e,e1};
			
			for (Employee employee : emp) {
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setDouble(3, employee.getSalary());
				int i = ps.executeUpdate();
				System.out.println(i);	
			}
			
			
		} catch (SQLException e) {

			System.out.println("exception occurs");
			e.printStackTrace();
		}
	}
	

}
