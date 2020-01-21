package com.icook.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courseOrder")
public class CourseOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer orderId;
	Integer userId;
	Integer courseId;
	Date orderDate;
	Integer orderQty;
	String orderStatus;
	
	public CourseOrderBean() {}
	
	public CourseOrderBean(
			Integer orderId,
			Integer userId,
			Integer courseId,
			Date orderDate,
			Integer orderQty,
			String orderStatus
			) {
		this.orderId = orderId;
		this.userId = userId;
		this.courseId = courseId;
		this.orderDate = orderDate;
		this.orderQty = orderQty; 
		this.orderStatus = orderStatus;
		
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
