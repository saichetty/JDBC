package com.ciq.BatchTransactions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ciq.DaoLayers.MyConnection;
import com.ciq.DaoLayers.Student;

public class BatchDemo {
	
	static Connection con;
	static PreparedStatement ps;
	static PreparedStatement ps1;
	
		public static void main(String[] args) {
			
			con=MyConnection.getConnect();
			
			try {
				con.setAutoCommit(false);
				ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
	
				String s1d = "16-07-1995";
				SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date s1date= sd.parse(s1d);
				java.sql.Date s1dob = new java.sql.Date(s1date.getTime());
				
				Student s1 = new Student(108, "saikumar", "saisai@gmail5.com", 32000, s1dob); 
				Student s2 = new Student(109, "praneeth", "praneeth@gmail5.com", 23000, s1dob); 
				Student s3 = new Student(110, "kumar", "kumar@gmail5.com", 54000, s1dob); 
				Student s4 = new Student(111, "suman", "suman@gmail5.com", 24000, s1dob); 
				Student s5 = new Student(112, "pradeep", "pradeep@gmail5.com", 19000, s1dob); 
				Student s6 = new Student(114, "ch", "ch@gmail56.com", 16000, s1dob); 
				
				List<Student> list = new ArrayList<>();
				
				
				list.add(s1);
				list.add(s2);
				list.add(s3);
				list.add(s4);
				list.add(s5);
				list.add(s6);
				
				for (Student student : list) {
					ps.setInt(1, student.getId());
					ps.setString(2, student.getName());
					ps.setString(3, student.getEmail());
					ps.setDouble(4, student.getFee());
					ps.setDate(5, (Date) student.getDob() );
					ps.addBatch();
				}
				
				
				
				
				
				int[] r = ps.executeBatch();
				System.out.println(r);
				
				
				
				ps1 = con.prepareStatement("update student set name=? where id=?");
				ps1.setString(1, "sai");
				ps1.setInt(2, 100);
				
				ps1.addBatch();
				
				int[] r1 = ps1.executeBatch();
				System.out.println(r1);
			
				con.commit();
				
				
				
			} catch (SQLException | ParseException e) {
				try {
					con.rollback();
					System.out.println(" Error Occured Roll backed ");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				
				try {
					ps1.close();
					MyConnection.closeConnect(con,ps);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}

		
}
