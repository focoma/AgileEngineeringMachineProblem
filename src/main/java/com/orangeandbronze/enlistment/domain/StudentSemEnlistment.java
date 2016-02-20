package com.orangeandbronze.enlistment.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class StudentSemEnlistment {
	private final Student student;
	private Collection<Semester> studentSemesters = new HashSet<>(); 

	public StudentSemEnlistment(Student student) {
		this.student = student;
	}
	
	private void checkIfPreRequisiteSubjectHasBeenTaken(Section section){
		for(Section studentSections: student.getSections()){
			if(studentSections.getSubject().isPreRequisites(studentSections.getSubject(),section.getSubject())){
			   throw new SubjectPreRequisitiesException(studentSections.getSubject(),section.getSubject());
		   }	   
		}	
	}
	
    void enlistInSection(Section section){
	   if(section.getSubject().hasPrerequisites()){
		 checkIfPreRequisiteSubjectHasBeenTaken(section);
       }   
		student.enlist(section);
	}
	
	public Student getStudent(){
		return student;
	}

}
