package com.orangeandbronze.enlistment;

public class StudentNumberException extends RuntimeException {

	public StudentNumberException(Integer studentNumber) {
		super("Student number should be non-negative but was " + studentNumber);
	}

}
