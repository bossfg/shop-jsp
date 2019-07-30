package com.igeek.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.domain.Car;
import com.igeek.domain.CarItem;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		HttpSession session=request.getSession();
		Car car=(Car) session.getAttribute("car");
		if(pid.equals("deleteAll")){
			if(car==null){
				;
			}else{
				session.removeAttribute("car");
				session.setAttribute("totalNum", 0);
			}
		}else{
			Map<String, CarItem> items = car.getCarItems();
			Iterator<String> it = items.keySet().iterator();
			while(it.hasNext()){
				String key=it.next();
				if(key.equals(pid)){
					double subtotal=items.get(key).getSubTotal();
					car.setTotal(car.getTotal()-subtotal);
					items.remove(key);
					it = items.keySet().iterator();
				}
			}
			session.setAttribute("totalNum", car.getCarItems().size());
			session.setAttribute("car", car);
		}
		
		request.getRequestDispatcher("/car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
