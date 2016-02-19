package com.orangeandbronze.enlistment.domain;

public class Semester {
	
	private final Integer semesterId;
	private final Section section;
	private final Student student;

	public Semester(Integer semesterId,Student student, Section section) {
		this.student = student;
		this.section = section;
		this.semesterId = semesterId;
	}

}
