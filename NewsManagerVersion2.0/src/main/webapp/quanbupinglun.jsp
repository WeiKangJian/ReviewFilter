<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>全部评论</title>
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
	<%
       if(session.getAttribute("adminId")==null || session.getAttribute("adminId")=="")

       {
             String path1 = request.getContextPath();
             String basePath1 = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path1 + "/"; 
             response.sendRedirect(basePath1+"Login.jsp");
       }
 	 %>
	
	<div class="modal fade" id="settingModal" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">设置</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" method="post" action="">
						<div class="form-group">
							<label class="col-sm-2 control-label">旧密码</label>
							<div class="col-sm-10">
								<input type="password" name="Name" class="form-control" 
									id="Old_Password_input" placeholder="请输入旧密码">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="password" name="Link" class="form-control"
									id="New_Password_input" placeholder="请输入新密码" onblur="checknew1pwd()"> 
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" name="Link" class="form-control"
									id="New_Password_input2" placeholder="请再次输入新密码" onblur="checknew2pwd()"> 
								<span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="sure_btn2">确认</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-sm" tabindex="-1" id="outModal" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">确认退出</h4>
				</div>
				<div class="modal-footer">
					<button type="button"
							class="btn btn-primary" id="sure_btn">确认</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
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
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
						<i class="fa fa-user fa-fw"></i>
						<b>管理员001</b> <b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li class="test"><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a></li>
						<li role="separator" class="divider"></li>
						<li class="test1"><a href="#"><i class="fa fa-sign-out fa-fw"></i>注销账号</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a href="index.jsp" class="waves-effect waves-dark">
						<i class="fa fa-dashboard"></i> 全部新闻<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="gongzuozixun.jsp" class="waves-effect waves-dark">
								<i class="glyphicon glyphicon-road"></i>工作资讯</a></li>
							<li><a href="xuexijiaoliu.jsp" class="waves-effect waves-dark">
								<i class="glyphicon glyphicon-book"></i>学习交流</a></li>
							<li><a href="shenghuozixun.jsp" class="waves-effect waves-dark">
								<i class="glyphicon glyphicon-fire"></i>生活资讯</a></li>
						</ul>
					</li>
					<li><a href="quanbupinglun.jsp" class="active-menu waves-effect waves-dark">
						<i class="fa fa-desktop"></i>全部评论</a></li>
					<li><a href="yonghuguanli.jsp" class="waves-effect waves-dark">
						<i class="fa fa-sitemap"></i> 用户管理</a></li>
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">全部评论</h1>
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
					<li class="active">全部评论</li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="table-responsive">
							<table class="table table-hover" id="comment_table">
								<thead>
									<tr class="info">
										<th>ID</th>
										<th>新闻标题</th>
										<th>评论用户</th>
										<th>评论时间</th>
										<th>评论内容</th>
										<th>点赞数</th>
										<th>审核状态</th>
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
	<!-- /. WRAPPER  -->
	</div>	
		
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	var totalRecord,currentPage;
	//1.在页面加载完成以后，直接去发送一个ajax请求,要到分页数据
	$(function() {
		//去首页
		to_page(1);
	});
	function to_page(pn) {
			$.ajax({
				url : "/NewsManager2/comments",
				data : "pn=" + pn,
				type : "GET",
				success : 
					function(result) {
						//1.解析并显示员工数据
						build_news_table(result);
						//2.解析并显示分页信息
						build_page_info(result);
						//解析显示分页条数据
						build_page_nav(result);
					}
			});
	}
	function build_news_table(result) {
		//清空table 表格
		//news_table tbody
		$("#comment_table tbody").empty();
		var news = result.extend.page.list;
		$.each(news, function(index, item) {
			var commentsIdTd = $("<td></td>").append(item.commentsId);
			var newstitleTd=$("<td></td>").append(item.newstitle);
			var usernameTd = $("<td></td>").append(item.username);
			var commentTimeTd= $("<td></td>").append(item.commentTime1);
			var commentContentTd = $("<td></td>").append(item.commentContent);
			var commentslikeTd = $("<td></td>").append(item.likes);
			var commentTypeTd = $("<td></td>").append(item.commentType);
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前新闻的id
			delBtn.attr("del-id",item.commentsId);
			var btnTd = $("<td></td>").append(delBtn);
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(commentsIdTd).append(newstitleTd).append(usernameTd).append(commentTimeTd)
			.append(commentContentTd).append(commentslikeTd).append(commentTypeTd).append(btnTd).appendTo("#comment_table tbody")
		})
	}
	//解析显示分页信息
	function build_page_info(result) {
		//page_info_area
		$("#page_info_area ").empty();
		$("#page_info_area").append("当前第" + result.extend.page.pageNum + "页,总"+ result.extend.page.pages 
		+ "页,总"+ result.extend.page.total + "条记录数");
		totalRecord=result.extend.page.total; //赋值为总记录数
		currentPage = result.extend.page.pageNum;
	}	
	//解析显示分页条
	function build_page_nav(result) {
		//page_nav
		$("#page_nav ").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (result.extend.page.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}
		//为元素添加点击翻页的事件
		firstPageLi.click(function() {
			to_page(1);
		})
		prePageLi.click(function() {
			to_page(result.extend.page.pageNum - 1);
		})
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
		if (result.extend.page.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function() {
				to_page(result.extend.page.pageNum + 1);
			})
			lastPageLi.click(function() {
				to_page(result.extend.page.pages);
			})
		}
		//添加首页和前一页的提示
		ul.append(firstPageLi).append(prePageLi);
		//1.2.3遍历给ul中添加页码提示
		$.each(result.extend.page.navigatepageNums, function(index,item) {
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.page.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function() {
				to_page(item);
			})
			ul.append(numLi);
		});
		//添加下一页和末页提示
		ul.append(nextPageLi).append(lastPageLi);
		//把ul加入到nav元素中
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav");
	}
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
	var status = 200;
	function show_validate_msg(ele,status,msg){
	//清除当前元素的检验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text(" ");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error"==status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	};
	//单个删除
	$(document). on("click", ".delete_btn" ,function(){
		//1.弹出是否确认删除对话框
		var title = $(this).parents("tr").find("td:eq(4)").text();
		var commentid = $(this).attr("del-id");
		if(confirm("确定删除["+title+"]吗?")){
			//确认.发送ajax请求删除
			$.ajax({
				url:"/NewsManager2/comment/"+commentid,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					//回到本页
					to_page(currentPage);
				}
			})
		}
	})
	function checknew1pwd(){           
		show_validate_msg("#New_Password_input","success","新密码可用"); 	
	};
	function checknew2pwd() {           
		if(New_Password_input2.value == New_Password_input.value) {
			show_validate_msg("#New_Password_input2","success","两次密码一致"); 
		 	$("#sure_btn2").attr("ajax_va","success"); //给按钮添加一个属性 内容为success
		 	status = 100;
         }else{
         	show_validate_msg("#New_Password_input2","error","两次密码不一致");
         	$("#sure_btn2").attr("ajax_va","error"); //给按钮添加一个属性 内容为success
         	New_Password_input2.value = "";  
         	New_Password_input.value = "";  
         	status = 200;
         }  
	}; 
	$('#sure_btn2').click(function(){
		$.ajax({
			url:"/NewsManager2/admin_edit",
			type:"POST",
			data:{
				"oldpassword": $("#Old_Password_input").val(),
				"password": $("#New_Password_input2").val(),
			},
			dataType: "JSON",
			success:function(data){
				if(data == 1){
					//新闻保存成功
					//1.关闭模态框
					$("#settingModal").modal("hide");
					alert("修改成功！")
				}else if(data == -1){
					alert("旧密码错误！")
				} 	
				else{
					alert("错误！")
				}
			}
		})
	});	 
    </script>
    
    <!-- admin退出登录 -->
	<script type="text/javascript">
		$('#sure_btn').click(function(){
			alert("退出成功！")
			$.ajax({
			url:"/NewsManager2/admin_quit",
			type:"POST",
		})
		window.location.href = "Login.jsp";
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