package com.jdbcSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class CreateStudent {
	public static void main(String[] args) throws SQLException {

		Driver dri = new Driver();
		DriverManager.registerDriver(dri);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "saikumar");

		Statement statement = conn.createStatement();
		statement.executeUpdate("Create table Student2(Sid int(3), SFirst_name varchar(200),SLast_name varchar(200), "
				+ "Fee double(10,3), Branch varchar(200), Address varchar(200), mobile varchar(200))");
		System.out.println("Table Created successfully");

		statement.executeUpdate(
				" insert into student2 values (106, 'swaraj', 'bodh', 33000.000,'software','ntpc2','9492623813')");
//		statement.executeUpdate ("insert into student values (100,'saikumar','cheepurusetti',30000,'Eee','ntpc','9133883332')");
		System.out.println("Data recorded");
		System.out.println(" ");
		conn.close();

//		ResultSet set=statement.executeQuery("select * from student3");
//		while(set.next())
//		{
//			System.out.println(set.getInt("sid"));
//			System.out.println(set.getString("SFirst_name"));
//		}
//		System.out.println("Data recorded");
//		System.out.println(" ");
//		conn.close();
	}

}
