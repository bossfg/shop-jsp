package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.Order;
import com.igeek.service.ConfiromOrderService;

public class ConfiromOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 解决POST乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		Order order = (Order) request.getSession().getAttribute("order");
		order.setAddress(address);
		order.setName(name);
		order.setTelephone(telephone);
		ConfiromOrderService service = new ConfiromOrderService();
		boolean isOK = service.confirom(order);
		//response.sendRedirect(request.getContextPath() + "/success.jsp");
		if (isOK) {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"成功！\");window.location.href =\"car.jsp\"</script>");
		}else {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"失败！\");window.location.href =\"car.jsp\"</script>");
		}

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
