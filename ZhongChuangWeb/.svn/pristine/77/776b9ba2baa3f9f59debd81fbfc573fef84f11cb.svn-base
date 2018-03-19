package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.dao.UserDao;
import cn.edu.njupt.bigdata.utils.StringUtils;

public class LoginService {
	
	
	public boolean login(UserBean userBean){
		UserDao userDao = new UserDao();
		if (userDao.find(userBean.getUserNo())==null){
			throw new RuntimeException("用户不存在！");
		}else{
			if (userDao.find(userBean.getUserNo()).getPassword().equals(StringUtils.getMD5Code(userBean.getPassword()))){
    	        return true;	 
    	    }else{
        	    return false;	
    	    }
        }	
	}
	
	public boolean adminlogin(AdminBean adminBean) throws SQLException {
		AdminDao adminDao = new AdminDao();
		if (!adminBean.getAdminName().equals("admin")){
			throw new RuntimeException("管理员不存在！");
		}else{
			if (adminDao.query(adminBean.getAdminName()).getAdminPassword().equals(StringUtils.getMD5Code(adminBean.getAdminPassword()))){
				return true;
			}else{
				return false;
			}
	
		}
	}
	
   
}

	
	

