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
}
