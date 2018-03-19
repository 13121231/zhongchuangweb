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
/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
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
		
		
	try {
			 difpage(request,response);
		//     dispatch(request,response);
			//difpage(request,response);
		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  //  request.getRequestDispatcher("/WEB-INF/jsp/adminpage.jsp").forward(request, response);

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String method1=request.getParameter("method1");
		//int method = Integer.getInteger(method1);
		//System.out.println(method1);
		doGet(request, response);
	}
	public ArrayList<ProjectBean> select(String id,String name) throws ClassNotFoundException, SQLException{
    	Connection conn=null;
    	Statement stat=null;
	    ResultSet rs=null;
	    conn=connect();
		stat=conn.createStatement();
    	ArrayList<ProjectBean> result=new ArrayList<ProjectBean>();
    	if(id==""&&name==""){
    	     rs=stat.executeQuery("select * from project"); 
    	}
    	if(id!=""&&name==""){
   	        rs=stat.executeQuery("select * from project where projectId="+id+""); 
     	}
    	if(id==""&&name!=""){	
   	        rs=stat.executeQuery("select * from project where projectName="+name+""); 
   	    }
    	if(id!=""&&name!=""){
      	    rs=stat.executeQuery("select * from project where projectId="+id+" and projectName="+name+""); 
      	}
    	while(rs.next())
        {
    		ProjectBean st=new ProjectBean();
    		st.setProjectId(rs.getString("projectid"));
			st.setProjectName(rs.getString("projectname"));
			st.setProjectType(rs.getString("projectType"));
			st.setProjectUser(rs.getString("projectUser"));
			st.setProjectEmail(rs.getString("projectEmail"));
			st.setProjectMobile(rs.getString("projectMobile"));
        	result.add(st);	
        }
	    if(rs!=null){
	    	  rs.close();
	       }
	    close(stat,conn);
    	return result;
    }
	public AdminPageBean setpage(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException{
		String crd=request.getParameter("currentRecord");
		
    	ArrayList<ProjectBean> result=select("","");
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
		
			 ArrayList<ProjectBean> result=select("","");
			 AdminPageBean adminPageBean=new AdminPageBean();
			 AdminProjectBean adminProjectBean =new AdminProjectBean();
			 adminPageBean=setpage(request,response);
	  	     List<ProjectBean> subResult=null;
	  	     int currentRecord=adminPageBean.getCurrentRecord();
	         if(currentRecord==0){
	         	if(adminPageBean.getTotalRecord()<8){
	         		subResult=(List<ProjectBean>) result.subList(0,adminPageBean.getTotalRecord());
	         	}
	         	else{
	         		subResult=(List<ProjectBean>) result.subList(0,adminPageBean.getPageSize());
	         	}         
	         }
	         else if(adminPageBean.getCurrentRecord()+adminPageBean.getPageSize()<result.size())
	         {
	               subResult=(List<ProjectBean>) result.subList(adminPageBean.getCurrentRecord(),adminPageBean.getCurrentRecord()+adminPageBean.getPageSize());
	         	}
		         else
		         {
		              subResult=(List<ProjectBean>) result.subList(adminPageBean.getCurrentRecord(),result.size());
		         }
	         //subResult.add(currentRecord, element);
	         request.setAttribute("adminPageBean", adminPageBean);//分页信息
		     request.setAttribute("subResult", subResult);//每一页的数据
		     request.getRequestDispatcher("/WEB-INF/jsp/adminpage.jsp").forward(request, response);
	     }
	 
	  //数据库连接方法
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
		
		public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		    String id5=request.getParameter("id");
		    String name5=request.getParameter("name");  
		     if(select(id5,name5).isEmpty()){
		    	 String localPath = request.getContextPath() + "/servlet/AdminPageServlet";
				request.setAttribute("tip", "查询失败无此人<meta http-equiv='refresh' content='3;url="+ localPath + "'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		        }
		       else{
		    		request.setAttribute("result", select(id5,name5));
		            request.getRequestDispatcher("idnameselect.jsp").forward(request, response);	
		        }
		    }

}

