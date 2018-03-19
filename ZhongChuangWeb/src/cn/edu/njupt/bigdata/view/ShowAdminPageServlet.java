package cn.edu.njupt.bigdata.view;

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
import cn.edu.njupt.bigdata.service.AdminDeleteService;
import cn.edu.njupt.bigdata.service.AdminService;
import cn.edu.njupt.bigdata.service.QueryProjectService;

/**
 * Servlet implementation class ShowAdminPageServlet
 */
@WebServlet("/ShowAdminPageServlet")
public class ShowAdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	// TODO Auto-generated method stub
		AdminService adminService = new AdminService();
		List<ProjectBean> projectList =  adminService.getAllList();
		request.setAttribute("projectList", projectList);*/
		String deleteFlag=request.getParameter("deleteFlag");
		//int deleteFlag=Integer.parseInt(deleteFlag);
		try {
			if(deleteFlag == null ){
			difpage(request,response);
			}else{
			delete(request,response);
			}
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
	public AdminPageBean setpage(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException{
		String crd=request.getParameter("currentRecord");
    	ArrayList<AdminProjectBean> result=select("","");
    	AdminPageBean adminPageBean=new AdminPageBean();
    	adminPageBean.setTotalRecord(result.size()); 
    	adminPageBean.setTotalPage(result.size(),adminPageBean.getPageSize());
    	if(crd!=null)
        {
    		int currentRecord=Integer.parseInt(crd);
    		adminPageBean.setCurrentRecord(currentRecord);
    		adminPageBean.setCurrentPage(currentRecord,adminPageBean.getPageSize());
    		adminPageBean.setnext(adminPageBean.getCurrentRecord(), adminPageBean.getPageSize());
        	adminPageBean.setlast(adminPageBean.getCurrentRecord(), adminPageBean.getPageSize());
        }
    	
    	return adminPageBean;
	}
	 public void difpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		 ArrayList<AdminProjectBean> result=select("","");
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
 
	 public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		 
		 String programNo=request.getParameter("programNo");
		 System.out.println(programNo);
		 AdminDeleteService adminDeleteService = new AdminDeleteService();
		 adminDeleteService.adminDelete(programNo);		
		 difpage(request,response);
	 }
	 
	public ArrayList<AdminProjectBean> select(String id,String name) throws ClassNotFoundException, SQLException{
    	Connection conn=null;
    	Statement stat=null;
	    ResultSet rs=null;
	    conn=connect();
	    stat=conn.createStatement();
    	ArrayList<AdminProjectBean> result=new ArrayList<AdminProjectBean>();
    	if(id==""&&name==""){
    	     rs=stat.executeQuery("select * from project"); 
    	} 	
    	while(rs.next())
        {
    		ProjectBean st=new ProjectBean();
    		st.setProjectId(rs.getString("projectid"));
    		QueryProjectService queryProjectService=new QueryProjectService();
    		AdminProjectBean adminProjectBean=queryProjectService.AdminProjectId(rs.getString("projectid"));
//    		rs=stat.executeQuery("select * from project where projectid ="+rs.getString("projectid"));
			result.add(adminProjectBean);	
        }
	    if(rs!=null){
	    	  rs.close();
	       }
	    close(stat,conn);
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
	//关闭数据库资源
	public void close(Statement stat,Connection conn) throws SQLException{
		if(stat!=null){
	    	   stat.close();
	    }
	    if(conn!=null){
	    	   conn.close();
	    }
	}
}
