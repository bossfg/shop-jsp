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
	
	////////�Լ�д��
	public PageBean<Product> findProductListByCid(String cid,int currentPage,int currentCount) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//��ǰҳ��
		//int currentPage = 1;
		pageBean.setCurrentPage(currentPage);
		//��ǰҳ��ʾ����
		//int currentCount = 12;
		pageBean.setCurrentCount(currentCount);
		//��ȡ������
		int totalCount = 0;
        ProductDao dao = new ProductDao();
		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		//��ҳ��
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		int start = (currentPage-1)*currentCount;
		//��ҳ��Ʒ������Ĭ���ǲ��ҵ�һҳ����Ʒ�б����ݷ�ҳ���ƣ���Ҫ�����ʼ������һҳ�е�����
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
				System.out.println("�ع�");
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
