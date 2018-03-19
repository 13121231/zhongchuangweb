package cn.edu.njupt.bigdata.service;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.UserDao;

public class QueryUserService {
	public String query(String userId){
		String userName = null;
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.find(userId);
		return userBean.getUserName();
	}

}
