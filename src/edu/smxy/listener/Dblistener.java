package edu.smxy.listener;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import edu.smxy.listener.dbThread;;
@WebListener
public class Dblistener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
