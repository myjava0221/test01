package com.icook.shoppingCart.service;

import java.util.List;

import com.icook.model.orderBean;
import com.icook.model.orderDetail;

public interface OrderServiceDao {
	public String FinalDealFinish(orderBean order,List<orderDetail> SCar);
	public int retUserId(orderBean order);
}
