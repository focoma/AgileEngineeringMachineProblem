package com.orangeandbronze.enlistment.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class StudentSemEnlistment {
	
	private final Collection<Section> sections;
	private final Student student;

	public StudentSemEnlistment(Student student, Collection<Section> sections) {
		this.student = student;
		this.sections = sections;
	}
	
	public Student getStudent(){
		return student;
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

	@Override
	public String toString() {
		return "StudentSemEnlistment [student=" + student +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}
