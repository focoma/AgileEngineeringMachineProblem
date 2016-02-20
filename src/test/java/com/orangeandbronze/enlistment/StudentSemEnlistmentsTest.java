package com.orangeandbronze.enlistment;

import static com.orangeandbronze.enlistment.Defaults.ROOM;
import static com.orangeandbronze.enlistment.Defaults.SCHEDULE;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class StudentSemEnlistmentsTest {

	@Test
	public void addStudentAndSectionOneStudentTwoSection() {
		Student student = new Student(1);
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10), new Subject("English"), 1);
		StudentSemEnlistments studentSemEnlistments = new StudentSemEnlistments();
		Collection<Section> sectionList = new HashSet<Section>();
		sectionList.add(sectionRose);
		sectionList.add(sectionSampaguita);
		studentSemEnlistments.addStudentAndSection(student, sectionList);
		assertEquals(2, studentSemEnlistments.getStudentSectionsBySem(student, 1).size());
	}
	
	@Test(expected = StudentSemEnlistmentsException.class)
	public void addStudentWithSameSubjectInTwoSection() {
		Student student = new Student(1);
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		student.enlist(sectionRose);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10), new Subject("Math"), 1);
		student.enlist(sectionSampaguita);
	}

	@Test
	public void addStudentWithDiffSubjectInTwoSection() {
		Student student = new Student(1);
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		student.enlist(sectionRose);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10), new Subject("English"), 1);
		student.enlist(sectionSampaguita);
		
	}
	
	@Test (expected = StudentSemEnlistmentsException.class)
	public void addStudentWithSubjectPreRequisiteNotTaken() {
		Student student = new Student(1);
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math2", "Math1"), 1);
		student.enlist(sectionRose);
	}
	
	@Test
	public void addStudentWithSubjectPreRequisiteTaken() {
		Student student = new Student(1);
		Section sectionSampaguita = new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math1"), 1);
		student.enlist(sectionSampaguita);
		Section sectionRose = new Section("ROSE", new Schedule(Days.WS, Period.H1600), ROOM, new Subject("Math2", "Math1"), 1);
		student.enlist(sectionRose);
	}
}
