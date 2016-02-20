package com.orangeandbronze.enlistment.domain;

enum Subject {

    Math1, Math2(Math1), Math3(Math2);
	private  Subject preReq;

	Subject(Subject preReq){
	  this.preReq = preReq;
    }
	
	Subject(){
	
	}
	
	boolean hasPrerequisites(){
		if(preReq != null){
			return true;
		}
		return false;
	}
	
	boolean isPreRequisites(Subject thisSubject, Subject otherSubject){
		  if(thisSubject != null  && otherSubject != null){
			 if(thisSubject.equals(otherSubject)){ 	
					return true;
			 }
		  } 
		   
		return false;
	}
	
}


