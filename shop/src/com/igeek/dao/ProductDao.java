package com.igeek.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.domain.Category;
import com.igeek.domain.Order;
import com.igeek.domain.OrderItem;
import com.igeek.domain.Product;
import com.igeek.utils.DataSourceUtils;

public class ProductDao {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	
	public List<Category> findAllCategory() throws SQLException {
		String sql = " select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
}
	/**
	* @Title: findHotProducts  
	* @Description:查询热门商品  
	* @return
	* @throws SQLException
	 */
	public List<Product> findHotProducts() throws SQLException {
		String sql = " select * from product where is_hot = ? limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class), 1,0,9);
		
	}
	//获取类别下的商品
	public List<Product> findProductByCid(String cid) throws SQLException {
		String sql = " select * from product where cid=?";
		return runner.query(sql,new BeanListHandler<Product>(Product.class), cid);
	}
	////////自己写的
	public Product findProductById(String pid) throws SQLException {
		String sql = " select * from product where pid = ? ";
		return runner.query(sql, new BeanHandler<Product>(Product.class), pid);
	}
	/**
	 * 
	* @Title: getCount  
	* @Description: 获取所选类别下所有商品的个数 
	* @param cid:类别ID
	* @return
	* @throws SQLException
	 */
	public int getCount(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " select count(*) from product where cid=?";
		Long row = (Long)runner.query(sql, new ScalarHandler(), cid);
		return row.intValue();
	}

	public String findCategoryByCid(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " select cname from category where cid=?";
		return (String) runner.query(sql, new ScalarHandler(), cid);
	}
	public List<Product> findProdutListByCid(String cid, int startIndex, int currentCount) {
		String sql = "select * from product where cid = ? limit ?,?";
		try {
			return runner.query(sql, new BeanListHandler<>(Product.class), cid,startIndex,currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addOrder(Order order) {
		try {
			QueryRunner qr1 = new QueryRunner();
			String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
			System.out.println("sql="+String.format(sql, order.getOid(),order.getOrdertime(),order.getTotal(),
					order.getState(),order.getAddress(),order.getName(),
					order.getTelephone(),order.getUser().getUid()));
			Connection conn = DataSourceUtils.getConnection();
			qr1.update(conn, sql, order.getOid(),order.getOrdertime(),order.getTotal(),
					order.getState(),order.getAddress(),order.getName(),
					order.getTelephone(),order.getUser().getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addOrderItems(Order order) {
		try {
			QueryRunner qr1 = new QueryRunner();
			Connection conn = DataSourceUtils.getConnection();
			for (OrderItem item : order.getOrderItems()) {
				String sql = "insert into orderitem values (?,?,?,?,?)";
				System.out.println("获得oid"+order.getOid());
				System.out.println(String.format(sql, item.getItemid(),item.getCount(),
						item.getSubtotal(),item.getProduct().getPid(),order.getOid()));
				qr1.update(conn, sql, item.getItemid(),item.getCount(),
						item.getSubtotal(),item.getProduct().getPid(),order.getOid());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
