package cn.edu.njupt.bigdata.test;

import java.sql.SQLException;

import org.junit.Test;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectFileBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectFileDao;

public class DaoJunit {
	ProjectDao pd = null;
	ProjectFileDao pfd = null;
	AdminDao ad = null;
	
	@Test
	public void testQueryAdminDao() throws SQLException {
		this.ad = new AdminDao();
		AdminBean adminBean = this.ad.query("admin");
		System.out.println(adminBean.getAdminPassword());
	}
	
	@Test
	public void testAddProjectDao() throws SQLException {
		ProjectBean projectBean = new ProjectBean();
		projectBean.setProjectId("ZCB021");
		projectBean.setProjectType("B");
		projectBean.setProjectName("城市定向运动系统app");
		projectBean.setProjectUser("吴道亮");
		projectBean.setProjectMobile("15062200118");
		projectBean.setProjectEmail("kid19911010@163.com");
		this.pd = new ProjectDao();
		if(this.pd.addProject(projectBean)) {
			System.out.println("success");
		} else {
			System.out.println("error");
		}
	}
	
	@Test
	public void testAddProjectFileDao() throws SQLException {
		String projectId = "ZCB021";
		this.pd = new ProjectDao();
		this.pfd = new ProjectFileDao();
		ProjectFileBean projectFileBean = new ProjectFileBean();
		if(this.pd.query(projectId) != null) {
			projectFileBean.setProjectId(projectId);
			projectFileBean.setProjectFile("城市定向运动系统app.doc");
			this.pfd.addProjectFile(projectFileBean);
		} else {
			System.out.println("项目编号不存在");
		}
		projectId = "ZCB020";
		if(this.pd.query(projectId) != null) {
			projectFileBean.setProjectId(projectId);
			projectFileBean.setProjectFile("3D打印机.doc");
			pfd.addProjectFile(projectFileBean);
		} else {
			System.out.println("项目编号不存在");
		}
	}
}
