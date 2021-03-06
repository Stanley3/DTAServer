<%@page import="java.util.Map"%>
<%@page import="com.dta.page.MoneyPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>驾考联盟后台管理系统</title>






	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

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

<body class="page-header-fixed">
<%
	HttpSession session2 = request.getSession(false);
    Map<String, Double> moneyMap = null;
    Map<String, Integer> numbersMap = null;
    float character2Rate = 0, character3Rate = 0 , depositRate = 0, consumedReate = 0;
    Integer allStudentNumbers = 0,  //所有学员总数
			allConsumedStudentNumbers = 0, //已消费学员总数
			allDepositedStudentNumbers = 0, //已充值学员总数
			allChartered2Numbers = 0, //包科二学员总数
			allChartered3Numbers = 0, //包科三学员总数
			allFree2Numbers = 0, //自由科二学员总数
			allFree3Numbers = 0; //自由科三学员总数
	if(session2 != null){
		Integer school_id = (Integer)session2.getAttribute("school_id");
		MoneyPage moneyPage = new MoneyPage(school_id);
		moneyMap = moneyPage.getMoney();
		numbersMap = moneyPage.getStudentNumbers();
		allStudentNumbers = numbersMap.get("allStudentNumbers");
		allChartered2Numbers = numbersMap.get("allChartered2Numbers");
		allChartered3Numbers = numbersMap.get("allChartered3Numbers");
		if(allStudentNumbers != 0){
			character2Rate = Math.round(allChartered2Numbers * 100.0 / allStudentNumbers);
			character3Rate = Math.round(allChartered3Numbers * 100.0 / allStudentNumbers);
			depositRate = Math.round(numbersMap.get("allDepositedStudentNumbers") * 100 / allStudentNumbers);
			consumedReate = Math.round(numbersMap.get("allConsumedStudentNumbers") * 100 / allStudentNumbers);
		}
			
	}
	
%>

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand"  style="margin-left:10px; " href="../index.html">

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

								<a href="../inbox.html?a=view">

								
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

								<a href="../inbox.html?a=view">

								

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

								<a href="../inbox.html?a=view">

								
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

								<a href="../inbox.html">查看所有投诉信息<i class="m-icon-swapright"></i></a>

							</li>

						</ul>

					</li>

					<!-- 结束全站顶部投诉信息 -->



					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

					

						<span class="username">超级管理员：丁海伟</span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="../extra_profile.html"><i class="icon-user"></i> 修改资料</a></li>

							
							<li class="divider"></li>

							<li><a href="../extra_lock.html"><i class="icon-lock"></i> 锁定屏幕</a></li>

							<li><a href="../login.html"><i class="icon-key"></i> 退出</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->
   

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- 开始 左侧菜单 -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- 开始 左侧通用 菜单 -->        

			<script src="../left.js" type="text/javascript"></script>

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

							财务管理 <small>驾考联盟统计信息</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="../main.jsp">财务管理</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">财务汇总</a></li>



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

										<%=moneyMap.get("allDepositAmount") %>元

									</div>

							    <div class="desc">总充值</div>

								</div>

								<a class="more" href="money_in_new.html">

								查看所有充值记录 <i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat green">

								<div class="visual">

									<i class="icon-shopping-cart"></i>

								</div>

								<div class="details">

									<div class="number"><%=moneyMap.get("allConsumeAmount") %>元</div>

									<div class="desc">总消费</div>

								</div>

								<a class="more" href="money_checkout_finish.html">

								查看所有结算</a>                 

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">

							<div class="dashboard-stat purple">

								<div class="visual">

									<i class="icon-globe"></i>

								</div>

								<div class="details">

									<div class="number"><%=moneyMap.get("allFreezeAmount") %>元</div>

									<div class="desc">总冻结</div>

								</div>

								<a class="more" href="money_checkout.html">

								查看所有应结算</a>                 

							</div>
                            

						</div>


						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">

							<div class="dashboard-stat yellow">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number"><%=moneyMap.get("allBalanceAmount") %>元</div>

									<div class="desc">现余资金</div>

								</div>

								<a class="more" href="#">总充值-总结算-待结算=余资金<i class="m-icon-swapright m-icon-white"></i>

								</a>                 

							</div>
                            
                      
                            

						</div>

					</div>

					<!-- END DASHBOARD STATS -->

					<div class="clearfix"></div>
					<div class="clearfix"></div>

				  <div class="row-fluid">

						<div class="span6">

							<div class="portlet box purple">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>财务统计</div>
								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number visits"  data-percent="<%=depositRate %>"><span>+<%=depositRate %></span>%</div>
                                                <!--此处的data-percent=''这个是比例的图示显示的位置，后面的+90是具体数据下同-->

												<a class="title" href="#">充值率 <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="6"><span>+6</span>%</div>

												<a class="title" href="#">申请退款<i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number bounce"  data-percent="<%=consumedReate%>"><span>+<%=consumedReate%></span>%</div>

												<a class="title" href="#">消费比例<i class="m-icon-swapright"></i></a>

											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

						<div class="span6">

						  <div class="portlet box blue">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>包过比例</div>
								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number visits"  data-percent="<%=character2Rate%>"><span>+<%=character2Rate%></span>%</div>

												<a class="title" >科二包过</a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="<%=character3Rate%>"><span>+<%=character3Rate%></span>%</div>

												<a class="title" >科三包过 </a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												

											  <a class="title">科二包过：<%=numbersMap.get("allChartered2Numbers")%></a>
                                               <a class="title">科二自由：<%=numbersMap.get("allFree2Numbers")%></a>
											<a class="title">科三包过：<%=numbersMap.get("allChartered3Numbers") %></a>                                                 
											<a class="title">科三自由：<%=numbersMap.get("allFree3Numbers") %></a>


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

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

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