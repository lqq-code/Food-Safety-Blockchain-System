<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.smxy.user.*,edu.smxy.blockchain.*"%>
    <%@page import="edu.smxy.info.i.*"%>
    <%@page import="edu.smxy.api.*,java.util.Map"%>
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

<%
 	request.setCharacterEncoding("utf-8");
	String ta=request.getParameter("tname");
	if(ta==null)
		ta="001";
	BlockDao dao=new BlockDao();
	int id=dao.findlast(ta);
	String day="["; 	
	String dayt="["; 
	String week="["; 	
	String weekt="["; 
	String time="";
	for(int i=id-24;i<=id;i++){
		day=day+dao.find(ta, i).data+",";
		dayt=dayt+"'"+dao.find(ta, i).timeStamp.substring(10,16)+"'"+",";
	}
	day=day+dao.find(ta,id).data+"]";
	dayt=dayt+"'"+dao.find(ta,id).timeStamp.substring(10,16)+"']";

	
	for(int i=id-24*7;i<=id;i++){
		week=week+dao.find(ta, i).data+",";
		weekt=weekt+"'"+dao.find(ta, i).timeStamp.substring(0,10)+"'"+",";
	}
	week=week+dao.find(ta,id).data+"]";
	weekt=weekt+"'"+dao.find(ta,id).timeStamp.substring(0,10)+"']";
	time=dao.find(ta, id).timeStamp.substring(0,10);
	
    session.setAttribute("day",day);
    session.setAttribute("dayt",dayt);
    session.setAttribute("week",week);
    session.setAttribute("weekt",weekt);
    
    session.setAttribute("time",time);  
	tinfoDao d=new tinfoDao();
	request.setAttribute("cd", d.query(ta));
	 Map<String, String> map = LocationUtil.getLatitude(d.query(ta).getCd());
	 if (null != map) {
    	 session.setAttribute("dtx",map.get("lng").toString());
         session.setAttribute("dty",map.get("lat").toString()); 
       
        
	 } 
     
%>



<div class="page-wrapper">
   <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="#">
        
            <img src="imgs/logo.png" alt="logo">
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">

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

						<li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 吃鸡成长史 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="layouts-normal.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 解锁等级
                                </a>
                            </li>

                  
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-energy"></i> 热销排行榜<i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                      
                            <li class="nav-item">
                                <a href="progress-bars.jsp" class="nav-link">
                                    <i class="icon icon-energy"></i> 最受欢迎的鸡
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="widgets.html" class="nav-link">
                                    <i class="icon icon-energy"></i> 大众数据
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-graph"></i> 大数据 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="chartjs.jsp" class="nav-link">
                                    <i class="icon icon-graph"></i> 健步鸡数据分析
                                </a>
                            </li>
                        </ul>
                    </li>

                  
                    <li class="nav-item">
                        <a href="tables.jsp" class="nav-link">
                            <i class="icon icon-grid"></i> 今日健步鸡王
                        </a>
                    </li>

                    <li class="nav-title">More</li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="blank.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Blank Page
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="login.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="register.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Register
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="invoice.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Invoice
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="404.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 404
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="500.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 500
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="settings.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Settings
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        
        <div class="content">
        
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                                                  最近24小时步数总览（ ${time}）
                        </div>

                        <div class="card-body" >
					
					  <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
                          <div id="day" style="height:400px"></div>
<script type="text/javascript">
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('day'));
          
            var option = {
                    title : {
                        text: '最新一天24小时',
                        subtext: '健步鸡'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['步数']
                    },
                    toolbox: {
                        show : false,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ${dayt}
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'步数',
                            type:'line',
                            data: ${day},
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
            }
            myChart.setOption(option);
        }
    );
</script>

                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                            本星期步数总览
                        </div>

                        <div class="card-body">
                         <div id="week" style="height:400px"></div>
<script type="text/javascript">
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('week'));
          
            var option = {
                    title : {
                        text: '最新一周的数据，7天（24*7）',
                        subtext: '健步鸡'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['步数']
                    },
                    toolbox: {
                        show : false,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ${weekt}
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'步数',
                            type:'line',
                            data: ${week},
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
            }
            myChart.setOption(option);
        }
    );
</script>

                           <!--  <canvas id="line-chart" width="100%" height="50"></canvas> -->
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                          ${cd.name}的详细信息如下：
                        </div>
                        <div class="card-body">
							 <div id = "ak">
								鸡的编号：${cd.name}
								<br>品种：${cd.pz}
								<br>入栏时间：${cd.rlsj}
								<br>产地：${cd.cd}
							</div>
							 <div id = "main"><div id = "allmap"></div></div>
                        </div>
                        
                           <style type="text/css">
							#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
							#main {width: 400px;height: 400px;overflow: hidden;margin:0;}
							#ak {width: 400px;float:left}
							</style>
                           <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=FzdF4AijYkFqv9jt5Q7znT4hhmCg4EzG"></script>
                           <script type="text/javascript">
								var map = new BMap.Map("allmap");
								var tx=${dtx}
								var ty=${dty}
								
								var dux = parseFloat(tx).toFixed(6);
								var duy = parseFloat(ty).toFixed(6);
								map.centerAndZoom(new BMap.Point(dux,duy),15);//根据坐标初始化地图
								map.enableScrollWheelZoom(true);
								map.addControl(new BMap.NavigationControl()); //平移缩放控件
								map.addControl(new BMap.ScaleControl()); //比例尺
								map.addControl(new BMap.OverviewMapControl()); //缩略地图
								map.addControl(new BMap.MapTypeControl()); //地图类型
								map.setCurrentCity("三明"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用
								var marker = new BMap.Marker(new BMap.Point(120.378386,30.309756)); // 创建标注
								map.addOverlay(marker); // 将标注添加到地图中
							</script>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                           	  ${cd.name}的疫苗信息：
                        </div>

                        <div class="card-body">
                            <% 
									ymDao dy=new ymDao();
									String[] b=new String[dy.findlast(ta)];
									for(int i=1;i<= b.length;i++)
									{
										out.print("<br>事件："+dy.find(ta, i).data+" - - - - - - 记录时间："+dy.find(ta, i).timeStamp.substring(0,16));
									}
							%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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

