package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.AdminProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectExpenseBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectExpenseDao;

public class QueryProjectService {
	public ProjectBean query(String id) throws SQLException{
		String programName = null;
		String programType = null;
		String author = null;
		String phoneNumber = null;
		String programEmail = null;
		ProjectDao projectDao = new ProjectDao();
		ProjectBean projectBean = projectDao.query(id);
		programName = projectBean.getProjectName();
		programType = projectBean.getProjectType();
		author = projectBean.getProjectUser();
		phoneNumber = projectBean.getProjectMobile();
		programEmail = projectBean.getProjectEmail();
		System.out.println(programName);
		System.out.println(programType);
		System.out.println(author);
		System.out.println(phoneNumber);
		System.out.println(programEmail);
		return projectBean;
	}
	public ProjectBean queryProjectName(String name) throws SQLException{
		String programNo = null;
		String programType = null;
		String author = null;
		String phoneNumber = null;
		String programEmail = null;
		ProjectDao projectDao = new ProjectDao();
		ProjectBean projectBean = projectDao.query(name);
		programNo = projectBean.getProjectId();
		programType = projectBean.getProjectType();
		author = projectBean.getProjectUser();
		phoneNumber = projectBean.getProjectMobile();
		programEmail = projectBean.getProjectEmail();
		return projectBean;
	}
	public AdminProjectBean AdminProjectId(String id) throws SQLException, ClassNotFoundException{
		String programNo = null;
		String programType = null;
		String author = null;
		String phoneNumber = null;
		String programEmail = null;
		String path = null;
		ProjectDao projectDao = new ProjectDao();
		ProjectExpenseDao projectExpenseDao = new ProjectExpenseDao();
		ProjectExpenseBean projectExpenseBean = projectExpenseDao.query(id);
		if(projectExpenseBean != null) {
			path = projectExpenseBean.getProjectBill();
		}
		AdminProjectBean adminProjectBean = projectDao.queryAdmin(id);
		if(adminProjectBean !=null){
		adminProjectBean.setPath(path);
		programNo =adminProjectBean.getProjectId();
		programType = adminProjectBean.getProjectType();
		author = adminProjectBean.getProjectUser();
		phoneNumber = adminProjectBean.getProjectMobile();
		programEmail = adminProjectBean.getProjectEmail();
		path = adminProjectBean.getPath();
		System.out.println(path);		
		}
		System.out.println(adminProjectBean);
		return adminProjectBean;
	}
}
