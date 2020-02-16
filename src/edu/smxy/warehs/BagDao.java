package edu.smxy.warehs;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.*;

import edu.smxy.db.*;
import edu.smxy.listener.FbsSendThread;

public class BagDao {
	static Connection conn = DBTools.getConnectionFromPool();
	public boolean createTable() {
		String CREATE_TABLE = "create table if not exists BlockChain"
				+ "(data varchar(100)," + "ta varchar(100),"
				+ "length int(20)," + "hash1 varchar(100)," +"hash2 varchar(100)," 
				+ "timedate varchar(100))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(CREATE_TABLE);
			int n = pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(Bag bag) {
		if(find(bag.getTa()))
		{
			return;
		}
		String INSERT = "insert into BlockChain"
				+ "(data,ta,length,hash1,hash2,timedate)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bag.getData());
			pstmt.setString(2, bag.getTa());
			pstmt.setInt(3, bag.getLength());
			pstmt.setString(4,bag.getHash1());
			pstmt.setString(5,bag.getHash2());
			pstmt.setString(6, bag.getTimedate());
			if (!checkta())
				createTable();
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println(bag.getTa()+"入库成功");
				new FbsSendThread("Ware#"+bag.getData()+"#"
						+bag.getTa()+"#"+bag.getLength()+"#"+bag.getHash1()+"#"+bag.getHash2()+"#"+bag.getTimedate()).start();
						//数据插入成功通知其他服务器
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkta() {
		String QUERY = "select * from BlockChain";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}
	public static Bag find(String hash1,String hash2) {
		String QUERY = "select * from BlockChain where hash1=? and hash2=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, hash1);
			pstmt.setString(2, hash2);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Bag(rs.getString("data"),
						rs.getString("ta"), rs.getInt("length"),rs.getString("hash1"),rs.getString("hash2"),
						rs.getString("timedate"));
			}
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Bag find2(String hash2) {
		String QUERY = "select * from BlockChain where hash2=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, hash2);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Bag(rs.getString("data"),
						rs.getString("ta"), rs.getInt("length"),rs.getString("hash1"),rs.getString("hash2"),
						rs.getString("timedate"));
			}
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean find(String ta) {
		String QUERY = "select * from BlockChain where ta=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setString(1, ta);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static int days(String ta) {
		int t = 0;
		String QUERY = "select * from BlockChain";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				t++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DBTools.close(null, pstmt, conn);
		}
		return t;
	}
	public boolean close() {
		if(conn!=null){
			DBTools.close(null, null, conn);
			return true;
		}
		return true;
	}
}
