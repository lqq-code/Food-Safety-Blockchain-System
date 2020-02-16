package edu.smxy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.smxy.user.*;
@WebServlet("/InfoPro")
public class InfoPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher ds;
    public InfoPro() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        session=request.getSession();
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String username=session.getAttribute("name").toString();
		String info=request.getParameter("info");
		String info2=request.getParameter("info2");
		Info tmp=new Info(username,info,info2);
		InfoDao dao=new InfoDao();
		if(!dao.queryByName(username)){
			dao.insert(tmp);
			System.out.print("插入成功");
			response.sendRedirect("./view/info.jsp");		
		}else{
			dao.updata(username, info,info2);
			System.out.print("更新成功");
			response.sendRedirect("./view/info.jsp");
			/*request.getRequestDispatcher("./view/login.jsp").forward(request, response);*/
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
