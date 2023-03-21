package com.ciq.DaoLayers;

import java.util.List;

public interface StudentDao {
	
	void save(Student student);

	void update(Student student);

	void delete(int id);

	List<Student> findAll();

	Student getByName(String name);

	Student getById(int id);

}
