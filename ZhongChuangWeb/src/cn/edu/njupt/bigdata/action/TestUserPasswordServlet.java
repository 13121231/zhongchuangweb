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
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.service.LoginService;

/**
 * Servlet implementation class TestUserPasswordServlet
 */
@WebServlet("/TestUserPasswordServlet")
public class TestUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUserPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNo = request.getParameter("userNo");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserBean userBean= new UserBean();
		userBean.setUserNo(userNo);
		
		userBean.setPassword(password);
		LoginService loginService =new  LoginService();
		
		if(loginService.login(userBean)) {
			//System.out.println(1);
			//flags = new boolean[]{true, false};
			//out.println(new JSONArray(flags));
			out.println("1");
		} else {
			//System.out.println(0);
			//flags = new boolean[]{false, true};
			//out.println(new JSONArray(flags));
			out.println("0");
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
