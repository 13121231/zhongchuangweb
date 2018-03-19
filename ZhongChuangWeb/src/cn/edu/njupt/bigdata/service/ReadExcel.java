package cn.edu.njupt.bigdata.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import jxl.Cell;  
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  

public class ReadExcel {
	public  void readfile(File file) throws BiffException, IOException, SQLException{
		ArrayList<ProjectBean> excelDataList=new ArrayList<ProjectBean>();
		Workbook rwb=null;
		try {
			InputStream File=new FileInputStream(file);
			rwb = Workbook.getWorkbook(File);
			Sheet rs = rwb.getSheet(0);
			 int rsRows=rs.getRows();
			 int rsClos=rs.getColumns();
			 System.out.println("总行："+rsRows);
			 System.out.println("总列："+rsClos);
			 for(int i=1;i<rsRows;i++){
					    String cell2=rs.getCell(0, i).getContents()+"";//取得第一列，第二行数据
					    String cell3=rs.getCell(1, i).getContents()+"";//取得第二列，第二行数据。以此类推
					    String cell4=rs.getCell(2, i).getContents()+"";
					    String cell5=rs.getCell(3, i).getContents()+"";
					    String cell6=rs.getCell(4, i).getContents()+"";
					    String cell7=rs.getCell(5, i).getContents()+"";
					    String cell8=rs.getCell(6, i).getContents()+"";
					   /* String cell9=rs.getCell(7, i).getContents()+"";*/
					    /*String cell10=rs.getCell(8, i).getContents()+"";
					    String cell11=rs.getCell(9, i).getContents()+"";
					    String cell12=rs.getCell(10,i).getContents()+"";
					    String cell13=rs.getCell(10,i).getContents()+"";
					    String cell14=rs.getCell(10,i).getContents()+"";
					    String cell15=rs.getCell(10,i).getContents()+"";*/
					    QueryProgramNameBean queryProgramNameBean = new QueryProgramNameBean();
					    queryProgramNameBean.setProjectName(cell3);
					    queryProgramNameBean.setUserNo(cell5);
					    ProjectDao projectDao = new ProjectDao();
					    if( projectDao.queryProgramName(queryProgramNameBean)!=null){
					    	ProjectBean projectBean = new ProjectBean();
					        try {
					         projectBean.setProjectId(cell2);
					         projectBean.setProjectName(cell3);
					         projectBean.setProjectType(cell4);
					         projectBean.setUserNo(cell5);
					         projectBean.setProjectUser(cell6);
					         projectBean.setProjectEmail(cell7);
					         projectBean.setProjectMobile(cell8);
					         /*projectBean.setProjectFile(cell10);
					         projectBean.setProjectBill(cell11);
					         projectBean.setFileState(Integer.parseInt(cell12));
					         projectBean.setBillState(Integer.parseInt(cell13));
					         projectBean.setAdminState(Integer.parseInt(cell14));
					         projectBean.setChangeState(Integer.parseInt(cell15));*/
					         projectDao.updateProjectId(projectBean);
					        } catch (Exception e) {
					         e.printStackTrace();
					         System.out.println("数字转换异常");
					        }
					       }else{
					    	   ProjectBean projectBean = new ProjectBean(); 
					    	   projectBean.setProjectId(cell2);
						       projectBean.setProjectName(cell3);
						       projectBean.setProjectType(cell4);
						       projectBean.setUserNo(cell5);
						       projectBean.setProjectUser(cell6);
						       projectBean.setProjectEmail(cell7);
						       projectBean.setProjectMobile(cell8);
						       projectBean.setProjectFile(null);
						       projectBean.setProjectBill(null);
						       projectBean.setAdminState(0);
						       projectBean.setBillState(0);
						       projectBean.setChangeState(0);
						       projectBean.setFileState(0);
						       projectDao.addProject(projectBean);
					       }
					       }
					    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//读取文件
		
		
		
	}
	

}
