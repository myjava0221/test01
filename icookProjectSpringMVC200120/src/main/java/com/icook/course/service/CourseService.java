package com.icook.course.service;


import java.util.List;

import com.icook.model.CourseBean;

public interface CourseService {
	
	List<CourseBean> queryAllCourse();
	List<CourseBean> queryCourse(String courseName);
	public CourseBean getCourseById(int courseId);

}
