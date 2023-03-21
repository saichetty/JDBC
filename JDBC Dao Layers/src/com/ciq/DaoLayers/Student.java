package com.ciq.DaoLayers;

import java.util.Date;

public class Student {
	
	private int id;
	private String name;
	private String email;
	private double fee;
	private Date dob;
	
	public Student(int id, String name, String email, double fee, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fee = fee;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Date getDob() {
		return dob;
	}

	public void setDare(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", fee=" + fee + ", dare=" + dob + "]";
	}
	
	

}
