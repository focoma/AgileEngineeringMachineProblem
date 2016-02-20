package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class EnlistServiceTest {
	
	@Test
	public void enlistServiceTest(){
		SectionDAO secDao = mock(SectionDAO.class);
		StudentDAO studentDao = mock(StudentDAO.class);
		EnlistService enlistService = new EnlistService();
		final int studentNo = 3;
		final String sectionId = "AA";
		enlistService.enlist(studentNo, sectionId);
	}
	
}
