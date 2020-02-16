package edu.smxy.listener;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import edu.smxy.blockchain.BlockDao;
import edu.smxy.db.CMDUs;
import edu.smxy.user.UserDao;

public class GySendThread extends Thread {
	// UDPIp
	private String ServerIp = "115.29.240.46";
	private int port = 6000;
	private DatagramSocket socket;

	public GySendThread(DatagramSocket socket) {
		this.socket = socket;
	}

	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendExecute(socket, ServerIp, port);
	}

	public static void sendExecute(DatagramSocket socket, String ServerIp,
			int port) {
		try {
			File file;
			
			while (true) {
				String str = "xt";
				DatagramPacket datagramPacket = new DatagramPacket(
						str.getBytes(), str.getBytes().length,
						InetAddress.getByName(ServerIp), port);
				socket.send(datagramPacket);
				sleep(1000*10);
				//自检服务开始
				//查看所有的数据库,流程如下，10086最优请求，然后996收集所有的反馈数据，比较数据，请求最优
				/*String at[]={"001","002","003","004","005","006","007","008","123","311"};
				for(int i=0;i<at.length;i++){
					if(!dao.isChainValid(at[i]))
					{
						//false
						new FbsSendThread("fz#"+at[i]+"#134.175.82.83").start();
						new FbsSendThread("fz#"+at[i]+"#120.79.248.97").start();
						//sleep(1000 * 5); 两次验证了
						file=new File("c:/fbs/"+at[i]+".sql");
						if(file.exists()){  //这个是备用的可以不加
							CMDUs.inport("blockchain", file);
						}
					}
				}*/
				//事实上最主要的就是这里的自检处理发送程序
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
