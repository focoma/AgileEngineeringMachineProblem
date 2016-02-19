package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */
public class ScheduleConflictException extends RuntimeException {
    public ScheduleConflictException() {}

    public ScheduleConflictException(String message) {
        super(message);
    }

    public ScheduleConflictException(Section thisSection, Section otherSection) {
        super("Section " + thisSection + " conflict to " + otherSection);
    }


}
