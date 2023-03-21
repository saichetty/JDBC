package com.jdbcPreparedStmt;

import java.sql.*;

public class Employee {

	private int id;
	
	private String name;
	
	private double salary;
	
	private Date dob;

	public Employee() {
		super();
	}

	public Employee(int id, String name, double salary, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dob=" + dob + "]";
	}
	
	

	
}
