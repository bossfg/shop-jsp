package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.domain.Product;
import com.igeek.utils.DataSourceUtils;

public class HotAndNewProductDao {
	QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
	String sql="";
	public List<Product> getHotProductup() {
		sql="select * from product where is_hot=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<>(Product.class), 1,0,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getNewProductup() {
		sql="select * from product order by pdate desc limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<>(Product.class), 0,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getHotProductdown() {
		sql="select * from product where is_hot=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<>(Product.class), 1,3,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Product> getNewProductdown() {
		sql="select * from product order by pdate desc limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<>(Product.class), 3,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
