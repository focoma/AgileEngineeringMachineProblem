package com.orangeandbronze.enlistment;

public class PeriodException extends RuntimeException {

	public PeriodException() {
	}

	public PeriodException(String message) {
		super(message);
	}

	public PeriodException(Throwable cause) {
		super(cause);
	}

	public PeriodException(String message, Throwable cause) {
		super(message, cause);
	}

	public PeriodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
