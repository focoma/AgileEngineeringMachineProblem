package com.orangeandbronze.enlistment;

public class Subject {
	private final String subjectName;
	private final String preRequisites;
	
	public Subject(String subjectName, String preRequisites){
		if(subjectName.equals(preRequisites)) {
			throw new SubjectNameException(subjectName, preRequisites);
		}
		this.subjectName = subjectName;
		this.preRequisites = preRequisites;
	}
	
	void checkPreRequisites(Subject subj){
		if(preRequisites.equals(subj.getSubjectName())) {
			throw new PreRequisiteSubjectRequiredException("The subject " + subj + " has a prerequisite of subject " + preRequisites);
		}
	}
	
	public String getSubjectName(){
		return subjectName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preRequisites == null) ? 0 : preRequisites.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
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
		Subject other = (Subject) obj;
		if (preRequisites == null) {
			if (other.preRequisites != null)
				return false;
		} else if (!preRequisites.equals(other.preRequisites))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", preRequisites=" + preRequisites + "]";
	}
	
	
}
