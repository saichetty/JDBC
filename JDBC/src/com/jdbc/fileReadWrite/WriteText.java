package com.jdbc.fileReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteText {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement ps = con.prepareStatement("insert into filetable values(?,?)");
			
			File f = new File("D:\\Downloads\\Test\\testing.txt");
			
			FileReader fr = new FileReader(f);
			ps.setInt(1, 102);
			ps.setCharacterStream(2, fr);
			int result = ps.executeUpdate();
			System.out.println("Affected rows "+ result);
			con.close();
			
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("Exeception thrown");
		}
		
	}

}
