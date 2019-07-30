package com.igeek.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.UserService;

/**
 * Servlet implementation class Activeservlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决POST乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String code = request.getParameter("code");
		UserService service=new UserService();
		boolean flag=service.active(code);
		if (flag) {
			//激活成功
			System.out.println("激活成功");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"您的账号已成功激活！即将为您跳转到登录页面...\");window.location.href =\"login.jsp\"</script>");
			//response.sendRedirect("index");
		}else {
			//激活失败
			System.out.println("激活失败");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"激活失败！\");window.location.href =\"register.jsp\"</script>");
			//response.sendRedirect("register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
