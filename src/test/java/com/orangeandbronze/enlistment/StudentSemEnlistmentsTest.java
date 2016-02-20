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
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"));
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10), new Subject("English"));
		StudentSemEnlistments studentSemEnlistments = new StudentSemEnlistments();
		Collection<Section> sectionList = new HashSet<Section>();
		sectionList.add(sectionRose);
		sectionList.add(sectionSampaguita);
		studentSemEnlistments.addStudentAndSection(student, sectionList);
		assertEquals(2, studentSemEnlistments.getSections(student).size());
	}

}
