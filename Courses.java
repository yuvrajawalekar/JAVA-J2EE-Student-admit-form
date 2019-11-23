package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20)
	private String cname;
	@OneToMany(mappedBy = "c",cascade = CascadeType.ALL)
	private List<Student> stuList;

	public Courses() {
		System.out.println("Inside Courses default constructor");
	}

	public Courses(Integer id, String cname) {
		super();
		this.id = id;
		this.cname = cname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
	public void addStudent(Student st)
	{
		stuList.add(st);
		st.setC(this);
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", cname=" + cname + ", stuList=]";
	}

}
