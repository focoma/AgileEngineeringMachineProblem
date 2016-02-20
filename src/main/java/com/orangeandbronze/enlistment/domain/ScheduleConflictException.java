package com.orangeandbronze.enlistment.domain;

public class ScheduleConflictException extends RuntimeException {
	
	public ScheduleConflictException(Section thisSection, Section otherSection) {
		super("This section " + thisSection + " has same schedule as other section " + otherSection + "at schedule " + thisSection.getSchedule());
	}
	
}

