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


    @Test(expected = RoomCapacityException.class)
    public void roomExceedsCapacity() {
        Student student1 = new Student(001);
        Student student2 = new Student(002);
        Student student3 = new Student(003);
        Student student4 = new Student(004);

        Section section1 = new Section("Section1", SCHEDULE_H0830 , new Room(ROOM101, 4), SUBJECT_MATH_01, S_FIRST_SEM);
        Section section2 = new Section("Section2", SCHEDULE_H1000, new Room(ROOM102, 3), SUBJECT_MATH_02, S_FIRST_SEM);

        student1.enlist(section1);
        student2.enlist(section1);
        student3.enlist(section1);
        student4.enlist(section1);

        student1.enlist(section2);
        student2.enlist(section2);
        student3.enlist(section2);
        student4.enlist(section2);
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
    public void roomDoesNotExceedsCapacity() {
        Student student1 = new Student(001);
        Student student2 = new Student(002);
        Student student3 = new Student(003);
        Student student4 = new Student(004);

        Section section1 = new Section("Section1", SCHEDULE_H0830, new Room(ROOM101, 3), SUBJECT_MATH_01, S_FIRST_SEM);
        Section section2 = new Section("Section2", SCHEDULE_H1000, new Room(ROOM101, 4), SUBJECT_SCIENCE_01, S_FIRST_SEM);

        student1.enlist(section1);
        student2.enlist(section1);
        student3.enlist(section1);
    }

    public void enlistStudentWithoutExceedingCapacity() {
        Student student = new Student(1);
        Student student2 = new Student(2);


        Section section = new Section(SECTION1_NAME, SCHEDULE_H1000, new Room(ROOM103, 3), SUBJECT_MATH_01, S_FIRST_SEM);
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