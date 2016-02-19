package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */
public class Default {

    public final static Integer STUDENT_ID = 1;
    public final static Integer STUDENT_ID_2 = 2;

    public final static String SECTION_INV = "RizalOOI";
    public final static String SECTION = "Rizal001";
    public final static String SECTION2 = "Bonifacio001";
    public final static String SECTION3 = "Mabini001";

    public final static String ROOM101 = "R101";
    public final static String ROOM102 = "R102";
    public final static String ROOM103 = "R103";


    public final static Schedule SCHEDULE = new Schedule(Days.MTH, Period.H0830);
    public final static Schedule SCHEDULE_H1000 = new Schedule(Days.MTH, Period.H1000);
    public final static Schedule SCHEDULE_H1130 = new Schedule(Days.MTH, Period.H1130);

    public final static Room  ROOM1 = new Room(ROOM101, 5);
    public final static Room  ROOM2 = new Room(ROOM101, 2);
    public final static Room  ROOM3 = new Room(ROOM101, 2);


    public final static Section s1 = new Section(SECTION2, SCHEDULE, ROOM1);
    public final static Section s2 = new Section(SECTION, SCHEDULE_H1000, ROOM1);
    public final static Section s3 = new Section(SECTION3, SCHEDULE_H1130, ROOM1);

}
