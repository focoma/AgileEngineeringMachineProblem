package com.orangeandbronze.enlistment.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Semester {
	
	private final Integer semesterId;
	private final Collection<StudentSemEnlistment> semesters = new ArrayList<>();

	public Semester(Integer semesterId) {
		if(semesterId <= 0){
			throw new IllegalArgumentException("Semester id should not be negative neither is zero but is " + semesterId);
		}
		this.semesterId = semesterId;
	}
	
	void addToSemesters(StudentSemEnlistment studentSemEnlistment){
		semesters.add(studentSemEnlistment);
	}
	
	Collection<StudentSemEnlistment> getSemesters(){
		return new ArrayList<>(semesters);
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

	@Override
	public String toString() {
		return "Semester [semesterId=" + semesterId + ", semesters=" + semesters + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((semesterId == null) ? 0 : semesterId.hashCode());
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
		if (semesterId == null) {
			if (other.semesterId != null)
				return false;
		} else if (!semesterId.equals(other.semesterId))
			return false;
		return true;
	}
	
}
