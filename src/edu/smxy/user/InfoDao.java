package edu.smxy.user;

import java.sql.*;

import edu.smxy.db.DBTools;

public class InfoDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public void createTable(){
		String ta="info";
		String CREATE_TABLE=
			"create table if not exists t_"+ta
			+"(id int(20) primary key auto_increment,"
			+ "username varchar(20),"
			+ "info varchar(100),"
			+ "str varchar(100))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			int n = pstmt.executeUpdate();
			if(n>0)
				System.out.print("the table has been successfully created:"+ta);
			else
				System.out.print("failed to create table:"+ta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public boolean insert(Info u1) {
		String sql = "insert into t_info(username,info,str) values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			String name=u1.getUsername();
			pstmt.setString(1, name);
			pstmt.setString(2, u1.getInfo());
			pstmt.setString(3, u1.getStr());
			if(new UserDao().queryByName(name)&&!new InfoDao().queryByName(name)){
				int n = pstmt.executeUpdate();
				if (n > 0) return true;
				else System.out.println("fail");
			}
		}
		catch (SQLException e) {e.printStackTrace();} 
		finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	public boolean updata(String name,String info,String info2) {
		String sql = "update  t_info set info=?,str=? where username =?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info);
			pstmt.setString(2, info2);
			pstmt.setString(3, name);
			if(new InfoDao().queryByName(name)){
				System.out.print("find go up");
				int n = pstmt.executeUpdate();
				if (n > 0) return true;
				else System.out.println("fail");
			}
		}
		catch (SQLException e) {e.printStackTrace();} 
		finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	public boolean queryByName(String username) {
		String sql = "select * from t_info where username=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	public Info query(String username) {
		Info tmp = null;
		String sql = "select * from t_info where username=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				tmp=new Info(rs.getString("username"),rs.getString("info"),rs.getString("str"));
				return tmp;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DBTools.close(null, pstmt, null);
		}
		return tmp;
	}
	public boolean close() {
		if(conn!=null){
			DBTools.close(null, null, conn);
			return true;
		}
		return true;
	}
}
