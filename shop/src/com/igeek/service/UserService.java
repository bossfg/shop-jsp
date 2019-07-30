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
		//�ֶ���Stringת��Date����
		ConvertUtils.register(new Converter() {
			/**
			 * 
			* @Title: convert  
			* @Description: ʵ������ת���� 
			* @param clazz��Ŀ�����������
			* @param value:Ҫת��������
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
		//����dao�ж��Ƿ����
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

		System.out.println("�û�����"+user.getUsername()+"<------->���룺"+user.getPassword());
		UserDao dao=new UserDao();
		return dao.login(user);
	}

	public boolean updatePwd(String email, String parameter) {
		UserDao dao=new UserDao();
		try {
			return dao.updatePwd(email,MD5Utils.md5(parameter));
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean checkEmail(String email) {
		//����dao�ж��Ƿ����
		Long count = 0L;
		UserDao dao=new UserDao();
		count = (long) dao.checkEmail(email);
		return count>0?false:true;
	}


}
