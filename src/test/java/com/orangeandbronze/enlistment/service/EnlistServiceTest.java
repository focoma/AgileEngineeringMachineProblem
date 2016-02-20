package com.orangeandbronze.enlistment.service;

import org.junit.*;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Time.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EnlistServiceTest {

	private static final Semester SEMESTER_OPEN = new Semester(
			new SchoolYear(2015), Term.FIRST);

	@Test
	public void enlistFirst() {
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentDAO studentDao = mock(StudentDAO.class);
		EnlistService service = new EnlistService();
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);

		int studentNo = 777;
		Student student = new Student(studentNo);
		student.addStudentSemEnlistments(
				new StudentSemEnlistments(student, SEMESTER_OPEN));
		when(studentDao.findBy(studentNo)).thenReturn(student);
		String sectionId = "TFX123";
		Section section = new Section(sectionId, new Subject("Math53"),
				new Schedule(TF, new Period(H0830, H1000)),
				new Room("Lec1", 50));
		when(sectionDao.findBy(sectionId)).thenReturn(section);

		service.enlist(studentNo, sectionId);

		assertTrue(student.getOpenStudentSemEnlistments().getSections()
				.contains(section));
		verify(studentDao).save(student);
	}

}
