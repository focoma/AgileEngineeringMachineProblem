package com.orangeandbronze.enlistment;

enum Days { MTH, TF, WS }
enum Period { H0830, H1000, H1130, H1300, H1430, H1600 }

public class Schedule {
	private final Days days;
	private final Period period;
	
	Schedule(Days days, Period period) {
		this.days = days;
		this.period = period;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return days + " " + period; //MTH H0830
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (days != other.days)
			return false;
		if (period != other.period)
			return false;
		return true;
	}
}