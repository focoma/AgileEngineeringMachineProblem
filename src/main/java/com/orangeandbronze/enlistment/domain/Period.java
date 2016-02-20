package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Period {
	private final Time start;
	private final Time end;
	
	public Period(Time start, Time end) {
		notNull(start);
		notNull(end);
		this.start = start;
		this.end = end;
	}

	boolean isOverlapping(Period other) {
		notNull(other);
		return this.start.isBefore(other.end) && this.end.isAfter(other.start);
	}
	
	@Override
	public String toString() {
		return "Start: " + start + " End: " + end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Period)) {
			return false;
		}
		Period other = (Period) obj;
		if (end != other.end) {
			return false;
		}
		if (start != other.start) {
			return false;
		}
		return true;
	}
}