package edu.smxy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBTools {
	static DataSource ds = null;
	// 静态代码块--只执行一次
	// 1 创建数据源DataSource
	static {
		ds = new ComboPooledDataSource();
	}
	public static Connection getConnectionFromPool() {
		Connection conn = null;
		try {// 2 从连接池中获取连接
			conn = ds.getConnection();
			while(conn==null){
				conn.close();
				conn = ds.getConnection();
			}
			ComboPooledDataSource cpds = (ComboPooledDataSource) ds;
			 System.out.println("最大连接数为："+cpds.getMaxPoolSize()); 
		} catch (SQLException e) {e.printStackTrace();}
		return conn;
	}
	//关闭流，选用
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {rs.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		if(stmt!=null){
			try {stmt.close();
			}catch (SQLException e) {e.printStackTrace();}
		}
		if(conn!=null){
			try {conn.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
