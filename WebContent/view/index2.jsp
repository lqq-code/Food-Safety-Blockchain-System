<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.smxy.user.*,edu.smxy.blockchain.*,edu.smxy.listener.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健步鸡-活龙鲜健，昂首阔步，蛋白鸡</title>
<link rel="stylesheet"
	href="vendor/simple-line-icons/css/simple-line-icons.css">
<link rel="stylesheet"
	href="vendor/font-awesome/css/fontawesome-all.min.css">

<link rel="stylesheet" href="css/styles.css">
</head>

<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<nav class="navbar page-header">
			<a href="#"
				class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto"> <i
				class="fa fa-bars"></i>
			</a> <a class="navbar-brand" href="#"> <img src="imgs/l1.png"
				alt="logo">
			</a> <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
				<i class="fa fa-bars"></i>
			</a>

			<ul class="navbar-nav ml-auto">
			
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img src="imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
						<span class="small ml-1 d-md-down-none">${name}</span>
				</a>

					<div class="dropdown-menu dropdown-menu-right">
						<div class="dropdown-header">Account</div>

						<a href="#" class="dropdown-item"> <i class="fa fa-user"></i>
							Profile
						</a> <a href="#" class="dropdown-item"> <i class="fa fa-envelope"></i>
							Messages
						</a>

						<div class="dropdown-header">Settings</div>

						<a href="#" class="dropdown-item"> <i class="fa fa-bell"></i>
							Notifications
						</a> <a href="#" class="dropdown-item"> <i class="fa fa-wrench"></i>
							Settings
						</a> <a href="yz_loginout.jsp" class="dropdown-item"> <i class="fa fa-lock"></i>
							Logout
						</a>
					</div></li>
			</ul>
		</nav>

		<div class="main-container">
			<div class="sidebar">
				<nav class="sidebar-nav">
					<ul class="nav">
						<li class="nav-title">活龙鲜健，昂首阔步，蛋白鸡</li>

						<li class="nav-item"><a href="index2.jsp"
							class="nav-link active"> <i class="icon icon-speedometer"></i>
								概况
						</a></li>

						<li class="nav-item nav-dropdown"><a href="#"
							class="nav-link nav-dropdown-toggle"> <i
								class="icon icon-target"></i> 吃鸡成长史 <i class="fa fa-caret-left"></i>
						</a>

							<ul class="nav-dropdown-items">
								<li class="nav-item"><a href="layouts-normal.jsp"
									class="nav-link"> <i class="icon icon-target"></i> 解锁等级
								</a></li>


							</ul></li>

						<li class="nav-item nav-dropdown"><a href="#"
							class="nav-link nav-dropdown-toggle"> <i
								class="icon icon-energy"></i> 热销排行榜<i class="fa fa-caret-left"></i>
						</a>

							<ul class="nav-dropdown-items">

								<li class="nav-item"><a href="progress-bars.jsp"
									class="nav-link"> <i class="icon icon-energy"></i> 最受欢迎的鸡
								</a></li>

								<li class="nav-item"><a href="widgets.jsp"
									class="nav-link"> <i class="icon icon-energy"></i> 大众数据
								</a></li>
							</ul></li>

						<li class="nav-item nav-dropdown"><a href="#"
							class="nav-link nav-dropdown-toggle"> <i
								class="icon icon-graph"></i> 大数据 <i class="fa fa-caret-left"></i>
						</a>

							<ul class="nav-dropdown-items">
								<li class="nav-item"><a href="chartjs.jsp"
									class="nav-link"> <i class="icon icon-graph"></i> 健步鸡数据分析
								</a></li>
							</ul></li>


						<li class="nav-item"><a href="tables.jsp" class="nav-link">
								<i class="icon icon-grid"></i> 今日健步鸡王
						</a></li>

						<li class="nav-title">更多</li>

						<li class="nav-item nav-dropdown"><a href="#"
							class="nav-link nav-dropdown-toggle"> <i
								class="icon icon-umbrella"></i>功能正在开发 <i
								class="fa fa-caret-left"></i>
						</a>
							<ul class="nav-dropdown-items">
								<li class="nav-item"><a href="404.html" class="nav-link">
										<i class="icon icon-umbrella"></i> 404
								</a></li>

								<li class="nav-item"><a href="500.html" class="nav-link">
										<i class="icon icon-umbrella"></i> 500
								</a></li>

								<li class="nav-item"><a href="settings.html"
									class="nav-link"> <i class="icon icon-umbrella"></i>
										设置
								</a></li>
							
					</ul>
				</nav>
			</div>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<div class="card p-4">
								<div
									class="card-body d-flex justify-content-between align-items-center">
									<div>
									<span class="h7 d-block font-weight-normal mb-2">鸡舍环境</span> <span
											class="font-weight-light"></span>
										<span class="h6 d-block font-weight-normal mb-2">温度：20°C</span> <span
											class="font-weight-light"></span>
											<span class="h6 d-block font-weight-normal mb-2">湿度：60%</span> <span
											class="font-weight-light"></span>
									</div>

									<div class="h2 text-muted">
									
										<img src="imgs/wendu.png" class="avatar avatar-sm" alt="logo">
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-4">
								<div
									class="card-body d-flex justify-content-between align-items-center">
									<div>
										<span class="h7 d-block font-weight-normal mb-2">入栏信息</span> <span
											class="font-weight-light"></span>
										<span class="h6 d-block font-weight-normal mb-2">公鸡：3只</span> <span
											class="font-weight-light"></span>
											<span class="h6 d-block font-weight-normal mb-2">母鸡：3只</span> <span
											class="font-weight-light"></span>
											
									</div>

									<div class="h2 text-muted">
										
										<img src="imgs/rulang.png" class="avatar avatar-sm" alt="logo">
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-4">
								<div
									class="card-body d-flex justify-content-between align-items-center">
									<div>
										<span class="h7 d-block font-weight-normal mb-2">下单数量</span> <span
											class="font-weight-light"></span>
										<span class="h6 d-block font-weight-normal mb-2">今日订单：0</span> <span
											class="font-weight-light"></span>
											<span class="h6 d-block font-weight-normal mb-2">历史订单：1</span> <span
											class="font-weight-light"></span>
									</div>

									<div class="h2 text-muted">
											<img src="imgs/gouwuche.png" class="avatar avatar-sm" alt="logo">
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-4">
								<div14
									class="card-body d-flex justify-content-between align-items-center">
									<div>
										<span class="h7 d-block font-weight-normal mb-2">关注人数</span> <span
											class="font-weight-light"></span>
										<span class="h6 d-block font-weight-normal mb-2">总人数：66</span> <span
											class="font-weight-light"></span>
										 <br>
									</div>

									<div class="h2 text-muted">
										<img src="imgs/yonghu.png" class="avatar avatar-sm" alt="logo">
									</div>
								</div>
							</div>
						</div>
					</div>
 						
					<div class="row ">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">当前账户下的鸡</div>

								<div class="card-body p-0">
									<div class="p-4">
