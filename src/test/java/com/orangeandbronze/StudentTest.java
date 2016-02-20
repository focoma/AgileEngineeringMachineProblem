package com.orangeandbronze;


import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by training on 2/19/16.
 */
public class StudentTest {

    @Test
    public void enlistSectionTest() {
        Student student = new Student(1);
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3), SUBJECT_MATH_01, S_FIRST_SEM);
        student.enlist(section);
        assertEquals(1, student.getSections().size());
    }

    // Test for prerequisite
    @Ignore
    public void test() {
        Section section = SECTION1;
        Section section2 = SECTION1_1;

        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);
    }


}