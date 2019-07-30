package com.igeek.service;

import com.igeek.dao.ConfiromOrderDao;
import com.igeek.domain.Order;

public class ConfiromOrderService {

	public boolean confirom(Order order) {
		ConfiromOrderDao dao=new ConfiromOrderDao();
		return dao.confirom(order)>0?true:false;
			
	}

}
