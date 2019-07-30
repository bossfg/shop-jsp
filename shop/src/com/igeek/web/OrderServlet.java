package com.igeek.web;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.domain.Car;
import com.igeek.domain.CarItem;
import com.igeek.domain.Order;
import com.igeek.domain.OrderItem;
import com.igeek.domain.User;
import com.igeek.service.ProductService;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Car car = (Car) request.getSession().getAttribute("car");
		Order order = new Order();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		 //判断user是否登录
		 if(user==null){
		 response.sendRedirect(request.getContextPath()+"/login.jsp");
		 return;
		 }
		order.setOid(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setTotal(car.getTotal());
		order.setState(0);
		order.setUser(user);
		Map<String, CarItem> items = car.getCarItems();
		Iterator<CarItem> it = items.values().iterator();
		while (it.hasNext()) {
			CarItem value = it.next();
			OrderItem item = new OrderItem();
			item.setItemid(UUID.randomUUID().toString());
			item.setCount(value.getSubTotal());
			item.setProduct(value.getProduct());
			item.setOrderid(order.getOid());
			order.getOrderItems().add(item);
		}
		ProductService service = new ProductService();
		service.submitOrder(order);// 向数据库添加数据
		session.setAttribute("order", order);// 向页面传递order参数
		response.sendRedirect(request.getContextPath() + "/order.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
