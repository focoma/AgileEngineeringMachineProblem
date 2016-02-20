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
	
	Collection getSections(Student student) {
		  return new ArrayList(studentKeyMap.get(student));
	}
	
}
