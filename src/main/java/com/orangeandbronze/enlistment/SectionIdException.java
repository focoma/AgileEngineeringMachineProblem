package com.orangeandbronze.enlistment;

public class SectionIdException extends RuntimeException {

	public SectionIdException(String sectionId) {
		super("Section ID must be alphanumeric, but was " + sectionId);
	}

}
