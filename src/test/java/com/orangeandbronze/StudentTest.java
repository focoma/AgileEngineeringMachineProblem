package com.orangeandbronze;


import static com.orangeandbronze.Default.ROOM103;
import static com.orangeandbronze.Default.ROOM1_5;
import static com.orangeandbronze.Default.ROOM2_2;
import static com.orangeandbronze.Default.SCHEDULE_H0830;
import static com.orangeandbronze.Default.SCHEDULE_H1000;
import static com.orangeandbronze.Default.SECTION1_NAME;
import static com.orangeandbronze.Default.SECTION2_NAME;
import static com.orangeandbronze.Default.SECTION3_NAME;
import static com.orangeandbronze.Default.SUBJECT_MATH_01;
import static com.orangeandbronze.Default.SUBJECT_MATH_02;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static com.orangeandbronze.Default.SECTION1;
import static com.orangeandbronze.Default.SECTION1_1;
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

    @Test(expected = ScheduleConflictException.class)
    public void enlistSectionSameScheduleTest() {
        Section s1 = new Section(SECTION1_NAME, SCHEDULE_H0830 ,ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Section s2 = new Section(SECTION2_NAME,SCHEDULE_H0830 ,ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }

    @Test
    public void enlistStudentWithoutExceedingCapacityFull(){
        Student student = new Student(1);
        Student student2 = new Student(2);
        
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3), SUBJECT_MATH_01, S_FIRST_SEM);
        student.enlist(section);
        student2.enlist(section);
    }
    
    @Test
    public void enlistStudentWithoutExceedingCapacityNotFull(){
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3), SUBJECT_MATH_01, S_FIRST_SEM);
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);
    }
    
    @Test(expected = RoomCapacityException.class)
    public void enlistStudentExceededCapacity(){
    	Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);  
    }
    
    @Test(expected = ExistingSubjectException.class)
    public void checkIfSubjectIsAlreadyAddedToAnyOfTheAddedSection() {
    	Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
    	Section section2 = new Section(SECTION2_NAME, SCHEDULE_H1000, ROOM2_2, SUBJECT_MATH_01, S_FIRST_SEM);
        
        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);
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