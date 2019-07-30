package com.igeek.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.Product;
import com.igeek.service.ProductService;

public class ProductInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		System.out.println(pid);
		//������Ʒid���Ҹ���Ʒ����
		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		req.setAttribute("product", product);
		//req.setAttribute("cid", pro);
		//System.out.println(product.getCategory().getCid());
		req.setAttribute("currentPage", req.getParameter("currentPage"));
		//�õ����������ƷID��ӵ�cookie��ȥ
		setCookie( req,  resp, pid) ;
	    req.getRequestDispatcher("proIntroduce.jsp").forward(req, resp);
	}
public void setCookie(HttpServletRequest request, HttpServletResponse response,String pid) {
    //ʹ��cookie�������������ʷ��¼
		//1.��cookie�ж�ȡ�Ƿ���������pids��ֵ
		String pids = pid;
		//��ȡ����Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		{
			for(Cookie cookie:cookies)
			{
				//�ж��Ƿ���Pids���cookie
				if("pids".equals(cookie.getName()))
				{
					//����Ϊpids���cookie,���ȡ��洢��ֵ,
					/*ÿ����ԭֵ��ǰ��ƴ����һ�η��ʵ�pid
					ԭ����:1)�����·��ʵķ�����ǰ��.
						����:�����ȡ��cookieֵΪ 1,2,3 ����Ʒ����˳��Ϊ�ȷ��ʵ�3-->2-->1,
						������һ�η�����ƷID��1
						2)������ظ���Ʒ,���Ƚ��ַ������ظ���IDɾ��,�ٽ����ظ��ķ�����ǰ��
						����:�����ȡ��cookieֵΪ 1,2,3
						�ôη��ʵ�pid=2,��ƴ����ɺ�Ӧ����2,1,3 
					 */
					pids = cookie.getValue();//1,2,3
					
					//��ȡ��cookieֵ��,����,���ַ���תΪ����
					String[] strs = pids.split(",");//{1,2,3}
					//������ת��ΪLinkedList���������,�Ƚ�����ת��List����,��ת��LinkedList����
					List<String> arrList = Arrays.asList(strs);
					LinkedList<String> list = new LinkedList<>(arrList);
					if(list.contains(pid))
					{
						list.remove(pid);
					}
					
					//�����ز��ظ���Ҫ�������ʼλ��
					list.addFirst(pid);
					
					StringBuffer sb = new StringBuffer();
					//�ٽ�����תΪString
					for(int i=0;i<list.size()&&i<4;i++)
					{
						sb.append(list.get(i));
						sb.append(",");
					}
					
					pids=sb.substring(0, sb.length()-1);
				}
			}
		}
		//����Cookie,����ƴ�Ӻõ�pidsЯ���ؿͻ���
		Cookie c = new Cookie("pids",pids);
		System.out.println("cookie:"+pids);
		response.addCookie(c);
}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
