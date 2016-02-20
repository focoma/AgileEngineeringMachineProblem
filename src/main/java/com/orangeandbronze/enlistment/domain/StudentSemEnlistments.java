package com.orangeandbronze.enlistment.domain;

import java.util.ArrayList;
import java.util.Collection;

public class StudentSemEnlistments {
	
	private final Semester semester;
	private final Student student;
	private Collection<StudentSemEnlistments> studentSemesters = new ArrayList<>(); 

	public StudentSemEnlistments(Semester semester, Student student) {
		this.semester = semester;
		this.student = student;
	}
	
	void addStudentSemester(){
		studentSemesters.add(this);
	}

}
