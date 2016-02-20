package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Time.*;
import static com.orangeandbronze.enlistment.domain.Semester.*;
import static com.orangeandbronze.enlistment.domain.Term.*;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class SemesterEnlistmentTest {

	private static final Semester SEMESTER_OPEN = new Semester(
			new SchoolYear(2015), Term.FIRST);

	@Test
	public void enlistFirstSection() {
		Student student = new Student(7);
		Section section = new Section("MHX123", new Subject("Math53"),
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("Lec1", 50));
		StudentSemEnlistments enlistement = new StudentSemEnlistments(student,
				SEMESTER_OPEN);
		enlistement.enlist(section);
		assertTrue(enlistement.getSections().contains(section));
	}

	@Test(expected = SchedueConflictException.class)
	public void enlistSectionSameScheduleAsCurrentSection() {
		Student student = new Student(7);
		Section section1 = new Section("MHX123", new Subject("Math53"),
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("Lec1", 50));
		StudentSemEnlistments enlistement = new StudentSemEnlistments(student,
				SEMESTER_OPEN);
		enlistement.enlist(section1);
		Section section2 = new Section("MHX456", new Subject("Philo1"),
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("AVR2", 50));
		enlistement.enlist(section2);
	}

	@Test
	public void enlistSectionWithPrereq() {
		Student student = new Student(7);
		Subject prereq = new Subject("Math17");
		Collection<Section> prevSections = new ArrayList<>();
		Semester prevSem = new Semester(new SchoolYear(2013), FIRST);
		prevSections.add(new Section("PrereqSection", prereq,
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("Lec1", 50)));
		StudentSemEnlistments prevEnlistment = new StudentSemEnlistments(
				student, prevSem, prevSections);
		student.addStudentSemEnlistments(prevEnlistment);
		Subject subject = new Subject("Math53", prereq);
		Section section = new Section("MHX123", subject,
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("AVR2", 50));
		StudentSemEnlistments currentEnlistments = new StudentSemEnlistments(
				student, SEMESTER_OPEN);
		student.addStudentSemEnlistments(currentEnlistments);
		currentEnlistments.enlist(section);
		assertTrue(currentEnlistments.getSections().contains(section));
	}

	@Test(expected = PrereqNotTakenException.class)
	public void enlistSectionMissingPrereq() {
		Student student = new Student(7);
		Subject prereq = new Subject("Math17");
		Subject subject = new Subject("Math53", prereq);
		Section section = new Section("MHX123", subject,
				new Schedule(MTH, new Period(H0830, H1000)),
				new Room("Lec1", 50));
		StudentSemEnlistments enlistment = new StudentSemEnlistments(student,
				SEMESTER_OPEN);
		enlistment.enlist(section);
	}

}
