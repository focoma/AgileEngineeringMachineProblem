package com.orangeandbronze;

/**
 * Created by training on 2/20/16.
 */
public class SubjectPrerequisiteException extends RuntimeException{
    public SubjectPrerequisiteException(Subject subject, Subject subjectPrerequisite) {
        super("Subject " + subject.toString() + " has a prerequisite to " + subjectPrerequisite.getSubjectIdPrerequisite());
    }

    public SubjectPrerequisiteException(String message) {
        super(message);
    }
}
