package cn.edu.njupt.bigdata.service;

import java.io.File;
import java.sql.SQLException;

import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectExpenseDao;
import cn.edu.njupt.bigdata.dao.ProjectFileDao;

public class AdminDeleteService {
	public void adminDelete(String id) throws SQLException {
		ProjectDao projectDao = new ProjectDao();
		if(projectDao.query(id) != null) {
			ProjectFileDao projectFileDao = new ProjectFileDao();
			String fileFolder = projectFileDao.query(id).getProjectFile();
			System.out.println(fileFolder.substring(0, fileFolder.lastIndexOf("/") - 1));
			File file = new File(fileFolder.substring(0, fileFolder.lastIndexOf("/")));
			if(this.deleteFile(file)) {
				ProjectExpenseDao projectExpenseDao = new ProjectExpenseDao();
				String expenseFolder = projectExpenseDao.query(id).getProjectBill();
				file = new File(expenseFolder);
				if(this.deleteFile(file)) {
					projectDao.deleteProject(id);
				}
			}
		}
	}
	
	public boolean deleteFile(File file) {
		if(file.isDirectory()) {
			String[] fileNames =  file.list();
			for(int i=0; i < fileNames.length; i++) {
				deleteFile(new File(file, fileNames[i]));
			}
		} 	
		return file.delete();
	}
}
