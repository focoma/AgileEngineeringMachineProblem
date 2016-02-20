package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Schedule {
	
	private final Days days;
	private final Period period;
	
	public Schedule(Days days, Period period) {
		notNull(days);
		notNull(period);
		this.days = days;
		this.period = period;
	}
	
	void checkConflict(Schedule other) {
		notNull(other);
		if (this.days == other.days && this.period.isOverlapping(other.period)) {
			throw new SchedueConflictException("This: " + this + " Other: " + other);
		}
	}
	
	@Override
	public String toString() {
		return days + " " + period; // MTH H0830
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		if (!(obj instanceof Schedule)) {
			return false;
		}
		Schedule other = (Schedule) obj;
		if (days != other.days) {
			return false;
		}
		if (period != other.period) {
			return false;
		}
		return true;
	}
	
	
}
