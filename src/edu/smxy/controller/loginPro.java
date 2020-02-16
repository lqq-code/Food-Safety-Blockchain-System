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
@WebServlet("/loginPro")
public class loginPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher ds;
    public loginPro() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        session=request.getSession();
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//String name = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println(name);
		User user=new User(username,password);
		UserDao dao=new UserDao();
		boolean flag=dao.checkLogin(user);
		if(flag){
			session.setAttribute("name", user.getUsername());
			response.sendRedirect("./view/index2.jsp");		
			/*request.getRequestDispatcher("./view/index.jsp").forward(request, response);*/
		}else{
			session.setAttribute("msg","erro");
			response.sendRedirect("./login.jsp");
			/*request.getRequestDispatcher("./view/login.jsp").forward(request, response);*/
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
