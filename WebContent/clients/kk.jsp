<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.smxy.warehs.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健步鸡</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="viewport"
	content="initial-scale=1, user-scalable=0, minimal-ui">
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

<body>

	<a href="javascript:" id="return-to-top"><i class="fa fa-angle-up"></i></a>
	<!-- preloader Start -->
	<div id="preloader">
		<div id="status">
			<img src="images/banner/loader.gif" id="preloader_image" alt="loader">
		</div>
	</div>
	<!--Header area start here-->

	<%
		request.setCharacterEncoding("utf-8");
		String ta2 = request.getParameter("ta2");
		String msg ="未在链上查询到信息！";
		Bag bag = null;
		if (ta2 != null) {
			BagDao dao = new BagDao();
			bag = dao.find2(ta2);
			if(bag!=null){
				msg = "查询成功";
				request.setAttribute("bg", bag);
			}
			else{
				msg ="未在链上查询到信息！";
			}
		}
		
	%>
	<script type="text/javascript">
		var ta= "<%=ta2%>";
		if(ta!="null"){
			alert("<%=msg%>");
		}
	</script>
	<div section-scroll='6' class="wd_scroll_wrap">
		<section class="tokens-area section">
		<div id="token-js">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="section-heading2">
							<h2 class="wow  fadeIn animated" data-wow-duration="1.0s"
								style="visibility: visible; animation-duration: 1.0s; animation-name: fadeIn;">健步鸡区块链验证</h2>
						</div>
					</div>
					<div
						class="col-lg-10 col-md-9 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1">

						<form action="kk.jsp" method="post" class="login-form">
							<!-- <div
								class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right wow  fadeIn animated"
								data-wow-duration="1.3s"
								style="visibility: visible; animation-duration: 1.3s; animation-name: fadeIn;">
								<div class="tokens mr-l50">
									<div class="token-name">链头</div>
									<input type="text" name="ta1" placeholder="粘贴首码到此处">
								</div>
							</div>
							<br> -->
							<div
								class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right wow  fadeIn animated"
								data-wow-duration="1.6s"
								style="visibility: visible; animation-duration: 1.6s; animation-name: fadeIn;">
								<div class="tokens mr-r50">
									<div class="token-name">链尾</div>
									<input type="text" name="ta2" placeholder="粘贴尾码到此处"> <br>
									<br> <br>
									<button type="submit" class="btn2">立即查询</button>
									<br>
									
									查询成功后请注意核对你的链首码！
								</div>
							</div>
					</form>
					
							<!--  -->
							<div
								class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right wow  fadeIn animated"
								data-wow-duration="1.6s"
								style="visibility: visible; animation-duration: 1.6s; animation-name: fadeIn;">
								<div class="tokens mr-r50">
									<div class="token-name">链首</div>
									
									<div class="token-body2">
									
										<p style="word-break: break-word;">${bg.hash1}</p>
									</div>
								
									<div class="token-name">存证内容</div>
									<div class="token-body2">
										<p style="word-break: break-word;">${bg.data}</p>
									</div>
									<div class="token-name">所在区块</div>
									<div class="token-body2">
										<p style="word-break: break-word;">${bg.ta}</p>
									</div>

									<div class="token-name">存证标识</div>
									<div class="token-body2">
										<p style="word-break: break-word;">${bg.hash2}</p>
										<p></p>
									</div>

									<div class="token-name">存证时间</div>
									<div class="token-body2">
										<p style="word-break: break-word;">${bg.timedate}</p>
									</div>
								</div>
							</div>
							<!--mi  -->
					





					</div>
				</div>
			</div>
		</div>
		</section>


	</div>
	<div id="clockdiv">
		<span class="days"></span> <span class="hours"></span> <span
			class="minutes"></span> <span class="seconds"></span>
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
