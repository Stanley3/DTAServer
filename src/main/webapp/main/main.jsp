<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
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
%>
<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<%-- <div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand"  style="margin-left:10px; " href="index.html">

				驾考联盟后台管理系统

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="../media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">

				
						

					<!-- BEGIN INBOX DROPDOWN -->

					<li class="dropdown" id="header_inbox_bar">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<i class="icon-envelope"></i>

						<span class="badge">5</span>

						</a>

						<ul class="dropdown-menu extended inbox">

							<li>

								<p>有 5 条未处理投诉</p>

							</li>

							<li>

								<a href="inbox.html?a=view">

								
								<span class="subject">

								<span class="from">学员：张四</span>

								<span class="time">刚刚</span>

								</span>

								<span class="message">

								真是受不了啦还号称服务第一呢啥服务
								</span>  

								</a>

							</li>

							<li>

								<a href="inbox.html?a=view">

								

								<span class="subject">

								<span class="from">学员：王五</span>

								<span class="time">16 分钟前</span>

								</span>

								<span class="message">

								我去了让我等了半个小时都不让我开始...

								</span>  

								</a>

							</li>

							<li>

								<a href="inbox.html?a=view">

								
								<span class="subject">

								<span class="from">学员：张三</span>

								<span class="time">2小时前</span>

								</span>

								<span class="message">

								你们的教练实在是太气人了都不好好教!

								</span>  

								</a>

							</li>

							<li class="external">

								<a href="inbox.html">查看所有投诉信息<i class="m-icon-swapright"></i></a>

							</li>

						</ul>

					</li>

					<!-- 结束全站顶部投诉信息 -->



					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

					

						<span class="username">超级管理员：<shiro:principal /></span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="extra_profile.html"><i class="icon-user"></i> 修改资料</a></li>

							
							<li class="divider"></li>

							<li><a href="extra_lock.html"><i class="icon-lock"></i> 锁定屏幕</a></li>

							<li><a href="../logout"><i class="icon-key"></i> 退出</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div> --%>
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

										1349

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

									<div class="number">549</div>

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

									<div class="number">135</div>

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

									<div class="number">108,520元</div>

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

												<div class="number visits"  data-percent="55"><span>+90</span>%</div>

												<a class="title" href="#">好评率 <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="85"><span>+6</span>%</div>

												<a class="title" href="#">中评率 <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number bounce"  data-percent="46"><span>+4</span>%</div>

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

	</script>    



	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>