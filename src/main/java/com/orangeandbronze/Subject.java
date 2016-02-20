package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */

public class Subject {
	
	private final Integer subjectId;
	private final Integer subjectIdPrerequisite;


	public Subject(Integer subjectId, Integer subjectIdPrerequisite) {
		this.subjectId = subjectId;
		this.subjectIdPrerequisite = subjectIdPrerequisite;
	}

	public Integer getSubjectIdPrerequisite() {
		return subjectIdPrerequisite;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"subjectId=" + subjectId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Subject subject = (Subject) o;

		return !(subjectId != null ? !subjectId.equals(subject.subjectId) : subject.subjectId != null);

	}

	@Override
	public int hashCode() {
		return subjectId != null ? subjectId.hashCode() : 0;
	}
}
