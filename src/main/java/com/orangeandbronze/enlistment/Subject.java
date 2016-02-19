package com.orangeandbronze.enlistment;

public class Subject {
	private final String subjectName;
	private final String preRequisites;
	
	public Subject(String subjectName, String preRequisites){
		this.subjectName = subjectName;
		this.preRequisites = preRequisites;
	}
	
	void checkPreRequisites(Subject subj){
		if(this.equals(subj)) {
			throw new PreRequisiteSubjectRequiredException(this, subj);
		}
	}
}
