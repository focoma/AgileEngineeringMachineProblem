package com.orangeandbronze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Student {

    private final Integer studentNumber;
    private final Collection<Section> sections = new HashSet<Section>();
    private final Collection<Student> classList = new HashSet<Student>();

    public Student(Integer studentNumber) {
        if (studentNumber < 0) {
            throw new IllegalArgumentException("Student number should be non-negative, was " + studentNumber);
        }
        this.studentNumber = studentNumber;
    }

    public void enlist(Section newSection) {
        for (Section currentSection : sections) {
            currentSection.checkForConflictWith(newSection);
        }
        sections.add(newSection);
        newSection.enlist(this);
    }

    void checkForConflictWith(Student other) {
        if (this.studentNumber.equals(other.studentNumber)) {
            throw new RuntimeException("Cannot Input same student!!!");
        }
    }

    Collection<Section> getSections() {
        return new ArrayList<Section>(sections);
    }

    @Override
    public String toString() {
        return "Student# " + studentNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (studentNumber == null) {
            if (other.studentNumber != null)
                return false;
        } else if (!studentNumber.equals(other.studentNumber))
            return false;
        return true;
    }
}
