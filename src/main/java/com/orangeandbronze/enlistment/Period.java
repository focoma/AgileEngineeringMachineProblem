package com.orangeandbronze.enlistment;

enum Period { 
	H0830, H0900, H1000, H1030, H1130, H1300, H1400, H1430, H1600;

	/*Period() {
		this.duration = duration;
	}*/
	
	void checkPeriod(Period newPeriod) {
		int currentPeriodHour = getHours(this.toString());
		int currentPeriodMin =  getMinutes(this.toString());
		String currentPeriodDuration = getDuration(this);
		int currentPeriodDurationHour = getHours(currentPeriodDuration);
		int newPeriodHour = getHours(newPeriod.toString());
		
		int addedCurrentPeriodMin = currentPeriodMin + currentPeriodDurationHour;
		int addedCurrentPeriodHour = currentPeriodHour + currentPeriodDurationHour;
		
		if(addedCurrentPeriodMin >= 60){
			addedCurrentPeriodHour += addedCurrentPeriodMin;
		}
		
		if(newPeriodHour <= addedCurrentPeriodHour && 
				newPeriodHour >= currentPeriodHour ){
			throw new PeriodException("Section conflict with " + newPeriod + " from " + this);
		}
	}
	
	private int getHours(String period) {
		return Integer.valueOf(period.substring(1, 3));
	}
	
	private int getMinutes(String period) {
		return Integer.valueOf(period.substring(3, 5));
	}
	
	private String getDuration(Period period){
		String duration = null;
		switch (period) {
		  case H0830:
		  case H1000:
		  case H1130:
		  case H1300:
		  case H1430:
		  case H1600:
		  {
			  duration = "H0130";
		  }
			  break;
		  case H0900:
		  case H1030:
		  case H1400:
		  {
			  duration = "H0200";
		  }
			  break;
		}
		return duration;
	}
}
