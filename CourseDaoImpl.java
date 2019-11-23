package com.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Courses;
import com.app.pojos.Student;
import static utils.ValidationRules.*;

@Repository
@Transactional
public class CourseDaoImpl implements ICourseDao {
	@Autowired
	private SessionFactory sf;

	public CourseDaoImpl() {
		System.out.println("CourseDao default contructor");
	}

	@Override
	public List<Courses> getCourseList() {

		System.out.println("In dao show course list method");
		List<Courses> c = sf.getCurrentSession().createQuery("select c from Courses c", Courses.class).getResultList();
		System.out.println("working " + c);

		return c;
	}

	@Override
	public String deleteCourse(Integer cid) {
		System.out.println("In dao delete course method");
		String jpql = "select c1 from Courses c1 where id=:c1";
		Courses c2 = sf.getCurrentSession().createQuery(jpql, Courses.class).setParameter("c1", cid).getSingleResult();
		sf.getCurrentSession().remove(c2);

		return "Deleted " + cid + " successfully";
	}

	@Override
	public String admitStudent(Integer cid, Student s) {
		Courses co = sf.getCurrentSession().createQuery("select c3 from Courses c3 where id=:c3", Courses.class).setParameter("c3", cid).getSingleResult();
		checkCgpa(s.getCgpa());
		checkDob(s.getDob());
		co.addStudent(s);
		System.out.println("Student added successfully");
		return null;
	}
}
