package com.orangeandbronze.enlistment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.domain.Section;
import com.orangeandbronze.enlistment.domain.Student;
import static com.orangeandbronze.enlistment.domain.Defaults.*;

public class EnlistServiceTest {
	
	@Test
	public void enlistServiceTest(){
		SectionDAO secDao = mock(SectionDAO.class);
		StudentDAO studentDao = mock(StudentDAO.class);
		EnlistService enlistService = new EnlistService();
		enlistService.setStudentDao(studentDao);
		enlistService.setSectionDao(secDao);
		final int studentNo = 3;
		final String sectionId = "AA";
		Student student = new Student(studentNo);
		Section section = new Section(sectionId, SCHEDULE,1 ,ROOM1, SUBJECT_NO_PREREQ);
		when(studentDao.findByStudentId(studentNo)).thenReturn(student);
		when(secDao.findBySectionId(sectionId)).thenReturn(section);
		enlistService.enlist(student.getStudentNumber(), section.getSectionId());
	}
	
}
