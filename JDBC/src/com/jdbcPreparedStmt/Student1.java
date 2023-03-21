package com.jdbcPreparedStmt;

public class Student1 {
	private int id;
	private String First_Name;
	private String Last_name;
	private double Fee;
	private String address;
	private String Email;
	private long Mobile;
	
	public Student1() {
		
	}
	
	public Student1 (int id, String First_Name, String Last_name,double Fee, String address,String Email,long Mobile) {
		this.id=id;
		this.First_Name=First_Name;
		this.Last_name=Last_name;
		this.Fee=Fee;
		this.address=address;
		this.Email=Email;
		this.Mobile=Mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public double getFee() {
		return Fee;
	}

	public void setFee(double fee) {
		Fee = fee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", First_Name=" + First_Name + ", Last_name=" + Last_name + ", Fee=" + Fee
				+ ", address=" + address + ", Email=" + Email + ", Mobile=" + Mobile + "]";
	}
	
	

}
