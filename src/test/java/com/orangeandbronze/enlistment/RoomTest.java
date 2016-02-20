package com.orangeandbronze.enlistment;

import org.junit.Test;

public class RoomTest {

	@Test
	public void roomNameAlphanumeric() {
		new Room("GDO101", 40);
	}
	
	@Test (expected = RoomNameException.class)
	public void roomNameHasWhiteSpace() {
		new Room("GDO 101", 40);
	}

	@Test (expected = RoomNameException.class)
	public void roomNameHasUnderscore() {
		new Room("GDO_101", 40);
	}	
	
	@Test (expected = RoomNameException.class)
	public void roomNameHasAmpersand() {
		new Room("DRD101&GDO101", 40);
	}	
	
	
	@Test(expected = RoomNameException.class)
	public void roomCapacityNegativeValue(){
		new Room("DXRT02", -1);
	}
	
	@Test(expected = RoomNameException.class)
	public void roomNameNullValue(){
		new Room(null, 2);
	}
	
	@Test(expected = RoomNameException.class)
	public void roomNameEmptyValue(){
		new Room("", 3);
	}

}
