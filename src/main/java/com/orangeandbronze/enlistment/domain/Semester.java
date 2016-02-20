package com.orangeandbronze.enlistment.domain;

import java.util.Collection;
import java.util.HashSet;

public class Semester {
	
	private final Integer semesterId;
	private final Collection<StudentSemEnlistment> semesters = new HashSet<>();
	private final StudentSemEnlistment studentSemEnlistment;

	public Semester(Integer semesterId, StudentSemEnlistment studentSemEnlistment) {
		if(semesterId <= 0){
			throw new IllegalArgumentException("Semester id should not be negative neither is zero but is " + semesterId);
		}
		this.studentSemEnlistment = studentSemEnlistment;
		this.semesterId = semesterId;
	}
	
	void addToSemesters(StudentSemEnlistment studentSemEnlistment){
		semesters.add(studentSemEnlistment);
	}
	
	Collection<StudentSemEnlistment> getSemesters(){
		return semesters;
	}
	
	Collection<StudentSemEnlistment> getStudentSemesters(Student student){
		Collection<StudentSemEnlistment> studentSems = new HashSet<>();
		for(StudentSemEnlistment studentEnlistment : semesters){
			if(studentEnlistment.getStudent().equals(student)){
				studentSems.add(studentEnlistment);
			}
		}
		
		return studentSems;
	}
	
}
