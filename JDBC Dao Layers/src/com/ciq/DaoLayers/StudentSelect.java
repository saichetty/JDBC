package com.ciq.DaoLayers;

public class StudentSelect {
	public static void main(String[] args) {
		
		StudentDaoImpl impl = new StudentDaoImpl();
		
		
		System.out.println(impl.getById(100));
		
		
		
	}

}
