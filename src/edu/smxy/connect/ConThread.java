package edu.smxy.connect;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;
//




import edu.smxy.blockchain.BlockDao;
import edu.smxy.user.AssetsDao;
import edu.smxy.user.User;
import edu.smxy.user.UserDao;

public class ConThread extends Thread {
		public void run(){
			System.out.println("进入监听线程");
			Timer timer = new Timer();
			System.out.println("创建定时器");
			timer.schedule(new TimerTask(){
				@Override
				public void run() {
					System.out.println("开始尝试访问");
					//流程开始1、登录
					new UserDao().checkLogin(new User("username","pass"));
					//列表
					new AssetsDao().query("name",20);;
					new BlockDao().find("ta", 5);
				}}, 0,1000*60*20);
		}
}
