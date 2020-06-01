<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>"/>
<%@include file="/WEB-INF/views/common/common.jsp" %>

<style>
	#background{
		background-image:url('/static/images/login1.jpg');
		background-size: 1600px 750px;
	}

	#login-background{
	position: fixed;
	height:54.2%;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	border:solid 1px white;
	}
	

	
	#loginForm{
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	}

	.easyui-linkbutton{
	text-decoration:none;
	background:#00DDDD;
	padding:4px;
	padding-left:20px;
	padding-right:20px;
	font-weight:bold;
	}
	#randomCode{
		height:30px;
		
	}
	

</style>


	
<script type="text/javascript">
	function submitForm() {
		$("#loginForm").form("submit", {
			url : "/login",
			success : function(data) {
				data = $.parseJSON(data);
				console.debug(data);
				if (data.success) {
					//如果登录成功，跳转到主页面
					location.href = "/main";
				} else {
					$.messager.alert("温馨提示", data.message, "info", function() {
						//console.debug($("input[name=username]"));
						if (data.code == -100) {// 用户名错误
							$("input[name=username]").focus();
						} else if (data.code == -101) {// 密码错误
							$("input[name=password]").focus();
						} else if (data.code == -109){
							$("input[name=randomCode]").focus();
						}
					});
				}
			}
		});
	}
	function resetForm() {
		$("#loginForm").form("clear");
	}
	
	$(document.documentElement).on("keyup", function(event) {
		var keyCode = event.keyCode;
		console.debug(keyCode);
		if (keyCode === 13) { // 捕获回车 
			submitForm(); // 提交表单
		}
	});
	
	//判断当前的页面是否是顶层页面
	if(window.top!=window){
		//如果不是，则让顶层页面跳转到登录页面
		window.top.location.href = "/login.jsp";		
	}

</script>
</head>

<body id="background">

	<div id="login-background"><img src="/static/images/login2.jpg" >
		<div align="center" style="margin-top: 100px;"></div>
	</div>
	
		<div>
			<form id="loginForm" class="easyui-form" method="post">
				<table align="center" style="margin-top: 15px;">
					<tr height="20">
						<td>用户名:</td>
					</tr>
					<tr height="10">
						<td><input name="username" class="easyui-validatebox" required="true" value="123"/></td>
					</tr>
					<tr height="20">
						<td>密&emsp;码:</td>
					</tr>
					<tr height="10">
						<td><input name="password" type="password" class="easyui-validatebox" required="true" /></td>
					</tr>
				  	<tr height="20">
						
						
						<td>验证码:
						<br><img id="randomCode" src="/randomCode"><br/>
						</td>
					</tr>
					<tr height="10">
					
						<td><input  name="randomCode" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr height="40" >
						<td align="center"><a href="javascript:;" class="easyui-linkbutton" onclick="submitForm();">登录</a></td>  
					</tr>
				</table>
			</form>
	</div>
	
		
	
	
	
</body>
</html>