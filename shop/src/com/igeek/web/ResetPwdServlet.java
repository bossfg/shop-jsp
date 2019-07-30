package com.igeek.web;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.service.UserService;
import com.igeek.utils.MailUtils;

/**
 * Servlet implementation class ResetPwdServlet
 */
public class ResetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email = "";
	String pwd = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
			request.setAttribute("email", email);
			System.out.println(request.getParameter("email"));
		}
		// 获取验证码
		if (request.getParameter("getCode") != null) {
			//如果没有发送过验证码
			if (request.getAttribute("sendCodeSucess")==null) {
				sendCode(request, response);
			}
			request.getRequestDispatcher("forget.jsp").forward(request, response);
		} else if (request.getParameter("submit") != null) {
			updatePwd(request, response);
		}

	}

	public void sendCode(HttpServletRequest request, HttpServletResponse response) {
		String code = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			code += random.nextInt(9);
		}
		request.getSession().setAttribute("code", code);
		System.out.println("验证码：" + code);
		String emailMsg = "您的验证码是：<font size='5' color='red'><b>" + code + "</b></font>";
		try {
			MailUtils.sendMail(email, emailMsg);
			request.setAttribute("sendCodeSucess", "true");//设置验证码发送成功
		} catch (AddressException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void updatePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String session_code = (String) request.getSession().getAttribute("code");
		System.out.println("保存的验证码" + session_code);
		System.out.println("输入的验证码" + request.getParameter("identify").toString());
		if (session_code==null||!session_code.equals(request.getParameter("identify"))) {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"验证码不正确！\");window.location.href =\"forget.jsp\"</script>");
		} else {
			String code = request.getParameter("password");
			UserService service = new UserService();
			boolean isOK = service.updatePwd(email, request.getParameter("password"));
			if (isOK) {
				System.out.println("密码重置成功！请牢记您的新密码。");
				response.getWriter().println(
						"<script type=\"text/javascript\">alert(\"密码重置成功！请牢记您的新密码。\");window.location.href =\"login.jsp\"</script>");
			} else {
				System.out.println("密码修改失败！");
				response.getWriter().println(
						"<script type=\"text/javascript\">alert(\"密码修改失败！\");window.location.href =\"forget.jsp\"</script>");
			}
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
