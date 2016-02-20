package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Section {
	private final String sectionId;
	private final Schedule schedule;
	private final Room room;
	private final Subject subject;
	private final int semester;
	private Map<Integer, Collection<Student>> studentSectionsMap = new HashMap<>();
	private Collection<Student> students = new HashSet<>();
	
	public Section(String sectionId, Schedule schedule, Room room, Subject subject, int semester) {
		if(!sectionId.matches("^[a-zA-Z0-9]*$")) {
			throw new SectionIdException(sectionId);
		}
		this.sectionId = sectionId;
		this.schedule = schedule;
		this.room = room;
		this.subject = subject;
		this.semester = semester;
	}
	
	void addStudentInSection(Integer newStudent) {
		room.checkRoomCapacity(students.size());
		subject.checkPreRequisites(subject);
		students.add(new Student(newStudent));
		studentSectionsMap.put(semester, students);
	}
	
	void checkForConflictWith(Section other) {
	  if(schedule.equals(other.schedule)) {
		throw new ScheduleConflictException(this, other);
	  }
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Section ID: " + sectionId + " at " + room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
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
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		return true;
	}
	
	
}
