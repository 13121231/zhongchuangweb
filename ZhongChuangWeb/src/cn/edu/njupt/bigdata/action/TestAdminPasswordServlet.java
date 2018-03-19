package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.dao.UserDao;
import cn.edu.njupt.bigdata.service.LoginService;

/**
 * Servlet implementation class TestAdminPasswordServlet
 */
@WebServlet("/TestAdminPasswordServlet")
public class TestAdminPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAdminPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminpassword = request.getParameter("adminpassword");
		System.out.println(adminpassword);
		AdminDao adminDao = new AdminDao();
		AdminBean adminBean = new AdminBean();
		LoginService adminloginService = new LoginService();
		adminBean.setAdminName("admin");
		adminBean.setAdminPassword(adminpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//boolean[] flags = null;
		try {
			if(adminloginService.adminlogin(adminBean)) {
				//System.out.println(1);
				//flags = new boolean[]{true, false};
				//out.println(new JSONArray(flags));
				out.println("0");
			} else {
				//System.out.println(0);
				//flags = new boolean[]{false, true};
				//out.println(new JSONArray(flags));
				out.println("1");
			}
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
