package com.igeek.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.domain.User;
import com.igeek.utils.DataSourceUtils;

public class UserDao {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	public int regist(User user) {
		// TODO 自动生成的方法存根
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		
		int row = 0;
		try {
			row = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
					user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
					user.getSex(),user.getState(),user.getCode());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return row;
	}

	public Long checkUsername(String username) {
		String sql ="select count(*) from user where username = ?" ;
		Long count = 0L;
		try {
			count = (Long)runner.query(sql, new ScalarHandler(), username);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return count;
	}

	public boolean active(String code) {
		String sql="update user set state = ? where code = ?";
		try {
			return runner.update(sql,1,code)>0?true:false;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean login(User user) {
		String sql ="select count(*) from user where username = ? and password = ? and state = ?" ;
		Long count = 0L;
		try {
			count = (Long)runner.query(sql, new ScalarHandler(), user.getUsername(),user.getPassword(),1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return count>0?true:false;
	}

	public boolean updatePwd(String email, String parameter) throws SQLException {
		String sql="update user set password = ? where email= ? ";
		int n = runner.update(sql, parameter,email);
		return n>0?true:false;
	}

	public Long checkEmail(String email) {
		String sql ="select count(*) from user where email = ?" ;
		Long count = 0L;
		try {
			count = (Long)runner.query(sql, new ScalarHandler(), email);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return count;
	}
}
