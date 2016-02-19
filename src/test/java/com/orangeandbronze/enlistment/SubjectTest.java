package com.orangeandbronze.enlistment;

import org.junit.Test;

public class SubjectTest {

	@Test
	public void SubjectNameIsAlphaNumeric() {
			new Subject("Math101", null);
	}
	
	@Test (expected = SubjectNameException.class)
	public void CheckSubjectAndPrerequisiteIfSame() {
		 	new Subject("Math101", "Math101");
	}
}
