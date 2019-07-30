package com.igeek.service;

import java.util.List;

import com.igeek.dao.HotAndNewProductDao;
import com.igeek.domain.Product;

public class HotAndNewProductService {
	HotAndNewProductDao dao=new HotAndNewProductDao();
	public List<Product> getHotProductup() {
		
		return dao.getHotProductup();
	}

	public List<Product> getNewProductup() {
		
		return dao.getNewProductup();
	}

	public List<Product> getHotProductdown() {
		// TODO Auto-generated method stub
		return dao.getNewProductdown();
	}

	public List<Product> getNewProductdown() {
		// TODO Auto-generated method stub
		return dao.getNewProductdown();
	}

}
