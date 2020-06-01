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

  

</head>
<body>

<style type="text/css">

	.layout{
		filt:flase;
		
	}
	
</style>
</head>
<body>
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
	
	.easyui-menubutton{
		margin-top:2px;
		float:left;
		padding-left:10px;
		padding-right:10px;
		plain:true;
	}
	
	.userBreakGround{
	  	display: inline-block;
		
	}
	#username{
	  	position: absolute;
	  	text-align: center;
	  	margin-top:-45px;
	  	margin-left:30px;
	}
	#searche{
	margin-top:50px
	
	}
	#informationCommunication{
		padding-left:37px;
		padding-right:37px;
		margin:auto;
	}
	#notice{
		padding-left:43px;
		padding-right:43px;
		margin:auto;
	}
	#forum{
		padding-left:49px;
		padding-right:49px;
		margin:auto;
	}
	
	#LeftMenu{
		width:126px;
		margin:1px 0px;
	}
	
	#menuButton{
		width:100%;
		height:33px;
		background-color:blue;
		height:30px;
	}
	
	#fontSerch{
		font-size:14px;
	}
</style>


<script type="text/javascript">
$(function(){
	//声明变量来缓存组件
	var employeeDatagrid;
	//使用声明的变量 来缓存组件
	employeeDatagrid=$("#employeeDatagrid")
	employeeDatagrid.datagrid({
		title:"公告",
		url : '${pageContext.request.contextPath}/page',
		pagination : true, 
		fit : true,
		fitColumns : true,
		singleSelect : true,
		rownumbers : true,
		columns : [ [ 
			{field : 'id',title : '编号',width : 100,hidden : true}, 
			{field : 'username',title : '用户名',width : 100}, 
			{field : 'password',title : '密码',width : 100}
			] ],
			toolbar: [{
					iconCls: 'icon-edit',
					handler: function(){alert('编辑按钮')}
				},'-',{
					iconCls: 'icon-help',
					handler: function(){alert('帮助按钮')}
				}]
			});
})

</script>

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
        		<a href="logout" class="login1">重登陆</a>
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
    
     
         <div data-options="region:'center'">
	        <div id="menuButton">     
	        	<a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
		        data-options="menu2:'#mm'">建档与孕期检查</a>
			    <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">分娩与访视</a>
			    <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">催检</a>
			    <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">高危管理</a>
			    <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">特殊情况</a>      
		  		
		  		<a href="javascript:void(0)" id="chileMenu" class="easyui-menubutton c1" plain="false"   
		        data-options="menu:'#mm'">综合查询与报表</a>
			        <div id="mm" class="easyui-menu" style="width:120px;">   
					    <div>   
					        <span>综合报表</span>   
					        <div style="width:150px;">   
					            <div>出生情况(一)</div>   
					            <div>出生情况(二)</div>   
					            <div>出生情况(三)</div>   
					            <div>各项指标情况</div>   
					            <div>工作报表</div>   
					    	</div>   
					    </div>  
					     
					    <div>   
					        <span>特殊情况报表</span>   
					        <div style="width:150px;">   				            
					        	<div>PowerPoint</div>   
					        </div>   
					    </div>   
					    
					    <div>   
					        <span>质量控制</span>   
					        <div style="width:150px;">   
					           <div>PowerPoint</div>   
					        </div>   
					    </div>   
					    
					</div>  
	
				<a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">妇女病普查治</a> 
			        <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">节育手术</a>   
			        <a href="javascript:void(0)" id="Menu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">婚前医学检查</a>              
		    
			</div> 
			
			
			<!-- 高级查询模态框 -->
		<div id="employeeAdvancedSearchDialog">
			<form id="employeeAdvancedSearchDialogForm" method="post">
				<table style="margin:auto;margin-top:10px">
					<tr>
						<td id="fontSerch">请输入用户名:</td>
						<td>
							<input name="username" class="easyui-textbox"  style="width:200px"> 
						</td>
						<td>
						<div id="serchbutton">
							<a data-cmd="employeeAdvancedSearchSubmit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-search',plain:true">查询</a>
							<a data-cmd="employeeAdvancedCancel" href="javascript:;" class="easyui-linkbutton c6" data-options="iconCls:'icon-cancel',plain:true">取消</a>
						</div>
						</td>
					</tr>
					
				</table>
			</form>	
		</div>
			  		<!-- 列表展示所有员工的datagrid -->
	<table id="employeeDatagrid"></table>
    </div>
  
    	
    	<!-- 左边功能菜单 -->
        <div data-options="region:'west'" collapsible="true" border="false"  title="功能菜单" style="width:150px;height:200px";>
        	<!-- 当前登录背景图片 -->
        	<div class="userBreakGround">
        		<img src="static/images/user-breakground.jpg" width="149" >
        	</div>
        	
        	<!-- 当前登录用户 -->
        	<div id="username">${sessionScope.loginUser.username}</div>
        	
        	<!-- 公告栏菜单 -->
		    <div id="leftPanel" class="easyui-panel" title="信息交流" fit="true" data-options="collapsible:true,">    
		    	  <!-- 公告栏按钮 -->
		    	  <a href="javascript:void(0)" id="LeftMenu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">公告栏</a>
		    	  <!-- 论坛按钮 -->
		    	  <a href="javascript:void(0)" id="LeftMenu" class="easyui-menubutton c1"  hasDownArrow="false" plain="false"
			        data-options="menu2:'#mm'">论坛</a>
		
		 
	    </div>
	        
	        <div data-options="region:'south'" style="height:30px;text-align:center;font-size: 12px;padding-top: 4px">版权归铼众医疗所有</div>
	</div>
        
       
</body>
</html>