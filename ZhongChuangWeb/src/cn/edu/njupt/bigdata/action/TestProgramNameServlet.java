package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;

/**
 * Servlet implementation class TestProgramNameServlet
 */
@WebServlet("/TestProgramNameServlet")
public class TestProgramNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProgramNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String programName = request.getParameter("programName");
		String userNo = (String) request.getSession().getAttribute("userNo");
		ProjectDao projectDao = new ProjectDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		QueryProgramNameBean queryProgramNameBean = new QueryProgramNameBean();
		queryProgramNameBean.setProjectName(programName);
		queryProgramNameBean.setUserNo(userNo);
		try {
			if(projectDao.queryProgramName(queryProgramNameBean)==null) {
				out.println("1");
			}else {
				out.println("0");
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
