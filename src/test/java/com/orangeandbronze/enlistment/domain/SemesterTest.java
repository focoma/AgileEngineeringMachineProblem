package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Defaults.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SemesterTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSemesterId() {
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		StudentSemEnlistment studentSemEnlistment = new StudentSemEnlistment(student, section);
		Semester semester = new Semester(-1, studentSemEnlistment);
		semester.addToSemesters(studentSemEnlistment);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroSemesterId() {
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		StudentSemEnlistment studentSemEnlistment = new StudentSemEnlistment(student, section);
		Semester semester = new Semester(0, studentSemEnlistment);
		semester.addToSemesters(studentSemEnlistment);
	}
	
	@Test
	public void createValidSemester(){
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		StudentSemEnlistment studentSemEnlistment = new StudentSemEnlistment(student, section);
		Semester semester = new Semester(1, studentSemEnlistment);
		semester.addToSemesters(studentSemEnlistment);
	}
}
