package cn.edu.njupt.bigdata.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class TestVerifyCodeServlet
 */
@WebServlet("/TestVerifyCodeServlet")
public class TestVerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestVerifyCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = (String) request.getSession().getAttribute("verifyCode");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//boolean[] flags = null;
		System.out.println(request.getSession().getAttribute("verifyCode"));
		if(code != null) {
			if(request.getParameter("code").toUpperCase().equals(code)) {
				//flags = new boolean[]{true};
				//out.println(new JSONArray(flags));
				out.println("1");
			} else {
				//flags = new boolean[]{false};
				//out.println(new JSONArray(flags));
				out.println("0");
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
