package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import cn.edu.njupt.bigdata.dao.UserDao;

/**
 * Servlet implementation class TestStudentNoServlet
 */
@WebServlet("/TestStudentNoServlet")
public class TestStudentNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestStudentNoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		System.out.println(studentNo);
		UserDao userDao = new UserDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//boolean[] flags = null;
		if(userDao.find(studentNo) == null) {
			//System.out.println(1);
			//flags = new boolean[]{true, false};
			//out.println(new JSONArray(flags));
			out.println("1");
		} else {
			//System.out.println(0);
			//flags = new boolean[]{false, true};
			//out.println(new JSONArray(flags));
			out.println("0");
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
