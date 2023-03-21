package com.ciq.BatchTransactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransiantRollback {
	static Connection con = null;
	static PreparedStatement ps = null;
	static PreparedStatement ps1 = null;

	public static void main(String[] args) {

		try {

//	Here you did not close ps, ps1. so I intialized those as static before the first try block.

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Dao", "root", "saikumar");
			con.setAutoCommit(false);

// So here i put only Ps reference
			ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, 116);
			ps.setString(2, "rajesh");
			ps.setString(3, "rajesh@gmail1.com");
			ps.setInt(4, 90000);

			String s1d = "16-07-1995";
			SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date s1date = sd.parse(s1d);
			java.sql.Date s1dob = new java.sql.Date(s1date.getTime());
			ps.setDate(5, s1dob);

			ps.addBatch();
//	Previously  You have added this print statement at below the insertion and update i.e, bottom of Two queries	
//	So if insertion is correct but there is no syso near the Insertion. thatsy  didnt print the insertion syso.	
			int a[] = ps.executeBatch();
			System.out.println(a + " :inserted");

			ps1 = con.prepareStatement("update student set email=? where id=?  ");

			ps1.setString(3, " msi@gmail.com");
			ps1.setInt(2, 102);

			ps1.addBatch();

			int rs[] = ps1.executeBatch();
			System.out.println(rs + " :updated");

			con.commit();

		} catch (SQLException | ParseException | ClassNotFoundException e) {
			try {
				con.rollback();
				System.out.println("error was occured");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
// Here i close the all connections
				ps.close();
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
