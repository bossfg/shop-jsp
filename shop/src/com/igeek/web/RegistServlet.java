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

		// ���POST��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//���ж��������֤�����������������֤���Ƿ�һ��
		String identify = request.getParameter("identify");
		String session_identify = (String) request.getSession().getAttribute("servletImg");
		System.out.println("�������֤�룺");
		if (identify.equalsIgnoreCase(session_identify)==false) {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"��֤�����\");window.location.href =\"register.jsp\"</script>");
			return;
		}
		//����Ͳ��뵽���ݿ�
		User user = new User();
		try {
			// ����BeanUtils��ľ�̬����,��������ֵӳ�䵽User������
			BeanUtils.populate(user, request.getParameterMap());

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����δ��ƵĲ��� stateĬ�ϼ�Ϊ0,�ɲ�����

		// uid ʹ��UUID����
		user.setUid(UUID.randomUUID().toString());
		// code ������,ʹ��UUID����
		user.setCode(UUID.randomUUID().toString());
		// ����״̬
		user.setState(0);
		//�������
		user.setPassword(MD5Utils.md5(user.getPassword()));

		UserService service = new UserService();
		boolean flag = service.regist(user);
		//���ؽ��
		if (flag) {
			//���ͼ����ʼ�
			String site="http://localhost:8080/shop/active?code="+user.getCode();
			String emailMsg="�����������Ӽ��������˻�<hr/><a font-size=10 href='"+site+"'>"+site+"</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				// TODO �Զ����ɵ� catch ��
				response.getWriter().println(
						"<script type=\"text/javascript\">alert(\"ע��ʧ�ܣ�\");window.location.href =\"register.jsp\"</script>");
				e.printStackTrace();
			}
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"ע��ɹ������������в��ռ����ʼ�������Ϊ����ת����¼ҳ��...\");window.location.href =\"login.jsp\"</script>");
		}else {
			response.getWriter().println(
					"<script type=\"text/javascript\">alert(\"ע��ʧ���ˣ�\");window.location.href =\"login.jsp\"</script>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		doGet(req, resp);
	}
}
