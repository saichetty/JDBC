package com.jdbc.fileReadWrite;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) {
		
		 try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement ps = con.prepareStatement("create table Image_text1 (Sl_no int(3), Photo BLOB, Textt text)");
			int result = ps.executeUpdate();
			System.out.println("Affected rows "+ result);
		
			PreparedStatement psimage = con.prepareStatement("insert into image_text1 values(?,?,?)");
			psimage.setInt(1, 100);
			
			FileInputStream fis = new FileInputStream("D:\\Downloads\\Test\\storeimage.jpg");
			psimage.setBinaryStream(2, fis,fis.available());
			
			File f = new File("D:\\Downloads\\Test\\testing");
			FileReader fr = new FileReader("D:\\Downloads\\Test\\testing.txt");
			psimage.setCharacterStream(3, fr);
			int result1 = psimage.executeUpdate();
			
			System.out.println("Affected rows "+ result1);
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("Throws My execption");
		}
		
		
		
	}

}
