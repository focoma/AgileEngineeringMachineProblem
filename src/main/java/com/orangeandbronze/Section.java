package com.orangeandbronze;

import java.util.Collection;
import java.util.HashSet;

public class Section {

    private final String sectionId;
    private final Schedule schedule;
    private final Room room;
    private final Collection<Student> classList = new HashSet<Student>();
//	private final Subjects subject;

    public Section(String sectionId, Schedule schedule, Room room) {
        if (!sectionId.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("Section ID must be alphanumeric, was: " + sectionId);
        }
        this.sectionId = sectionId;
        this.schedule = schedule;
        this.room = room;
        //	this.subject = subject;
    }


    void checkForConflictWith(Section other) {
        if (this.schedule.equals(other.schedule)) {
            throw new ScheduleConflictException(this, other);
        }
    }


    public void enlist(Student newStudent) {
        for (Student currentStudent : classList) {
            currentStudent.checkForConflictWith(newStudent);
        }

        if(classList.size() != room.getMaxCapacity()) {
            classList.add(newStudent);
        } else
            throw new RoomCapacityException(room+ " had reach it's maximum capacity");
    }

    Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return sectionId;
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
