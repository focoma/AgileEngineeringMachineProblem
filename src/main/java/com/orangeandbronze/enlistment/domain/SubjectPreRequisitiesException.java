package com.orangeandbronze.enlistment.domain;

public class SubjectPreRequisitiesException extends RuntimeException{
	public SubjectPreRequisitiesException(Subject subject, Subject preReq) {
		super("The Subject cannot be taken " + subject + " because the Prerequisite subject " + preReq + "has not yet been taken");
	}
}
