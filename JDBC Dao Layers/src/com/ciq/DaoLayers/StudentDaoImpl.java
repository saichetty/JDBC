package com.ciq.DaoLayers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;

	@Override
	public void save(Student student) {
		con = MyConnection.getConnect();

		try {

			ps = con.prepareStatement(SqlQueries.insert);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setDouble(4, student.getFee());
			ps.setDate(5, (Date) student.getDob());
			int result = ps.executeUpdate();
			System.out.println("Affected rows " + result);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void update(Student student) {

		try {
			ps = con.prepareStatement(SqlQueries.updateByName);
			
			ps.setString(1, " udemy" );
			ps.setInt(2, 100);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		
		con = MyConnection.getConnect();
		try {
			ps = con.prepareStatement(SqlQueries.delete);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public Student getByName(String name) {

		con = MyConnection.getConnect();
		try {
			ps = con.prepareStatement(SqlQueries.getByName);

			ps.setString(1, name);
			rs = ps.executeQuery();

			Student studentByName = null;

			while (rs.next()) {

				studentByName = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getDouble("fee"), rs.getDate("dob"));

				System.out.println(studentByName);
			}

			return studentByName;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public Student getById(int id) {

		con = MyConnection.getConnect();
		try {
			ps = con.prepareStatement(SqlQueries.getById);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			Student st = null;

			while (rs.next()) {
				st = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getDouble("fee"),
						rs.getDate("dob"));
				System.out.println(st);

			}
//			con.close();
//			ps.close();

			return st;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}