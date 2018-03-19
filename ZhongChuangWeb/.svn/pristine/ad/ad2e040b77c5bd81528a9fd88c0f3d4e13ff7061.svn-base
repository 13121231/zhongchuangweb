package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;

/**
 * Servlet implementation class AdminStateQueryServlet
 */
@WebServlet("/AdminStateQueryServlet")
public class AdminStateQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStateQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNo = request.getParameter("userNo");
		String programName = request.getParameter("programName");
		String AdminState = request.getParameter("adminState");
		int adminState = Integer.parseInt(AdminState);
		ProjectBean projectBean = new ProjectBean();
		projectBean.setUserNo(userNo);
		projectBean.setProjectName(programName);
		projectBean.setAdminState(adminState);
		ProjectDao projectDao = new ProjectDao();
		try {
			projectDao.updateadminState(projectBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<ProjectBean> selectProjectList = projectDao.selectUserProject(userNo);
			request.setAttribute("selectProjectList",selectProjectList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("ShowAdminQueryPageServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
