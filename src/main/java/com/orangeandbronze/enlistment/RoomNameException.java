package com.orangeandbronze.enlistment;

public class RoomNameException extends RuntimeException {

	public RoomNameException(String roomName) {
		super("Room name must be alphanumeric, but was " + roomName);
	}

}
