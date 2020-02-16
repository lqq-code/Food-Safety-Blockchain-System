package edu.smxy.listener;

import java.net.DatagramSocket;
import java.net.SocketException;

import javax.servlet.ServletContext;

public class test {

	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
		int port=996;
		DatagramSocket socket=new DatagramSocket(port);
		System.out.println("接收端口初始化"+port);
        new FbsRecieveThread(socket).start();
       // new FileDownThread(999,"c:\\fbs\\").start();
        //分布式监听的作用，永久监听996 使用10086发送信号，999接收数据
		//new FbsSendThread("sendover#002").start();;

	}

}
