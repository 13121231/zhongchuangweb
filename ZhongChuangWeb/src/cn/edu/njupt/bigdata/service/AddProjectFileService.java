package cn.edu.njupt.bigdata.service;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectFileBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectFileDao;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;


public class AddProjectFileService {
	public boolean add(ProjectFileBean projectFileBean) throws SQLException{
		ProjectFileDao projectFileDao = new ProjectFileDao();
		if(projectFileDao.addProjectFile(projectFileBean)){
			return true;
		}else{
			return false;
		}
	}
	public boolean addProject(ProjectBean projectBean) throws SQLException{
		ProjectDao projectDao = new ProjectDao();
		return projectDao.addProject(projectBean);
	}
	
}


