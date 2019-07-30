package com.igeek.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.PageBean;
import com.igeek.domain.Product;
import com.igeek.service.ProductService;

/**
 * Servlet implementation class FilterServlet
 */
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  currentPage= request.getParameter("currentPage");
		if (currentPage==null) {
			currentPage="1";
		}
		String cid = request.getParameter("cid");
		request.setAttribute("cid", cid);
		ProductService service=new ProductService();
		PageBean<Product> pageBean = service.findProductListByCid(cid,Integer.parseInt( currentPage), 9);
		System.out.println(pageBean.getTotalCount());
		request.getSession().setAttribute("pageBean", pageBean);
		//request.getSession().setAttribute("list", pageBean.getList());
		request.getRequestDispatcher("filter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
