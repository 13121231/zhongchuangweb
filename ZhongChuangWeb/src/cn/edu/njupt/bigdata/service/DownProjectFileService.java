package cn.edu.njupt.bigdata.service;

import java.sql.SQLException;

import cn.edu.njupt.bigdata.bean.ProjectFileBean;
import cn.edu.njupt.bigdata.dao.ProjectFileDao;

public class DownProjectFileService {
	
	public ProjectFileBean getProjectFileName(String projectFile) {
		ProjectFileDao projectFileDao = new ProjectFileDao();
		try {
			return projectFileDao.query(projectFile);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
