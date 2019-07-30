package com.igeek.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.igeek.domain.Order;
import com.igeek.utils.DataSourceUtils;

public class ConfiromOrderDao {

	public int confirom(Order order) {
		try {
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="update orders set address=?,name=?,telephone=? where oid=?";
			System.out.println("»∑»œoid=" +order.getOid());
			System.out.println(String.format(sql, order.getAddress(),order.getName(),order.getTelephone(),order.getOid()));
			System.out.println();
			return qr.update(sql, order.getAddress(),order.getName(),order.getTelephone(),order.getOid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
