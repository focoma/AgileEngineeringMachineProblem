package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.orangeandbronze.enlistment.domain.Room;

public class RoomTest {

	@Test
	public void roomAlphanumeric() {
		new Room("aBc123",5);
		new Room("123", 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void roomIdHasWhiteSpace(){
		new Room("test room", 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void roomIdHasUnderScore(){
		new Room( "test_room", 5);
	}

}
