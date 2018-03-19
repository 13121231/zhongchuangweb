package cn.edu.njupt.bigdata.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectExpenseBean;
import cn.edu.njupt.bigdata.utils.JdbcUtils;

public class ProjectExpenseDao {
	public boolean addProjectExpense (ProjectExpenseBean projectExpenseBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into projectexpense(projectId, projectBill) values(?,?)";
		Object[] params ={projectExpenseBean.getProjectId(),projectExpenseBean.getProjectBill()};
		if(qr.update(sql, params) != 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void deleteProjectExpense(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="delete from projectexpense where projectId = ?";
		qr.update(sql, id);
	}
	
	public void updateProjectExpense(ProjectExpenseBean projectExpenseBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="update projectexpense set projectBill = ? where projectId = ?";
		Object[] params ={projectExpenseBean.getProjectBill(),projectExpenseBean.getProjectId()};
		qr.update(sql, params);
	}
	
	public ProjectExpenseBean query(String id ) {
		QueryRunner qr =new  QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from projectexpense where projectId = ?";
		try {
			return(ProjectExpenseBean) qr.query(sql, id, new BeanHandler(ProjectExpenseBean.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
