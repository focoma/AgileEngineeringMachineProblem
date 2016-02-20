package com.orangeandbronze.enlistment.domain;

import java.util.*;
import static org.apache.commons.lang3.Validate.*;

public class StudentSemEnlistments
		implements Comparable<StudentSemEnlistments> {
	private final Student student;
	private final Semester semester;
	private final Collection<Section> sections = new HashSet<>();

	public StudentSemEnlistments(Student student, Semester semester,
			Collection<Section> sections) {
		notNull(student);
		notNull(semester);
		notNull(sections);
		this.student = student;
		this.semester = semester;
		this.sections.addAll(sections);
		student.addStudentSemEnlistments(this);
	}

	public StudentSemEnlistments(Student student, Semester semester) {
		this(student, semester, new ArrayList<>(0));
	}

	boolean isOpenForEnlistment() {
		return this.equals(student.getOpenStudentSemEnlistments());
	}

	public void enlist(Section newSection) {
		notNull(newSection);
		checkIfThisIsTheSemesterOpenForEnlistment();
		checkForSectionConflict(newSection);
		checkIfPrereqTakenIfAny(newSection);
		newSection.checkIfSectionCanAccommodateEnlistment();
		// two-way add:
		sections.add(newSection);
		newSection.add(this);
	}

	private void checkIfThisIsTheSemesterOpenForEnlistment() {
		if (!isOpenForEnlistment()) {
			throw new SemesterClosedException(
					"Cannot enlist for closed semester. Semester: " + semester);
		}
	}

	private void checkForSectionConflict(Section newSection) {
		notNull(newSection);
		sections.forEach(
				currentSection -> currentSection.checkForConflict(newSection));
	}

	private void checkIfPrereqTakenIfAny(Section newSection) {
		notNull(newSection);
		if (!student.hasTakenPrereqFor(newSection)) {
			throw new PrereqNotTakenException(newSection.toString());
		}
	}

	public boolean hasPrereqFor(Section otherSection) {
		notNull(otherSection);
		
		return sections.stream().filter(
				enlistedSection -> enlistedSection.isPrereqFor(otherSection))
				.findFirst().isPresent();
		
//		boolean hasPrereq = false;
//		for (Section enlistedSection : sections) {
//			hasPrereq = enlistedSection.isPrereqFor(otherSection);
//			if (hasPrereq) {
//				break;
//			}
//		}
//		return hasPrereq;
	}

	void checkIfBelongsTo(Student student) {
		if (!this.student.equals(student)) {
			throw new IllegalArgumentException("Enlistment " + this
					+ " does not belong to student: " + student);
		}
	}

	@Override
	public int compareTo(StudentSemEnlistments other) {
		return this.semester.compareTo(other.semester);
	}

	public Student getStudent() {
		return student;
	}

	public Semester getSemester() {
		return semester;
	}

	public Collection<Section> getSections() {
		return new ArrayList<>(sections);
	}

	@Override
	public String toString() {
		return student + "-" + semester + ": sections " + sections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((semester == null) ? 0 : semester.hashCode());
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
		StudentSemEnlistments other = (StudentSemEnlistments) obj;
		if (semester != other.semester)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
}
