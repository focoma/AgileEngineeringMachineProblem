package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class StudentSemEnlistmentTest {

	@Test
	public void getStudentSemEnlismentOfFreshGrad() {
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 2, new Room("P123", 2), Subject.Math1);
		StudentSemEnlistment semester = new StudentSemEnlistment(student);
		Semester studSemEnlistments = new Semester(1, semester);
		//studSemEnlistments.addStudentSemester();
		//Collection<StudentSemEnlistment> noOfSem = studSemEnlistments.getStudentSemesters(student);
		//assertTrue(noOfSem.size() <= 1);
	}
	
	@Test
	public void getStudentSemEnlistmentOfSophomore(){
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math1);
		Section section2 = new Section("A", new Schedule(Days.WS, Period.H0830), 2, new Room("P122", 2), Subject.Math2);
		student.enlist(section);
		student.enlist(section2);
		StudentSemEnlistment semester = new StudentSemEnlistment(student);
		StudentSemEnlistment semester2 = new StudentSemEnlistment(student);
		Semester studSemEnlistments = new Semester(1, semester);
		Semester studSemEnlistments2 = new Semester(2, semester2);
		//studSemEnlistments.addStudentSemester();
		//studSemEnlistments2.addStudentSemester();
		//Collection<StudentSemEnlistment> noOfSem = studSemEnlistments.getStudentSemesters(student);
//		System.out.println(noOfSem.size());
//		assertTrue(noOfSem.size() > 1);
	}
	
	@Test
	public void checkIfStudenthasTakenTheSubject(){
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math2);
		Section section1 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math2);
		Section section2 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math2);
		StudentSemEnlistment semEnlist = new StudentSemEnlistment(student);
		semEnlist.enlistInSection(section2);
		semEnlist.enlistInSection(section1);
	}
	
	@Test
	public void checkIfStudenthasTakenTheSubjectError(){
		Student student = new Student(1);
		Section section = new Section("A", new Schedule(Days.MTH, Period.H1130), 1, new Room("P123", 2), Subject.Math2);
		Section section1 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math2);
		Section section2 =  new Section("A", new Schedule(Days.MTH, Period.H1000), 1, new Room("P123", 2), Subject.Math2);
		StudentSemEnlistment semEnlist = new StudentSemEnlistment(student);
		semEnlist.enlistInSection(section2);
		semEnlist.enlistInSection(section1);
	}

}
