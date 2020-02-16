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

import edu.smxy.blockchain.BlockDao;
import edu.smxy.warehs.WareHs;

@WebServlet("/WarePro")
public class WarePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher ds;
    public WarePro() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        session=request.getSession();
        
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String ta=request.getParameter("ta");
		String mi=request.getParameter("mi");
		ta=new String(ta.getBytes("ISO-8859-1"),"UTF-8");
		if(ta!=null&&"FN".equals(mi)){
			System.out.println("开始处理"+ta);
			BlockDao d=new BlockDao();
			String hash1=d.find(ta, 1).hash;
			int length=d.findlast(ta);
			String hash2=d.find(ta, length).hash;
			new WareHs(ta,length,hash1,hash2).start();
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
