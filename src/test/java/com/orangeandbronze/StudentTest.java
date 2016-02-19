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
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }

    @Test
    public void checkNumberOfStudentPerSection() {

        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);

        student.enlist(s1);
        student2.enlist(s1);
        student3.enlist(s1);

        Collection<Student> c = new ArrayList<Student>();
        c.add(student);
        c.add(student2);
        c.add(student3);

        StudentList e = new StudentList(c);

        assertEquals(3, e.getNumberOfStudentInsideASection(s1));




    }

}