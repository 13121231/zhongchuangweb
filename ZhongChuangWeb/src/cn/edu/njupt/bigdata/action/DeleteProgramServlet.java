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
 * Servlet implementation class DeleteProgramServlet
 */
@WebServlet("/DeleteProgramServlet")
public class DeleteProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String findFlag =request.getParameter("findFlag");
		if(findFlag ==null){
			findFlag="0";
		}
		int FindFlag=Integer.parseInt(findFlag);
		String userNo=request.getParameter("userNo");
		String programName=request.getParameter("programName");
		ProjectDao projectDao =new ProjectDao();
		try {
			projectDao.delteProgram(userNo, programName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(FindFlag==0){
			try {
				List<ProjectBean> projectAllList = projectDao.getAllProject();
				request.setAttribute("projectAllList",projectAllList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("ShowAdminIndexServlet").forward(request, response);
			}else{
				List<ProjectBean> selectProjectList;
				try {
					selectProjectList = projectDao.selectUserProject(userNo);
					request.setAttribute("selectProjectList",selectProjectList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/WEB-INF/jsp/adminquerypage.jsp").forward(request, response);
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
