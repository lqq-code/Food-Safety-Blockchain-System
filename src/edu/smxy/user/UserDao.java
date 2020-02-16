package edu.smxy.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.smxy.db.DBTools;

public class UserDao {

	static Connection conn = DBTools.getConnectionFromPool();
	public void createTable(){
		String ta="user";
		String CREATE_TABLE=
	"create table if not exists t_"+ta
	+"(uid int(20) primary key auto_increment,"
	+ "username varchar(20),"
	+ "password varchar(40))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			int n = pstmt.executeUpdate();
			System.out.println("the table has been successfully created:"+ta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public void insert(User u1) {
		String INSERT = "insert into t_user(username,password) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, u1.getUsername());
			pstmt.setString(2, u1.getPassword());
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("ok");
			} else {

				System.out.println("fail");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	
	public int findid(String username) {
		String QUERY = "select * from t_user where username=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				return rs.getInt("uid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return 0;
	}
	
	public boolean queryByName(String username) {
		String QUERY = "select * from t_user where username=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	
	public boolean checkLogin(User u1) {
		String QUERY = "select * from t_user where username=? and password=?";
		System.out.println(u1);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, u1.getUsername());
			pstmt.setString(2, u1.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}

		return false;

	}
	public boolean close() {
		if(conn!=null){
			DBTools.close(null, null, conn);
			return true;
		}
		return true;
	}

}
