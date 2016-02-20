package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

import java.util.*;

public class Section {

	private final String sectionId;
	private Schedule schedule;
	private final Subject subject;
	private Room room;
	private Collection<StudentSemEnlistments> enlistements = new HashSet<>();

	public Section(String sectionId, Subject subject,
			Schedule schedule, Room room) {
		matchesPattern(sectionId, "[a-zA-Z0-9]+",
				"sectionId should be alphanumeric, was %s", sectionId);
		notNull(schedule);
		notNull(subject);
		notNull(room);

		this.sectionId = sectionId;
		this.schedule = schedule;
		this.subject = subject;
		this.room = room;
	}

	void checkForConflict(Section other) {
		notNull(other);
		this.schedule.checkConflict(other.schedule);
		if (subject.equals(other.subject)) {
			throw new SameSubjectException("Subject: " + subject);
		}
	}

	void checkIfSectionCanAccommodateEnlistment() {
		if (enlistements.size() >= room.getCapacity()) {
			throw new RoomCapacityReachedException("enlistments: "
					+ enlistements.size() + " capacity: " + room.getCapacity());
		}
	}

	void add(StudentSemEnlistments enlistment) {
		notNull(enlistment);
		if (!enlistment.getSections().contains(this)) {
			throw new IllegalArgumentException(
					"Enlistment does not contain this section: " + enlistment);
		}
		checkIfSectionCanAccommodateEnlistment();
		enlistements.add(enlistment);
	}

	boolean hasPrereq() {
		return subject.hasPrereq();
	}

	boolean isPrereqFor(Section otherSection) {
		notNull(otherSection);
		return otherSection.subject.isPrereq(this.subject);
	}

	Schedule getSchedule() {
		return schedule;
	}

	Subject getSubject() {
		return subject;
	}

	public String getSectionId() {
		return sectionId;
	}

	@Override
	public String toString() {
		return sectionId + " " + subject + " " + schedule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sectionId == null) ? 0 : sectionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Section))
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
