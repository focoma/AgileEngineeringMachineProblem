package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Period.*;

public class Defaults {

	public final static Schedule SCHEDULE = new Schedule(MTH, H0830);
	public final static Schedule SCHEDULE2 = new Schedule(WS, H0830);
	public final static Schedule SCHEDULE3 = new Schedule(TF, H0830);
	public final static Room ROOM1 = new Room("S306", 1);
	public final static Room ROOM2 = new Room("S304", 2);
	public final static Subject SUBJECT_WITH_PREREQ = Subject.Math2;
	public final static Subject SUBJECT_NO_PREREQ = Subject.Math1;
}
