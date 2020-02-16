package edu.smxy.blockchain;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.*;

import edu.smxy.db.*;
import edu.smxy.info.i.ymDao;
import edu.smxy.listener.FbsSendThread;
//import edu.smxy.warehs.BagDao;
import edu.smxy.warehs.BagDao;

public class BlockDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public boolean createTable(String ta){
		if(ta==""||ta==null)
			return false;
		String CREATE_TABLE=
	"create table if not exists t_"
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
		
			new ymDao().createTable(ta);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.close(null, pstmt, null);
		}
		return false;
	}
	public void insert(String ta,Block block) {
		if(new BagDao().find(ta)){
			return;
		}
		String INSERT = "insert into t_"+ta+"(hash,previousHash,data,timeStamp) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			//pstmt.setString(1, ta);
			pstmt.setString(1, block.hash);
			pstmt.setString(2, block.previousHash);
			pstmt.setString(3, block.data);
			pstmt.setString(4, block.timeStamp);
			if(!checkta(ta))
	        	createTable(ta);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println(ta+"数据添加成功");
				new FbsSendThread(5+"#"+ta+"#"
				+block.hash+"#"+block.previousHash+"#"+block.data+"#"+block.timeStamp).start();
				//数据插入成功通知其他服务器
			}else{
				System.out.println(ta+"数据添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBTools.close(null, pstmt, null);
		}
	}
	public void updata(String ta,int id,Block block) {
		String INSERT = "update t_"+ta+" set hash=?,previousHash=?,data=?,timeStamp=? where id=?";
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
		String QUERY = "select * from t_"+ta;
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
		String QUERY = "select * from t_"+ta+" ORDER BY id DESC LIMIT 0,1 ";
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
		String QUERY = "select * from t_"+ta+" where id=?";
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
	
	public static int days(String ta) {
		int t=0;
		String QUERY = "select * from t_"+ta;
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
		}finally {
			DBTools.close(null, pstmt, null);
		}
		return t;
	}
	public static int allstep(String ta) {
		int t=0;
		String QUERY = "select * from t_"+ta;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				t=t+rs.getInt("data");
			}
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTools.close(null, pstmt, null);
		}
		return t;
	}
	public static Boolean isChainValid(String ta) {
		int x=findlast(ta);
		Block currentBlock;
		Block previousBlock;
		// 循环遍历区块链来检查hash值
		if(x>=2){
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
		}
		else if(x==1){
			currentBlock = find(ta,1);
			if (currentBlock==null||!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal:"+1);
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
