package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Defaults.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StudentTest {

	@Test
	public void enlistFirstSection() {
		Student student = new Student(1);
		Section section = new Section("abc123", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		student.enlist(section);
		assertTrue(student.getSections().contains(section));
	}
	
	@Test(expected = ScheduleConflictException.class) 
	public void enlistSectionsSameSchedule() {
		Room room = new Room("R101", 10);
		Student student = new Student(1);
		Section s1 = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		Section s2 = new Section("B", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		student.enlist(s1);
		student.enlist(s2);
	}
	
	@Test 
	public void enlistToSectionsWithoutExceedingRoomCapacity() {
		Room room = new Room("R101", 3);
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Section s1 = new Section("A", SCHEDULE, 1, ROOM2, SUBJECT_NO_PREREQ);
		student1.enlist(s1);
		student2.enlist(s1);
	}
	
	@Test(expected = ExceedsRoomCapacityException.class) 
	public void enlistToSectionsExceedsRoomCapacity() {
		Room room = new Room("R102", 2);
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Student student3 = new Student(3);
		Student student4 = new Student(4);
		Section s1 = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		student1.enlist(s1);
		student2.enlist(s1);
		student3.enlist(s1);
		student4.enlist(s1);
	}
	
	@Test(expected = ExceedsRoomCapacityException.class) 
	public void enlist3StudentsInSameSection(){
		Student stud1 = new Student(1);
		Student stud2 = new Student(2);
		Student stud3 = new Student(3);
		Room room1 = new Room("S123", 2);
		Section section = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		stud1.enlist(section);
		stud2.enlist(section);
		stud3.enlist(section);
	}
	
	@Test(expected = SubjectConflictException.class)
	public void enlistToSectionWithNoScheduleConflictButHasSubjectConflict() {
		Student student = new Student(1);
		Room room = new Room("R102", 2);
		Section section1 = new Section("A", SCHEDULE, 1, ROOM1, SUBJECT_NO_PREREQ);
		Section section2 = new Section("B", SCHEDULE2, 1, ROOM1, SUBJECT_NO_PREREQ);
		student.enlist(section1);
		student.enlist(section2);
	}
}
