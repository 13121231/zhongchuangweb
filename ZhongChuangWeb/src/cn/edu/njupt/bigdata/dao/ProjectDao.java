package cn.edu.njupt.bigdata.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.njupt.bigdata.bean.AdminProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.utils.JdbcUtils;

public class ProjectDao {
	public boolean addProject(ProjectBean projectBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into project(projectId, projectName, projectType,userNo,projectUser,projectEmail,projectMobile,projectFile,projectBill,time,fileState,billState,adminState,changeState) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params ={projectBean.getProjectId(),projectBean.getProjectName(),projectBean.getProjectType(),projectBean.getUserNo(),projectBean.getProjectUser(),projectBean.getProjectEmail(),projectBean.getProjectMobile(),projectBean.getProjectFile(),projectBean.getProjectBill()
				           ,projectBean.getTime(),projectBean.getFileState(),projectBean.getBillState(),projectBean.getAdminState(),projectBean.getChangeState()};
		if(qr.update(sql, params) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteProject(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from project where projectId=?";
		qr.update(sql, id);
	}
	
	public boolean delteProgram(String id,String programName) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from project where userNo=? and projectName = ?";
		Object[] params = {id,programName};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void updateProject(ProjectBean projectBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set projectName=?,projectType=?,userNo=?,projectUser=?,projectEmail=?,projectMobile=? ,projectFile=?,projectBill=?,fileState=?,billState=?,adminState=?,changeState=? where projectId=?";
		Object[] params ={projectBean.getProjectName(),projectBean.getProjectType(),projectBean.getUserNo(),projectBean.getProjectUser(),projectBean.getProjectEmail(),projectBean.getProjectMobile(),
				          projectBean.getProjectFile(),projectBean.getProjectBill(),projectBean.getFileState(),projectBean.getBillState(),projectBean.getAdminState(),projectBean.getChangeState(),projectBean.getProjectId()};
		qr.update(sql, params);
	}
	
	public boolean updateProjectFile(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set projectFile = ?,time=? where userNo=? and projectName = ?";
		Object[] params = {projectBean.getProjectFile(),projectBean.getTime(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean updateProjectId(ProjectBean projectBean) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set projectId = ? where userNo=? and projectName = ?";
		Object[] params = {projectBean.getProjectId(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateProjectBill(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set projectBill = ? where userNo=? and projectName = ?";
		Object[] params = {projectBean.getProjectBill(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updatefileState(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set fileState = ?  where userNo = ? and projectName = ?";
		Object[] params = {projectBean.getFileState(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updatebillState(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set billState = ?  where userNo = ? and projectName = ?";
		Object[] params = {projectBean.getBillState(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean updateadminState(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set adminState = ?, changeState=? where userNo = ? and projectName = ?";
		Object[] params = {projectBean.getAdminState(),projectBean.getChangeState(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updatechangeState(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update project set changeState = ?  where userNo = ? and projectName = ?";
		Object[] params = {projectBean.getChangeState(),projectBean.getUserNo(),projectBean.getProjectName()};
		if(qr.update(sql, params)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public ProjectBean query(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project where projectId = ?";
		return (ProjectBean) qr.query(sql, id,  new BeanHandler(ProjectBean.class));
	}
	
	public ProjectBean find(String programName) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project where projectName = ?";
		return (ProjectBean) qr.query(sql, programName,  new BeanHandler(ProjectBean.class));
	}
	
	public AdminProjectBean queryAdmin(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project where projectId = ?";
		return (AdminProjectBean) qr.query(sql, id,  new BeanHandler(AdminProjectBean.class));
	}
	
	public List<ProjectBean> getProjectBeanList(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from project where userNo = ?";
		return (List<ProjectBean>) qr.query(sql,id, new BeanListHandler(ProjectBean.class));
	}
	public List<AdminProjectBean> adminBeanList() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select project.projectId,project.projectName,project.projectType,project.projectUser,project.projectEmail,project.projectEmail,project.projectMobile,projectexpense.projectBill from project, projectexpense where project.projectId=projectexpense.projectId";
		return (List<AdminProjectBean>) qr.query(sql, new BeanListHandler(ProjectBean.class));
	}
	
	public ProjectBean queryProgramName(QueryProgramNameBean queryProgramNameBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project where projectName = ? and userNo = ?";
		Object[] params = {queryProgramNameBean.getProjectName(),queryProgramNameBean.getUserNo()};
		return(ProjectBean) qr.query(sql, params, new BeanHandler(ProjectBean.class));
	}
	
	public List<ProjectBean> getAllProject() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project ";
		return(List<ProjectBean>) qr.query(sql, new BeanListHandler(ProjectBean.class));
	}
	
	public List<ProjectBean> selectUserProject(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from project where userNo = ?";
		return(List<ProjectBean>) qr.query(sql, id, new BeanListHandler(ProjectBean.class));
	}
	
	public void updateExcel(ProjectBean projectBean) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql="update project set projectId=?,projectType=?,projectUser=?,projectEmail=?,projectMobile=? where userNo=? and projectName=?";
		Object[] params={projectBean.getProjectId(),projectBean.getProjectType(),projectBean.getProjectUser(),projectBean.getProjectEmail(),
				projectBean.getProjectMobile(),projectBean.getUserNo(),projectBean.getProjectName()};
		qr.update(sql, params);
		
	}


}
