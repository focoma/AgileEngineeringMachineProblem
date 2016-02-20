package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Defaults.*;
import static org.junit.Assert.*;
import static com.orangeandbronze.enlistment.domain.Subject.*;

import org.junit.Test;

import com.orangeandbronze.enlistment.domain.Room;

public class SectionTest {
	
	@Test
	public void sectionIdAlphaNumeric() {
		new Section("aBc123", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		new Section("123", SCHEDULE, 2, ROOM1, SUBJECT_NO_PREREQ);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasUnderscore() {
		new Section("hello_World", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasAmpersand() {
		new Section("hello&World", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void addTwoSectionsToRoomWithoutScheduleConflict() {
		Section s1 = new Section("S1", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		Section s2 = new Section("S2", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		assertTrue(s1.getRoom().equals(s1.getRoom()));
	}
	
	@Test 
	public void incrementStudentEnlistCounterWithoutExceedingRoomCapacity() {
		Student student = new Student(1);
		Section section = new Section("S1", SCHEDULE, 1, ROOM2, SUBJECT_NO_PREREQ);
		section.incrementStudentEnlistCounter();
		assertEquals(1, section.getStudentEnlistCounter());
	}
	
	@Test(expected = ExceedsRoomCapacityException.class)
	public void incrementStudentEnlistCounterExceedsRoomCapacity() {
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Section section = new Section("S1", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		for(int i = 1; i <= 3; i++) {
			section.incrementStudentEnlistCounter();
		}
	}
	
	@Test
	public void sectionsWithDiffSchedButSameRoom(){
		new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		new Section("B", SCHEDULE2, 1, ROOM1, SUBJECT_NO_PREREQ);
		new Section("C", SCHEDULE3, 1, ROOM1, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void sectionsWithSameSchedDifferentRooms(){
		new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		new Section("B", SCHEDULE, 1, ROOM2, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void sectionsWithSameIdDifferentSchedAndRooms(){
		new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		new Section("A", SCHEDULE, 1, ROOM2, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void subjectCheckIfPreRequisitesHasBeenTaken(){
		Section section2 = new Section("B", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		Section section1 = new Section("B", SCHEDULE, 1, ROOM1, SUBJECT_WITH_PREREQ);
	    section1.checkIfPreRequisiteSubjectHasBeenTaken(section2);
	}
	
	@Test(expected = SubjectPreRequisitiesException.class)
	public void subjectCheckIfPreRequisitesHasBeenTaken1(){
		Section subject1 = new Section("B", SCHEDULE, 1, ROOM1, SUBJECT_WITH_PREREQ);
		Section subject2 = new Section("B", SCHEDULE, 1, ROOM1, SUBJECT_WITH_PREREQ);
		subject1.checkIfPreRequisiteSubjectHasBeenTaken(subject2);	
	}	
}

