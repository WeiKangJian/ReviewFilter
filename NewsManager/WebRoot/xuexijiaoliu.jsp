<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>学习交流</title>
<script type="application/javascript">
    $(function(){
       $(".nav li").click(function () {
           var index = $(this).index();
           sessionStorage.setItem("currentNav",index);
           $(this).addClass("active").siblings().removeClass("active");
       });
       window.onload = function () {
           var index = sessionStorage.getItem("currentNav");
           var li = $(".nav li").eq(index);
           li.addClass("active").siblings().removeClass("active");
       }
    });
</script>
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
	<div class="modal fade" id="settingModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >设置</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">旧密码</label>
							<div class="col-sm-10">
								<input type="text" name="Name" class="form-control"
									id="Old_Password_input" placeholder="请输入旧密码">
									<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="text" name="Link" class="form-control"
									id="New_Password_input" placeholder="请输入新密码">
									<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="text" name="Link" class="form-control"
									id="New_Password_input2" placeholder="请再次输入新密码">
									<span  class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<a href="Login.jsp"><button type="button" class="btn btn-primary" id="sure_btn2">确认</button></a>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade bs-example-modal-sm" tabindex="-1" id="outModal" role="dialog" aria-labelledby="mySmallModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >确认退出</h4>
				</div>
	    <div class="modal-footer">
					<a href="Login.jsp"><button type="button" class="btn btn-primary" id="sure_btn">确认</button></a>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
	  </div>
	    </div>
	</div>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
				</button>
				<a class="navbar-brand waves-effect waves-dark" href="index.jsp"><i
					class="large material-icons">track_changes</i> <strong>红星新闻</strong></a>
				<div id="sideNav" href="">
					<i class="material-icons dp48">toc</i>
				</div>
			</div>
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-user fa-fw"></i> 
						<b>管理员001</b> 
						<b class="caret"></b>
					</a>
  					<ul class="dropdown-menu">
	    				<li class="test"><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a></li>
				    	<li role="separator" class="divider"></li>
	    				<li class="test1"><a href="#"><i class="fa fa-sign-out fa-fw"></i>注销账号</a> </li>
			  		</ul>
			  	</li>
			</ul>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu" onmouseover="disp()" onmouseout="out()">

					<li><a href="index.jsp" class="waves-effect waves-dark"><i class="fa fa-dashboard"></i> 全部新闻<span class="fa arrow"></span></a>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav nav-second-level">
							<li class="sss"><a href="gongzuozixun.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>工作资讯</a></li>
							<li class="sss"><a href="xuexijiaoliu.jsp" class="active-menu waves-effect waves-dark"><i class="glyphicon glyphicon-book"></i>学习交流</a></li>
							<li class="sss"><a href="shenghuozixun.jsp" class="waves-effect waves-dark"><i class="glyphicon glyphicon-fire"></i>生活资讯</a></li>
						</ul>
						</div>
						</li>
					<li><a href="quanbupinglun.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>全部评论</a></li>
					<li><a href="yonghuguanli.jsp" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> 用户管理</a></li>
				</ul>
			</div>

		</nav>
		<!-- /. NAV SIDE  -->

		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">学习交流</h1>
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="index.jsp">全部新闻</a></li>
					<li class="active">学习交流</li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">	
					<div class="table-responsive">
						<table class="table table-hover">
							<tbody>
								<tr class="info">
									<th>序号</th>
									<th>标题</th>
									<th>发布日期</th>
									<th>点赞数</th>
									<th>收藏数</th>
									<th>回复数</th>
								</tr>
								<tr class="info">
									<td>1</td>
									<td>钢铁是怎样炼成的</td>
									<td>2018/2/9</td>
									<td>5</td>
									<td>11</td>
									<td>23</td>
									<td><button type="button" class="btn btn-sm btn-primary">编辑</button></td>
									<td><button type="button" class="btn btn-sm btn-danger">删除</button></td>
								</tr>
								<tr class="info">
									<td>2</td>
									<td>北京大学</td>
									<td>浙江大学</td>
									<td>厦门大学</td>
									<td>北京大学</td>
									<td>浙江大学</td>
									<td><button type="button" class="btn btn-sm btn-primary">编辑</button></td>
									<td><button type="button" class="btn btn-sm btn-danger">删除</button></td>
								</tr>
								<tr class="info">
									<td>3</td>
									<td>13233333333</td>
									<td>13122222222</td>
									<td>13233333333</td>
									<td>15644444444</td>
									<td>17866666666</td>
									<td><button type="button" class="btn btn-sm btn-primary">编辑</button></td>
									<td><button type="button" class="btn btn-sm btn-danger">删除</button></td>
								</tr>
								<tr class="info">
									<td>4</td>
									<td>中国XX省XX市XX县</td>
									<td>中国XX省XX市XX县</td>
									<td>中国XX省XX市XX县</td>
									<td>中国XX省XX市XX县</td>
									<td>中国XX省XX市XX县</td>
									<td><button type="button" class="btn btn-sm btn-primary">编辑</button></td>
									<td><button type="button" class="btn btn-sm btn-danger">删除</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					</div>
				</div>
				<!-- /. PAGE INNER  -->
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>
		<!-- /. WRAPPER  -->
		<!-- JS Scripts-->
		<!-- jQuery Js -->
		<script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(".test1").click(function(){
    $("#outModal").modal({ //利用js创建模态框
				backdrop : "static"
			});
	});
	$(".test").click(function(){
    $("#settingModal").modal({ //利用js创建模态框
				backdrop : "static"
			});
	});
	</script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
</body>
</html>
