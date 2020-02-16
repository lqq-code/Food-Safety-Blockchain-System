package edu.smxy.user;

import java.sql.*;

import edu.smxy.blockchain.BlockDao;
import edu.smxy.db.DBTools;

public class AssetsDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public void createTable(String username){
		String ta=new UserDao().findid(username)+"";
		String CREATE_TABLE=
			"create table if not exists u_"+ta
			+"(id int(20) primary key auto_increment,"
			+ "tname varchar(20))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			int n = pstmt.executeUpdate();
				System.out.print(ta+"the table has been successfully created\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public boolean insert(String username,String tname) {
		if(tname==""||tname==null)
			return false;
		String ta=new UserDao().findid(username)+"";
		String sql = "insert into u_"+ta+"(tname) values(?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tname);
			if(!new AssetsDao().queryByName(username,tname)){
				int n = pstmt.executeUpdate();
				new BlockDao().createTable(tname);
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

	public boolean queryByName(String name,String tname) {
		if(tname==""||tname==null)
			return false;
		String ta=""+new UserDao().findid(name);
		String sql = "select * from u_"+ta+" where tname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tname);
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
	
	public String[] query(String name,int k) {
		String[] tmp=new String[k];
		for(int j=0;j<k;j++){
			tmp[j]=0+"";
		}
		String ta="";
		if(new UserDao().findid(name)==0)
			return tmp;
		else
			ta=""+new UserDao().findid(name);
		String sql = "select * from u_"+ta;
		PreparedStatement pstmt = null;
		try {
			int i=0;
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()&&i<k)
			{
				
				tmp[i]=rs.getString("tname");
				i++;
			}
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
