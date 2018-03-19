package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.bean.EmailBean;
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.dao.UserDao;
import cn.edu.njupt.bigdata.service.LoginService;
import cn.edu.njupt.bigdata.service.QueryUserService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;
import cn.edu.njupt.bigdata.utils.StringUtils;

/**
 * Servlet implementation class ChangeUserPasswordServlet
 */
@WebServlet("/ChangeUserPasswordServlet")
public class ChangeUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserPasswordServlet() {
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
		String newPassword = request.getParameter("Newpassword");
		String verifyCode = request.getParameter("verifyCode").toUpperCase();
		String userName = null;
		String userLogin = request.getContextPath()+ "/servlet/ShowChangeUserPasswordServlet";
		request.setAttribute("forwardSecond", "3");
		QueryUserService queryUserService = new QueryUserService();
		userName = queryUserService.query(userNo);
		if(userNo == null || userNo.trim() == "") {
			request.setAttribute("tip", "学号不能为空<meta http-equiv='refresh' content='1;url="+userLogin +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else {
			if(userName == null) {
				request.setAttribute("tip", "学号不存在<meta http-equiv='refresh' content='1;url="+userLogin +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				if(password== null || password.trim() == "") {
					request.setAttribute("tip", "密码不能为空<meta http-equiv='refresh' content='1;url="+ userLogin +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				}  else {
					LoginService loginService = new LoginService();
					UserBean  userBean = new UserBean();
					//	adminBean.getAdminName(adminuserNO);
					userBean.setUserNo(userNo);
					userBean.setPassword(password);
						
						try {
							if(!loginService.login(userBean)) {
								//request.getSession().setAttribute("userNo", adminAdminName);
								
								request.setAttribute("tip", "密码不正确<meta http-equiv='refresh' content='3;url="+ userLogin +"'>");
								request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
							} else {					
								if(newPassword== null || newPassword.trim() == "") {
									request.setAttribute("tip", "新密码不能为空<meta http-equiv='refresh' content='1;url="+ userLogin +"'>");
									request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
								}else{
									if(verifyCode == null || verifyCode.trim().equals("")) {
										request.setAttribute("tip", "验证码不能为空<meta http-equiv='refresh' content='3;url="+ userLogin +"'>");
										request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
									} else {
										if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
											request.setAttribute("tip", "验证码不正确<meta http-equiv='refresh' content='3;url="+ userLogin +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
										} else {
											String successPath = request.getContextPath() + "/servlet/ShowLoginPageServlet";
											userBean.setUserNo(userNo);
											userBean.setPassword(StringUtils.getMD5Code(newPassword));
											userBean.setUserName(userName);
											UserDao userDao = new UserDao();
											userDao.updateUser(userBean);
											request.setAttribute("tip", "新密码设置成功<meta http-equiv='refresh' content='3;url="+ successPath +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
											}
										}
											
										}
									}
						}
							catch (RuntimeException e) {
								request.setAttribute("tip", e.getMessage()+"<meta http-equiv='refresh' content='3;url="+ userLogin +"'>");
								request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
		}	
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
