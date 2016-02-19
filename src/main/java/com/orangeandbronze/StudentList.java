package com.orangeandbronze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by training on 2/19/16.
 */
public class StudentList {

    private final Collection<Student> students;


    public StudentList(Collection<Student> students) {
        this.students = students;
    }


    public Collection<Student> getStudents() {
        return new ArrayList<Student>(students);
    }

    public int getNumberOfStudentInsideASection(Section givenSection) {
        int ctr = 0;
        for(Student s: students) {
            //s.hasSection(section);
            if(givenSection.isExisting(s, givenSection)) {
                ctr++;
            }
        }
        return ctr;
    }



//    public void enlistStudent() {
//
//    }
//    public void enlist(Student newStudent) {
//        for(Student s: students) {
//            // check if student is existing
//        }
//        students.add(newStudent);
//    }


}
