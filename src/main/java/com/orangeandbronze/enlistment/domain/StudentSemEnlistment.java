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
	
}
