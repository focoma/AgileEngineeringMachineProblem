package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class StudentSemEnlistmentTest {

	@Test
	public void getStudentSemEnlismentOfFreshGrad() {
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), new Room("P123", 2), Subject.Math1);
		Semester semester = new Semester(1, student, section);
		StudentSemEnlistments studSemEnlistments = new StudentSemEnlistments(semester, student);
		Collection<Semester> noOfSem = studSemEnlistments.getStudentSemesters(student);
		assertTrue(noOfSem.size() <= 0);
	}

}
