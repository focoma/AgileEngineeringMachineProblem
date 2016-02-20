package com.orangeandbronze.enlistment.domain;

import java.util.Collection;
import java.util.HashSet;

public class Semester {
	
	private final Integer semesterId;
	private final Section section;
	private final Student student;
	private final Collection<StudentSemEnlistments> semesters = new HashSet<>();

	public Semester(Integer semesterId, Section section, Student student) {
		if(semesterId <= 0){
			throw new IllegalArgumentException("Semester id should not be negative neither is zero but is " + semesterId);
		}
		this.section = section;
		this.student = student;
		this.semesterId = semesterId;
	}
	
	void addToSemesters(StudentSemEnlistments studentSemEnlistment){
		semesters.add(studentSemEnlistment);
	}
	
	Collection<StudentSemEnlistments> getSemesters(){
		return semesters;
	}
	
}
