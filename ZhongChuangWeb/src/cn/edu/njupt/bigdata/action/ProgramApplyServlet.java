package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.service.LoginService;
import cn.edu.njupt.bigdata.service.QueryUserService;

/**
 * Servlet implementation class ProgramApplyServlet
 */
@WebServlet("/ProgramApplyServlet")
public class ProgramApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest session;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String programName = request.getParameter("ProgramName");
		//String programNo = request.getParameter("programNo");
		String programType = request.getParameter("ProgramType");
		String programMobile = request.getParameter("ProgramMobileNumber");
		String programEmail = request.getParameter("ProgramEmail");
		String verifyCode = request.getParameter("verifyCode").toUpperCase();
		int fileState = 0;
		int billState = 0;
		int adminState = 0;
		int changeState = 1;
		String time = null;
		String successPath = request.getContextPath() + "/servlet/user/ShowIndexPageServlet";//需要修改 应该跳转到后台界面
		String errorPath = request.getContextPath() + "/servlet/user/ShowUI1PageServlet";//需要修改 应该跳转到申请项目界面
		String userNo = (String) request.getSession().getAttribute("userNo");
		ProjectDao projectDao = new ProjectDao();
		QueryProgramNameBean queryProgramNameBean = new QueryProgramNameBean();
		QueryUserService queryUserService = new QueryUserService();
		String author = queryUserService.query(userNo);
		request.setAttribute("forwardSecond", "3");
		if(programName == null || programName.trim() == "") {
			request.setAttribute("tip", "项目名称不能为空<meta http-equiv='refresh' content='3;url="+errorPath +"'>");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} else { 
			 queryProgramNameBean.setUserNo(userNo);
			 queryProgramNameBean.setProjectName(programName);
			 ProjectBean projectbean;
			try {
				projectbean = projectDao.queryProgramName(queryProgramNameBean);
				if (projectbean != null) {
					 request.setAttribute("tip", "该项目您已注册<meta http-equiv='refresh' content='3;url="+errorPath +"'>");
					 request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					 return; 
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
			if(programType == null || programType.trim() == "") {
				request.setAttribute("tip", "项目类型不能为空<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			} else {   
				if(programMobile == null || programMobile.trim() == "") {
					request.setAttribute("tip", "手机号码不能为空<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);	
				} else{
					if(programEmail == null || programEmail.trim() == "") {
						request.setAttribute("tip", "邮箱不能为空<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);	
					} else {
					  if(verifyCode == null || verifyCode.trim().equals("")) {
						request.setAttribute("tip", "验证码不能为空<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
						request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					} else {
						if(!verifyCode.equals(request.getSession().getAttribute("verifyCode"))) {
							request.setAttribute("tip", "验证码不正确<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
							request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						} else {
								LoginService loginService = new LoginService();
								try{
									ProjectBean projectBean = new ProjectBean();
									projectBean.setProjectName(programName);
									projectBean.setProjectType(programType);
									projectBean.setUserNo(userNo);
									projectBean.setProjectUser(author);
									projectBean.setProjectMobile(programMobile);
									projectBean.setProjectEmail(programEmail);
									projectBean.setFileState(fileState);
									projectBean.setBillState(billState);
									projectBean.setAdminState(adminState);
									projectBean.setChangeState(changeState);
									projectBean.setTime(time);
									if(projectDao.addProject(projectBean)) {
										request.getSession().setAttribute("ProgramName", programName);
										request.setAttribute("tip", "项目申请成功<meta http-equiv='refresh' content='3;url="+ successPath + "'>");
										request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
									} else {
										request.setAttribute("tip", "未写入数据库<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
										request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
						}
					} catch (RuntimeException e) {
						request.setAttribute("tip", e.getMessage()+"<meta http-equiv='refresh' content='3;url="+ errorPath +"'>");
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
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
