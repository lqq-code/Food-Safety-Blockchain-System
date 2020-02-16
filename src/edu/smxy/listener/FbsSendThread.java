package edu.smxy.listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import edu.smxy.user.UserDao;
//更新使用的线程同步，被调用使用
public class FbsSendThread extends Thread {
	private String ServerIp[] = {"192.168.1.106","120.79.248.97","192.168.1.128"
			,"192.168.43.183"
			};//发送数据到指定服务器  120.79.248.97
	//119.3.167.184   
	private int port = 10086;
	private static String strs="";
	private static DatagramSocket socket;
	public FbsSendThread(String strs) {
		this.strs=strs;
	}
	public void setSocket(String strs) {
		this.strs=strs;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sendExecute(ServerIp, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void sendExecute(String ServerIp[],
			int port) throws IOException {
		socket=new DatagramSocket();//建立udp的服务对象
		try {
		        //准备数据。
		        String sdata =  "mi:"+strs;
		        //-----------------创建了一个数据流,对数据的处理---------------
		        ByteArrayOutputStream ostream = new ByteArrayOutputStream();  
		        DataOutputStream dataStream = new DataOutputStream(ostream);  
		        dataStream.writeUTF(sdata);  
		        dataStream.close();  
		        byte[] data = ostream.toByteArray();  
		        
		        //-----------------对数据发送前的处理结束---------------------------
		        //定义发送的端口
		  
		    	//定义循环发送
		    	DatagramPacket datagramPacket;
				for(int i=0;i<ServerIp.length;i++){
					datagramPacket = new DatagramPacket(data, data.length,InetAddress.getByName(ServerIp[i]),port);
					socket.send(datagramPacket);
					System.out.println(ServerIp[i]+"发送结束"+port);
				}
				//关闭流，用了再新建
				socket.close();
				//System.out.println("发送的一次");
				return;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
