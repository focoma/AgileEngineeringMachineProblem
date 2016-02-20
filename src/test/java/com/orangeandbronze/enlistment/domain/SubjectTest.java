package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.domain.Subject.*;
import static com.orangeandbronze.enlistment.domain.Defaults.*;

public class SubjectTest {

	@Test
	public void sameSubjectTest() {
	assertEquals(Subject.Math1, SUBJECT_NO_PREREQ);
	}
	
	@Test
	public void preRequesitesSubjectTest() {
		assertEquals(true, Math3.isPreRequisites(Math2));
	}
	
	@Test
	public void preRequesitesSubjectTest1() {
	  assertEquals(false, Math1.isPreRequisites(Math2));
	}
	
	@Test
	public void preRequesitesSubjectTest2() {
	  assertEquals(false, Math1.isPreRequisites(null));
	}
}
