package com.orangeandbronze;


import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.Default.s1;
import static org.junit.Assert.assertEquals;


/**
 * Created by training on 2/19/16.
 */
public class RoomTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkIfIsNotEmpty() {
        new Room("", 0);
    }

    @Test
    public void checkAlphanumeric() {
        new Room(ROOM101, 2);
    }

    @Test(expected = RoomCapacityException.class)
    public void checkIfRoomIsFull() {
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
        student.enlist(s3);
    }

}