<%
	AssetsDao da=new AssetsDao();
	BlockDao dao=new BlockDao();
	String name=session.getAttribute("name").toString();
	String b[]=da.query(name,20);
	
%>
<table width="100%" border="2" >
         <tr>
	         <th  style="text-align:center">鸡的编号</th>
	         <th  style="text-align:center">最新的步数</th>
	         <th style="text-align:center">计步天数</th>
	         <th style="text-align:center">总步数</th>
	         <th  style="text-align:center">平均步数</th>
	         <th style="text-align:center">数据是否正常</th>
	     	 
         </tr>
         <%
         for(int i=0;i<10;i++){
        	 if(b[i]!="0"){
        		 //jj 编号
	    		 out.print("<tr  style='text-align:center' >");
	    		 out.print("<td class='st'>");
	    		 out.print(""+"<a href=\"chartjs.jsp?tname="+b[i]+"\">"+b[i]+"</a>" );
        		 out.print("</td>");
        		 //鸡 当天步数
        		 out.print("<td>");
        		 out.print(""+dao.find(b[i], dao.findlast(b[i])).data);
        		 out.print("<br>(<font size='1' color='red'> "+dao.find(b[i], dao.findlast(b[i])).timeStamp.substring(0,16)+"</font>)");
        		 out.print("</td>");	 
	        	 //鸡计步天数
	        	 out.print("<td >");
	        	 int days=dao.days(b[i]);
	        	 out.print(days);
        		 out.print("</td>");	
	        	 //总步数
	        	  out.print("<td>");
	        	 int allstep=dao.allstep(b[i]);
	        	 out.print(""+allstep);
        		 out.print("</td>");	
	        	 //平均步数
	        	 out.print("<td>");
	        	 double av=(double)allstep/days;
	        	 String m = new java.text.DecimalFormat("#0.00").format(av);
	        	 if(days==0) out.print("0");
	        	 else out.print(m);
        		 out.print("</td>");	
	        	 //是否被更改
	        	 out.print("<td>");
	        	 out.print(dao.isChainValid(b[i]));
	        	 if(!dao.isChainValid(b[i])){
	        		 String myip="119.3.167.184";
	        		 new FbsSendThread("fz#"+b[i]+"#"+myip).start();
	        	 }
        		 out.print("</td>");	
	        	 out.print("</tr>");
    		 }
         }
        	 %>
        	
          </table>		
					
									</div>
								</div>
							</div>
							
							<div class="card1">
								<div class="card-header1">
								<img src="imgs/j1.png" class="avatar avatar-j1" alt="logo" > 
								<img src="imgs/j2.png" class="avatar avatar-j2" alt="logo" > 
								<img src="imgs/j3.png" class="avatar avatar-j3" alt="logo" > 
								<img src="imgs/j4.png" class="avatar avatar-j4" alt="logo" > 
								<img src="imgs/j5.png" class="avatar avatar-j5" alt="logo" > 
								<img src="imgs/j6.png" class="avatar avatar-j6" alt="logo" > 
								<img src="imgs/j7.png" class="avatar avatar-j7" alt="logo" > 
								<img src="imgs/j8.png" class="avatar avatar-j8" alt="logo" > 
								</div>
								</div>
						</div>
						

					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="row ">
						<div class="col-md-12">
							</div>
						</div>
	<script src="./vendor/jquery/jquery.min.js"></script>
	<script src="./vendor/popper.js/popper.min.js"></script>
	<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="./vendor/chart.js/chart.min.js"></script>
	<script src="./js/carbon.js"></script>
	<script src="./js/demo.js"></script>
</body>
</html>
