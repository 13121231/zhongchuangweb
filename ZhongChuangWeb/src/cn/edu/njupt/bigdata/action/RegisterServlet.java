package cn.edu.njupt.bigdata.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.service.RegisterService;
import cn.edu.njupt.bigdata.utils.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String Newpassword = request.getParameter("Newpassword");
		String verifyCode = request.getParameter("verifyCode").toUpperCase();
		String registerPath = request.getContextPath() + "/servlet/ShowRegisterPageServlet";
		request.setAttribute("forwardSecond", "3");
		if(userNo == null || userNo.trim().equals("")) {
			request.setAttribute("tip", "学号不能为空！<meta http-equiv='refresh' content='3;url="+registerPath +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else {
			if(userName == null || userName.trim().equals("")) {
				request.setAttribute("tip", "姓名不能为空！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {
				if(password == null || password.trim().equals("")) {
					request.setAttribute("tip", "密码不能为空！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				} else {
					if(Newpassword == null || Newpassword.trim().equals("")) {
					request.setAttribute("tip", "确认密码不能为空！<meta http-equiv='refresh' content='3;url="+registerPath +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);	
					} else {
						if(!Newpassword.equals(password)) {
						request.setAttribute("tip", "两次密码输入不一致！<meta http-equiv='refresh' content='3;url="+registerPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						}else {
					if(verifyCode == null || verifyCode.trim().equals("")) {
						request.setAttribute("tip", "验证码不能为空！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					} else {
						if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
							request.setAttribute("tip", "验证码不正确！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
							request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						} else {
							UserBean userBean = new UserBean();
							userBean.setUserNo(userNo);
							userBean.setUserName(userName);
							userBean.setPassword(StringUtils.getMD5Code(password));
							RegisterService registerService = new RegisterService();
							registerService.setUserBean(userBean);
							try{
								if(registerService.register()) {
									request.setAttribute("tip", "注册成功！<meta http-equiv='refresh' content='3;url="+ request.getContextPath()+"'>");
									request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
								} else {
									request.setAttribute("tip", "注册失败！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
									request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
								}
							} catch (RuntimeException e) {
								request.setAttribute("tip", e.getMessage()+"！<meta http-equiv='refresh' content='3;url="+ registerPath +"'>");
								request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
							}
						}
					}
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
		doGet(request, response);
	}

}
