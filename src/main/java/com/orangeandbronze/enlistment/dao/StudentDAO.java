package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.Section;
import com.orangeandbronze.enlistment.Student;

public interface StudentDAO {
	
	Student getStudentNo(Integer studentNo);
	Student save(Student student);
}
