package cn.edu.njupt.bigdata.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static BasicDataSource ds = null;
	
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		try{
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties p = new Properties();
			p.load(in);
			JdbcUtils.ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private JdbcUtils() {
		
	}
	
	public static BasicDataSource getDataSource() {
		return JdbcUtils.ds;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = JdbcUtils.threadLocal.get();
		if(conn == null) {
			conn = JdbcUtils.ds.getConnection();
			JdbcUtils.threadLocal.set(conn);
		}
		return conn;
	}
	
	public static void startTransaction() {
		try{
			Connection conn = JdbcUtils.threadLocal.get();
			if(conn == null) {
				conn = getConnection();
				JdbcUtils.threadLocal.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void commit() {
		try {
			Connection conn = JdbcUtils.threadLocal.get();
			if(conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void rollback() {
		try {
			Connection conn = JdbcUtils.threadLocal.get();
			if(conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release() {
		try {
			Connection conn = JdbcUtils.threadLocal.get();
			if(conn != null) {
				conn.close();
				JdbcUtils.threadLocal.remove();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
