package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import java.util.Collection;
import static com.orangeandbronze.enlistment.domain.Defaults.*;
import org.junit.Test;

public class StudentSemEnlistmentTest {

	@Test
	public void getStudentSemEnlismentOfFreshGrad() {
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		Semester semester = new Semester(1, student, section);
		StudentSemEnlistments studSemEnlistments = new StudentSemEnlistments(semester, student);
		Collection<Semester> noOfSem = studSemEnlistments.getStudentSemesters(student);
		assertTrue(noOfSem.size() <= 0);
	}

}
