package com.orangeandbronze.enlistment;

import org.junit.Test;

public class SubjectTest {

	@Test(expected = SubjectNameException.class)
	public void subjectNameIsAlphaNumeric() {
			new Subject("Math101", null);
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkSubjectAndPrerequisiteIfSame() {
		 	new Subject("Math101", "Math101");
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkSubjectAndPrerequisiteIfNull(){
		new Subject(null, null);
	}
	
	@Test
	public void checkForNormalValues(){
		new Subject("Enlish101", "Math102");
	}
	
	
	@Test(expected = SubjectNameException.class)
	public void checkForSubjectAndPrerequisiteIsEmpty(){
		new Subject("", "");
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkForSubjectEmptyValue(){
		new Subject("", "Math101");
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkForPreRequisiteEmptyValue(){
		new Subject("Philo101", "");
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkForSubjectEmpty(){
		new Subject("");
	}
	
	@Test(expected = SubjectNameException.class)
	public void checkForSubjectNull(){
		new Subject(null);
	}
}
