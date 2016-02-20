package com.orangeandbronze.enlistment;

public class RoomCapacityExceedsException extends RuntimeException {
	
	public RoomCapacityExceedsException(String roomToString) {
		super(roomToString + ". Number of student already exceeds.");
	}

}
