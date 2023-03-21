package com.ciq.DaoLayers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	
	static Connection con= null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	static {	
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dao","root","saikumar");
//		System.out.println(con);
	
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}
	
	
	public static Connection getConnect(){
		return con;
	}
	
	public static void closeConnect (Connection con) {
		
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnect (Connection con, Statement st) {
		
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnect ( Connection con , Statement st, PreparedStatement ps ) {
		
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnect ( Connection con , Statement st, PreparedStatement ps , ResultSet rs) {
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}