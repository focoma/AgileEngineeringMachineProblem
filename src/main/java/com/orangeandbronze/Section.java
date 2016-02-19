package com.orangeandbronze;

import com.orangeandbronze.utils.EnlistmentUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by training on 2/19/16.
 */
public class Section {

    private final String sectionId;
    private final Schedule schedule;
    private final Room room;
    private int counterList;

    public int getCounterList() {
        return counterList;
    }

    public Section(String sectionId, Schedule schedule, Room room) {
        if(!sectionId.matches(EnlistmentUtils.alphanumeric)){
            throw new IllegalArgumentException("Invalid sectionId " + sectionId);
        }

        this.sectionId = sectionId;
        this.schedule = schedule;
        this.room = room;
    }


    public Schedule getSchedule() {
        return schedule;
    }


    public void checkForConflict(Section other) {
        if(other.getSchedule().equals(schedule)) {
            throw new ScheduleConflictException("conflict section, " + other);
        }
    }

    public boolean isExisting( Student students, Section section) {
        return students.getSection().contains(section);
    }

    public int getRoomMaxCapacity() {
        return room.getMaxCapacity();
    }

    @Override
    public String toString() {
        return "Section ID: " + sectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return sectionId.equals(section.sectionId);

    }

    @Override
    public int hashCode() {
        return sectionId.hashCode();
    }
}
