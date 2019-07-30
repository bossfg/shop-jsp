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
		//获取浏览历史
		List<Product> historyList = getHistoryFromCookie(request, response);
		request.setAttribute("historyList", historyList);
		System.out.println("历史记录"+historyList.size());
		//根据类别号码显示该类下的商品
		String cid =request.getParameter("cid");
		String page =request.getParameter("page");
		if (cid==null) {
			System.out.println("cid为空");
			cid="1";
		}
		if (page==null) {
				page="1";	
		}else {
			page=String.valueOf((int) Double.parseDouble(page));
		}
		System.out.println("请求的商品类别编号是cid："+cid);
		System.out.println("当前页面编号是page："+page);
		request.setAttribute("cid", cid);
		request.setAttribute("page", page);
		//通过cid获取商品列表
		ProductService service=new ProductService();
		List<Product> products = service.findProductByCid(cid);
		if (products==null) {
			System.out.println("该类别下没有商品！");
			response.getWriter().write("该类别下没有商品！");
		}else {
			request.setAttribute("products", products);
			int totalPage=(int) Math.ceil(products.size()*1.0/8);
			System.out.println("总页数"+totalPage);
			request.setAttribute("totalPage",totalPage );
		}
		request.setAttribute("beginIndex", page==null?0:8*(Integer.parseInt(page)-1));
		System.out.println("起始index"+request.getAttribute("beginIndex"));
		//response.sendRedirect("product.jsp?cid="+cid+"&page="+page);
		request.getRequestDispatcher("product.jsp?cid="+cid+"&page="+page).forward(request, response);
	}

	public List<Product> getHistoryFromCookie(HttpServletRequest request, HttpServletResponse response) {
		// 获取cookie中名字为pids的Cookie值,查询商品集合,放入request域中,返回product_list.jsp页面中展现
		Cookie[] cookies = request.getCookies();
		List<Product> historyList = new ArrayList<Product>();
		if (cookies != null) {
			ProductService service = new ProductService();
			for (Cookie c : cookies) {
				if ("pids".equals(c.getName())) {
					String pids = c.getValue();// 获取字符串1,31,33,34
					String[] pids_arr = pids.split(",");
					for (String pid : pids_arr) {
						// 根据id查找商品
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
