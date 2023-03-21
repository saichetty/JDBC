package com.jdbcSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;





public class UpdateStudent {

	public static void main(String[] args) throws SQLException {
		
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "saikumar");
	Statement statement = connection.createStatement(); 
//	statement.executeUpdate("update student set sid=001 where sid=100");
	String update	 = " update student set sid=100 where sid is null ";
	int result = statement.executeUpdate(update);
	System.out.println("Update successfull");
//	To see the table
//	String selectQurey = "select * from student order by sid asc";
//	
//	ResultSet result = statement.executeQuery(selectQurey);
//	while(result.next()) {
//		System.out.println(result.getInt(1));
//		System.out.println(result.getString(2));
//	}
//	System.out.println(result);
	
	connection.close();
	}

}
