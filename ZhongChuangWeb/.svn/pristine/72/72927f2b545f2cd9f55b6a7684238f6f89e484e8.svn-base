package cn.edu.njupt.bigdata.action;
import java.io.File;
import java.io.FileOutputStream;   
import java.io.IOException;   
import java.sql.ResultSet;   
import java.sql.ResultSetMetaData;   
  
import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
  
import org.apache.poi.hssf.usermodel.HSSFCell;   
import org.apache.poi.hssf.usermodel.HSSFRichTextString;   
import org.apache.poi.hssf.usermodel.HSSFRow;   
import org.apache.poi.hssf.usermodel.HSSFSheet;   
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.edu.njupt.bigdata.service.DataBaseService;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;   
  
public class BuildExcelServlet extends HttpServlet {   
  
    protected void doGet(HttpServletRequest request,   
            HttpServletResponse response) throws ServletException, IOException {   
        DataBaseService stuResultSet = new DataBaseService();   
        ResultSet rs = stuResultSet.query();   
        String xlsName = "admin.xls";   
        String sheetName = "sheetName";
        String[] excelHeader = {"项目编号","项目名称","项目类型","学号","项目负责人","邮箱","手机号"};
        String path =request.getServletContext().getRealPath(ConstCodeUtils.PROJECT_ADMIN_PATH);
        File file = new File(path);
        if(!file.exists()) {
        	file.mkdir();
        }
  
        HSSFWorkbook workbook = new HSSFWorkbook();   
        HSSFSheet sheet = workbook.createSheet();   
        workbook.setSheetName(0, sheetName);   
        HSSFRow row = sheet.createRow((short) 0);   
        HSSFCell cell;   
        try {   
            ResultSetMetaData md = rs.getMetaData();   
            int nColumn = md.getColumnCount();   
  
            for (int i = 0; i <= 6; i++) {   
                cell = row.createCell((short) (i));   
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);   
                cell.setCellValue(new HSSFRichTextString(excelHeader[i]));   
            }   
            int iRow = 1;   
            while (rs.next()) {   
                row = sheet.createRow((short) iRow);   
                for (int j = 0; j <= 6; j++) {   
                    cell = row.createCell((short) (j));   
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell.setCellValue(new HSSFRichTextString(rs.getString(j+2)));   
                } 
                iRow++;   
            }   
            String filename =  path + ConstCodeUtils.FILE_SPLIT+ xlsName;
            System.out.println(filename);
            request.setAttribute("filename", filename);   
            FileOutputStream fOut = new FileOutputStream(filename);   
            workbook.write(fOut);   
            fOut.flush();   
            fOut.close();   
            request.getRequestDispatcher("OpenExcelServlet").forward(request,   
                    response);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
  
    protected void doPost(HttpServletRequest request,   
            HttpServletResponse response) throws ServletException, IOException {   
        this.doGet(request, response);   
    }   
}  