package edu.smxy.listener;

import java.io.*;
import java.net.*;
public class Gysendstr extends Thread {
	//作为发送接口使用
	private String str="xt";
	public Gysendstr(String str) {
		this.str=str;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendExecute(str);
	}
	public static void sendExecute(String str) {
		try {
			//System.out.println("开始发送");
			String ServerIp="115.29.240.46";
			 int port=6000;
			 DatagramSocket socket = Gysocket.getsocket();
			//发送一次就好
			 DatagramPacket datagramPacket = new DatagramPacket(
						str.getBytes(), str.getBytes().length,
						InetAddress.getByName(ServerIp), port);
			 socket.send(datagramPacket); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
