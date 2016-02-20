package com.orangeandbronze.enlistment;

public class Subject {
	private final String subjectName;
	private final String preRequisite;

	public Subject(String subjectName) {
		checkValidationWith(subjectName == null || subjectName.equals(""), "Error values for Subject: " + subjectName);
		this.subjectName = subjectName;
		this.preRequisite = "";
	}

	public Subject(String subjectName, String preRequisites) {
		checkValidationWith(hasSubjectAndPreRequisitesValidation(subjectName, preRequisites),
				"Error values for Subject: " + subjectName + ", Pre-requisite: " + preRequisites);
		this.subjectName = subjectName;
		this.preRequisite = preRequisites;
	}

	private boolean hasSubjectAndPreRequisitesValidation(String subject, String preRequisites) {
		return (subject == null || preRequisites == null || subject.equals("") || preRequisites.equals("")
				|| subject.equals(preRequisites));
	}

	private void checkValidationWith(boolean isValid, String errMsg) {
		if (isValid) {
			throw new SubjectNameException(errMsg);
		}
		return;
	}

	void checkPreRequisites(Subject subj) {
		if (preRequisite.equals(subj.getSubjectName())) {
			throw new PreRequisiteSubjectRequiredException(
					"The subject " + subj + " has a prerequisite of subject " + preRequisite);
		}
	}

	public String getSubjectName() {
		return subjectName;
	}
	
	public String getPreRequisiteSubjectName() {
		return preRequisite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preRequisite == null) ? 0 : preRequisite.hashCode());
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
		if (preRequisite == null) {
			if (other.preRequisite != null)
				return false;
		} else if (!preRequisite.equals(other.preRequisite))
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
		return "subjectName=" + subjectName + ", preRequisites=" + preRequisite + "";
	}

}
