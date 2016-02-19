package com.orangeandbronze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by training on 2/19/16.
 */
public class Student {

    private final Integer studentNumber;
    private final Collection<Section> sections = new HashSet<Section>();

    public Student(Integer studentNumber) {
        if (studentNumber < 0) {
            throw new IllegalArgumentException("Student number should be non-negative, was " + studentNumber);
        }
        this.studentNumber = studentNumber;
    }

    public void enlist(Section newSection) {
        for (Section currentSection : sections) {
            currentSection.checkForConflict(newSection);
        }
        sections.add(newSection);
    }

    public Collection<Section> getSection() {
        return new HashSet<Section>(sections);
    }

    public boolean hasSection(Section section) {
        return this.sections.contains(section);
    }

    @Override
    public String toString() {
        return "Student# " + studentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentNumber.equals(student.studentNumber);

    }

    @Override
    public int hashCode() {
        return studentNumber.hashCode();
    }
}
