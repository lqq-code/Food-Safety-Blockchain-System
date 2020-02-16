<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.smxy.user.*,edu.smxy.blockchain.*,edu.smxy.info.i.*"%>
<%@ page import="edu.smxy.warehs.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健步鸡</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="viewport" content="initial-scale=1, user-scalable=0, minimal-ui">
<!-- Place favicon.ico in the root directory -->
<!-- all css here -->
<!-- bootstrap v3.3.6 css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate css -->
<link rel="stylesheet" href="css/animate.css">
<!-- jquery-ui.min css -->
<link rel="stylesheet" href="css/jquery-ui.min.css">
<!-- meanmenu css -->
<link rel="stylesheet" href="css/meanmenu.min.css">
<!-- owl.carousel css -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- bxslider css -->
<!--flaticon css -->
<link rel="stylesheet" href="css/flaticon.css">
<!-- font-awesome css -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<link href="css/video-js.css" rel="stylesheet">
<!-- style css -->
<link rel="stylesheet" href="style.css">
<!-- responsive css -->
<link rel="stylesheet" href="css/responsive.css">
<!-- modernizr css -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<% 
	//编号，品种产地入栏时间，日龄，总步数
	//http://134.175.82.83/walking/clients/sj.jsp?tname=001
	request.setCharacterEncoding("utf-8");
	String ta=request.getParameter("tname");
	//String Bta=md5.Base64Encode(ta);
	if(ta==null)
		ta="001";
	BlockDao dao=new BlockDao();
	//String ta="001";
	request.setAttribute("cd", new tinfoDao().query(ta));
	request.setAttribute("ts",dao.days(ta)/24);
	request.setAttribute("pk",dao.find(ta, 1).timeStamp.substring(0,10));
	request.setAttribute("zb",dao.allstep(ta));
	Block sl=dao.find(ta,1);
	Block wl=dao.find(ta, dao.findlast(ta));
	ymDao d=new ymDao();
	int ymt=3;
	Block ymb[]=new Block[ymt];
	for(int i=0;i<ymt;i++)
	{
		ymb[i]=d.find(ta, d.findlast(ta)-i);
	}
	
%>
<body>
<a href="javascript:" id="return-to-top"><i class="fa fa-angle-up"></i></a>
<!-- preloader Start -->
<div id="preloader">
	<div id="status"><img src="images/banner/loader.gif" id="preloader_image" alt="loader">
	</div>
</div>
<!--Header area start here-->
<div section-scroll='0' class="wd_scroll_wrap">
	<header >
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-6">
					<div class="logo-area">
						<img src="images/logo/logo1.png" alt="logo" class="logo1"/>
					</div>
				</div>
				<!-- Mobile Menu  Start -->
				<div class="col-lg-9 col-md-9 col-sm-12 col-xs-6">
					<div class="menu-area  hidden-xs">
						<nav class="wd_single_index_menu btc_main_menu">
							
						</nav>
						
						
					</div>
					<!-- mobile menu area start -->
					
						
					</div>
					<!-- Mobile Menu  End -->
				</div>
			</div>
		</div>
	</header>
	<!--Header area end here-->
	<!--Slider area start here-->
	<section class="slider-area">
		<canvas id="canvas">
			
		</canvas>
		<div id="particles-js">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<div class="carousel-captions caption-1">
							<div class="container">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="slider-content">
											<br>
											<h2 data-animation="animated bounceInLeft">健步鸡 </h2><br>
											<h4 data-animation="animated bounceInLeft">活龙鲜健，昂首阔步，蛋白鸡</h4>
											<div class="buttons">
												
												<a href="#" class="btn2" data-animation="animated bounceInUp">一键购买</a>
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 hidden-xs hidden-sm">
										<div class="btc_slider_about_img" data-animation="animated bounceInDown">
											<img src="images/about/1.png" alt="about_img">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
		</div>
	</section>
	<!--Slider area end here-->
	<section class="currency-area">
		<div class="container-fliud">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="rete-list bt_title wow  fadeIn animated" data-wow-duration="1.0s" style="visibility: visible; animation-duration: 1.0s; animation-name: fadeIn;">
						<div class="content">
							<div class="con">
								<img src="images/icons/k1.png" alt="k1" class="k1">
								<h1>NO.${cd.name}</h1>
								<h4>品种：${cd.pz}</h4>
								<h4>产地：${cd.cd}</h4>
								<h4>日龄：${ts}天</h4>
								<h4>入栏时间：${cd.rlsj}</h4>
							</div>
						</div>
					</div>
					<div class="rete-list bt_title wow  fadeIn animated" data-wow-duration="1.3s" style="visibility: visible; animation-duration: 1.3s; animation-name: fadeIn;">
						<div class="content">
							<div class="con">
								<img src="images/icons/k2.png" alt="k2" class="k2">
								<h3  class="birth">${pk}破蛋成功！</h3>
				
							</div>
						</div>
					</div>
					
					
					<div class="rete-list bt_title wow  fadeIn animated" data-wow-duration="1.3s" style="visibility: visible; animation-duration: 1.3s; animation-name: fadeIn;">
						<div class="content">
							<div class="con">
								<img src="images/icons/k3.png" alt="k2" class="k3">
								<h4  class="birth">兜兜转转我这一生，<font style='color: yellow'>${zb}</font>步传奇旅程</h4>
								<h4  class="birth">领略蓝天白云，品尝奇虫异草，叱咤鸡界</h4>
								<h4  class="birth">我是千娇百媚撩汉高手<h2>${cd.name}号小慧</h2></h4>
								

							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</section>
