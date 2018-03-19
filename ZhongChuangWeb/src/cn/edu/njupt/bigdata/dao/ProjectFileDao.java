package cn.edu.njupt.bigdata.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.njupt.bigdata.bean.ProjectFileBean;
import cn.edu.njupt.bigdata.utils.JdbcUtils;

public class ProjectFileDao {
	public boolean addProjectFile (ProjectFileBean projectFileBean) throws SQLException{
		QueryRunner qr =new QueryRunner(JdbcUtils.getDataSource());
		String sql ="insert into projectfile(projectId,projectFile) values (?,?)";
		Object[] params ={projectFileBean.getProjectId(),projectFileBean.getProjectFile()};
		if(qr.update(sql, params) > 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public void deleteProjectFile(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="delete from projectfile where projectId = ?";
		qr.update(sql, id);
	}
	
	public void updateProjectFile(ProjectFileBean projectFileBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="update projectfile set projectFile=? where projectId=?";
		Object[] params ={projectFileBean.getProjectFile(),projectFileBean.getProjectId()};
		qr.update(sql, params);
	}
	
	
	public ProjectFileBean query (String projectFile) throws SQLException{
		QueryRunner qr =new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from projectfile where projectId = ?";
		return(ProjectFileBean) qr.query(sql, projectFile, new BeanHandler(ProjectFileBean.class));
	}

}
