package com.orangeandbronze.enlistment.domain;

public class ExceedsRoomCapacityException extends RuntimeException {

	public ExceedsRoomCapacityException(String message) {
		super(message);
	}
}
