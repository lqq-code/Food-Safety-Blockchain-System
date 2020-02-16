package edu.smxy.warehs;

import java.text.SimpleDateFormat;

import edu.smxy.blockchain.StringUtil;

public class Bag {
		private String data; //内容 md5 ta+length
		private String ta;  //存放的区块
		private int length;  //链长
		private String hash1;//存证标识FN+time+length
		private String hash2;//存证标识FN+time+length
		private String timedate; //存证时间
		public Bag(String ta, int length,String hash1,String hash2) {
			this.ta = ta;
			this.length = length;
				this.data =md5.getMD5(ta+length);
				this.timedate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				this.hash1=hash1;
				this.hash2=hash2;
		}
		public Bag(String data, String ta, int length, String hash1,String hash2,String timedate) {
			this.data = data;
			this.ta = ta;
			this.length = length;
			this.hash1 = hash1;
			this.hash2 = hash2;
			this.timedate = timedate;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getTa() {
			return ta;
		}
		public void setTa(String ta) {
			this.ta = ta;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public String getHash1() {
			return hash1;
		}
		public void setHash1(String hash1) {
			this.hash1 = hash1;
		}
		public String getHash2() {
			return hash2;
		}
		public void setHash2(String hash2) {
			this.hash2 = hash2;
		}
		public String getTimedate() {
			return timedate;
		}
		public void setTimedate(String timedate) {
			this.timedate = timedate;
		}
		
}
