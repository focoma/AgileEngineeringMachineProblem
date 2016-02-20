package com.orangeandbronze;


import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
public class ScheduleTest {

    @Test(expected = ScheduleConflictException.class)
    public void enlistStudentWithConflict() {
        Section s1 = new Section(SECTION1_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Section s2 = new Section(SECTION2_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }
}