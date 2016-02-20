package com.orangeandbronze;

import java.util.Collection;
import java.util.HashSet;

public class Section {

    private final String sectionId;
    private final Schedule schedule;
    private final Room room;
    private Collection<Student> classList = new HashSet<Student>();
    private int studentCounter;
    private final Subject subject;
    private final SemesterEnum semester;

    public void setStudentCounter() {
        studentCounter++;
    }

    public int getRoomMaxCapacity() {
        return room.getMaxCapacity();
    }

    public boolean canAddNewSection() {
        return studentCounter < getRoomMaxCapacity();
    }

    public Subject getSubject() {
        return subject;
    }

    public Integer getSubjectId() {
        return subject.getSubjectId();
    }

    public Section(String sectionId,
                   Schedule schedule,
                   Room room,
                   Subject subject, SemesterEnum semester) {

        if (!sectionId.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("Section ID must be alphanumeric, was: " + sectionId);
        }
        this.sectionId = sectionId;
        this.schedule = schedule;
        this.room = room;
        this.subject = subject;
        this.semester = semester;
    }

    void checkForConflictWith(Section other) {
        if (isCurrentEndPeriodHasConflictWith(other) || isCurrentStartPeriodHasConflictWith(other)) {
            throw new ScheduleConflictException(this, other);
        }
    }

    boolean isCurrentStartPeriodHasConflictWith(Section other) {
        if (this.schedule.getTimeValueStartPeriod(this.schedule) >= other.schedule.getTimeValueStartPeriod(other.schedule) &&
                this.schedule.getTimeValueEndPeriod(this.schedule) <= other.schedule.getTimeValueEndPeriod(other.schedule)) {
            return true;
        }
        return false;
    }

    boolean isCurrentEndPeriodHasConflictWith(Section other) {
        if (this.schedule.getTimeValueEndPeriod(this.schedule) >= other.schedule.getTimeValueStartPeriod(other.schedule) &&
                this.schedule.getTimeValueEndPeriod(this.schedule) <= other.schedule.getTimeValueEndPeriod(other.schedule)) {
            return true;
        }
        return false;
    }

    void checkForExistingSubject(Section newSection) {
        if (newSection.getSubject() == getSubject()) {
            throw new ExistingSubjectException(newSection.getSubject());
        }
    }

    public Integer getSubjectPrerequisite() {
        return subject.getSubjectIdPrerequisite();
    }

    @Override
    public String toString() {
        return "Section [sectionId=" + sectionId + ", schedule=" + schedule + ", room=" + room + ", classList="
                + classList + ", studentCounter=" + studentCounter + ", subject=" + subject + ", semester=" + semester
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
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
        Section other = (Section) obj;
        if (sectionId == null) {
            if (other.sectionId != null)
                return false;
        } else if (!sectionId.equals(other.sectionId))
            return false;
        return true;
    }

}
