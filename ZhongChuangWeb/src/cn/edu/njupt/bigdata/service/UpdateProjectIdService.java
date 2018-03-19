package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;

public class UpdateProjectIdService {
	public boolean updateProjectId(ProjectBean projectBean) throws SQLException {
		ProjectDao projectDao = new ProjectDao();
		if(projectDao.updateProjectId(projectBean)) {
			return true;
		} else{
			return false;
		}
	}

}
