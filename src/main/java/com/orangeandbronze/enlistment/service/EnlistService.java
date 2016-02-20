package com.orangeandbronze.enlistment.service;

import static com.orangeandbronze.enlistment.Defaults.*;
import com.orangeandbronze.enlistment.Room;
import com.orangeandbronze.enlistment.Section;
import com.orangeandbronze.enlistment.Student;
import com.orangeandbronze.enlistment.Subject;
import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import static org.mockito.Mockito.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	//private Student studentDao;
	//private Section sectionDao;
	
	public void enlist(int studentNo, String sectionId) {
		final Student student = new Student(studentNo);
	    final Section section = new Section(sectionId, SCHEDULE, new Room("GDO101",2), new Subject("Math"), 1);
	    
		when(studentDao.getStudentNo(studentNo)).thenReturn(student);
		when(sectionDao.getSectionId(sectionId)).thenReturn(section);
		student.enlist(section);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void setStudent(Student studentDao2) {
		// TODO Auto-generated method stub
		//studentDao = studentDao2;
	}

	public void setSection(Section sectionDao2) {
		// TODO Auto-generated method stub
		//sectionDao = sectionDao2;
	}
	
	
}
