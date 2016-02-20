package com.orangeandbronze;

import java.util.Collection;

/**
 * Created by training on 2/19/16.
 */
public class StudentSemEnlistments {

    private Collection<StudentPerSem> studentPerSem;

    public Collection<StudentPerSem> getStudentPerSem() {
        return studentPerSem;
    }

    public void enlistStudentPerSem(StudentPerSem studentPerSem) {
        this.studentPerSem.add(studentPerSem);
    }

    public void enlistStudent (Integer studentId, Collection<Section> sections){

        Student student = new Student(studentId);
        for(Section s : sections) {
            student.enlist(s);
        }
    }
}
