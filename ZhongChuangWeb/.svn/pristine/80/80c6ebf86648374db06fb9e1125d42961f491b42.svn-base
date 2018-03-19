package cn.edu.njupt.bigdata.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.bean.ProjectBean;
import cn.edu.njupt.bigdata.bean.ProjectFileBean;
import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.service.DownProjectFileService;
import cn.edu.njupt.bigdata.service.QueryUserService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;

/**
 * Servlet implementation class ShowProjectFileServlet
 */
@WebServlet("/ShowProjectFileServlet")
public class DownProjectFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownProjectFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String programNo = request.getParameter("programNo");
		String programName = request.getParameter("programName");
		String userNo = request.getParameter("userNo");
		String UI1ErrorPath = request.getContextPath() + "/servlet/admin/ShowAdminIndexServlet";
		request.setAttribute("forwardSecond", "3");
		QueryUserService queryUser = new QueryUserService();
		String author = queryUser.query(userNo);
		QueryProgramNameBean queryProgram = new QueryProgramNameBean();
		queryProgram.setUserNo(userNo);
		queryProgram.setProjectName(programName);
		ProjectDao projectDao = new ProjectDao();
		ProjectBean projectBean;
		try {
			projectBean = projectDao.queryProgramName(queryProgram);
			String filePath = projectBean.getProjectFile();
			if (filePath == null) {
				request.setAttribute("tip", "文档尚未上传<meta http-equiv='refresh' content='3;url="+ UI1ErrorPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				 return;
			}
			String fileName = userNo + "_" + programName + "_" + author + "." +filePath.substring(filePath.lastIndexOf(".") + 1);
			File file = new File(filePath);
			InputStream fis = new FileInputStream(filePath);
			response.setCharacterEncoding("utf-8");
	        //吴道亮  2016.05.26↓ 修改
	        //response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
	        //吴道亮  2016.05.26↑ 修改
	        response.addHeader("Content-Length", "" + file.length());
	        response.setContentType("application/octet-stream");
			OutputStream out = response.getOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while((len = fis.read(buffer)) > 0){
	        	out.write(buffer, 0, len);
	        }
	        fis.close();
	        out.close();
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
