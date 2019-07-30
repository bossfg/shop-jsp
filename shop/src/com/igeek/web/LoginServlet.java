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
		//���ñ���
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ�Ƿ��Զ���¼
		String autoLogin = request.getParameter("autoLogin");
		User user = new User();
		if (autoLogin==null) {
			//�����Զ���¼���ʹ�������ȡ
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else {
			//�Զ���¼����cookie�ж�ȡ�û���Ϣ
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
			System.out.println("��½�ɹ�");
			request.getSession().setAttribute("user", user);
			//�ѵ�½���û��������뱣�浽cookie
			Cookie cookie_username=new Cookie("cookie_username", user.getUsername());
			Cookie cookie_pwd=new Cookie("cookie_password", user.getPassword());
			response.addCookie(cookie_username);
			response.addCookie(cookie_pwd);
			//��ת����ҳ
			response.sendRedirect("index");
		} else {
			System.out.println("��¼ʧ��");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"��¼ʧ�ܡ��˻�δ��������û������������\");window.location.href =\"login.jsp\"</script>");
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
