package com.orangeandbronze.enlistment.domain;

enum Subject {


    Math1, Math2(Math1), Math3(Math2);
	private  Subject preReq;

	Subject(Subject preReq){
	  this.preReq = preReq;
    }
	
	Subject(){
	
	}
	public boolean isPreRequisites(Subject otherSubject){
			if(preReq.equals(otherSubject)){ 		
				return true;
			}
		return false;
	}
	
}


