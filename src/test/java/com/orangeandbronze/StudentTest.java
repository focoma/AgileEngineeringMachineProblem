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

//    @Test(expected = ScheduleConflictException.class)
//    public void enlistSectionSameScheduleTest() {
//        Student student = new Student(1);
//        student.enlist(s1);
//        student.enlist(s2);
//    }

}