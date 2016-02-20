package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Room {
	private final String name;
	private final int capacity;
	
	public Room(String name, int capacity) {
		notBlank(name);
		isTrue(capacity >= 0, "Capacity cannot be negative, was: %d", capacity);
		this.name = name;
		this.capacity = capacity;
	}

	String getName() {
		return name;
	}

	int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
