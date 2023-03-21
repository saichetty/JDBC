package com.jdbc.fileReadWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadText {

	public static void main(String[] args) {

		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","saikumar");
			PreparedStatement ps = con.prepareStatement("select * from filetable");
			
			ResultSet result = ps.executeQuery();
			result.next();
			Clob c = result.getClob(2);
			Reader r = c.getCharacterStream();
			FileWriter fw = new FileWriter("C:\\Users\\user\\OneDrive\\Desktop\\saikumar3.txt");
		
			int i;
			while((i = r.read())!=-1) 
				fw.write((char)i);
				System.out.println("Success");
			
			fw.close();
			con.close();
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("Exeception thrown");
		}
		
	}

}
