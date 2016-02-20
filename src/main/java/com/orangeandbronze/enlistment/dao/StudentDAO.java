package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.domain.Student;

public interface StudentDAO {
	Student findByStudentId(int studentNo);
	
	void addStudentSemester(Student student, Integer semesterId);
	void save(Student student);
}
