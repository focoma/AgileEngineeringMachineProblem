package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Defaults.*;

public class SectionTest {

	@Test
	public void sectionIdAlphanumeric() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math", null));
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("English", null));
	}
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasWhiteSpace() {
		new Section("ROSE SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math", null));
	}

	@Test (expected = SectionIdException.class)
	public void sectionIdHasUnderscore() {
		new Section("ROSE_SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math", null));
	}	
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasAmpersand() {
		new Section("ROSE&SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math", null));
	}
	
	@Test
	public void sectionHasSubjectWithPreRequisite() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math1", null));
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math2", "Math1"));
	}

}
