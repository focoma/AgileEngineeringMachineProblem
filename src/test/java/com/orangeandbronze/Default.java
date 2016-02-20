package com.orangeandbronze;

import static com.orangeandbronze.Default.ROOM1_5;
import static com.orangeandbronze.Default.SCHEDULE_H0830;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;
import static com.orangeandbronze.SemesterEnum.S_SECOND_SEM;

/**
 * Created by training on 2/19/16.
 */
public class Default {

    final  Student STUDENT = new Student(1);

    public final static Integer STUDENT_ID = 1;
    public final static Integer STUDENT_ID_2 = 2;

    
    
    public final static Schedule SCHEDULE_H0830 = new Schedule(Days.MTH, Period.H0830);
    public final static Schedule SCHEDULE_H1000 = new Schedule(Days.MTH, Period.H1000);
    public final static Schedule SCHEDULE_H1130 = new Schedule(Days.MTH, Period.H1130);
    
    public final static String SECTION_INV_NAME = "RizalOOI";
    public final static String SECTION1_NAME = "Rizal001";
    public final static String SECTION2_NAME = "Bonifacio001";
    public final static String SECTION3_NAME = "Mabini001";
    
    public final static String ROOM101 = "R101";
    public final static String ROOM102 = "R102";
    public final static String ROOM103 = "R103";
    
    public final static Room  ROOM1_5 = new Room(ROOM101, 5); // (roomName, maxCapacity)
    public final static Room  ROOM2_2 = new Room(ROOM102, 2);
    public final static Room  ROOM3_1 = new Room(ROOM103, 1);
    
    
    public final static Subject SUBJECT_MATH_01 = new Subject(1, null); // no prerequisite
    public final static Subject SUBJECT_MATH_02 = new Subject(2, 1);    // prerequisite = SUBJECT_MAT_01

    public final static Subject SUBJECT_SCIENCE_01 = new Subject(3, null); // no prerequisite
    
    
    public final static Section SECTION1 = new Section(SECTION1_NAME, SCHEDULE_H0830, ROOM1_5, SUBJECT_MATH_01, S_FIRST_SEM);
    public final static Section SECTION1_1 = new Section(SECTION3_NAME, SCHEDULE_H1000, ROOM1_5, SUBJECT_MATH_02, S_SECOND_SEM);
    public final static Section SECTION2 = new Section(SECTION2_NAME, SCHEDULE_H0830, ROOM2_2, SUBJECT_MATH_02, S_SECOND_SEM);
    public final static Section SECTION3 = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM3_1, SUBJECT_MATH_01, S_FIRST_SEM);
    
//    public final static Section SECTION11_ = new Section(SECTION1_NAME, SCHEDULE_H0830, ROOM1_5);
//    public final static Section SECTION22 = new Section(SECTION2_NAME, SCHEDULE_H0830, ROOM2_2);
//    public final static Section SECTION33 = new Section(SECTION3_NAME, SCHEDULE_H0830, ROOM3_1);
    
    

    

}
