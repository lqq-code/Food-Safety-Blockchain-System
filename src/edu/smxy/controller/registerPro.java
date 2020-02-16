package edu.smxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.smxy.user.*;
@WebServlet("/registerPro")
public class registerPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher ds;
    public registerPro() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User(username,password);
		UserDao dao=new UserDao();
		boolean flag=dao.queryByName(username);
		if(!flag){
			dao.insert(user);
			new InfoDao().insert(new Info(username,"#","#"));
			new AssetsDao().createTable(username);
			response.sendRedirect("./login.jsp");		
		}else{
			request.setAttribute("msg","11");
			response.sendRedirect("./register.jsp");	
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
