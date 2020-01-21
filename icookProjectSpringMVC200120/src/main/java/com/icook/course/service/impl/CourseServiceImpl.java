package com.icook.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icook.course.dao.CourseDao;
import com.icook.course.service.CourseService;
import com.icook.model.CourseBean;

@Service
public class CourseServiceImpl implements CourseService{

	CourseDao dao;
	@Autowired
	public void setDao(CourseDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public List<CourseBean> queryCourse(String courseName) {
		return dao.queryCourse(courseName);
	}

	@Transactional
	@Override
	public List<CourseBean> queryAllCourse() {
		return dao.queryAllCourse();
	}

	@Transactional
	@Override
	public CourseBean getCourseById(int courseId) {
		return dao.getCourseById(courseId);
	}

}
