package com.icook.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icook.course.dao.CourseDao;
import com.icook.model.CourseBean;

@Repository
public class CourseDaoImpl implements CourseDao{
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

//	列出所有課程清單
	@SuppressWarnings("unchecked")
	@Override
	public List<CourseBean> queryAllCourse() {
		System.out.println("進入DAO AllCourse");
		
		List<CourseBean> courses = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM CourseBean";
		courses = session.createQuery(hql).getResultList();
		return courses;
	}
	
//	關鍵字查詢課程
	@SuppressWarnings("unchecked")
	@Override
	public List<CourseBean> queryCourse(String courseName) {
		System.out.println("進入DAO courseName :" + courseName);
		
		List<CourseBean> courses = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM CourseBean c WHERE c.courseName like :name";
		courses = session.createQuery(hql).setParameter("name", "%"+courseName+"%").getResultList();
		
		return courses;
	}

//	課程詳細資訊
	@Override
	public CourseBean getCourseById(int courseId) {
		Session session = factory.getCurrentSession();
		CourseBean cb = session.get(CourseBean.class, courseId);
		return cb;
	}

}
