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

import cn.edu.njupt.bigdata.bean.QueryProgramNameBean;
import cn.edu.njupt.bigdata.dao.ProjectDao;
import cn.edu.njupt.bigdata.dao.ProjectExpenseDao;
import cn.edu.njupt.bigdata.service.QueryUserService;
import cn.edu.njupt.bigdata.service.ZipFileDownService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;

/**
 * Servlet implementation class ShowProjectExpenseServlet
 */
@WebServlet("/ShowProjectExpenseServlet")
public class DownProjectExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownProjectExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNo = request.getParameter("userNo");
		request.setAttribute("forwardSecond", "3");
		QueryUserService queryUser = new QueryUserService();
		String author = queryUser.query(userNo);
		String programNo = request.getParameter("programNo");
		String programName = request.getParameter("programName");
		String UI1ErrorPath = request.getContextPath() + "/servlet/admin/ShowAdminIndexServlet";
		QueryProgramNameBean queryProgram = new QueryProgramNameBean();
		queryProgram.setUserNo(userNo);
		queryProgram.setProjectName(programName);
		ProjectDao projectDao = new ProjectDao();
		String path;
		try {
			path = projectDao.queryProgramName(queryProgram).getProjectBill();
			if (path == null) {
				request.setAttribute("tip", "文档尚未上传<meta http-equiv='refresh' content='3;url="+ UI1ErrorPath +"'>");
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				return;
			} 
			String returnFileName = request.getServletContext().getRealPath(ConstCodeUtils.TEMP);
			String zipFileName = userNo + "_" + programName + "_" + author +".zip";
			//String fileName =programNo + "-" + programName + "-" + author +".zip";
			String realFileName = returnFileName + ConstCodeUtils.FILE_SPLIT + zipFileName;
			//System.out.println("realFileName"+realFileName);
			ZipFileDownService zipDownService = new ZipFileDownService();
			try {
				zipDownService.generateZip(zipFileName, path, returnFileName, false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file = new File(realFileName);
			InputStream fis = new BufferedInputStream(new FileInputStream(realFileName));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	        response.reset();
	        response.setCharacterEncoding("utf-8");
	        //吴道亮  2016.05.26↓ 修改
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(zipFileName.getBytes(), "ISO-8859-1"));
	        //response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
	        //吴道亮  2016.05.26↑ 修改
	        response.addHeader("Content-Length", "" + file.length());
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
	        String zipPath = path + ConstCodeUtils.FILE_SPLIT + zipFileName;
	        //System.out.println("zippath"+zipPath);
	        File zipFile = new File(zipPath);
	        if(zipFile.exists()) {
	            zipFile.delete();
	        }
	        File tempFile = new File(realFileName);
	        if(tempFile.exists()) {
	        	tempFile.delete();
	        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
