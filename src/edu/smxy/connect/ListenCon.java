package edu.smxy.connect;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenCon implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
        	System.out.println("准备连接监听");
            new ConThread().start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
