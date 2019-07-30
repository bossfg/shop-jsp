package com.igeek.service;

import java.sql.SQLException;
import java.util.List;

import com.igeek.dao.ProductDao;
import com.igeek.domain.Category;
import com.igeek.domain.Order;
import com.igeek.domain.PageBean;
import com.igeek.domain.Product;
import com.igeek.utils.DataSourceUtils;

public class ProductService {
	public List<Category> findCategoryList() {
		List<Category> categoryList = null;
		ProductDao dao=new ProductDao();
		try {
			categoryList = dao.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(categoryList.size());
		return categoryList;
}
	public List<Product> findHotProductList() {
		ProductDao dao=new ProductDao();
		List<Product> hotProductList = null;
		try {
			hotProductList = dao.findHotProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotProductList;
}
	public List<Product> findProductByCid(String cid) {
		ProductDao dao=new ProductDao();
		List<Product> productList = null;
		try {
			productList = dao.findProductByCid(cid);
			String cname=dao.findCategoryByCid(cid);
			Category category=new Category();
			category.setCid(cid);
			category.setCname(cname);
			for (int i = 0; i < productList.size(); i++) {
				productList.get(i).setCategory(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	////////自己写的
	public PageBean<Product> findProductListByCid(String cid,int currentPage,int currentCount) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//当前页数
		//int currentPage = 1;
		pageBean.setCurrentPage(currentPage);
		//当前页显示条数
		//int currentCount = 12;
		pageBean.setCurrentCount(currentCount);
		//获取总条数
		int totalCount = 0;
        ProductDao dao = new ProductDao();
		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		int start = (currentPage-1)*currentCount;
		//当页商品，并且默认是查找第一页的商品列表，根据分页机制，需要算出起始条数和一页中的数量
		List<Product> list = null;
		list = dao.findProdutListByCid(cid,start,currentCount);
		pageBean.setList(list);
		return pageBean;
	}
	public void submitOrder(Order order) {
		try {
			DataSourceUtils.startTransaction();
			ProductDao dao = new ProductDao();
			dao.addOrder(order);
			dao.addOrderItems(order);
		} catch (Exception e) {
			try {
				DataSourceUtils.rollback();
				System.out.println("回滚");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public Product findProductByPid(String pid) {
		Product product = null;
		ProductDao dao = new ProductDao();
				try {
					product = dao.findProductById(pid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return product;
	}

}
