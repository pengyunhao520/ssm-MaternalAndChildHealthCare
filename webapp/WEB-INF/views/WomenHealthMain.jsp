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
<title>铼众医疗管理系统</title>
<base href="<%=basePath%>"/>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<script type="text/javascript">
	$(function(){
		$("#leftPanel").tree({
			url:"tree.json",
			onClick:function(node){
				console.debug(node);
				//判断是否是一级菜单，如果是不做事情 没有儿子菜单
				if(!node.children){
					//跳转到对应页面的URL
					var url = node.url;
					var text = node.text;
					var iconCls = node.iconCls;
					//同一个菜单，可以多次点击，创建相同的页面。期望效果，没有就创建，有就选中
					if($("#mainUI").tabs("exists",text)){
						//有就选中 select
						$("#mainUI").tabs("select",text)
					}else{
						//创建内容区域的一个页面
						$("#mainUI").tabs("add",{
							title:text,
							iconCls:iconCls,
							closable:true,
							//页面里面远程加载数据。。。。。只加载body部分，头部没有。在头部实现的功能没有了
							// href:"/02_datagrid/datagrid.jsp"
							content:'<iframe frameborder="no" src="'+url+'" width="99.9%" height="99.5%"></iframe>'
						});
					}
					
					
				}
			}
		});
	});
</script>

<style type="text/css">
	.head{
	background-color: blue;
	height:80px;
	}
	
	.logoPng{
		float:left;
		padding-top:12px;
		padding-left:200px;
		}
		
	.login{
		color: white;
		position: fixed;
		right:20px;
		margin:8px 8px
	}
	.login1{
		color: white;
		font-size:13px;
		text-decoration:none;
		
		
	}
	
	.login2{
		margin:0px 5px;
		position:relative;
		top:-1px;
	}
	.easyui-linkbutton{
		padding-left:5px;
		padding-right:5px;
	}
	
	#button{
		 position:absolute;
		bottom:3px;
		right:30px;
		
		
	}
	
	.logoText{
		color: white;
		font-size: 24px;
		font-weight: bold;
		float:left;
		padding-top:22px;
	}
	
	.userBreakGround{
	  	display: inline-block;
		
	}
	
	#LeftMenu{
		width:126px;
		margin:1px 0px;
}
</style>
</head>
<body>
<!-- 	easyui-layout 布局空间
		split:true" 是否可拖拽
		fit="true" 填充满父容器
-->
	<div class="easyui-layout" fit="true">
        <div class="head" data-options="region:'north'">
			<!--logo -->
        	<div class="logoPng">
        		<img src="static/images/logo.jpg" width="90" >
        	</div>
        	
        	<div class="logoText">
        		妇幼保健服务管理系统
        	</div>
        	<div class="login">
        		<a href="/logout" class="login1">重登陆</a>
        		<span class="login2">|</span>
        		<a href="/exitBrowser" class="login1">退出</a>
        	</div>
	        <div id="button">
	        	<a href="otherpage.php" class="easyui-linkbutton c4" >其他</a>  
	        	<a href="otherpage.php" class="easyui-linkbutton c4" >儿保</a>  
	        	<a href="/WomenHealthMain" class="easyui-linkbutton c4" >妇保</a>  
	        	<a href="otherpage.php" class="easyui-linkbutton c4" >系统设置</a>  
	        </div>
       </div>
    
    <div data-options="region:'center',title:'孕妇管理'">
        <div id="mainUI" class="easyui-tabs" fit="true">
          
    	</div>
  	</div>
    	
    	<!-- 左边功能菜单 -->
        <div data-options="region:'west'" collapsible="false" border="false"  title="登录人" style="width:150px;height:200px";>
        	<!-- 当前登录背景图片 -->
        	<div class="userBreakGround">
        		<img src="static/images/user-breakground.jpg" width="149" >
        	</div>
        	
        	<!-- 当前登录用户 -->
        	<div id="username">${sessionScope.loginUser.username}</div>
        	
        	<!-- 公告栏菜单 -->
		    <div id="leftPanel" class="easyui-panel" title="妇女保健系统" fit="true" data-options="collapsible:true,"></div>    
		</div>
		  
</body>
</html>