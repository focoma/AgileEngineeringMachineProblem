package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class Room {
	private final String roomName;
	private final int roomCapacity;
	
	public Room(String roomName, int roomCapacity) {
		if(!roomName.matches("^[a-zA-Z0-9]*$")) {
			throw new RoomNameException(roomName);
		}		
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
	}
	
	void checkRoomCapacity(int studentSize) {
		if(studentSize >= roomCapacity) {
			throw new RoomCapacityExceedsException(this.toString());
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Room " + roomName + " has a capacity of " + roomCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}
	
	

}
