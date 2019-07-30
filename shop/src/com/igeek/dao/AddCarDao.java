package com.igeek.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.igeek.domain.Product;
import com.igeek.utils.DataSourceUtils;

public class AddCarDao {

	public Product addCar(String pid) {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		try {
			String sql="select * from product where pid = ?";
			return qr.query(sql, new BeanHandler<>(Product.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
