package com.igeek.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.UserService;

/**
 * Servlet implementation class CheckEmailServlet
 */
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String email=request.getParameter("email");
		//service验证是否存在
				UserService service = new UserService();
				boolean isExist = service.checkEmail(email);
				String json = "{\"isExist\":"+isExist+"}";
				response.getWriter().write(json);
				System.out.println(isExist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
