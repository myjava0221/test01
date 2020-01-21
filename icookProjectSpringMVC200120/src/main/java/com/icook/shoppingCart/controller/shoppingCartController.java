package com.icook.shoppingCart.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icook.model.MemberBean;
import com.icook.model.orderBean;
import com.icook.model.orderDetail;
import com.icook.shoppingCart.service.OrderServiceDao;

@Controller
public class shoppingCartController {
	
	@Autowired
	OrderServiceDao service;
	
	@Autowired
	public void setService(OrderServiceDao service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/ShoppingCar/OrderCheck", method = RequestMethod.GET)
	public String SendOrder(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		orderDetail ord1 = new orderDetail(null,null,1,"雞胸肉",5,60,"9.0000",1);
		orderDetail ord2 = new orderDetail(null,null,2,"平底鍋 紅色",2,500,null,2);
		orderDetail ord3 = new orderDetail(null,null,3,"高麗菜",10,100,null,3);
		List<orderDetail> list = new LinkedList<>();
		list.add(0, ord1);
		list.add(1, ord2);
		list.add(2, ord3);
		MemberBean mem = new MemberBean(10003,"xxu1566","a123123","張",
					"嘉原","GaOne","xxu1566@gmail.com","1995-05-04","男 ","0977302207","台北市大安區復興南路一段");
		session.setAttribute("LogOK", mem);
		session.setAttribute("ShoppingOrder",list);
		System.out.println("1111");
		return "shoppingCart/OrderCheck";
	}
	
	@RequestMapping(value = "/ShoppingCar/CheckOrder", method = RequestMethod.GET)
	public String CheckOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		//返回的主頁面的網址
		if (session == null) {   // 使用逾時
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
			return "index";
		}
		String finalDecision = (String)request.getParameter("finalDecision");
		//取得使用者最終的決定 送出訂單則為ORDER 取消訂單則為CANAEL 
		if(finalDecision.equals("CANCEL")) {
			System.out.println("--------------CANCEL---------------");
			session.removeAttribute("ShoppingOrder");
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
			return "index";
		}
		else {
			System.out.println("--------------ORDER--------------");
			MemberBean mem = (MemberBean)session.getAttribute("LogOK");
			// 取得登錄者資訊
			@SuppressWarnings("unchecked")
			List<orderDetail> SCar = (List<orderDetail>)session.getAttribute("ShoppingOrder");
			// 取得購物車資料
			if(mem == null || SCar == null) {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return "index";
			}
			else {
				String ShippingAddress = (String)request.getParameter("ShippingAddress");
				String BNO = (String)request.getParameter("BNO");
				if(BNO == "") {
					BNO = null;
				}
				String invoiceTitle = (String)request.getParameter("invoiceTitle");
				if(invoiceTitle == "") {
					invoiceTitle = null;
				}
				//判斷 BNO 跟 invoiceTitle 有沒有輸入 無則為null
				double total = (double)session.getAttribute("total");
				//取得總金額
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
				String date = sdFormat.format(new Date());
				// date取得今天的日期
				orderBean order = new orderBean(null,mem.getUserId(),total,ShippingAddress,BNO,invoiceTitle,date,null,"N");
				//存放訂單資訊
				String res = service.FinalDealFinish(order,SCar);
				if(res.equals("true")) {
					int uid = service.retUserId(order);
					session.setAttribute("UID",uid);
					session.removeAttribute("ShoppingOrder");
					return "shoppingCart/TheDealFinish";
				}
				else {
					System.out.println("--------------error---------------");
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
					return "index";
				}
			}
		}
	}
	
}
