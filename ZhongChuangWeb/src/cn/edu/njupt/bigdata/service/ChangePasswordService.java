package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.dao.UserDao;
import cn.edu.njupt.bigdata.utils.StringUtils;

public class ChangePasswordService {
	public void UserChangePassword(String password) throws SQLException {
		UserDao userDao = new UserDao();
		UserBean userBean = new UserBean();
		userBean.setPassword(StringUtils.getMD5Code(password));
		userDao.updateUser(userBean);
	}
	public void AdminChangePassword(String adminPassword,String adminEmail) throws SQLException {
		AdminDao adminDao = new AdminDao();
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminPassword(StringUtils.getMD5Code(adminPassword));
		adminBean.setAdminEmail(adminEmail);
		adminDao.updatePassword(adminBean);
	}

}
