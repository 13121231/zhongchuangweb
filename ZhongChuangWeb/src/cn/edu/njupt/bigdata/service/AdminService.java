package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njupt.bigdata.bean.AdminProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;

public class AdminService {
	
	public List<ProjectBean> getAllList(String id) {
		ProjectDao projectDao = new ProjectDao();
		try {
			List<ProjectBean> projectList = projectDao.getProjectBeanList(id);
			return projectList;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	
}
