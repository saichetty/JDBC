package com.jdbcSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteStudent {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","saikumar");
		Statement statement = connection.createStatement();
		String delete = "delete from student where sid=107";
		int result = statement.executeUpdate(delete);
		System.out.println(result + " Delete successfully");
		connection.close();
	}

}
