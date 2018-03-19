package cn.edu.njupt.bigdata.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.AdminPageBean;
import cn.edu.njupt.bigdata.bean.AdminProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.service.QueryUserProjectService;

/**
 * Servlet implementation class ShowAdminIndexServlet
 */
@WebServlet("/ShowAdminIndexServlet")
public class ShowAdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdminIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjectDao projectDao = new ProjectDao();
		String cp=request.getParameter("currentPage");
		String ps=request.getParameter("pageSize");
		if(cp == null){
			cp="0";
		}
		if(ps == null){
			ps="5";
		}
		int currentPage=Integer.parseInt(cp);
		int pageSize=Integer.parseInt(ps);
		try { 
			List<ProjectBean> projectAllList = projectDao.getAllProject();
			request.setAttribute("projectAllList",projectAllList);
			AdminPageBean adminPageBean=new AdminPageBean();
			adminPageBean.setPageSize(pageSize);
			adminPageBean.setTotalRecord(projectAllList.size()); 
	    	adminPageBean.setTotalPage(projectAllList.size(),adminPageBean.getPageSize());
	    	int currentRecord=0;
	    	currentRecord=currentPage*adminPageBean.getPageSize();
	    	adminPageBean.setCurrentRecord(currentRecord);
	    	adminPageBean.setCurrentPage(currentRecord,adminPageBean.getPageSize());
	    	adminPageBean.setnext(adminPageBean.getCurrentRecord(), adminPageBean.getPageSize());
	        adminPageBean.setlast(adminPageBean.getCurrentRecord(), adminPageBean.getPageSize());
	        adminPageBean.setnextPage(currentPage);
	        adminPageBean.setlastPage(currentPage);
	        List<ProjectBean> subResult=null;
	        if(currentRecord==0){
	         	if(adminPageBean.getTotalRecord()<adminPageBean.getPageSize()){
	         		subResult=(List<ProjectBean>) projectAllList.subList(0,adminPageBean.getTotalRecord());
	         	}
	         	else{
	         		subResult=(List<ProjectBean>) projectAllList.subList(0,adminPageBean.getPageSize());
	         	}         
	         }
	         else if(adminPageBean.getCurrentRecord()+adminPageBean.getPageSize()<projectAllList.size())
	         {
	               subResult=(List<ProjectBean>) projectAllList.subList(adminPageBean.getCurrentRecord(),adminPageBean.getCurrentRecord()+adminPageBean.getPageSize());
	         	}
		         else
		         {
		              subResult=(List<ProjectBean>) projectAllList.subList(adminPageBean.getCurrentRecord(),projectAllList.size());
		         }
	         request.setAttribute("totalPage", adminPageBean.getTotalPage());//分页信息     
	         request.setAttribute("adminPageBean", adminPageBean);//分页信息     
	         request.setAttribute("subResult", subResult);//每一页的数据
		     request.getRequestDispatcher("/WEB-INF/jsp/adminIndex.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