</div>
<div section-scroll='4' class="wd_scroll_wrap">
	<section class="steps-area section">
		<div id="steps-js">
			<div class="container">
				<div class="row">
					<div class="col-lg-11 col-md-11 col-sm-12 col-xs-12">
						<div class="steps-heading">
							<h2 class="wow  fadeIn animated" data-wow-duration="1.0s" style="visibility: visible; animation-duration: 1.0s; animation-name: fadeIn; ">我的疫苗史</h2>
							<div class="right-con">
								
								<a data-scroll data-options='{ "speed": 100 }' href="#steps"><i class="fa fa-angle-down"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="steps" class="steps-details bg-mg">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-md-offset-1 col-lg-offset-1">
					<div class="steps-cont">
						<ul>
							<li class="l-con">
								<div class="cont wow  fadeIn animated" data-wow-duration="1.0s" style="visibility: visible; animation-duration: 1.0s; animation-name: fadeIn;">
									<h2><%
										out.println(ymb[0].data);
									%></h2>
									<p> 
									<%
										out.println("接种时间：   "+ymb[0].timeStamp);
									%>
									</p>
								</div>
								<span><i class="fa fa-users"></i></span>
							</li>
							
							<li class="r-con">
								<div class="cont wow  fadeIn animated" data-wow-duration="1.9s" style="visibility: visible; animation-duration: 1.9s; animation-name: fadeIn;">
										<h2><%
										out.println(ymb[1].data);
									%></h2>
									<p> 
									<%
										out.println("接种时间："+ymb[1].timeStamp);
									%>
									</p>
								</div>
								<span><i class="fa fa-university"></i></span>
							</li>
							<li class="l-con">
								<div class="cont wow  fadeIn animated" data-wow-duration="2.1s" style="visibility: visible; animation-duration: 2.1s; animation-name: fadeIn;">
										<h2><%
										out.println(ymb[2].data);
									%></h2>
									<p> 
									<%
										out.println("接种时间："+ymb[2].timeStamp);
									%>
									</p>
								</div>
								<span><i class="fa fa-bell"></i></span>
							</li>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="sud">
		<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 1920 181.1" style="enable-background:new 0 0 1920 181.1;" xml:space="preserve">
			<style type="text/css">
				.st0 {
					fill-rule: evenodd;
					clip-rule: evenodd;
					fill: #10122d;
				}
			</style>
			<g>
				<path class="st0" d="M0,80c0,0,28.9-4.2,43-13c14.3-9,71-35.7,137,5c17.3,7.7,33.3,13,48,11c17.3,0.3,50.3,4.7,66,23
				 c20.3,9.7,68,40.3,134-12c24-11,59-16.3,104,2c21,7.3,85,27.7,117-14c24-30.7,62.7-55,141-12c26,10.3,72,14.7,110-14
				 c37.7-19,89.7-29,122,53c23,32.7,47.7,66.3,97,26c24-22.7,51-78.3,137-38c0,0,28.3,15.7,52,15c23.7-0.7,50.7,4.3,76,41
				 c19.7,19.7,71,36.7,121-2c0,0,22.3-16,55-12c0,0,32.7,6.7,56-71c23.3-76,79-92,122-29c9.3,13.7,25,42,62,43c37,1,51.7,25.3,67,48
				 c15.3,22.7,51,22.7,53,23v28.1H0V80z" />
			</g>
		</svg>
	</div>
