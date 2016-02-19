package com.orangeandbronze.enlistment;

public class ScheduleConflictException extends RuntimeException {

	public ScheduleConflictException(Section thisSection, Section otherSection) {
		super("Section " + thisSection + " has same schedule as " + otherSection);
	}

}
