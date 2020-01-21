package com.icook.courseOrder.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icook.course.service.CourseService;

@Controller
public class CourseOrderController {
	
	CourseService service;
	@Autowired
	public void setService(CourseService service) {
		this.service = service;
	}
	
	ServletContext context;
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@RequestMapping("/courseOrder/addCourseOrder")
	public String homePage(Model model) {
		return "/index";
	}

}
