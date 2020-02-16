package edu.smxy.info.i;

import java.sql.*;

import edu.smxy.db.DBTools;

public class tinfoDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public void createTable(){
		String ta="tinfo";
		String CREATE_TABLE=
			"create table if not exists t_"+ta
			+"(id int(20) primary key auto_increment,"
			+ "name varchar(20),"
			+ "pz varchar(20),"
			+ "cd varchar(20),"
			+ "rlsj varchar(20))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			int n = pstmt.executeUpdate();
			if(n>0)
				System.out.print("cg"+ta);
			else
				System.out.print(ta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public boolean insert(tinfo u1) {
		String sql = "insert into t_tinfo(name,pz,cd,rlsj) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			String name=u1.getName();
			pstmt.setString(1, name);
			pstmt.setString(2, u1.getPz());
			pstmt.setString(3, u1.getCd());
			pstmt.setString(4, u1.getRlsj());
			if(!new tinfoDao().queryByName(name)){
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
	public boolean queryByName(String name) {
		String sql = "select * from t_tinfo where name=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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
	public tinfo query(String name) {
		tinfo tmp = new tinfo("","","","");
		String sql = "select * from t_tinfo where name=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				tmp=new tinfo(name,rs.getString("pz"),rs.getString("cd"),rs.getString("rlsj"));
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
