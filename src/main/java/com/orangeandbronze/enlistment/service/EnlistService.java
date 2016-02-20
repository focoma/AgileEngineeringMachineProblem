package com.orangeandbronze.enlistment.service;

import static org.mockito.Mockito.when;

import com.orangeandbronze.enlistment.Defaults;
import com.orangeandbronze.enlistment.*;
import com.orangeandbronze.enlistment.dao.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		final Student student = new Student(studentNo);
	    final Section section = new Section(sectionId, Defaults.SCHEDULE, new Room("GDO101",2), new Subject("Math"), 1);
	    
		when(studentDao.getStudentNo(studentNo)).thenReturn(student);
		when(sectionDao.getSectionId(sectionId)).thenReturn(section);
		student.enlist(section);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
}
