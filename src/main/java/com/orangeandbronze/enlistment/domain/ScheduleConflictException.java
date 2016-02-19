package com.orangeandbronze.enlistment.domain;

public class ScheduleConflictException extends RuntimeException {
	
	public ScheduleConflictException(Section thisSection, Section otherSection) {
		super("This section " + thisSection + " has same schedule as other section " + otherSection + "at schedule " + thisSection.getSchedule());
	}
	
	public ScheduleConflictException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleConflictException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ScheduleConflictException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ScheduleConflictException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ScheduleConflictException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}

