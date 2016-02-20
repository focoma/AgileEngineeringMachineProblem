package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class StudentSemEnlistmentTest {

	@Test
	public void getStudentSemEnlismentOfFreshGrad() {
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 2, new Room("P123", 2), Subject.Math1);
		StudentSemEnlistment studSemEnlistments = new StudentSemEnlistment(student, student.getSections());
		Semester semester = new Semester(1);
		semester.addToSemesters(studSemEnlistments);
		Collection<StudentSemEnlistment> noOfSem = semester.getStudentSemesters(student);
		assertTrue(noOfSem.size() <= 1);
	}
	
	@Test
	public void getStudentSemEnlistmentOfSophomore(){
		Semester semester = new Semester(1);
	
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math1);
		Section section2 = new Section("B", new Schedule(Days.WS, Period.H0830), 2, new Room("P122", 2), Subject.Math2);
		Section section3 = new Section("A", new Schedule(Days.MTH, Period.H1430), 1, new Room("P123", 2), Subject.Math3);
		student.enlist(section);
		student.enlist(section2);
		StudentSemEnlistment studEnlistment = new StudentSemEnlistment(student, student.getSections());
		semester.addToSemesters(studEnlistment);
		Semester semester2 = new Semester(2);
		student.enlist(section3);
		StudentSemEnlistment studEnlistment2 = new StudentSemEnlistment(student, student.getSections());
		semester2.addToSemesters(studEnlistment2);
		Collection<StudentSemEnlistment> sem1 = semester.getStudentSemesters(student);
		Collection<StudentSemEnlistment> sem2 = semester2.getStudentSemesters(student);
		assertTrue(sem1.size() + sem2.size() > 1);
	}
	
	@Test(expected = SubjectConflictException.class)
	public void checkIfStudenthasTakenTheSubject(){
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math2);
		Section section1 =  new Section("A", new Schedule(Days.MTH, Period.H1430), 1, new Room("P123", 2), Subject.Math2);
		Section section2 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math2);
		StudentSemEnlistment semEnlist = new StudentSemEnlistment(student, student.getSections());
		student.enlist(section1);
		student.enlist(section2);
	}
	
	@Test
	public void checkIfStudenthasTakenTheSubjectError(){
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math1);
		Section section1 =  new Section("A", new Schedule(Days.MTH, Period.H1430), 1, new Room("P123", 2), Subject.Math2);
		Section section2 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math3);
		StudentSemEnlistment semEnlist = new StudentSemEnlistment(student, student.getSections());
		student.enlist(section1);
		student.enlist(section2);
		//semEnlist.enlistInSection(section3);
	}

}
