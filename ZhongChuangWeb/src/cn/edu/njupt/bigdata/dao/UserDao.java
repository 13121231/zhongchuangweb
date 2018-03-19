package cn.edu.njupt.bigdata.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.utils.JdbcUtils;

public class UserDao {

	public boolean addUser(UserBean userBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into user(userNo, userName, password) values(?,?,?)";
		Object[] params = {userBean.getUserNo(), userBean.getUserName(), userBean.getPassword()};
		int num = qr.update(sql, params);
		if(num > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public UserBean find(String userNo) {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from user where userNo = ?";
		try {
			return (UserBean) qr.query(JdbcUtils.getConnection(), sql, userNo, new BeanHandler(UserBean.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release();
		}
	}
	
	public void deleteUser(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from user where userNo=?";
		qr.update(sql, id);
	}
	
	public void updateUser(UserBean userBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update user set userName = ?,password = ? where userNo=?";
		Object[] params ={userBean.getUserName(),userBean.getPassword(),userBean.getUserNo()};
		qr.update(sql, params);
	}
}
