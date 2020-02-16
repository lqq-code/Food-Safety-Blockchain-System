package edu.smxy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AuthFilter implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		HttpServletResponse res=(HttpServletResponse)response;
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		//System.out.println("请求的URL为：" + url);
		if(url.endsWith(".css")||url.endsWith(".js")){
			arg2.doFilter(request, response);
		}else {
			if(session!=null&session.getAttribute("name")!=null){
				arg2.doFilter(request, response);
			}else{
				request.setAttribute("msg", "请先登录后查看或者输入正确的密码");
				req.getSession().setAttribute("tmpurl", req.getRequestURL()+"?"+req.getQueryString());
				System.out.println(req.getRequestURL());
				res.sendRedirect("../login.jsp");
				/*request.getRequestDispatcher("https://www.baidu.com/").forward(request, response);*/
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.print("过滤器初始化");
		
	}

}
