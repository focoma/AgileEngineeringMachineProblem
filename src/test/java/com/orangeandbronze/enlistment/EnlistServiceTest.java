package com.orangeandbronze.enlistment;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.service.EnlistService;

public class EnlistServiceTest {

	@Test
	public void studentSemEnlistmentTest() {
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);

		final int studentNo = 1;
		final String sectionId = "ROSE";

		EnlistService service = new EnlistService();
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);

		when(studentDao.getStudentNo(studentNo)).thenReturn(new Student(studentNo));
		when(sectionDao.getSectionId(sectionId)).thenReturn(new Section(sectionId, new Schedule(Days.MTH, Period.H0830),
				new Room("GDO101", 2), new Subject("Math"), 1));

	}
}
