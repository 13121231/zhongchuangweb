package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.service.LoginService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;


/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RuntimeException {
		String adminuserName = request.getParameter("adminuserNo");
		String adminpassword = request.getParameter("adminpassword");
		String verifyCode = request.getParameter("verifyCode").toUpperCase();		
		String Adminlogin = request.getContextPath() + "/servlet/ShowAdminLoginPageServlet";
		//List list=(List)userInfoDao.findByNamePwd(userName,password);
		System.out.println(adminuserName);
		request.setAttribute("forwardSecond", "3");
		if(adminuserName == null || adminuserName.trim() == "") {
			request.setAttribute("tip", "用户名不能为空<meta http-equiv='refresh' content='3;url="+Adminlogin +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else {
			if(!adminuserName.equals(ConstCodeUtils.ADMIN_NAME)) {
				request.setAttribute("tip", "用户名不正确<meta http-equiv='refresh' content='3;url="+Adminlogin +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				if(adminpassword== null || adminpassword.trim() == "") {
					request.setAttribute("tip", "密码不能为空<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				} else {   
						  if(verifyCode == null || verifyCode.trim().equals("")) {
							request.setAttribute("tip", "验证码不能为空<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
							request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						} else {
							if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
								request.setAttribute("tip", "验证码不正确<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
								request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
							} else {
								LoginService adminloginService = new LoginService();
									try{
										AdminBean adminBean = new AdminBean();
									//	adminBean.getAdminName(adminuserNO);
										adminBean.setAdminName(adminuserName);
										adminBean.setAdminPassword(adminpassword);
										if(adminloginService.adminlogin(adminBean)) {
											request.getSession().setAttribute("userNo", adminuserName);
											String successPath = request.getContextPath() + "/servlet/admin/ShowAdminIndexServlet";
											request.setAttribute("tip", "登录成功<meta http-equiv='refresh' content='3;url="+ successPath +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
										} else {
											request.setAttribute("tip", "密码不正确<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
											}
										}
									catch (RuntimeException e) {
									request.setAttribute("tip", e.getMessage()+"<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
									request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
								}
						}
				}
			}
		}
}
					
				/*
				 * if(list.isEmpty()){request.setAttribute("tip", "用户名和密码正确<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/tip.jsp").forward(request, response);}*/
			/*else{
			 * sendRedirect("/WEB-INF/jsp/主界面.jsp");
			}*/
				 

				
				


		//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
