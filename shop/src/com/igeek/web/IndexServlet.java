package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.Category;
import com.igeek.domain.Product;
import com.igeek.service.HotAndNewProductService;
import com.igeek.service.ProductService;
import com.igeek.utils.MD5Utils;

/**
 * Servlet implementation class CategoryServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		// 查找所有类别
		List<Category> categoryList = service.findCategoryList();
		request.getServletContext().setAttribute("categoryList", categoryList);
		System.out.println(categoryList.size() + "--------------------");

		// 获取热门商品
		HotAndNewProductService service2=new HotAndNewProductService();
		List<Product>hot_productup=service2.getHotProductup();
		List<Product>new_productup=service2.getNewProductup();
		request.setAttribute("hot_productup", hot_productup);
		request.setAttribute("new_productup", new_productup);
		List<Product>hot_productdown=service2.getHotProductdown();
		List<Product>new_productdown=service2.getNewProductdown();
		request.setAttribute("hot_productdown", hot_productdown);
		request.setAttribute("new_productdown", new_productdown);

		//
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
