package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectExpenseBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectExpenseDao;

public class AddProjectExpenseService {
	public boolean add(ProjectExpenseBean projectExpenseBean) throws SQLException{
		ProjectExpenseDao projectExpenseDao = new ProjectExpenseDao();
		return projectExpenseDao.addProjectExpense(projectExpenseBean);
	}
	
	public boolean addProject(ProjectBean projectBean) throws SQLException{
		ProjectDao projectDao = new ProjectDao();
		return projectDao.addProject(projectBean);
		
	}

}
