package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.AdminPageBean;
import cn.edu.njupt.bigdata.bean.AdminProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.service.QueryProjectService;

/**
 * Servlet implementation class AdminQueryPageServlet
 */
@WebServlet("/AdminQueryPageServlet")
public class AdminQueryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//String id = request.getParameter("id");
		//String name = request.getParameter("id");
		try {
			dispatch(request,response);
		} catch (ClassNotFoundException | SQLException e) {
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
	public ArrayList<AdminProjectBean> select(String id) throws ClassNotFoundException, SQLException{
    
    	ArrayList<AdminProjectBean> result=new ArrayList<AdminProjectBean>();
    //	ProjectBean projectBean=new ProjectBean();

    	
    	if(id!=""){
    		QueryProjectService queryProjectService=new QueryProjectService();
    		AdminProjectBean adminProjectBean=queryProjectService.AdminProjectId(id);;
    		result.add(adminProjectBean);		   		
     	}
    	
    
    	return result;
    }
	public Connection connect() throws ClassNotFoundException, SQLException{
    	Connection conn=null; 
	    Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/zhongchuangweb"; 
	    String user="root"; 
		String password="123456"; 
		conn=DriverManager.getConnection(url,user,password); 
		return conn;
	}
	public void close(Statement stat,Connection conn) throws SQLException{
		if(stat!=null){
	    	   stat.close();
	    }
	    if(conn!=null){
	    	   conn.close();
	    }
	}
	public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
	    String id=request.getParameter("id");
	    String crd=request.getParameter("currentRecord");
	    QueryProjectService queryProjectService=new QueryProjectService();
		AdminProjectBean adminProjectBean=queryProjectService.AdminProjectId(id);
	     if(adminProjectBean==null){
	    	 String localPath = request.getContextPath() + "/servlet/admin/ShowAdminPageServlet";
			request.setAttribute("tip", "查询失败无此人<meta http-equiv='refresh' content='3;url="+ localPath + "'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
	        }
	       else{
	    	   ArrayList<AdminProjectBean> result=select(id);
		       	AdminPageBean adminPageBean=new AdminPageBean();
		       	adminPageBean.setTotalRecord(result.size()); 
		       	adminPageBean.setTotalPage(result.size(),adminPageBean.getPageSize());
		       	if(crd!=null)
		           {
		       		int currentRecord=Integer.parseInt(crd);
		       		adminPageBean.setCurrentRecord(currentRecord);
		       		adminPageBean.setCurrentPage(currentRecord,adminPageBean.getPageSize());
		           }
		        List<AdminProjectBean> subResult=null;
		  	     int currentRecord=adminPageBean.getCurrentRecord();
		         if(currentRecord==0){
		         	if(adminPageBean.getTotalRecord()<8){
		         		subResult=(List<AdminProjectBean>) result.subList(0,adminPageBean.getTotalRecord());
		         	}
		         	else{
		         		subResult=(List<AdminProjectBean>) result.subList(0,adminPageBean.getPageSize());
		         	}         
		         }
		         else if(adminPageBean.getCurrentRecord()+adminPageBean.getPageSize()<result.size())
		         {
		               subResult=(List<AdminProjectBean>) result.subList(adminPageBean.getCurrentRecord(),adminPageBean.getCurrentRecord()+adminPageBean.getPageSize());
		         	}
			         else
			         {
			              subResult=(List<AdminProjectBean>) result.subList(adminPageBean.getCurrentRecord(),result.size());
			         }
		         request.setAttribute("adminPageBean", adminPageBean);//分页信息
			     request.setAttribute("subResult", subResult);//每一页的数据
	    	   
	    		request.setAttribute("result", select(id));
	            request.getRequestDispatcher("/WEB-INF/jsp/adminquerypage.jsp").forward(request, response);	
	        }
	    }
	public AdminPageBean setpage(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException{
		String crd=request.getParameter("currentRecord");
		
    	ArrayList<AdminProjectBean> result=select("");
    	AdminPageBean adminPageBean=new AdminPageBean();
    	adminPageBean.setTotalRecord(result.size()); 
    	adminPageBean.setTotalPage(result.size(),adminPageBean.getPageSize());
    	if(crd!=null)
        {
    		int currentRecord=Integer.parseInt(crd);
    		adminPageBean.setCurrentRecord(currentRecord);
    		adminPageBean.setCurrentPage(currentRecord,adminPageBean.getPageSize());
        }
    	return adminPageBean;
	}
	 public void difpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		
			 ArrayList<AdminProjectBean> result=select("");
			 AdminPageBean adminPageBean=new AdminPageBean();
			 adminPageBean=setpage(request,response);
	  	     List<AdminProjectBean> subResult=null;
	  	     int currentRecord=adminPageBean.getCurrentRecord();
	         if(currentRecord==0){
	         	if(adminPageBean.getTotalRecord()<8){
	         		subResult=(List<AdminProjectBean>) result.subList(0,adminPageBean.getTotalRecord());
	         	}
	         	else{
	         		subResult=(List<AdminProjectBean>) result.subList(0,adminPageBean.getPageSize());
	         	}         
	         }
	         else if(adminPageBean.getCurrentRecord()+adminPageBean.getPageSize()<result.size())
	         {
	               subResult=(List<AdminProjectBean>) result.subList(adminPageBean.getCurrentRecord(),adminPageBean.getCurrentRecord()+adminPageBean.getPageSize());
	         	}
		         else
		         {
		              subResult=(List<AdminProjectBean>) result.subList(adminPageBean.getCurrentRecord(),result.size());
		         }
	         request.setAttribute("adminPageBean", adminPageBean);//分页信息
		     request.setAttribute("subResult", subResult);//每一页的数据
		     request.getRequestDispatcher("/WEB-INF/jsp/adminpage.jsp").forward(request, response);
	     }
	 
}
