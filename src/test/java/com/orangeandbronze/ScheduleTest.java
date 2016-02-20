package com.orangeandbronze;


import org.junit.Test;

import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
public class ScheduleTest {

    @Test
    public void scheduleWithoutConflict(){
        Section s1 = new Section(SECTION1_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Section s2 = new Section(SECTION2_NAME, SCHEDULE_H1000, ROOM1_5, SUBJECT_MATH_02, S_FIRST_SEM);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }

    @Test(expected = ScheduleConflictException.class)
    public void scheduleWithConflict() {
        Section s1 = new Section(SECTION1_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Section s2 = new Section(SECTION2_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }
}