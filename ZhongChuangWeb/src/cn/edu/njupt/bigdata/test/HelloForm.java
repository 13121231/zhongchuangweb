package cn.edu.njupt.bigdata.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// ��չ HttpServlet ��
public class HelloForm extends HttpServlet {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// ���� GET ��������ķ���
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // ����ˢ���Զ�����ʱ��Ϊ 5 ��
      response.setIntHeader("Refresh", 5);
 
      // ������Ӧ��������
      response.setContentType("text/html");
 
      // Get current time
      Calendar calendar = new GregorianCalendar();
      String am_pm;
      int hour = calendar.get(Calendar.HOUR);
      int minute = calendar.get(Calendar.MINUTE);
      int second = calendar.get(Calendar.SECOND);
      if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
      else
        am_pm = "PM";
 
      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    
      PrintWriter out = response.getWriter();
      String title = "�Զ�ˢ�� Header ����";
      String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
        "<html>\n" +
        "<head><title>" + title + "</title></head>\n"+
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<p>��ǰʱ���ǣ�" + CT + "</p>\n");
  }
  // ���� POST ��������ķ���
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
     doGet(request, response);
  }
}