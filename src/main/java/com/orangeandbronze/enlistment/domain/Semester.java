package com.orangeandbronze.enlistment.domain;

public class Semester {
	
	private final Integer semesterId;
	private final Section section;
	private final Student student;

	public Semester(Integer semesterId,Student student, Section section) {
		if(semesterId <= 0){
			throw new IllegalArgumentException("Semester id should not be negative neither is zero but is " + semesterId);
		}
		this.student = student;
		this.section = section;
		this.semesterId = semesterId;
	}
	
	public Section getSection(){
		return section;
	}
}
