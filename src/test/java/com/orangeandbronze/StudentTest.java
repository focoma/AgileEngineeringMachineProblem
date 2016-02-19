package com.orangeandbronze;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static com.orangeandbronze.Default.*;
import static org.junit.Assert.*;

/**
 * Created by training on 2/19/16.
 */
public class StudentTest {


    @Test
    public void enlistFirstSection() {
        Student student = new Student(1);
        Section section = new Section(SECTION, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3));
    }

    @Test(expected = ScheduleConflictException.class)
    public void enlistSectionSameScheduleTest() {
        Section s1 = new Section(SECTION, SCHEDULE,ROOM1);
        Section s2 = new Section(SECTION2,SCHEDULE,ROOM1);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }


    @Test
    public void enlistStudentWithoutExceedingCapacity(){
        new Room("room1",3);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Section section = new Section(SECTION, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3));
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);
    }

}