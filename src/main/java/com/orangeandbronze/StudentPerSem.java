package com.orangeandbronze;

import java.util.Collection;

/**
 * Created by training on 2/20/16.
 */
public class StudentPerSem {
    private  Collection<Student> students;
    private  SemesterEnum semester;

    public StudentPerSem(Collection<Student> students, SemesterEnum semester) {
        this.students = students;
        this.semester = semester;
    }


    public SemesterEnum getSemester() {
        return semester;
    }
}
