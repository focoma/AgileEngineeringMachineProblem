package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Defaults.*;
public class StudentTest {

	private final Student STUDENT = new Student(1);
	
	@Test
	public void studentNumberIsPositive() {
		new Student(123);
	}
	
	@Test (expected = StudentNumberException.class)
	public void studentNumberIsNegative() {
		new Student(-123);
	}
	
	@Test
	public void enlistFirstSection() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM);
		STUDENT.enlist(sectionRose);
		assertTrue(STUDENT.getSections().contains(sectionRose));
	}
	
	@Test
	public void enlistTwoSectionInOneStudent() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10));
		STUDENT.enlist(sectionRose);
		STUDENT.enlist(sectionSampaguita);
		assertEquals(2, STUDENT.getSections().size());
	}	

	@Test (expected = ScheduleConflictException.class)
	public void enlistTwoSectionSameScheduleInOneStudent() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM);
		Section sectionSampaguita = new Section("SAMPAGUITA", SCHEDULE, ROOM);
		STUDENT.enlist(sectionRose);
		STUDENT.enlist(sectionSampaguita);
	}
		
	@Test
	public void enlistSectionWithoutExceedingRoomCapacity() {
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 1));
		Student student = new Student(1);
		student.enlist(sectionRose);
	}	

	@Test (expected = RoomCapacityExceedsException.class)
	public void enlistSectionExceedsRoomCapacity() {
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 1));
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(2);
		firstStudent.enlist(sectionRose);
		secondStudent.enlist(sectionRose);
	}
	
	@Test (expected = RoomCapacityExceedsException.class)
	public void enlistSectionExceedsRoomCapacity1() {
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 1));
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(2);
		firstStudent.enlist(sectionRose);
		secondStudent.enlist(sectionRose);
	}

}
