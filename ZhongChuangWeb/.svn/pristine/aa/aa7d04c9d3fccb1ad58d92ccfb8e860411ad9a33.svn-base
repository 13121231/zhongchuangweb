 	package cn.edu.njupt.bigdata.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.utils.JdbcUtils;

public class AdminDao {
	

	public void addAdmin(AdminBean adminbean) throws SQLException {
		QueryRunner qr =new  QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into admin(adminId, adminName, adminPassword,adminEmail) values(?, ?, ?,?)";
		Object[] params = {adminbean.getAdminId(), adminbean.getAdminName(), adminbean.getAdminPassword(),adminbean.getAdminEmail()};
		qr.update(sql, params);
	}


	public void updatePassword(AdminBean adminbean) throws SQLException {
		QueryRunner qr =new  QueryRunner(JdbcUtils.getDataSource());
		String sql ="update admin set adminPassword=? ,adminEmail=? where adminName = ?";
		Object[] params = {adminbean.getAdminPassword(),adminbean.getAdminEmail(), adminbean.getAdminName()};
		qr.update(sql, params);
	}
	
	public AdminBean query(String adminName) throws SQLException {
		QueryRunner qr =new  QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from admin where adminName = ?";
		return (AdminBean) qr.query(sql, adminName, new BeanHandler(AdminBean.class));
	}
	
}	
	


