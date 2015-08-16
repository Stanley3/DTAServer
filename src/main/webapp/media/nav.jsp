<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-coach">
<title>nav</title>
</head>
<body>
<%
	Integer school_id = (Integer)request.getSession(false).getAttribute("school_id");
	String school_name = (String)request.getSession(false).getAttribute("school_name");
%>
	<div class="container-fluid" id="nav">

				<!-- BEGIN LOGO -->

				<a class="brand"  style="margin-left:10px; " href="index.html">

				<%=school_name %>后台管理系统

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

					

						<span class="username">超级管理员：<span id="username"><shiro:principal /></span></span>

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
				<input type="hidden" id="school_id" value="<%=school_id %>">
				<input type="hidden" id="school_name" value="<%=school_name %>">
			</div>
</body>
</html>