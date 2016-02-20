package com.orangeandbronze;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static com.orangeandbronze.Default.SECTION1;
import static com.orangeandbronze.Default.SECTION1_2;

/**
 * Created by training on 2/20/16.
 */

public class StudentSemEnlistmentsTest {


    @Ignore
    public void TestEnlistment() {

        StudentSemEnlistments studentSemEnlistments = new StudentSemEnlistments();

        Section section = SECTION1;
        Section section2 = SECTION1_2;

        Student student = new Student(1);
        Collection<Section> sections = new HashSet<Section>();
        sections.add(section);
        sections.add(section2);
        studentSemEnlistments.enlistStudent(1, sections );


        Student student2 = new Student(2);
//        Collection<Section> sections2 = new HashSet<Section>();
        sections.add(section);
        sections.add(section2);
        studentSemEnlistments.enlistStudent(2, sections );

        Collection<Student> students = new HashSet<Student>();
        students.add(student);
        students.add(student2);
//        Collection<Student> students = new HashSet<Student>();
//        students.add(student);
        StudentPerSem s1 = new StudentPerSem(students, SemesterEnum.S_FIRST_SEM);
        studentSemEnlistments.enlistStudentPerSem(s1);


        // SECOND SEM
        Student student2ndSem = new Student(1);
        Collection<Section> sections2 = new HashSet<Section>();
        sections.add(section);
        sections.add(section2);
        studentSemEnlistments.enlistStudent(1,sections2);



    }

}