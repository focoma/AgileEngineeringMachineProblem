package com.orangeandbronze.enlistment.domain;

public enum Time {
	H0830, H0900, H1000, H1030, H1100, H1130, H1300, H1330, H1400, H1430, H1600, H1730;
	
	boolean isBefore(Time other) {
		return this.ordinal() < other.ordinal();
	}
	
	boolean isAfter(Time other) {
		return this.ordinal() > other.ordinal();
	}
}