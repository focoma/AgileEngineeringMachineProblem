package com.orangeandbronze;


import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

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

    @Test
    public void prerequisiteTestNormalWithoutIncludingSemester() {
    	Section section = SECTION1;
    	Section section2 = SECTION1_1;
        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);
    }

    @Test(expected = SubjectPrerequisiteException.class)
    public void prerequisiteWithOutIncludingSemeterTest() {
        Section section = SECTION1;
        Section section2 = SECTION1_1;
        Student student = new Student(1);
        student.enlist(section2);
        student.enlist(section);
    }

    @Test
    public void prerequisiteTestNormalWithSemester() {
        Section section = SECTION1;
        Section section2 = SECTION1_1;

        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);

        Collection<Section> expected = new ArrayList<Section>();
        expected.add(section);
        expected.add(section2);
        assertEquals(2, student.getSections().size());
    }

    @Test
    public void prerequisiteAddingNotAddedSubjectNormalWithSemester() {
        Section section = SECTION1;
        Section section2 = SECTION1_2;

        Student student = new Student(1);
        student.enlist(section);
        student.enlist(section2);

        Collection<Section> expected = new ArrayList<Section>();
        expected.add(section);
        expected.add(section2);
        assertEquals(2, student.getSections().size());
    }

}