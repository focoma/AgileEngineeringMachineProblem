package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class SchoolYear implements Comparable<SchoolYear> {
	private final int startYear;

	public SchoolYear(int startYear) {
		isTrue(startYear >= 0, "startYear cannot be negative, was %d", startYear);
		this.startYear = startYear;
	}
	
	@Override
	public int compareTo(SchoolYear other) {
		return this.startYear - other.startYear;
	}

	@Override
	public String toString() {
		return startYear + "-" + (startYear + 1); // 2010-2011
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + startYear;
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
		SchoolYear other = (SchoolYear) obj;
		if (startYear != other.startYear)
			return false;
		return true;
	}
}
