package com.jdbc.fileReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadImage {

	public static void main(String[] args) throws IOException {
		
	
		try {
			Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement ps = con.prepareStatement("select * from imgtable");
			
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				Blob blob = result.getBlob(2);
				FileOutputStream fos= new FileOutputStream("C:\\Users\\user\\OneDrive\\Desktop\\trrrfdfdrd.png");
				byte barr[]=blob.getBytes(1,(int)blob.length());
				fos.write(barr);
				fos.close();
			}
			System.out.println("ok");
			
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
	}

}
