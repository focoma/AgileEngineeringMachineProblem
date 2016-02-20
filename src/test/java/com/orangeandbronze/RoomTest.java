package com.orangeandbronze;


import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
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

    @Test(expected = IllegalArgumentException.class)
    public void roomHasUnderscore() {
        new Room("hello_world", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void roomHasWhiteSpace() {
        new Room("hello world", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void roomHasAmpersand() {
        new Room("hello&world", 2);
    }

    @Test
    public void enlistStudentWithoutExceedingCapacity() {
        Student student = new Student(1);
        Student student2 = new Student(2);

        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3), SUBJECT_MATH_01, S_FIRST_SEM);
        student.enlist(section);
        student2.enlist(section);
    }

    @Test(expected = RoomCapacityException.class)
    public void enlistStudentExceededCapacity() {
        Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);
    }
}