<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="edu.smxy.warehs.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>防伪查询</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	request.setAttribute("msg", "msgasdhjlash");
	String msg="dassd";
    session.setAttribute("weekt","weekt");
    
%>

<script type="text/javascript">
	 var tmp="<%=msg%>";
		alert("你好"+tmp);
</script>
	hello
	${msg}
</body>
</html>