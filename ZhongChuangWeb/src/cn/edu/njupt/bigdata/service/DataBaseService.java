package cn.edu.njupt.bigdata.service;

import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.PreparedStatement;   
import java.sql.ResultSet;   
import java.sql.SQLException; 

public class DataBaseService {
	private Connection conn;   
    private PreparedStatement pstmt;   
    private ResultSet rs;   
    private static final String DRIVER = "com.mysql.jdbc.Driver";   
    private static final String URL = "jdbc:mysql://localhost:3306/zhongchuangweb";   
    private static final String USERNAME = "root";   
    private static final String PASSWORD = "123456";  
    public ResultSet query() {   
        try {   
            Class.forName(DRIVER);   
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);   
            pstmt = conn.prepareStatement("select * from project");   
            rs = pstmt.executeQuery();   
        } catch (ClassNotFoundException e) {   
            e.printStackTrace();   
        } catch (SQLException e) {   
            e.printStackTrace();   
        }   
        return rs;   
    }    

}
