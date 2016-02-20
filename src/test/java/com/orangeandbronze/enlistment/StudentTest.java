package com.orangeandbronze.enlistment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class StudentTest {

	private final Student STUDENT = new Student(1);
	private final Schedule SCHEDULE = new Schedule(Days.MTH, Period.H0830);
	private final Room ROOM = new Room("SDFRT2", 40);
	
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
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		STUDENT.enlist(sectionRose);
		assertTrue(STUDENT.getSections().contains(sectionRose));
	}
	
	@Test
	public void enlistTwoSectionInOneStudent() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H1600), new Room("CEAT101", 10), new Subject("English"), 1);
		STUDENT.enlist(sectionRose);
		STUDENT.enlist(sectionSampaguita);
		assertEquals(2, STUDENT.getSections().size());
	}	

	@Test (expected = ScheduleConflictException.class)
	public void enlistTwoSectionSameScheduleInOneStudent() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		Section sectionSampaguita = new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("English"), 1);
		STUDENT.enlist(sectionRose);
		STUDENT.enlist(sectionSampaguita);
	}	
		
	@Test
	public void enlistSectionWithoutExceedingRoomCapacity() {
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 2), new Subject("Math"), 1);
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(2);
		firstStudent.enlist(sectionRose);
		secondStudent.enlist(sectionRose);
	}	

	@Test (expected = RoomCapacityExceedsException.class)
	public void enlistSectionExceedsRoomCapacity() {
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 1), new Subject("Math"), 1);
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(2);
		firstStudent.enlist(sectionRose);
		secondStudent.enlist(sectionRose);
	}
	
	@Test (expected = RoomCapacityExceedsException.class)
	public void enlistSectionExceedsRoomCapacity1() {
		Subject subj1 = new Subject("MATH101");
		Section sectionRose = new Section("ROSE", SCHEDULE, new Room("SECTION1", 1), subj1, 1);
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(2);
		firstStudent.enlist(sectionRose);
		secondStudent.enlist(sectionRose);
	}
	
	@Test (expected = StudentNumberException.class)
	public void studentNumberNullValue(){
		new Student(null);
	}
	
	@Test (expected = PeriodException.class)
	public void enlistTwoSectionInOneStudentWithConflictPeriod() {
		Section sectionRose = new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		Section sectionSampaguita = new Section("SAMPAGUITA", new Schedule(Days.WS, Period.H0900), new Room("CEAT101", 10), new Subject("English"), 1);
		STUDENT.enlist(sectionRose);
		STUDENT.enlist(sectionSampaguita);
		assertEquals(2, STUDENT.getSections().size());
	}	
	
}
