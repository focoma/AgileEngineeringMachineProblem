package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.assertEquals;
import static com.orangeandbronze.enlistment.domain.Defaults.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class SectionTest {
	
	@Test
	public void sectionIdAlphaNumeric() {
		Room room = new Room("R101", 10);
		new Section("aBc123", SCHEDULE, room);
		new Section("123", SCHEDULE, room);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasUnderscore() {
		Room room = new Room("R101", 10);
		new Section("hello_World", SCHEDULE, room);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sectionIdHasAmpersand() {
		Room room = new Room("R101", 10);
		new Section("hello&World", SCHEDULE, room);
	}
	
	@Test
	public void addTwoSectionsToRoomWithoutScheduleConflict() {
		Room room = new Room("R101", 10);
		Section s1 = new Section("S1", SCHEDULE, room);
		Section s2 = new Section("S2", new Schedule(Days.TF, Period.H0830), room);
		assertTrue(s1.getRoom().equals(s1.getRoom()));
	}
	
	@Test 
	public void incrementStudentEnlistCounterWithoutExceedingRoomCapacity() {
		Student student = new Student(1);
		Room room = new Room("R101", 10);
		Section section = new Section("S1", SCHEDULE, room);
		section.incrementStudentEnlistCounter();
		assertEquals(1, section.getStudentEnlistCounter());
	}
	
	@Test(expected = ExceedsRoomCapacityException.class)
	public void incrementStudentEnlistCounterExceedsRoomCapacity() {
		Student student1 = new Student(1);
		Room room = new Room("R101", 1);
		Section section = new Section("S1", SCHEDULE, room);
		for(int i = 1; i <= 3; i++) {
			section.incrementStudentEnlistCounter();
		}
	}
	
	

}
