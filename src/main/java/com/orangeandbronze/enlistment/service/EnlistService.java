package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		Student student = studentDao.findBy(studentNo);
		StudentSemEnlistments semEnl = student.getOpenStudentSemEnlistments();
		Section section = sectionDao.findBy(sectionId);
		semEnl.enlist(section);
		studentDao.save(student);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	
}
