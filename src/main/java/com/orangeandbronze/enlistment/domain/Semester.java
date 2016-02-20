package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Semester implements Comparable<Semester> {
	private final SchoolYear schoolYear;
	private final Term term;

	public Semester(SchoolYear year, Term term) {
		notNull(term);
		notNull(year);
		this.schoolYear = year;
		this.term = term;
	}

	@Override
	public int compareTo(Semester other) {
		int yearDiff = this.schoolYear.compareTo(other.schoolYear);
		return yearDiff != 0 ? yearDiff
				: this.term.ordinal() - other.term.ordinal();
	}

	@Override
	public String toString() {
		return term + " " + schoolYear; // FIRST 2015
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		result = prime * result
				+ ((schoolYear == null) ? 0 : schoolYear.hashCode());
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
		Semester other = (Semester) obj;
		if (term != other.term)
			return false;
		if (schoolYear == null) {
			if (other.schoolYear != null)
				return false;
		} else if (!schoolYear.equals(other.schoolYear))
			return false;
		return true;
	}
}
