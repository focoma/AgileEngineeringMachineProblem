package com.orangeandbronze.enlistment.domain;

enum Subject {
    None(null), Math1(null), Math2(Math1), Math3(Math2);
	
	private Subject preReq;
	
	
	Subject(Subject preReq){
	  this.preReq = preReq;
    }
		
	//This will check if the Subject has Prerequisites and return boolean
	public boolean checkIfSubjectHasPreRequisites(){
		for(Subject subject: Subject.values()){;

			if(subject.name().equals(preReq.name()) && subject.name()!=null){
			 return true;
			}
		}
		return false;
	}
	
}


