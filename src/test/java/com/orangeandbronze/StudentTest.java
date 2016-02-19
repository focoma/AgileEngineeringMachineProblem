package com.orangeandbronze;


import static com.orangeandbronze.Default.ROOM103;
import static com.orangeandbronze.Default.ROOM1_5;
import static com.orangeandbronze.Default.ROOM2_2;
import static com.orangeandbronze.Default.SCHEDULE_H0830;
import static com.orangeandbronze.Default.SECTION1_NAME;
import static com.orangeandbronze.Default.SECTION2_NAME;
import static com.orangeandbronze.Default.SECTION3_NAME;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by training on 2/19/16.
 */
public class StudentTest {

    @Test
    public void enlistSectionTest() {
        Student student = new Student(1);
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3));
        student.enlist(section);
        assertEquals(1, student.getSections().size());
    }

    @Test(expected = ScheduleConflictException.class)
    public void enlistSectionSameScheduleTest() {
        Section s1 = new Section(SECTION1_NAME, SCHEDULE_H0830 ,ROOM1_5);
        Section s2 = new Section(SECTION2_NAME,SCHEDULE_H0830 ,ROOM1_5);
        Student student = new Student(1);
        student.enlist(s1);
        student.enlist(s2);
    }

    @Test
    public void enlistStudentWithoutExceedingCapacityFull(){
        Student student = new Student(1);
        Student student2 = new Student(2);
        
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3));
        student.enlist(section);
        student2.enlist(section);
    }
    
    @Test
    public void enlistStudentWithoutExceedingCapacityNotFull(){
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        
        Section section = new Section(SECTION1_NAME, new Schedule(Days.MTH, Period.H0830), new Room(ROOM103, 3));
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);
    }
    
    @Test(expected = RoomCapacityException.class)
    public void enlistStudentExceededCapacity(){
    	Section section = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM2_2);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        student.enlist(section);
        student2.enlist(section);
        student3.enlist(section);  
    }
    
    

}