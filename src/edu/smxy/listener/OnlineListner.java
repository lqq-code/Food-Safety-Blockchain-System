package edu.smxy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListner implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {
	ServletContext sc;
    public OnlineListner() {
        // TODO Auto-generated constructor stub
    }
    public void sessionCreated(HttpSessionEvent arg0) {
    	System.out.println("-----sessionCreated--------");
    	int online=(Integer) sc.getAttribute("online");
    	online++;
    	sc.setAttribute("online", online);
    }
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	int online=(Integer) sc.getAttribute("online");
    	online--;
    	sc.setAttribute("online", online);
    }
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    public void attributeAdded(HttpSessionBindingEvent arg0) {
    }
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    }
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
    }
    public void attributeAdded(ServletContextAttributeEvent arg0) {
    	System.out.println("-----context--------"+arg0.getName()+":"+arg0.getValue());
    }
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
    }
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    	System.out.println("-----context--------"+arg0.getName()+":"+arg0.getValue());
    }
    public void contextInitialized(ServletContextEvent arg0) {
    	System.out.println("-----contextInitialized--------");
        sc=arg0.getServletContext();
        sc.setAttribute("online", 0);
    }
}
