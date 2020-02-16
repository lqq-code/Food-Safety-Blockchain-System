package edu.smxy.listener;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Gysocket {
	private String ServerIp = "115.29.240.46";
	private static int port = 6000;
	static DatagramSocket socket=null;
	static{
		try {
			socket=new DatagramSocket(port);
			System.out.print("static 创建");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Gysocket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static DatagramSocket getsocket(){
		if(socket==null){
			try {
				socket=new DatagramSocket(port);
				System.out.print("get 创建");
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return  socket;
	}
}
