package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.Section;

public interface SectionDAO {
	// TODO: Add method signatures
	
	Section getSectionId(String sectionId);
	void save(Section section);
}
