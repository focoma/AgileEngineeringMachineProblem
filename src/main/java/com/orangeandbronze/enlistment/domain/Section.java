package com.orangeandbronze.enlistment.domain;

public class Section {
	private final String sectionId;
	private final Schedule schedule;
	private final Room room;
	private int studentEnlistCounter;
	private final Subject subject;
	
	public Section(String sectionId, Schedule schedule, Room room, Subject subject) {
		if(!sectionId.matches("^[A-Za-z0-9]+$")) {
			throw new IllegalArgumentException("Section Id must be alpha-numeric");
		}
		this.schedule = schedule;
		this.sectionId = sectionId;
		this.room = room;
		this.subject = subject;
		
	}
	
	void checkForConflictWith(Section currentSection, Section other) {
		if(this.schedule.equals(other.schedule)) {
			throw new ScheduleConflictException(currentSection, other);
		}
	}
	
	void checkIfPreRequisiteSubjectHasBeenTaken(Section section){
		if(!subject.isPreRequisites(section.getSubject())){
			throw new SubjectPreRequisitiesException(subject,section.getSubject());
		}
	}
	
	public void incrementStudentEnlistCounter() {
		if(!hasSlotAvailable()) {
			throw new ExceedsRoomCapacityException("No more slot available to this section " + sectionId);
		}
		studentEnlistCounter++;
	}
	
	boolean hasSlotAvailable() {
		return studentEnlistCounter < room.getRoomMaxCapacity();
	}
	
	Schedule getSchedule() {
		return schedule;
	}
	
	int getStudentEnlistCounter() {
		return studentEnlistCounter;
	}
	
	Room getRoom() {
		return room;
	}
	
	Subject getSubject() {
		return subject;
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

