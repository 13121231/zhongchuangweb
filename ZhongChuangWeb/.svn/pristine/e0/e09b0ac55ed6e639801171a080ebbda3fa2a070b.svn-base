package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.UserDao;

public class RegisterService {

	private UserBean userBean = null;
	
	public boolean register() {
		UserDao userdao = new UserDao();
		try {
			if(userdao.find(this.userBean.getUserNo()) == null) {
				if(userdao.addUser(this.userBean)) {
					return true;
				} else {
					return false;
				}
			} else {
				throw new RuntimeException("该学号已经被注册了");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setUserBean(UserBean userBean) {
		if(userBean == null) {
			userBean = new UserBean();
		}
		this.userBean = userBean;
	}
}
