package edu.smxy.listener;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import edu.smxy.listener.dbThread;;
@WebListener
public class Gylistener implements ServletContextListener {
	 public static String ServerIp="115.29.240.46";
	 public  static int port=6000;
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("nb服务结束!");
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
        	String str="ep=PDTZZCL7C8MFTK4T&pw=123456";
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(ServerIp), port);
            DatagramSocket socket = Gysocket.getsocket();
            System.out.println("nb服务初始化");
            socket.send(datagramPacket);
            new GySendThread(socket).start();//发送心跳包
            new GyRecieveThread(socket).start();//接受数据包
          //  new Discipline().start();;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
