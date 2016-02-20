package com.orangeandbronze.enlistment;

public class SubjectNameException extends RuntimeException {

	public SubjectNameException(String subjectName, String preRequisites) {
		super("Subject :" + subjectName + " is equal to pre-requisite subject " + preRequisites);
	}
	
	public SubjectNameException(String errMsg){
		super(errMsg);
	}
}

