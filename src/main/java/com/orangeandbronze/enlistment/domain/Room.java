package com.orangeandbronze.enlistment.domain;

public class Room {
	private final String roomName;
	private final int maxCapacity;
	
	public Room(String roomName, int maxCapacity) {
		if(!roomName.matches("^[A-Za-z0-9]+$")) {
			throw new IllegalArgumentException("Room name must be alpha-numeric");
		}
		this.roomName = roomName;
		this.maxCapacity = maxCapacity;
	}
	
	public int getRoomMaxCapacity() {
		return maxCapacity;
	}
	
	@Override
	public String toString() {
		return roomName;
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
