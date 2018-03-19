package cn.edu.njupt.bigdata.action;

import java.io.BufferedInputStream;   
import java.io.FileInputStream;   
import java.io.IOException;   
import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenExcelServlet
 */
@WebServlet("/OpenExcelServlet")
public class OpenExcelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {   
  
        response.setContentType("application/vnd.ms-excel");   
        PrintWriter out = response.getWriter();   
        String filePath = (String) request.getAttribute("filename");
        String fileName = "项目表.xls";
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
        System.out.println(filePath);
        BufferedInputStream bis = null;   
        try {   
            bis = new BufferedInputStream(new FileInputStream(filePath));   
            int bytesRead;   
            while ((bytesRead = bis.read()) != -1) {   
                out.write(bytesRead);   
                out.flush();   
            }   
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally {   
            if (bis != null)   
                bis.close();   
            if (out != null)   
                out.close();   
        }   
    }   
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {   
        this.doGet(request, response);   
    }    

}
