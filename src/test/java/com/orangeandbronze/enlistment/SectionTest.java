package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Defaults.*;

public class SectionTest {

	@Test
	public void sectionIdAlphanumeric() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math"), 1);
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("English"), 1);
	}
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasWhiteSpace() {
		new Section("ROSE SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"), 1);
	}

	@Test (expected = SectionIdException.class)
	public void sectionIdHasUnderscore() {
		new Section("ROSE_SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"), 1);
	}	
	
	@Test (expected = SectionIdException.class)
	public void sectionIdHasAmpersand() {
		new Section("ROSE&SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math"), 1);
	}
	
	@Test
	public void sectionHasSubjectWithPreRequisite() {
		new Section("ROSE", SCHEDULE, ROOM, new Subject("Math1", "English2"), 1);
		new Section("SAMPAGUITA", SCHEDULE, ROOM, new Subject("Math2", "Math1"), 1);
	}
	
	@Test (expected = SectionIdException.class)
	public void sectionIdWithEmptyValye(){
		new Section("", SCHEDULE, ROOM, new Subject("Math1", "English2"), 1);
	}
	
	@Test(expected = SectionIdException.class)
	public void sectionIdWithNullValue(){
		new Section(null, SCHEDULE, ROOM, new Subject("Math1", "English2"), 1);
	}
}
