<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="com.dta.resource.WebMainPageResource" %>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>驾考联盟后台管理系统</title>

	<!-- <meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" /> -->

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="../media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="../media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="../media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="../media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="../media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="../media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="../media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<%
	String username = org.apache.shiro.SecurityUtils.getSubject().getPrincipal().toString();
	Subject subject = SecurityUtils.getSubject();
	WebMainPageResource pageInfo = new WebMainPageResource();
	Map<String, Integer> map = pageInfo.getStaticInfoByUsername(username);
	int evaluationSum = map.get("goodEvaluationSum") + map.get("midEvaluationSum") + map.get("badEvaluationSum");
	float goodEvaluationRate = 0, midEvaluationRate = 0, badEvaluationRate = 0;
	if(evaluationSum != 0){
		goodEvaluationRate = Math.round(map.get("goodEvaluationSum") * 100.0 / evaluationSum );
		midEvaluationRate = Math.round(map.get("midEvaluationSum") * 100.0 / evaluationSum );
		badEvaluationRate = Math.round(map.get("badEvaluationSum") * 100.0 / evaluationSum);
	}
%>
<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<a href="../media/nav.jsp #nav"></a>
		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->
   

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- 开始 左侧菜单 -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- 开始 左侧通用 菜单 -->        

				<script src="../media/left.js" type="text/javascript"></script>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>Widget Settings</h3>

				</div>

				<div class="modal-body">

					Widget settings form goes here

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- 开始当前位置-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">

							<div class="color-mode-icons icon-color"></div>

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								<p>更改后台颜色</p>

								<ul class="inline">

									<li class="color-black current color-default" data-style="default"></li>

									<li class="color-blue" data-style="blue"></li>

									<li class="color-brown" data-style="brown"></li>

									<li class="color-purple" data-style="purple"></li>

									<li class="color-grey" data-style="grey"></li>

									<li class="color-white color-light" data-style="light"></li>

								</ul>

								

							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER -->    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							管理主页 <small>驾考联盟统计信息</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="main.html">管理首页</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">基础数据统计</a></li>



						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- 结束当前位置-->

			  <div id="dashboard">

					<!-- BEGIN DASHBOARD STATS -->

					<div class="row-fluid">

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat blue">

								<div class="visual">

									<i class="icon-comments"></i>

								</div>

								<div class="details">

									<div class="number">

										<!-- <span id="studentName">0</span> -->
										<%=map.get("studentSum") %>

									</div>

									<div class="desc">                           

										学员总数

									</div>

								</div>

								<a class="more" href="#">

								查看所有学员 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat green">

								<div class="visual">

									<i class="icon-shopping-cart"></i>

								</div>

								<div class="details">

									<div class="number">
									<!-- <span id="todayOrderNumber">0</span> -->
									<%=map.get("todayOrderSum") %>
									</div>

									<div class="desc">今日预约数</div>

								</div>

								<a class="more" href="#">

								查看所有预约 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">

							<div class="dashboard-stat purple">

								<div class="visual">

									<i class="icon-globe"></i>

								</div>

								<div class="details">

									<div class="number">
									<!-- <span id="coachName">0</span> -->
									<%=map.get("coachSum") %>
									</div>

									<div class="desc">教练员总数</div>

								</div>

								<a class="more" href="#">

								查看所有教练员 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat yellow">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">
									<!-- <span id="balanceAmount">0</span> -->
									<%=map.get("balanceAmount") %>
									元</div>

									<div class="desc">现余资金</div>

								</div>

								<a class="more" href="#">

								查看收支详细 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

					</div>

					<!-- END DASHBOARD STATS -->

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

								  <div class="caption"><i class="icon-bar-chart"></i>本月订单趋势</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

										  <a href="#" class="btn mini">查看订单详细</a>

										  <a href="#" class="btn mini active">查看收入详细</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_statistics_loading">
                                        <!-- 统计图表在 media/js/index.js 大概200多行开始文件里面修改-->
										<img src="../media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_statistics_content" class="hide">

										<div id="site_statistics" class="chart"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN REGIONAL STATS PORTLET-->

						  <div class="portlet">

								<div class="portlet-title">

									<div class="caption"><i class="icon-globe"></i>客户端分布</div>

									<div class="tools">

										
										<a href="" class="reload"></a>

									
									</div>

								</div>

								<div class="portlet-body">
