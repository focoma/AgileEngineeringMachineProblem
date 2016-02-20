package com.orangeandbronze.enlistment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentSemEnlistments {
	private Map<Student, Collection<Section>> studentKeyMap = new HashMap<>();
	
	void addStudentAndSection(Student student,Collection<Section> section) {
		studentKeyMap.put(student, section);
	}
	
	Collection getStudentSectionsBySem(Student student, int semester) {
		  return new ArrayList(studentKeyMap.get(student));
	}
	
	void checkStudentSameSubjectInSection(Student student, Section section){
		if(!studentKeyMap.isEmpty()) {
			Collection<Section> sectionsByStudent = new ArrayList<>();
			sectionsByStudent = studentKeyMap.get(student);
			if(!sectionsByStudent.isEmpty()){
				for(Section sect: sectionsByStudent){
					if(sect.getSubject().getSubjectName().equals(section.getSubject().getSubjectName())){
						throw new StudentSemEnlistmentsException("Student failed to enlist due to same subject enlisted, "
								+ section.getSubject().getSubjectName());
					}
				}
			}
		}
	}
	
	void checkPreRequisiteSubjectFromStudentEnlist(Student student, Section section){
		if(!studentKeyMap.isEmpty()) {
			
			String subjectInEnlistedSection = section.getSubject().getPreRequisiteSubjectName();
			Collection<Section> sectionsByStudent = studentKeyMap.get(student);
			if(!sectionsByStudent.isEmpty()){
				for(Section sect: sectionsByStudent){
					if(subjectInEnlistedSection != null || subjectInEnlistedSection.equals("")){
						for(int i = 0; i < section.getSemesters().size(); i++){
							if(sect.getSubject().getSubjectName().equals(section.getSubject().getPreRequisiteSubjectName()) &&
									sect.getSemester() >= section.getSemester()){
								throw new StudentSemEnlistmentsException("Subject Pre-Requisites from previous semester"
										+ section.getSubject().getSubjectName());
							}
						}
					}
				}
			}
		}
		else if(!(section.getSubject().getPreRequisiteSubjectName() == null || section.getSubject().getPreRequisiteSubjectName().equals(""))){
			throw new StudentSemEnlistmentsException("Subject Pre-Requisites from previous semester"
					+ section.getSubject().getSubjectName());
		}
			
	}
	
}
