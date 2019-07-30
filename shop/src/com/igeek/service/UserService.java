package com.igeek.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.igeek.dao.UserDao;
import com.igeek.domain.User;
import com.igeek.utils.MD5Utils;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class UserService {

	public boolean regist(User user) {
		//手动将String转成Date类型
		ConvertUtils.register(new Converter() {
			/**
			 * 
			* @Title: convert  
			* @Description: 实现类型转换啊 
			* @param clazz：目标的数据类型
			* @param value:要转换的数据
			* @return
			* @see org.apache.commons.beanutils.Converter#convert(java.lang.Class, java.lang.Object)
			 */
			public Object convert(Class clazz, Object value) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date desc = null;
				try {
					desc = sf.parse((String)value);
				} catch (ParseException | java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return desc;
			}
		}, Date.class);
		//Object convert = ConvertUtils.convert(user.getBirthday(),Date.class);
		
		int row = 0;
		UserDao dao=new UserDao();
		row = dao.regist(user);
		return row>0?true:false;
	}

	public boolean checkUsername(String username) {
		//调用dao判断是否存在
				Long count = 0L;
				UserDao dao=new UserDao();
				count = (long) dao.checkUsername(username);
				return count>0?true:false;
	}

	public boolean active(String code) {
		UserDao dao=new UserDao();
		return dao.active(code);
	}

	public boolean login(User user) {
		if (user==null||user.getPassword()==null) {
			return false;
		}
		
		if (user.getPassword().length()!=32) {
			user.setPassword(MD5Utils.md5(user.getPassword()));
		}

		System.out.println("用户名："+user.getUsername()+"<------->密码："+user.getPassword());
		UserDao dao=new UserDao();
		return dao.login(user);
	}

	public boolean updatePwd(String email, String parameter) {
		UserDao dao=new UserDao();
		try {
			return dao.updatePwd(email,MD5Utils.md5(parameter));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean checkEmail(String email) {
		//调用dao判断是否存在
		Long count = 0L;
		UserDao dao=new UserDao();
		count = (long) dao.checkEmail(email);
		return count>0?false:true;
	}


}
