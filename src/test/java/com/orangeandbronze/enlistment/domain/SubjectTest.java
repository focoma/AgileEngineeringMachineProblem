package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.domain.Subject.*;
public class SubjectTest {

	@Test
	public void sameSubjectTest() {
	assertEquals(Subject.Math1, Subject.Math1);
	}
	
	@Test
	public void preRequesitesSubjectTest() {
		assertEquals(true, Math3.checkIfSubjectHasPreRequisites());
	}
	
	@Test
	public void preRequesitesSubjectTest1() {
		assertEquals(false, Math1.checkIfSubjectHasPreRequisites());
	}

}
