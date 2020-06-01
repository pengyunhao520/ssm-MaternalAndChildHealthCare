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

<script type="text/javascript">
$(function(){
	//声明变量来缓存组件
	var employeeDatagrid;
	//使用声明的变量 来缓存组件
	employeeDatagrid=$("#employeeDatagrid")
	employeeDatagrid.datagrid({
		title:"员工管理",
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
	  		<!-- 列表展示所有员工的datagrid -->
	<table id="employeeDatagrid"></table>
</body>
</html>