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
		// ���POST��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String code = request.getParameter("code");
		UserService service=new UserService();
		boolean flag=service.active(code);
		if (flag) {
			//����ɹ�
			System.out.println("����ɹ�");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"�����˺��ѳɹ��������Ϊ����ת����¼ҳ��...\");window.location.href =\"login.jsp\"</script>");
			//response.sendRedirect("index");
		}else {
			//����ʧ��
			System.out.println("����ʧ��");
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"����ʧ�ܣ�\");window.location.href =\"register.jsp\"</script>");
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
