package com.jdbc.fileReadWrite;

import java.sql.*;
import java.io.*;

public class WriteImage {
	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement ps = con.prepareStatement("insert into imgtable values(?,?)");
			
			ps.setString(1, "ch");
			FileInputStream fin = new FileInputStream("C:\\Users\\user\\OneDrive\\Desktop\\imgg.png");
			ps.setBinaryStream(2, fin);
			int i = ps.executeUpdate();
			
			System.out.println(i + " records affected");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}