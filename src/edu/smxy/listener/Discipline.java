package edu.smxy.listener;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import edu.smxy.blockchain.BlockDao;

public class Discipline extends Thread{
	//所有的自律程序
	public void run(){
		//-----定义区域-----
			BlockDao dao=new BlockDao();
			File file;
			String myip="119.3.167.184";
		//-----
			 Timer timer = new Timer();
			 timer.schedule(new TimerTask() {
					public void run() {
						System.out.println("勤奋的检查员");
						//-------健步鸡数据完整检查---------
						String at[]={"001","002","003","004","005","006","007","008","123","311"};
						for(int i=0;i<at.length;i++){
							if(!dao.isChainValid(at[i]))
							{
								//---请求服务器的正确数据到本地---
								new FbsSendThread("fz#"+at[i]+"#"+myip).start();
								//new FbsSendThread("fz#"+at[i]+"#120.79.248.97").start();
								//---请求完就可以了------
							}
						}
					}
				}, 0, 1000*60*60);
			 //-------心跳数据库---
			 new dbThread().start();
			 //--------
	}

}
