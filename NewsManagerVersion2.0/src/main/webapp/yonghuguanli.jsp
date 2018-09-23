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
<title>用户管理</title>
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
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">用户修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户ID</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="usersId_uptate_static"></p>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="name" class="form-control"
									id="Name_update_input" placeholder="请输入用户名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">电话号码</label>
							<div class="col-sm-10">
								<input type="text" name="phoneNumber" class="form-control"
									id="phoneno_update_input" placeholder="请输入电话号码"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">电子邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="eMail" class="form-control"
									id="email_update_input" placeholder="请输入电子邮箱"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="sex" id="Kind1_update_input" value="男">
									<!-- values指定提交值 --> 男
								</label> 
								<label class="radio-inline"> <input type="radio"
									name="sex" id="Kind2_update_input" value="女"> 女
								</label> 
							</div>
						</div>		
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="users_uptate_input_btn">更新</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
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
					<form class="form-horizontal" role="form" method="post" action = "">
						<div class="form-group">
							<label class="col-sm-2 control-label">旧密码</label>
							<div class="col-sm-10">
								<input type="password" name="Name" class="form-control"
									id="Old_Password_input" placeholder="请输入旧密码" >
								<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="password" name="Link" class="form-control"
									id="New_Password_input" placeholder="请输入新密码" onblur="checknew1pwd()">
								<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" name="Link" class="form-control"
									id="New_Password_input2" placeholder="请再次输入新密码" onblur="checknew2pwd()">
								<span  class="help-block"></span>
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
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >确认退出</h4>
				</div>
	    <div class="modal-footer">
					<button type="button" class="btn btn-primary" id="sure_btn">确认</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		</div>
	  </div>
	    </div>
	</div>
	<div class="modal fade" id="userModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >添加用户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户ID</label>
							<div class="col-sm-10">
								<input type="text" name="usersId" class="form-control"
									id="usersId_input" placeholder="请输入用户ID">
									<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="name" class="form-control"
									id="Name_update_input1" placeholder="请输入用户名">
									<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" name="password" class="form-control"
									id="Password_input" placeholder="请输入密码">
									<span  class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="text" name="password1" class="form-control"
									id="Password_input1" placeholder="请输入再输入一次密码">
									<span  class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="user_uptate_btn">确认</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-sm" tabindex="-1"
		id="fileModal" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<input id="lefile" type="file" style="display:none">
				<div class="input-append">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">导入用户表</h4>
					</div>
				</div>
				<div class="modal-body">
					<form id = "usersform" method="post"
						enctype="multipart/form-data">
						Upload File1:<input type="file" name="file" id = "file"><br />
						<button type="submit" value="Submit" id = "submintusers">Submit</button>
						<button type="reset" value="Reset">Reset</button>
					</form>
				</div>
				<div class="modal-footer"></div>
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
				<ul class="nav" id="main-menu">
					<li id=li><a href="#" class="waves-effect waves-dark"><i class="fa fa-dashboard"></i> 全部新闻<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="gongzuozixun.jsp" class="waves-effect waves-dark"><i class="glyphicon glyphicon-road"></i>工作资讯</a></li>
							<li><a href="xuexijiaoliu.jsp" class="waves-effect waves-dark"><i class="glyphicon glyphicon-book"></i>学习交流</a></li>
							<li><a href="shenghuozixun.jsp" class="waves-effect waves-dark"><i class="glyphicon glyphicon-fire"></i>生活资讯</a></li>
						</ul>
					</li>
					<li><a href="quanbupinglun.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>全部评论</a></li>
					<li><a href="yonghuguanli.jsp" class="active-menu waves-effect waves-dark"><i class="fa fa-sitemap"></i> 用户管理</a></li>		
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">用户管理
				<a href="file/userstable.xlsx" class="btn btn-success" role="button" download="用户表格.xlsx"  style="position: absolute;top:60px;right:280px;">表格下载</a>
				<a href="#" class="btn btn-success" role="button" data-toggle="modal" data-target="#fileModal"  style="position: absolute;top:60px;right:180px;">批量添加</a>
				<a href="#" class="btn btn-success" role="button" data-toggle="modal" data-target="#userModal" style="position: absolute;top:60px;right:80px;">添加用户</a>
				</h1>
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
					<li class="active">用户管理</li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="table-responsive">
							<table class="table table-hover" id="users_table">
								<thead>
									<tr class="info">
										<th>ID</th>
										<th>用户名</th>
										<th>电话号码</th>
										<th>电子邮箱</th>
										<th>性别</th>
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
	<!-- /. WRAPPER  -->
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
				url : "/NewsManager2/user12",
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
		$("#users_table tbody").empty();
		var news = result.extend.page.list;
		$.each(news, function(index, item) {
			var usersIdTd = $("<td></td>").append(item.usersId);
			var nameTd=$("<td></td>").append(item.name);
			var phoneNumberTd = $("<td></td>").append(item.phoneNumber);
			var eMailTd= $("<td></td>").append(item.eMail);
			var sexTd = $("<td></td>").append(item.sex);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性,来表示当前新闻的id
			editBtn.attr("edit-id",item.usersId);
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前新闻的id
			delBtn.attr("del-id",item.usersId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(usersIdTd).append(nameTd).append(phoneNumberTd).append(eMailTd)
			.append(sexTd).append(btnTd).appendTo("#users_table tbody")
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
	//单个删除
	$(document). on("click", ".delete_btn" ,function(){
		//1.弹出是否确认删除对话框
		var title = $(this).parents("tr").find("td:eq(1)").text();
		var commentid = $(this).attr("del-id");
		if(confirm("确定删除["+title+"]吗?")){
			//确认.发送ajax请求删除
			$.ajax({
				url:"/NewsManager2/user12/"+commentid,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					//回到本页
					to_page(currentPage);
				}
			})
		}
	})
	$(".test2").click(function(){
    $("#fileModal").modal({ //利用js创建模态框
				backdrop : "static"
			});
	});
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
	$("#Name_update_input1").change(function(){
			var title = this.value;
			$.ajax({
				url:"/NewsManager2/checktitle1",
				data: "title="+title,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#Name_update_input1","success","用户名可用");
						$("#user_uptate_btn").attr("ajax_va","success"); //给按钮添加一个属性 内容为success
					}else{
						show_validate_msg("#Name_update_input1","error",result.extend.va_msg);
						$("#user_uptate_btn").attr("ajax_va","error");
					}
				}		 
			});
	});
	$("#usersId_input").change(function(){
			var title = this.value;
			$.ajax({
				url:"/NewsManager2/checkuserid",
				data: "title="+title,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#usersId_input","success","用户ID可用");
						$("#user_uptate_btn").attr("ajax_va","success"); //给按钮添加一个属性 内容为success
					}else{
						show_validate_msg("#usersId_input","error",result.extend.va_msg);
						$("#user_uptate_btn").attr("ajax_va","error");
					}
				}		 
			});
	});
	$("#user_uptate_btn").click(function(){
		$.ajax({
			url:"/NewsManager2/user123",
			type:"POST",
			data:$("#userModal form").serialize(),
			success:function(result){
				if(result.code == 100){
					//新闻保存成功
					//1.关闭模态框
					$("#userModal").modal("hide");
					to_page(99999); //数字足够大会直接去最后一面
				}else{
					//显示失败信息
					//有哪个字段的错误信息就显示哪个字段
					if(result.extend.va_msg=="两次密码不一致"){
						show_validate_msg("#Password_input1","error",result.extend.va_msg);
					}
					if(result.extend.va_msg1=="用户ID不能为空"){
						show_validate_msg("#usersId_input","error",result.extend.va_msg1);
					}else if(result.extend.va_msg2=="用户名不能为空"){
						show_validate_msg("#Name_update_input1","error",result.extend.va_msg2);
					}else if(result.extend.va_msg3=="密码不能为空"){
						show_validate_msg("#Password_input","error",result.extend.va_msg3);
					}else{
						if(undefined != result.extend.errorFields.newsId){
						//显示员工名字的错误信息
						show_validate_msg("#usersId_input","error",result.extend.errorFields.newsId);
						}
						if(undefined != result.extend.errorFields.title){
						//显示员工名字的错误信息
						show_validate_msg("#Name_update_input1","error",result.extend.errorFields.title);
						}
						if(undefined != result.extend.errorFields.newsContent){
						//显示员工名字的错误信息
						show_validate_msg("#Password_input","error",result.extend.errorFields.newsContent);
						}
					}
				} 	
			}
		}) 
	});
	$("#Name_update_input").change(function(){
			var title = this.value;
			$.ajax({
				url:"/NewsManager2/checktitle1",
				data: "title="+title,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#Name_update_input","success","用户名可用");
						$("#users_uptate_input_btn").attr("ajax_va","success"); //给按钮添加一个属性 内容为success
					}else{
						show_validate_msg("#Name_update_input","error",result.extend.va_msg);
						$("#users_uptate_input_btn").attr("ajax_va","error");
					}
				}		 
			});
	});
	$("#phoneno_update_input").change(function(){
			var title = this.value;
			$.ajax({
				url:"/NewsManager2/phoneno",
				data: "title="+title,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#phoneno_update_input","success","电话号码可用");
						$("#users_uptate_input_btn").attr("ajax_va","success"); //给按钮添加一个属性 内容为success
					}else{
						show_validate_msg("#phoneno_update_input","error",result.extend.va_msg);
						$("#users_uptate_input_btn").attr("ajax_va","error");
					}
				}		 
			});
	});
	function getuser(id){
		$.ajax({
			url:"/NewsManager2/user12/"+id,
			type:"GET",
			success:function(result){
				//console.log(result);
				var userData = result.extend.user;
				$("#usersId_uptate_static").text(userData.usersId);
				$("#Name_update_input").val(userData.name);
				$("#phoneno_update_input").val(userData.phoneNumber);
				$("#email_update_input").val(userData.eMail);
				$("#editModal input[name=sex]").val([userData.sex]); //当单选框被选中
			}
		})
	}
	$(document). on("click", ".edit_btn" ,function(){ 
		 getuser($(this).attr("edit-id")); //获取当前按钮的id 
		 $("#users_uptate_input_btn").attr("edit-id",$(this).attr("edit-id"));
		$("#editModal").modal({ //利用js创建模态框
			backdrop : "static"
		});							
	});
	$("#users_uptate_input_btn").click(function(){
		$.ajax({
			url:"/NewsManager2/user12/"+$(this).attr("edit-id"),
			type:"POST",
			data:$("#editModal form").serialize()+"&_method=PUT", //获取表单序列化后的结果,改方法为put
			success:function(result){
				//alert(result.msg);
				//1.关闭对话框
				$("#editModal").modal("hide");
				//2.回到本页面
				to_page(currentPage);
			}
		});			
	});
	
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
	<!-- admin退出登录 -->
	$('#sure_btn').click(function(){
		alert("退出成功！")
		$.ajax({
			url:"/NewsManager2/admin_quit",
			type:"POST",
		})
		window.location.href = "Login.jsp";
	});
	$('#submintusers').click(function(){
		var formData = new FormData($( "#usersform" )[0]);
		$.ajax({
			url:"/NewsManager2/importUsers",
			type:"POST",
			dataType: "JSON",
			data: formData,
			async: false,  
      		cache: false,  
     	 	contentType: false,  
      		processData: false,  
			success:function(data){
				if(data != 0){
					//新闻保存成功
					//1.关闭模态框
					$("#fileModal").modal("hide");
					alert("添加成功了 " + data + "条数据");
				}
				else{
					alert("错误！")
				}
			}
		})
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