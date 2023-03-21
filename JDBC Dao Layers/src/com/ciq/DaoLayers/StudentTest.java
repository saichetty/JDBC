package com.ciq.DaoLayers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentTest {
	
	public static void main(String[] args) {
		
		try {
			String s1d = "16-07-1995";
			SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date s1date= sd.parse(s1d);
			java.sql.Date s1dob = new java.sql.Date(s1date.getTime());
			
			Student s1 = new Student(88, "saikumar", "saicetty4412@gmail12.com",20000,s1dob);
			 
			 String s2d = "17-03-1995";
			 java.util.Date s2date= sd.parse(s2d);
			 java.sql.Date s2dob = new java.sql.Date(s2date.getTime());
			 
			 Student s2 = new Student(89, "pradeep", "pradeep1@gmail234.com", 21000, s2dob);
			 
			 String s3d = "16-07-1997";
			 java.util.Date s3Date = sd.parse(s3d);
			 java.sql.Date s3dob = new java.sql.Date(s3Date.getTime());
			 
			 Student s3 = new Student(90, "vamshi", "vamshi1@gmail345.com", 25000, s3dob);
			 
			
			 StudentDaoImpl testImpl = new StudentDaoImpl();
			 
//			 testImpl.save(s1);
//			 testImpl.save(s2);
//			 testImpl.save(s3);
			 
			 
//			  if we didnt add print statement here , that means print allready added in studentImpl class before return.
//			System.out.println(testImpl.getById(91));
			
//			 testImpl.getById(91);
			 
			 // it shows in cosole that, cannot iterate after the connection  close.
//				testImpl.getByName("pradeep");
				
			testImpl.delete(107);
		
			
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
