package com.app.controller;

import javax.servlet.http.HttpSession;
import com.app.pojos.Student;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.ICourseDao;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseDao icd;


	public CourseController() {
		System.out.println("Controller's default contructor");
	}
	@GetMapping("/list")
	public String getCourseList(HttpSession hs) {
		System.out.println("In  controller getlist method");
		System.out.println(icd.getCourseList());
		hs.setAttribute("clist", icd.getCourseList());
		return "/course/clist";
	}

	@GetMapping("/del")
	public String delCourse(@RequestParam Integer cid, RedirectAttributes flash, Model map) 
	{
		System.out.println("In controller delCourse method");
		try 
		{
			icd.deleteCourse(cid);
			System.out.println("Course " + cid + " deleted successfully");
			flash.addFlashAttribute("delmsg", "Course "+cid+" is been deleted successfully");
			return "redirect:/course/list";
		}
		catch(HibernateException e)
		{
			System.out.println("Error in deletion...");
			flash.addFlashAttribute("delmsg", "Course " + cid + " not deleted");
			return "redirect:/course/list";
		}
	}

	@GetMapping("/form")
	public String showForm(Model map,@RequestParam Integer cid) {
		System.out.println("In controller showForm method");
		map.addAttribute("student", new Student());
		System.out.println("displaying Stu Admit form");
		return "/student/form";
	}
	
	@PostMapping("/form")
	public String admitForm(Student st,RedirectAttributes flash, @RequestParam Integer cid,Model map) 
	{
		System.out.println("In controller admitForm method");
		try {
			System.out.println("try start");
		icd.admitStudent(cid, st);
		System.out.println("try end");
		}
		catch(HibernateException e)
		{
			System.out.println(" catch start");
			map.addAttribute("fail",e.getMessage());
			System.out.println(" catch end");
			return "/student/form";
		}
		flash.addFlashAttribute("done", "Student Admitted Successfully");
		return "redirect:/course/list";
	}
}
