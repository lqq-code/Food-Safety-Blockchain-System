package edu.smxy.listener;

import java.net.DatagramSocket;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Fbslistener implements ServletContextListener {
	public  static int port=996;
	public static ServletContext context = null;
	DatagramSocket socket;
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println(port+"端口服务结束!");
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
        	DatagramSocket socket=new DatagramSocket(port);
            System.out.println("接收端口初始化"+port);
            new FbsRecieveThread(socket).start();
            new FileDownThread(999,"c:\\fbs\\").start();
            //分布式监听的作用，永久监听996 使用10086发送信号，999接收数据
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
