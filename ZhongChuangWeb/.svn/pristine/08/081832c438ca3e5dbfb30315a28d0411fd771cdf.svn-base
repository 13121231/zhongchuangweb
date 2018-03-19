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
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.service.LoginService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;
import cn.edu.njupt.bigdata.utils.StringUtils;

/**
 * Servlet implementation class ChangePasswordServelt
 */
@WebServlet("/ChangePasswordServelt")
public class ChangePasswordServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminAdminName = request.getParameter("adminuserNo");
		String adminpassword = request.getParameter("adminpassword");
		String adminNewpassword = request.getParameter("adminNewpassword");
		String setEmail = request.getParameter("setEmail");
		//String verifyCode = request.getParameter("verifyCode");		
		String verifyCode = request.getParameter("verifyCode").toUpperCase();		
		String Adminlogin = request.getContextPath() + "/servlet/ShowChangePasswordServlet";
		//List list=(List)userInfoDao.findByNamePwd(userName,password);
		System.out.println(adminAdminName);
		request.setAttribute("forwardSecond", "3");
		if(adminAdminName == null || adminAdminName.trim() == "") {
			request.setAttribute("tip", "用户名不能为空<meta http-equiv='refresh' content='1;url="+Adminlogin +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else {
			if(!adminAdminName.equals(ConstCodeUtils.ADMIN_NAME)) {
				request.setAttribute("tip", "用户名不正确<meta http-equiv='refresh' content='1;url="+Adminlogin +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				if(adminpassword== null || adminpassword.trim() == "") {
					request.setAttribute("tip", "密码不能为空<meta http-equiv='refresh' content='1;url="+ Adminlogin +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				}  else {
					if(setEmail== null || setEmail.trim() == "") {
						request.setAttribute("tip", "邮箱不能为空不能为空<meta http-equiv='refresh' content='1;url="+ Adminlogin +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					}else { 
					LoginService adminloginService = new LoginService();
					AdminBean adminBean = new AdminBean();
					//	adminBean.getAdminName(adminuserNO);
						adminBean.setAdminName(adminAdminName);
						adminBean.setAdminPassword(adminpassword);
						
						try {
							if(!adminloginService.adminlogin(adminBean)) {
								//request.getSession().setAttribute("userNo", adminAdminName);
								
								request.setAttribute("tip", "密码不正确<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
								request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
							} else {					
								if(adminNewpassword== null || adminNewpassword.trim() == "") {
									request.setAttribute("tip", "新密码不能为空<meta http-equiv='refresh' content='1;url="+ Adminlogin +"'>");
									request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
								}else{
									if(verifyCode == null || verifyCode.trim().equals("")) {
										request.setAttribute("tip", "验证码不能为空<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
										request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
									} else {
										if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
											request.setAttribute("tip", "验证码不正确<meta http-equiv='refresh' content='3;url="+ Adminlogin +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
										} else {
											String successPath = request.getContextPath() + "/servlet/ShowAdminLoginPageServlet";
											adminBean.setAdminName(adminAdminName);
											adminBean.setAdminPassword(StringUtils.getMD5Code(adminNewpassword));
											adminBean.setAdminEmail(setEmail);
											AdminDao adminDao = new AdminDao();
											adminDao.updatePassword(adminBean);
											EmailBean emailBean = new EmailBean();
										//	emailBean.setAdminEmail(setEmail);
											System.out.println(emailBean.getAdminEmail());
											
											request.setAttribute("tip", "新密码设置成功<meta http-equiv='refresh' content='3;url="+ successPath +"'>");
											request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
											}
										}
											
										}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
