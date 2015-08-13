<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'leftJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="leftNav">
		<ul class="page-sidebar-menu">

			<li class="start active"><a href="../main/main.jsp"><span
					class="title">管理主页</span> </a></li>
			<!-- <li class=""><a href="javascript:;"><span class="title">系统设置</span></a>
				<ul class="sub-menu">
					<li><a href="layout_horizontal_sidebar_menu.html">系统参数设置</a></li>
					<li><a href="layout_horizontal_menu1.html">赞助商设置</a></li>
				</ul></li> -->

			<shiro:hasPermission name="superadmin">
				<li class=""><a href="javascript:;"><span class="title">驾校考场</span></a>
					<ul class="sub-menu">
						<li><a href="../school/school_add_edit.html">添加驾校</a></li>
						<li><a href="../school/school_school_list.html">驾校列表</a></li>
					</ul></li>
			</shiro:hasPermission>

			<li class=""><a href="javascript:;"><span class="title">教练管理</span></a>
				<ul class="sub-menu">
					<li><a href="../techer/techer_add_edit.html">添加教练</a></li>
					<li><a href="../techer/techer_view_list.html">教练列表</a></li>
				</ul></li>

			<li class=""><a href="javascript:;"><span class="title">学员管理</span></a>
				<ul class="sub-menu">
					<li><a href="../student/students_add.html">添加学员</a></li>
					<li><a href="../student/students_view_list.html">学员列表</a></li>
					<li><a href="../student/students_view_list.html?L%3d=0">自由学员</a></li>
					<li><a href="../student/students_view_list.html?L%3d=2">包科二学员</a></li>
					<li><a href="../student/students_view_list.html?L%3d=3">包科三学员</a></li>
					<li><a href="../student/students_view_list.html">尚未报名</a></li>
					<li><a href="../student/students_view_list.html">拿证学员</a></li>
				</ul></li>

			<li><a href="javascript:;"><span class="title">财务管理</span></a>
				<ul class="sub-menu">
					<li><a href="../money/money.jsp">财务汇总</a></li>
					<li><a href="../money/money_in_new_student.html">学员费用充值</a></li>
					 <shiro:hasPermission name="superadmin">
					 <li><a href="../money/money_in_new_school.html">驾校费用充值</a>
					 </shiro:hasPermission>
					<!-- <li><a href="../money/money_checkout.html">结算费用</a></li>
					<li><a href="../money/money_feed.html">消费明细</a></li> -->
				</ul></li>

			<li><a class="active" href="javascript:;"><span
					class="title">评价管理</span></a>
				<ul class="sub-menu">
					<li><a href="../comment/comment_view.html">评价汇总</a></li>
				</ul></li>

			<li class=""><a href="javascript:;"><span class="title">订单管理</span></a>
				<ul class="sub-menu">
					<li><a href="../order/order_list_yuyue.html">查看订单</a></li>
				</ul></li>
			<%-- <shiro:hasPermission name="superadmin">
				<li class=""><a href="javascript:;"><span class="title">超管设置</span></a>
					<ul class="sub-menu">
						<li><a href="login_soft.html">网站超管</a></li>
					</ul></li>
			</shiro:hasPermission> --%>
		</ul>
	</div>
</body>
</html>
