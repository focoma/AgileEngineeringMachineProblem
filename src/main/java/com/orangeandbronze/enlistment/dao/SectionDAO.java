package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.Section;

public interface SectionDAO {
	
	Section getSectionId(String sectionId);
	void save(Section section);
}
