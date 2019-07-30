package com.igeek.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.igeek.domain.User;
import com.igeek.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取是否自动登录
		String autoLogin = request.getParameter("autoLogin");
		User user = new User();
		if (autoLogin==null) {
			//不是自动登录，就从输入框获取
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			//自动登录，从cookie中读取用户信息
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cookie_username")) {
					user.setUsername(cookie.getValue());
				}else if (cookie.getName().equals("cookie_password")) {
					user.setPassword(cookie.getValue());
				}
			}
		}
		checkLogin(request, response, user);
	}

	private void checkLogin(HttpServletRequest request, HttpServletResponse response,User user) throws IOException {
		UserService service = new UserService();
		boolean isSucess = service.login(user);
		if (isSucess) {
			System.out.println("登陆成功");
			request.getSession().setAttribute("user", user);
			//把登陆的用户名和密码保存到cookie
			Cookie cookie_username=new Cookie("cookie_username", user.getUsername());
			Cookie cookie_pwd=new Cookie("cookie_password", user.getPassword());
			response.addCookie(cookie_username);
			response.addCookie(cookie_pwd);
			//跳转到首页
			response.sendRedirect("index");
		} else {
			System.out.println("登录失败");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"登录失败。账户未激活或者用户名或密码错误！\");window.location.href =\"login.jsp\"</script>");
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
