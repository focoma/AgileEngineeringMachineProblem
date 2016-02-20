package com.orangeandbronze.enlistment.domain;

import java.util.*;

import static org.apache.commons.lang3.Validate.*;

public class Student {

	private final Integer studentNumber;
	private final SortedSet<StudentSemEnlistments> semEnlistments = new TreeSet<>();

	public Student(Integer studentNumber) {
		this(studentNumber, new ArrayList<StudentSemEnlistments>(0));
	}

	public Student(Integer studentNumber,
			Collection<StudentSemEnlistments> semEnlistements) {
		isTrue(studentNumber >= 0, "Student number cannot be negative. Was: %d",
				studentNumber);
		notNull(semEnlistements);
		this.studentNumber = studentNumber;
		this.semEnlistments.addAll(semEnlistements);
	}

	boolean hasTakenPrereqFor(Section section) {
		notNull(section);
		if (!section.hasPrereq()) {
			return true;
		}
		boolean hasTaken = false;
		for (StudentSemEnlistments enlistment : semEnlistments) {
			if (!enlistment.isOpenForEnlistment()) {
				hasTaken = enlistment.hasPrereqFor(section);
				if (hasTaken) {
					break;
				}
			}
		}
		return hasTaken;
	}

	/** Returns latest StudentSemEnlistments **/
	public StudentSemEnlistments getOpenStudentSemEnlistments() {
		return semEnlistments.last();
	}

	public void addStudentSemEnlistments(StudentSemEnlistments enlistment) {
		notNull(enlistment);
		enlistment.checkIfBelongsTo(this);
		this.semEnlistments.add(enlistment);
	}

	void addStudentSemEnlistments(
			Collection<StudentSemEnlistments> enlistments) {
		notNull(enlistments);
		enlistments.forEach(enlistment -> addStudentSemEnlistments(enlistment));
	}

	@Override
	public String toString() {
		return "Student#" + studentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentNumber;
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
		if (studentNumber != other.studentNumber)
			return false;
		return true;
	}

}