<iframe src="http://lbs.qq.com/javascript_v2/sample/sample-map.html" width=100% height=315 frameborder=0 scrolling=no></iframe>
                                </div>
                                
                               

							</div>

							<!-- END REGIONAL STATS PORTLET-->

						</div>

					</div>

					<div class="clearfix"></div>

				  <div class="row-fluid">

						<div class="span6">

							<div class="portlet box purple">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>评论概况</div>

									<div class="actions">

										<a href="#" class="btn yellow "><i class="icon-repeat"></i> 查看所有评价</a>

									</div>

								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number visits"  data-percent="<%=goodEvaluationRate %>"><span>+<%=goodEvaluationRate %></span>%</div>

												<a class="title" href="#">好评率 <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="<%=midEvaluationRate %>"><span>+<%=midEvaluationRate %></span>%</div>

												<a class="title" href="#">中评率 <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number bounce"  data-percent="<%=badEvaluationRate %>"><span>+<%=badEvaluationRate %></span>%</div>

												<a class="title" href="#">差评率<i class="m-icon-swapright"></i></a>

											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

						<div class="span6">

						  <div class="portlet box blue">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>APP在线比例</div>
								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number visits"  data-percent="55"><span>+70</span>%</div>

												<a class="title" >学员APP</a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="85"><span>+95</span>%</div>

												<a class="title" >教练APP </a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												

											  <a class="title">学员在线：965人</a>
                                                <a class="title">教练在线：100人</a>
                                                <a class="title">校长在线：100人</a>


										  </div>

										</div>

									</div>

								</div>

							</div>

						</div>



				</div>

				<div class="clearfix"></div>
				<div class="clearfix"></div>
				</div>

			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2013 &copy; HenanZhonghe Inc. 

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>
	</div>
<div style="width:100%;height:100%" id="container"></div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="../media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="../media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="../media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="../media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="../media/js/excanvas.min.js"></script>

	<script src="../media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="../media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="../media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="../media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="../media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="../media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="../media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="../media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="../media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="../media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="../media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="../media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="../media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="../media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="../media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="../media/js/date.js" type="text/javascript"></script>

	<script src="../media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="../media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="../media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="../media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="../media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="../media/js/app.js" type="text/javascript"></script>

	<script src="../media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    
		   
		  // getStaticInfo();
		   
		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();

		});
	function getStaticInfo(){
		var username = $('#username').html();
		$.ajax({
			url: '../rest/webMainPage/getStaticInfo',
			type: 'get',
			dataType: 'json',
			data: {username: username},
			success: function(data){
				$('#studentName').html(data.studentSum);
				$('#todayOrderNumber').html(data.todayOrderSum);
				$('#coachName').html(data.coachSum);
				$('#balanceAmount').html(data.balanceAmount);
			},
			error: function(error){
				alert(error.responseText);
			}
		});
	}
	/*
	window.onload： 
	当一个文档完全下载到浏览器中时，才会触发window.onload事件。这意味着页面上的全部元素对js而言都是可以操作的，
	也就是说页面上的所有元素加载完毕才会执行。这种情况对编写功能性代码非常有利，因为无需考虑加载的次序。
	$(document).ready{ }： 
	会在DOM完全就绪并可以使用时调用。虽然这也意味着所有元素对脚本而言都是可以访问的，
	但是，并不意味着所有关联的文件都已经下载完毕。换句话说，当HMTL下载完成并解析为DOM树之后，代码就会执行。 
	*/
	window.onload = function(){
		//getStaticInfo();
		
	}
	</script>    



	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>