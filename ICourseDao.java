package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICourseDao {
	List<Courses> getCourseList();
	String deleteCourse(Integer cid);
	String admitStudent(Integer cid, Student s);
}
