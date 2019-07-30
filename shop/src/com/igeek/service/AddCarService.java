package com.igeek.service;

import com.igeek.dao.AddCarDao;
import com.igeek.domain.Product;

public class AddCarService {

	public Product getProductById(String pid) {
		AddCarDao dao=new AddCarDao();
		return dao.addCar(pid);
	}

}
