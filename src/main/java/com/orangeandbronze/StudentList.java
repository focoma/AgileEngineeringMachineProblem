package com.orangeandbronze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class StudentList {

    private final Collection<Student> students;


    public StudentList(Collection<Student> students) {
        this.students = students;
    }


    public Collection<Student> getStudents() {
        return new ArrayList<Student>(students);
    }


}
