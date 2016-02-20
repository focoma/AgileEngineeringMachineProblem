package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.domain.Time.*;

public class PeriodTest {

	@Test
	public void endOfFirstOverlapsStartOfSecond() {
		Period first = new Period(H0830, H1000);
		Period second = new Period(H0900, H1100);
		assertTrue(first.isOverlapping(second));
	}
	
	@Test
	public void startOfFirstOverlapsEndOfSecond() {
		Period first = new Period(H0900, H1100);
		Period second = new Period(H0830, H1000);		
		assertTrue(first.isOverlapping(second));
	}
	
	@Test 
	public void oneIsWithinOtherSameEnd() {
		Period inner = new Period(H1430, H1600);
		Period outer = new Period(H1400, H1600);		
		assertTrue(inner.isOverlapping(outer));
		assertTrue(outer.isOverlapping(inner));
	}
	
	@Test 
	public void oneIsWithinOtherSameStart() {
		Period inner = new Period(H1400, H1730);
		Period outer = new Period(H1400, H1600);		
		assertTrue(inner.isOverlapping(outer));
		assertTrue(outer.isOverlapping(inner));
	}
	
	@Test
	public void sameStartAndEnd() {
		Period one = new Period(H1400, H1730);
		Period two = new Period(H1400, H1730);	
		assertTrue(one.isOverlapping(two));
		assertTrue(two.isOverlapping(one));
	}
	
	@Test 
	public void startOfOneIsEndOfOtherNoOverlap() {
		Period first = new Period(H0830, H1000);
		Period second = new Period(H1000, H1130);
		assertFalse(first.isOverlapping(second));
		assertFalse(second.isOverlapping(first));
	}
	
	@Test
	public void notTouchingAtAll() {
		Period one = new Period(H0830, H1000);
		Period two = new Period(H1030, H1330);	
		assertFalse(one.isOverlapping(two));
		assertFalse(two.isOverlapping(one));
	}
	

}
