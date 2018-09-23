<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻视图</title>
	<% pageContext.setAttribute("APP_PATH", request.getContextPath());%>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Bootstrap Styles-->
	<link href="assets/css/bootstrap.css" rel="stylesheet" />
	<!-- FontAwesome Styles-->
	<link href="assets/css/font-awesome.css" rel="stylesheet" />
	<!-- Morris Chart Styles-->
	<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
	<!-- Custom Styles-->
	<link href="assets/css/custom-styles.css" rel="stylesheet" />
	<!-- Google Fonts-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle waves-effect waves-dark"
				data-toggle="collapse" data-target=".sidebar-collapse"></button>
			<a class="navbar-brand waves-effect waves-dark" href="index.jsp"><i
				class="large material-icons">track_changes</i> <strong>红星新闻</strong></a>
			<div id="sideNav" href="">
				<i class="material-icons dp48">toc</i>
			</div>
		</div>
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<b>管理员001</b> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li class="test"><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a></li>
					<li role="separator" class="divider"></li>
					<li class="test1"><a href="#"><i
							class="fa fa-sign-out fa-fw"></i>注销账号</a></li>
				</ul></li>
		</ul>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a href="#" class="active-menu waves-effect waves-dark"><i
							class="fa fa-dashboard"></i> 全部新闻<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="gongzuozixun.jsp"
								class="waves-effect waves-dark"><i
									class="glyphicon glyphicon-road"></i>工作资讯</a></li>
							<li><a href="xuexijiaoliu.jsp"
								class="waves-effect waves-dark"><i
									class="glyphicon glyphicon-book"></i>学习交流</a></li>
							<li><a href="shenghuozixun.jsp"
								class="waves-effect waves-dark"><i
									class="glyphicon glyphicon-fire"></i>生活资讯</a></li>
						</ul></li>
					<li><a href="quanbupinglun.jsp" class="waves-effect waves-dark"><i
							class="fa fa-desktop"></i>全部评论</a></li>
					<li><a href="yonghuguanli.jsp" class="waves-effect waves-dark"><i
							class="fa fa-sitemap"></i> 用户管理</a></li>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">全部新闻</h1>
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#myModal"
					style="position: absolute;top:60px;right:80px;">发布新闻</button>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li class="active">全部新闻</li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="table-responsive">
							<table class="table table-hover" id="news_table">
								<thead>
									<tr class="info">
										<th><input type="checkbox" id="check_all"></th>
										<th>#</th>
										<th>标题</th>
										<th>发布日期</th>
										<th>新闻类型</th>
										<th>新闻链接</th>
										<th>点赞数</th>
										<th>收藏数</th>
										<th>分享数</th>
										<th>评论数</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<!--分页文字信息-->
					<div class="col-md-6" id="page_info_area"></div>
					<!--分页条信息-->
					<div class="col-md-6" id="page_nav"></div>
				</div>
				<!-- /. PAGE INNER  -->
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>
	</div>
	<script type="text/javascript">
		$(".test1").click(function(){
	    $("#outModal").modal({ 
	    	//利用js创建模态框
			backdrop : "static"
				});
		});
		$(".test").click(function(){
		    $("#settingModal").modal({ 
		    	//利用js创建模态框
				backdrop : "static"
			});
		});
	</script>
</body>
</html>
