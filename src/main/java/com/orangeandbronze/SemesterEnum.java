package com.orangeandbronze;

public enum SemesterEnum {
	S_FIRST_SEM(1), S_SECOND_SEM(2), S_THIRD_SEM(3);

	private int semesterNum;

	SemesterEnum(final int semesterNum) {
		this.semesterNum = semesterNum;

	}

	public int getSemesterNum() {
		return semesterNum;
	}
}
