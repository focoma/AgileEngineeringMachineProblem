package com.orangeandbronze;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.Default.ROOM102;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static org.junit.Assert.*;

/**
 * Created by training on 2/19/16.
 */
public class EnlistmentTest {

    @Test
    public void enlistOneStudentWithDifferentSectionAndDifferentSubject() {
        Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        Section section2 = new Section(SECTION2_NAME, SCHEDULE_H1000, ROOM2_2, SUBJECT_ENGLISH_01, S_FIRST_SEM);

        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);
    }

    @Test
    public void enlistOneStudentWithSameSectionAndDifferentSubject() {
        Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        Section section2 = new Section(SECTION3_NAME, SCHEDULE_H1000, ROOM2_2, SUBJECT_ENGLISH_01, S_FIRST_SEM);
        Student student = new Student(2);
        student.enlist(section);
        student.enlist(section2);
    }

    @Test(expected = ExistingSubjectException.class)
    public void checkIfSubjectIsAlreadyAddedToAnyOfTheAddedSection() {
        Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        Section section2 = new Section(SECTION2_NAME, SCHEDULE_H1000, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);

        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);
    }
}