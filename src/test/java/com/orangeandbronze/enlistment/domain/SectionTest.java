package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.assertEquals;
import static com.orangeandbronze.enlistment.domain.Defaults.*;
import static org.junit.Assert.assertTrue;
import static com.orangeandbronze.enlistment.domain.Subject.*;

import org.junit.Test;

import com.orangeandbronze.enlistment.domain.Room;

public class SectionTest {
	
	final Room ROOM = new Room("S306", 2);
	
	@Test
	public void sectionIdAlphaNumeric() {
		Room room = new Room("R101", 10);
		new Section("aBc123", SCHEDULE, room, SUBJECT_NO_PREREQ);
		new Section("123", SCHEDULE, room, SUBJECT_NO_PREREQ);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasUnderscore() {
		Room room = new Room("R101", 10);
		new Section("hello_World", SCHEDULE, room, SUBJECT_NO_PREREQ);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasAmpersand() {
		Room room = new Room("R101", 10);
		new Section("hello&World", SCHEDULE, room, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void addTwoSectionsToRoomWithoutScheduleConflict() {
		Room room = new Room("R101", 10);
		Section s1 = new Section("S1", SCHEDULE, room, SUBJECT_NO_PREREQ);
		Section s2 = new Section("S2", new Schedule(Days.TF, Period.H0830), room, SUBJECT_NO_PREREQ);
		assertTrue(s1.getRoom().equals(s1.getRoom()));
	}
	
	@Test 
	public void incrementStudentEnlistCounterWithoutExceedingRoomCapacity() {
		Student student = new Student(1);
		Room room = new Room("R101", 10);
		Section section = new Section("S1", SCHEDULE, room, SUBJECT_NO_PREREQ);
		section.incrementStudentEnlistCounter();
		assertEquals(1, section.getStudentEnlistCounter());
	}
	
	@Test(expected = ExceedsRoomCapacityException.class)
	public void incrementStudentEnlistCounterExceedsRoomCapacity() {
		Student student1 = new Student(1);
		Room room = new Room("R101", 1);
		Section section = new Section("S1", SCHEDULE, room, SUBJECT_NO_PREREQ);
		for(int i = 1; i <= 3; i++) {
			section.incrementStudentEnlistCounter();
		}
	}
	
	@Test
	public void sectionsWithDiffSchedButSameRoom(){
		new Section("A", SCHEDULE, ROOM, SUBJECT_NO_PREREQ);
		new Section("B", SCHEDULE2, ROOM, SUBJECT_NO_PREREQ);
		new Section("C", SCHEDULE3, ROOM, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void sectionsWithSameSchedDifferentRooms(){
		new Section("A", SCHEDULE, ROOM, SUBJECT_NO_PREREQ);
		new Section("B", SCHEDULE, new Room("A412", 25), SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void sectionsWithSameIdDifferentSchedAndRooms(){
		new Section("A", SCHEDULE, ROOM, SUBJECT_NO_PREREQ);
		new Section("A", SCHEDULE, new Room("A412", 25), SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void subjectCheckIfPreRequisitesHasBeenTaken(){
		Section section2 = new Section("B", SCHEDULE, new Room("A412", 25), Subject.Math1);
		Section section1 = new Section("B", SCHEDULE, new Room("A412", 25), Subject.Math2);
	    section1.checkIfPreRequisiteSubjectHasBeenTaken(section2);
	}
	
	@Test(expected = SubjectPreRequisitiesException.class)
	public void subjectCheckIfPreRequisitesHasBeenTaken1(){
		Section subject1 = new Section("B", SCHEDULE, new Room("A412", 25), Subject.Math2);
		Section subject2 = new Section("B", SCHEDULE, new Room("A412", 25), Subject.Math2);
		subject1.checkIfPreRequisiteSubjectHasBeenTaken(subject2);	
	}	
}

