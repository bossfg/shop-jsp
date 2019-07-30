package com.igeek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.domain.Car;
import com.igeek.domain.CarItem;
import com.igeek.domain.Product;
import com.igeek.service.AddCarService;

/**
 * Servlet implementation class OrderServlet
 */
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String buyNum=request.getParameter("buyNum");
		
		Product product=new Product();
		AddCarService service=new AddCarService();
		product=service.getProductById(pid);
		int num=0;
		if(buyNum!=null){
			if((num=Integer.parseInt(buyNum))<=0){
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		CarItem item=new CarItem();
		item.setProduct(product);
		item.setBuyNum(num);
		double subtotal=product.getShop_price()*num;
		item.setSubTotal(subtotal);
		HttpSession session=request.getSession();
		Car car=(Car) session.getAttribute("car");
		if(car!=null){
			if(car.getCarItems().containsKey(product.getPid())){
				CarItem item1=car.getCarItems().get(product.getPid());
				item1.setBuyNum(item1.getBuyNum()+num);
				car.getCarItems().put(product.getPid(), item1);
				item1.setSubTotal(item1.getSubTotal()+subtotal);
				car.setTotal(car.getTotal()+subtotal);
			}
			else{
				car.getCarItems().put(product.getPid(),item);
				car.setTotal(car.getTotal()+subtotal);
			}
			request.getSession().setAttribute("totalNum", car.getCarItems().size());
		}else{
			car=new Car();
			car.getCarItems().put(product.getPid(),item);
			car.setTotal(car.getTotal()+subtotal);
			request.getSession().setAttribute("totalNum", 1);
		}
		session.setAttribute("car",car);
		response.sendRedirect(request.getContextPath()+"/car.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
