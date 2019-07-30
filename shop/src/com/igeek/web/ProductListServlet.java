package com.igeek.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.Product;
import com.igeek.service.ProductService;

/**
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�����ʷ
		List<Product> historyList = getHistoryFromCookie(request, response);
		request.setAttribute("historyList", historyList);
		System.out.println("��ʷ��¼"+historyList.size());
		//������������ʾ�����µ���Ʒ
		String cid =request.getParameter("cid");
		String page =request.getParameter("page");
		if (cid==null) {
			System.out.println("cidΪ��");
			cid="1";
		}
		if (page==null) {
				page="1";	
		}else {
			page=String.valueOf((int) Double.parseDouble(page));
		}
		System.out.println("�������Ʒ�������cid��"+cid);
		System.out.println("��ǰҳ������page��"+page);
		request.setAttribute("cid", cid);
		request.setAttribute("page", page);
		//ͨ��cid��ȡ��Ʒ�б�
		ProductService service=new ProductService();
		List<Product> products = service.findProductByCid(cid);
		if (products==null) {
			System.out.println("�������û����Ʒ��");
			response.getWriter().write("�������û����Ʒ��");
		}else {
			request.setAttribute("products", products);
			int totalPage=(int) Math.ceil(products.size()*1.0/8);
			System.out.println("��ҳ��"+totalPage);
			request.setAttribute("totalPage",totalPage );
		}
		request.setAttribute("beginIndex", page==null?0:8*(Integer.parseInt(page)-1));
		System.out.println("��ʼindex"+request.getAttribute("beginIndex"));
		//response.sendRedirect("product.jsp?cid="+cid+"&page="+page);
		request.getRequestDispatcher("product.jsp?cid="+cid+"&page="+page).forward(request, response);
	}

	public List<Product> getHistoryFromCookie(HttpServletRequest request, HttpServletResponse response) {
		// ��ȡcookie������Ϊpids��Cookieֵ,��ѯ��Ʒ����,����request����,����product_list.jspҳ����չ��
		Cookie[] cookies = request.getCookies();
		List<Product> historyList = new ArrayList<Product>();
		if (cookies != null) {
			ProductService service = new ProductService();
			for (Cookie c : cookies) {
				if ("pids".equals(c.getName())) {
					String pids = c.getValue();// ��ȡ�ַ���1,31,33,34
					String[] pids_arr = pids.split(",");
					for (String pid : pids_arr) {
						// ����id������Ʒ
						Product product = service.findProductByPid(pid);
						historyList.add(product);
					}
				}
			}
		}
		return historyList;
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
