package com.igeek.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.igeek.domain.User;
import com.igeek.service.UserService;
import com.igeek.utils.MD5Utils;
import com.igeek.utils.MailUtils;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 解决POST乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//先判断输入的验证码与服务器产生的验证码是否一致
		String identify = request.getParameter("identify");
		String session_identify = (String) request.getSession().getAttribute("servletImg");
		System.out.println("输入的验证码：");
		if (identify.equalsIgnoreCase(session_identify)==false) {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"验证码错误！\");window.location.href =\"register.jsp\"</script>");
			return;
		}
		//否则就插入到数据库
		User user = new User();
		try {
			// 借助BeanUtils类的静态方法,将表单参数值映射到User属性中
			BeanUtils.populate(user, request.getParameterMap());

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 表单中未设计的参数 state默认即为0,可不设置

		// uid 使用UUID生成
		user.setUid(UUID.randomUUID().toString());
		// code 激活码,使用UUID生成
		user.setCode(UUID.randomUUID().toString());
		// 激活状态
		user.setState(0);
		//密码加密
		user.setPassword(MD5Utils.md5(user.getPassword()));

		UserService service = new UserService();
		boolean flag = service.regist(user);
		//返回结果
		if (flag) {
			//发送激活邮件
			String site="http://localhost:8080/shop/active?code="+user.getCode();
			String emailMsg="点击下面的链接激活您的账户<hr/><a font-size=10 href='"+site+"'>"+site+"</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				// TODO 自动生成的 catch 块
				response.getWriter().println(
						"<script type=\"text/javascript\">alert(\"注册失败！\");window.location.href =\"register.jsp\"</script>");
				e.printStackTrace();
			}
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"注册成功！请在邮箱中查收激活邮件。即将为您跳转到登录页面...\");window.location.href =\"login.jsp\"</script>");
		}else {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"注册失败了！\");window.location.href =\"login.jsp\"</script>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}
}
