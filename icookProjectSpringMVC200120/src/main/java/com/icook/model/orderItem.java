package com.icook.model;

import java.io.Serializable;

public class orderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer seqno;
	private Integer orderId;
	private Integer productId;
	private String describe;
	private Integer qty;
	private double unitPrice;
	private String discount;
	private Integer typeId;
	private String image1;
	public orderItem() {
	}
	public orderItem(Integer seqno, Integer orderId, Integer productId, String describe, Integer qty,
			double unitPrice, String discount, Integer typeId) {
		super();
		this.seqno = seqno;
		this.orderId = orderId;
		this.productId = productId;
		this.describe = describe;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.typeId = typeId;
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	
	
}
