package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */
enum Subjects {
    MATH, ENGLISH, SCIENCE, FILIPINO
}

public class Subject {
    private final Subject subjects;

    Subject(Subject subjects) {
        this.subjects = subjects;
    }
}
