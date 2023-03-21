package com.ciq.DaoLayers;

public class SqlQueries {

	static String insert = "insert into student values (?,?,?,?,?)";
	static String update = "update student set name=?, email=?, fee=?, dob=? where id=?";
	static String updateByName = "update student set name=? where id=?";
	static String delete = "delete from student where id=?";
	static String select = "select * from student";
	static String getById = " select * from student where id=?";
	static String getByName = "select * from student where name=?";

}