</div>
	
</div>
<div section-scroll='6' class="wd_scroll_wrap">
	<section class="tokens-area section">
		<div id="token-js">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="section-heading2">
							<h2 class="wow  fadeIn animated" data-wow-duration="1.0s" style="visibility: visible; animation-duration: 1.0s; animation-name: fadeIn;">我的区块链码</h2>
						</div>
					</div>
					<div class="col-lg-10 col-md-9 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right wow  fadeIn animated" data-wow-duration="1.3s" style="visibility: visible; animation-duration: 1.3s; animation-name: fadeIn;">
							<div class="tokens mr-l50">
								<div class="token-name">链头</div>
								
								<div class="token-body">
									hash值:
									<br>
									<div>
									<p style="word-break:break-word;">
											<%
											out.print(sl.hash);
											%>
									</div>
									<br>
									步数：<br>
									<button class="left-btn">
										<%
											out.print(sl.data);
										%>步
									</button>
									<br><br>
									记录时间：<br>
									<button class="left-btn">
										<%
											out.print(sl.timeStamp.substring(0,10));
										%>
									</button>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right wow  fadeIn animated" data-wow-duration="1.6s" style="visibility: visible; animation-duration: 1.6s; animation-name: fadeIn;">
							<div class="tokens mr-r50">
								<div class="token-name">链尾</div>
								<div class="token-body">
									hash值:
									<br>
									<div>
									<p style="word-break:break-word;">
											<%
											out.print(wl.hash);
											%>
									</div>
									<br>
									步数：<br>
									<button class="left-btn">
										<%
											out.print(wl.data);
										%>步
									</button>
									<br><br>
									记录时间：<br>
									<button class="left-btn">
										<%
											out.print(wl.timeStamp.substring(0,10));
										%>
									</button>
								</div>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
							<h5>你可以复制上面的链尾，去我们的验证平台查询哦！</h5>
							<a href="kk.jsp" class="btn2">去查询我的区块链</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
</div>
		<div id="clockdiv">
								<span class="days"></span>		
								<span class="hours"></span>							
								<span class="minutes"></span>
								<span class="seconds"></span>		
		</div>
			
<!--Footer area end here-->
<!-- all js here -->
<!-- jquery latest version -->
<script src="js/vendor/jquery-3.2.1.min.js"></script>
<!-- tether js -->
<script src="js/tether.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- owl.carousel js -->
<script src="js/owl.carousel.min.js"></script>
<!-- meanmenu js -->
<script src="js/jquery.meanmenu.js"></script>
<!-- jquery-ui js -->
<script src="js/jquery-ui.min.js"></script>
<!-- easypiechart js -->
<script src="js/jquery.easypiechart.min.js"></script>
<!-- particles js -->
<!-- wow js -->
<script src="js/wow.min.js"></script>
<!-- smooth-scroll js -->
<script src="js/smooth-scroll.min.js"></script>
<!-- plugins js -->
<script src="js/plugins.js"></script>
<!-- EChartJS JavaScript -->
<script src="js/echarts-en.min.js"></script>
<script src="js/echarts-liquidfill.min.js"></script>
<script src="js/vc_round_chart.min.js"></script>
<script src="js/videojs-ie8.min.js"></script>
<script src="js/video.js"></script>
<!---<script src="js/Youtube.min.js"></script>--->
<!-- main js -->
<script src="js/main.js"></script>

</body>
</html>
