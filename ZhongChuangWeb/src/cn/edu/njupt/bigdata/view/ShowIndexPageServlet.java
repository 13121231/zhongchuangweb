package cn.edu.njupt.bigdata.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.service.QueryUserProjectService;

/**
 * Servlet implementation class ShowIndexPageServlet
 */
@WebServlet("/ShowIndexPageServlet")
public class ShowIndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowIndexPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNo = (String) request.getSession().getAttribute("userNo");
		QueryUserProjectService queryUserProjectService = new QueryUserProjectService();
		List<ProjectBean> projectList = queryUserProjectService.getAllList(userNo);
		request.setAttribute("projectList",projectList);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
