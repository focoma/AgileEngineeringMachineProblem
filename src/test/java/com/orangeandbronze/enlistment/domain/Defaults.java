package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Period.*;
import static org.junit.Assert.*;
import org.junit.Test;

import com.orangeandbronze.enlistment.domain.Schedule;
public class Defaults {

	public final static Schedule SCHEDULE = new Schedule(MTH, H0830);
	final static Schedule SCHEDULE2 = new Schedule(WS, H0830);
	final static Schedule SCHEDULE3 = new Schedule(TF, H0830);

}
