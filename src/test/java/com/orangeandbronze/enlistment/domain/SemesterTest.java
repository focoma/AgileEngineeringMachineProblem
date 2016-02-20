package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import static com.orangeandbronze.enlistment.domain.Defaults.*;
import org.junit.Test;

public class SemesterTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSemesterId() {
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, Subject.Math1);
		new Semester(-1, student, section);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroSemesterId() {
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, Subject.Math1);
		new Semester(0, student, section);
	}
	
	@Test
	public void createValidSemester(){
		Student student = new Student(1);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, Subject.Math1);
		new Semester(1, student, section);
	}
}
