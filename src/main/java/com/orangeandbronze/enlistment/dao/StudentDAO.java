package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.domain.Student;

public interface StudentDAO {
	void save(Student student);
	Student findBy(int id);
}
