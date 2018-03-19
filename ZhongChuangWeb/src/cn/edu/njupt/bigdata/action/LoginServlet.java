package cn.edu.njupt.bigdata.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.service.LoginService;
import cn.edu.njupt.bigdata.service.QueryUserService;
import cn.edu.njupt.bigdata.service.RegisterService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		QueryUserService queryUserService = new QueryUserService();
		String author = queryUserService.query(userNo);
		request.getSession().setAttribute("author", author);
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode").toUpperCase();		
		String LoginPath = request.getContextPath() + "/servlet/ShowLoginPageServlet";
		request.setAttribute("forwardSecond", "3");
		if(userNo == null || userNo.trim() == "") {
			request.setAttribute("tip", "账号不能为空<meta http-equiv='refresh' content='3;url="+LoginPath +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else {
			if(password == null || password.trim() == "") {
				request.setAttribute("tip", "密码不能为空<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {   
					  if(verifyCode == null || verifyCode.trim().equals("")) {
						request.setAttribute("tip", "验证码不能为空<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					} else {
						if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
							request.setAttribute("tip", "验证码不正确<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
							request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						} else {
								LoginService loginService = new LoginService();
								try{
									UserBean userBean = new UserBean();
									userBean.setUserNo(userNo);
									userBean.setPassword(password);
									if(loginService.login(userBean)) {
										request.getSession().setAttribute("userNo", userNo);
										String successPath = request.getContextPath() + "/servlet/user/ShowIndexPageServlet";
										request.setAttribute("tip", "登录成功<meta http-equiv='refresh' content='3;url="+ successPath + "'>");
										request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
									} else {
										request.setAttribute("tip", "密码不正确<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
										request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						}
					} catch (RuntimeException e) {
						request.setAttribute("tip", e.getMessage()+"<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					}
				}
		}
	}
}
					
				/*
				 * if(list.isEmpty()){request.setAttribute("tip", "用户名和密码正确<meta http-equiv='refresh' content='3;url="+ LoginPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/tip.jsp").forward(request, response);}*/
			/*else{
			 * sendRedirect("/WEB-INF/jsp/主界面.jsp");
			}*/
				 

				
				
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
