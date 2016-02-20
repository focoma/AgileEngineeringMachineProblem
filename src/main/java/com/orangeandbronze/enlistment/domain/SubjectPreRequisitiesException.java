package com.orangeandbronze.enlistment.domain;

public class SubjectPreRequisitiesException extends RuntimeException{
	public SubjectPreRequisitiesException(Subject subject, Subject preReq) {
		super("The Subject cannot be taken " + subject + " because it is either the same or the preRequisite has not yet been taken: result: "+ preReq);
	}
}
