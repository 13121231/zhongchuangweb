package cn.edu.njupt.bigdata.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.njupt.bigdata.service.ReadExcel;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;
import jxl.read.biff.BiffException;

/**
 * Servlet implementation class UploadExcelServlet
 */
@WebServlet("/UploadExcelServlet")
public class UploadExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletContext().getRealPath(ConstCodeUtils.PROJECT_ADMIN_PATH);
		String savePath = null;
		File file = new File(path);
		System.out.println(file);
		if(!file.exists()) {
			file.mkdir();
		}
		String UI1ErrorPath =  request.getContextPath() + "/servlet/admin/ShowAdminIndexServlet";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		request.setAttribute("forwardSecond", "3");
		if(!upload.isMultipartContent(request)) {
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				if(!item.isFormField()) {
					String fileName = item.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					savePath = path + ConstCodeUtils.FILE_SPLIT+"updateadmin" + "."+ fileName.split("\\.")[fileName.split("\\.").length - 1];
					 if(fileName.split("\\.")[fileName.split("\\.").length - 1].equals("xls")
					||fileName.split("\\.")[fileName.split("\\.").length - 1].equals("xlsx")){
						 FileOutputStream out = new FileOutputStream(savePath);
						 InputStream in = item.getInputStream();
						 byte[] buffer = new byte[1024];
						 int len = 0;
						 while((len = in.read(buffer))>0) {
							 out.write(buffer);
						 }
						 in.close();
						 out.close();
					 } else {
						 request.setAttribute("tip", "上传格式错误<meta http-equiv='refresh' content='3;url="+ UI1ErrorPath +"'>");
						 request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
					 }
					 
					// request.getRequestDispatcher("/WEB-INF/jsp/adminIndex.jsp").forward(request, response);
				}
			}
			ReadExcel readExcel = new ReadExcel();
			File file1=new File(savePath);
			try {
				readExcel.readfile(file1);
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("tip", "上传成功<meta http-equiv='refresh' content='3;url="+ UI1ErrorPath +"'>");
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
