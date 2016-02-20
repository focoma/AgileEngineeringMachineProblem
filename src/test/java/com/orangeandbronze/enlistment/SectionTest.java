package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Defaults.*;

public class SectionTest {

	@Test
	public void sectionIdAlphanumeric() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"));
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("English"));
	}
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasWhiteSpace() {
		new Section("ROSE SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"));
	}

	@Test (expected = SectionIdException.class)
	public void sectionIdHasUnderscore() {
		new Section("ROSE_SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"));
	}	
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasAmpersand() {
		new Section("ROSE&SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"));
	}
	
	@Test
	public void sectionHasSubjectWithPreRequisite() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math1", "English2"));
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math2", "Math1"));
	}

}
