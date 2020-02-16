package edu.smxy.listener;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

import edu.smxy.blockchain.Block;
import edu.smxy.blockchain.BlockDao;
import edu.smxy.info.i.tinfoDao;
import edu.smxy.info.i.ymDao;
import edu.smxy.user.AssetsDao;
import edu.smxy.user.UserDao;

public class dbThread extends Thread {
		public void run(){
			System.out.println("数据库开始保持通畅");
				 Timer timer = new Timer();
				 timer.schedule(new TimerTask() {
					 	UserDao dao=new UserDao();
						AssetsDao dao1=new AssetsDao();
						BlockDao dao2=new BlockDao();
						tinfoDao dao3=new tinfoDao();
						ymDao dao4=new ymDao();
						
						public void run() {
						 	dao.queryByName("健步鸡");
							dao2.checkta("123");
							dao1.query("123",1);
							dao3.query("001");
							dao4.find("123", 1);
							System.out.println("数据库通畅");
						}
					}, 0, 1000 * 60*60);
		}
}
