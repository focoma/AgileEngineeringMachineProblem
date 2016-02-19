package com.orangeandbronze;

import java.util.Collection;

/**
 * Created by training on 2/19/16.
 */
public class StudentSemEnlistments {
    private final Collection<Section> sections;
    private final Collection<Student> students;

    public StudentSemEnlistments(Collection<Section> sections, Collection<Student> students) {
        this.sections = sections;
        this.students = students;
    }
}
