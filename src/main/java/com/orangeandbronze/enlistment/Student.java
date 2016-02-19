package com.orangeandbronze.enlistment;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Student {
	private final Integer studentNumber;
	private final Collection<Section> sections = new HashSet<>();
	
	public Student(Integer studentNumber) {
		if(studentNumber < 0) {
			throw new StudentNumberException(studentNumber);
		}
		this.studentNumber = studentNumber;
	}
	
	public void enlist(Section newSection) {
		sections.forEach(currentSection -> currentSection.checkForConflictWith(newSection));
		newSection.addStudentInSection(studentNumber);
		sections.add(newSection);
	}
	
	Collection<Section> getSections() {
		return new ArrayList<>(sections);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student#" + studentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
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
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}
	
	
}
