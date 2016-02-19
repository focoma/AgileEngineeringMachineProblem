package com.orangeandbronze;

public class ExistingSubjectException extends RuntimeException {
	public ExistingSubjectException(Subject subject) {
        super("Subject already exists, " + subject);
    }

    public ExistingSubjectException(String message) {
        super(message);
    }
}
