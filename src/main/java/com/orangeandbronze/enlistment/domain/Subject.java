package com.orangeandbronze.enlistment.domain;

enum Subject {
    Math1, Math2(Math1);
	
    Subject(Subject preReq) {
	   
	}
	Subject() {
	}

}
