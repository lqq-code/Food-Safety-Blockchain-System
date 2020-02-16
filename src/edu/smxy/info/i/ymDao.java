package edu.smxy.info.i;

import java.sql.*;

import edu.smxy.blockchain.*;
import edu.smxy.db.*;

public class ymDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public void createTable(String ta){
		if(ta==""||ta==null)
			return ;
		String CREATE_TABLE=
	"create table if not exists t_ym_"
	+ta
	+"(id int(20) primary key auto_increment,"
	+ "hash varchar(100),"
	+ "previousHash varchar(100),"
	+ "data varchar(100),"
	+ "timeStamp varchar(100))";
		//System.out.print(CREATE_TABLE);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			//pstmt.setString(1, ta);
			int n = pstmt.executeUpdate();
			System.out.print("创建成功"+ta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	
	public void insert(String ta,Block block) {
		String INSERT = "insert into t_ym_"+ta+"(hash,previousHash,data,timeStamp) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			//pstmt.setString(1, ta);
			pstmt.setString(1, block.hash);
			pstmt.setString(2, block.previousHash);
			pstmt.setString(3, block.data);
			pstmt.setString(4, block.timeStamp);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println(ta+"数据添加成功");
			}else{
				System.out.println(ta+"数据添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public void updata(String ta,int id,Block block) {
		String INSERT = "update t_ym_"+ta+" set hash=?,previousHash=?,data=?,timeStamp=? where id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			//pstmt.setString(1, ta);
			pstmt.setString(1, block.hash);
			pstmt.setString(2, block.previousHash);
			pstmt.setString(3, block.data);
			pstmt.setString(4, block.timeStamp);
			pstmt.setInt(5, id);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println(ta+"数据更新成功");
			}else{
				System.out.println(ta+"数据更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	//select * FROM 表名 ORDER BY id DESC LIMIT 0,1 ;
	public boolean checkta(String ta) {
		String QUERY = "select * from t_ym_"+ta;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	public static int findlast(String ta) {
		String QUERY = "select * from t_ym_"+ta+" ORDER BY id DESC LIMIT 0,1 ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			//pstmt.setString(1, u1.hash);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return 0;
	}
	public static Block find(String ta,int x) {
		String QUERY = "select * from t_ym_"+ta+" where id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1,x);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Block(rs.getString("hash")
						,rs.getString("previousHash")
						,rs.getString("data")
						,rs.getString("timeStamp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTools.close(null, pstmt, null);
		}
		return new Block("0","0","0","2019-00-00 00:00:00");
	}
	public static int times(String ta) {
		int t=0;
		String QUERY = "select * from t_ym_"+ta;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				t++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTools.close(null, pstmt, null);
		}
		return t;
	}
	public static String all(String ta) {
		String t="";
		String QUERY = "select * from t_ym_"+ta;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				t=t+rs.getString("data");
			}
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return t;
	}
	public static Boolean isChainValid(String ta) {
		int x=findlast(ta);
		Block currentBlock;
		Block previousBlock;
		// 循环遍历区块链来检查hash值
		for (int i = 2; i <=x; i++) {
			currentBlock = find(ta,i);
			previousBlock = find(ta,i-1);
			
			// 比对hash值和计算的hash值
			if (currentBlock==null||!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal:"+i);
				return false;
			}
			// 比对前一个区块的hash值和previousHash值
			if (!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
	public boolean close() {
		if(conn!=null){
			DBTools.close(null, null, conn);
			return true;
		}
		return true;
	}
}
