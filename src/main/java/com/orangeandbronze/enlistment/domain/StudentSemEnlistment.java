package com.orangeandbronze.enlistment.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class StudentSemEnlistment {
	
	private final Section section;
	private final Student student;
	private Collection<Semester> studentSemesters = new HashSet<>(); 

	public StudentSemEnlistment(Student student, Section section) {
		this.student = student;
		this.section = section;
	}
	
	public Section getSection(){
		return section;
	}
	
	public Student getStudent(){
		return student;
	}

	@Override
	public String toString() {
		return "StudentSemEnlistment [section=" + section + ", student=" + student + ", studentSemesters="
				+ studentSemesters + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudentSemEnlistment other = (StudentSemEnlistment) obj;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
}
