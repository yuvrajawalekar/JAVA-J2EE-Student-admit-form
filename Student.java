package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private double cgpa;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Courses c;

	public Student() {
		System.out.println("Inside Student's default constructor");
	}

	public Student(String name, String address, LocalDate dob, double cgpa) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa=cgpa;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public Courses getC() {
		return c;
	}

	public void setC(Courses c) {
		this.c = c;
	}


}
