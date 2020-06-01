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
<script type="text/javascript" src="/static/js/PersonBasicInformation/PersonBasicInformation.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="PersonBasicInfomationDatagrid"></table>
	<div id="PersonBasicInfomationDatagridToolbar">
		<a data-cmd="PersonBasicInfomationAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="PersonBasicInfomationEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="PersonBasicInfomationRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="PersonBasicInfomationReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<a data-cmd="PersonBasicInfomationpreWoman" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-reload'">转为孕妇</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="PersonBasicInfomationSearchForm">
			关键字:<input id="keyword" name="q" class="easyui-textbox" style="width:100px;">
			孕妇标示:
			<select id="isPregnantwoman" name="isPregnantwoman" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="未怀孕">未怀孕</option>   
			    <option value="已怀孕">已怀孕</option>
			    <option value="已生产">已生产</option>
			    <option value="未知">未知</option>
			       
			</select> 
			<a data-cmd="PersonBasicInfomationSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="PersonBasicInfomationHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="PersonBasicInfomationDialog">
		<form id="PersonBasicInfomationDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>保健册号:</td>
					<td>
						<input name="healthcode" class="easyui-textbox" required="true"  style="width:140px"> 
					</td>
				
					<td>姓名:</td>
					<td>
						<input name="name" labelAlign="right" class="easyui-textbox" style="width:90px" required="true">
						 
					</td>
				</tr>
				 <tr>
					<td>性别:</td>
					<td>
						<input name="sex"  type="radio" value="男"/>男
						<input name="sex"  type="radio" value="女"/>女
					</td>
				
					<td>年龄:</td>
					<td>
						<input name="age" class="easyui-textbox" style="width:30px" required="true"> 
					</td>
				</tr>
				 <tr>
					<td>出生日期:</td>
					<td>
						<input name="birthdate" class="easyui-datebox" style="width:90px"> 
					</td>
				
					<td>民族:</td>
					<td>
						<input id="nationCombobox" name="nation.nationid" style="width:100px"> 
					</td>
				</tr>
				 <tr>
					<td>职业:</td>
					<td>
						<input name="profession" class="easyui-textbox" style="width:60px"> 
					</td>
			
					<td>学历:</td>
					<td>
						<!-- <input id="educationInput" name="education.id" class="easyui-textbox" style="width:60px"> -->
						<%-- <input id="cc" class="easyui-combobox" name="edutation.id"   
    					data-options="valueField:'edutation.id',textField:'education',url:'${pageContext.request.contextPath}/PersonBasicInformation/education'" />  --%> 
    					<input id="educationCombobox" name="education.id" style="width:80px">   
					</td>
				</tr>
				
				<tr>
					<td>家庭角色:</td>
					<td>
						<!-- <input name="familymembertype" class="easyui-textbox" style="width:40px"> -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="familymembertype" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '妻子',
									value: '妻子'
								},{
									label: '丈夫',
									value: '丈夫'
								},{
									label: '(无)未婚',
									value: '(无)未婚'
								}]" />
					</td>
		
					<td>省:</td>
					<td>
						<input id="provinceCombobox" name="province.id" style="width:110px"> 
					</td>
				</tr>
				
				<tr>
					<td>市:</td>
					<td>
						<input id="cityCombobox" name="city.id" style="width:110px">
						<!-- <input name="city" class="easyui-textbox" style="width:60px"> --> 
					</td>
				
					<td>县:</td>
					<td>
						<input id="countyCombobox" name="county.id" style="width:120px">
						<!-- <input name="county" class="easyui-textbox" style="width:60px">  -->
					</td>
				</tr>
				<tr>
					<td>乡镇:</td>
					<td>
						<input id="townCombobox" name="town.id" style="width:130px">
						<!-- <input name="town" class="easyui-textbox" style="width:60px"> -->
					</td>
			
					<td>村:</td>
					<td>
						<input name="gardon" class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				
				<tr>
					<td>工作单位:</td>
					<td>
						<input name="workunit" class="easyui-textbox" style="width:140px"> 
					</td>
			
					<td>手机号:</td>
					<td>
						<input name="phonenumber" validType="phoneNumber" class="easyui-textbox" style="width:100px" required="true"> 
					</td>
				</tr>
				
				<tr>
					<td>微信号:</td>
					<td>
						<input name="wechat" class="easyui-textbox" style="width:145px"> 
					</td>
			
					<td>身份证号:</td>
					<td>
						<input name="idNumber" validType="idNumber" class="easyui-textbox" style="width:145px" required="true"> 
					</td>
				</tr>
				
				<tr>
					<td>户口:</td>
					<td>
						<!-- <input name="isLocal" class="easyui-textbox" style="width:60px"> -->
						<input name="isLocal"  type="radio" value="本地"/>本地
						<input name="isLocal"  type="radio" value="外地"/>外地 
					</td>
			
					<td>生育证号:</td>
					<td>
						<input name="birthcertificatenumber" class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				
				<tr>
					<td>休养地址:</td>
					<td>
						<input name="restaddress" class="easyui-textbox" style="width:140px"> 
					</td>
			
					<td>孕妇标示:</td>
					<td>
						<!-- <input name="isPregnantwoman" class="easyui-textbox" style="width:60px"> -->
<!-- 						<input name="isPregnantwoman"  type="radio" value="未怀孕"/>未怀孕 
						<input name="isPregnantwoman"  type="radio" value="已怀孕"/>已怀孕 
						<input name="isPregnantwoman"  type="radio" value="已生产"/>已生产 
						<input name="isPregnantwoman"  type="radio" value="未知"/>未知  -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="isPregnantwoman" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '未怀孕',
									value: '未怀孕'
								},{
									label: '已怀孕',
									value: '已怀孕'
								},{
									label: '哺乳期',
									value: '哺乳期'
								},{
									label: '未知',
									value: '未知'
								}]" />
						 
					</td>
				</tr>
				
				<tr>
					<td>生育标示:</td>
					<td>
						<!-- <input name="isBirth" class="easyui-textbox" style="width:60px"> -->
<!-- 						<input name="isBirth"  type="radio" value="未生育"/>未怀孕 
						<input name="isBirth"  type="radio" value="生育期"/>已怀孕 
						<input name="isBirth"  type="radio" value="已生育"/>已生产 
						<input name="isBirth"  type="radio" value="未知"/>未知  -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="isBirth" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '未生育',
									value: '未生育'
								},{
									label: '生育期',
									value: '生育期'
								},{
									label: '已生育',
									value: '已生育'
								},{
									label: '未知',
									value: '未知'
								}]" />
					</td>
			
					<td>婚史:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="ss" name="marryhistory" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>精神病:</td>
					<td>
						<!-- <input data-cmd="psychosis" name="psychosis"  type="radio" value="有"/>有
						<input data-cmd="psychosis" name="psychosis"  type="radio" value="无"/>无 -->
						<input class="easyui-combobox" id="psychosis" style="width:90px" panelHeight="auto" name="psychosis" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '有',
									value: '有'
								},{
									label: '无',
									value: '无'
								}]" />
						
					</td>
				
					<td>精神病史描述:</td>
					<td>
						<input id="psychosisdescribe" name="psychosisdescribe" multiline="true" labelAlign="right" class="easyui-textbox" style="width:160px;height:55px;">
					</td>
				</tr>
				 <tr>
					<td>痴呆:</td>
					<td>
						<!-- <input name="dementia"  type="radio" value="有"/>有
						<input name="dementia"  type="radio" value="无"/>无 -->
						<input class="easyui-combobox" id="dementia" style="width:90px" panelHeight="auto" name="dementia" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '有',
									value: '有'
								},{
									label: '无',
									value: '无'
								}]" />
					</td>
				
					<td>痴呆病史描述:</td>
					<td>
						<input id="dementiadescribe" name="dementiadescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				 <tr>
					<td>畸形:</td>
					<td>
						<!-- <input name="malformation"  type="radio" value="有"/>有
						<input name="malformation"  type="radio" value="无"/>无 -->
						<input class="easyui-combobox" id="malformation" style="width:90px" panelHeight="auto" name="malformation" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '有',
									value: '有'
								},{
									label: '无',
									value: '无'
								}]" />
					</td>
			
					<td>畸形描述:</td>
					<td>
    					<input id="malformationdescribe" name="malformationdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;">
					</td>
				</tr>
				
				<tr>
					<td>遗传病史:</td>
					<td>
						<!-- <input name="geneticdisease"  type="radio" value="有"/>有
						<input name="geneticdisease"  type="radio" value="无"/>无 -->
							<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="geneticdisease" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '有',
									value: '有'
								},{
									label: '无',
									value: '无'
								}]" />
					</td>
		
					<td>遗传病史描述:</td>
					<td>
						<input id="geneticdiseasedescribe" name="geneticdiseasedescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr> 
			</table>
		</form>
	</div>
	
	
	<!-- 添加修改模态框按钮 -->
	<div id="PersonBasicInfomationDialogToolbar">
		<a data-cmd="PersonBasicInfomationSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="PersonBasicInfomationCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="PersonBasicInfomationHightSearchDialog">
		<form id="PersonBasicInfomationHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>保健册号:</td>
					<td>
						<input name="healthcode" class="easyui-textbox"  style="width:140px"> 
					</td>
				
					<td>姓名:</td>
					<td>
						<input name="name" labelAlign="right" class="easyui-textbox" style="width:90px">
						 
					</td>
				</tr>
				 <tr>
					<td>性别:</td>
					<td>
						<input name="sex"  type="radio" value="男"/>男
						<input name="sex"  type="radio" value="女"/>女
					</td>
				
					<td>年龄:</td>
					<td>
						<input name="age" class="easyui-textbox" style="width:30px"> 
					</td>
				</tr>
				 <tr>
					<td>出生日期:</td>
					<td>
						<input name="begintime" class="easyui-datebox" style="width:90px"> 
						到<input name="endtime" class="easyui-datebox" style="width:90px"> 
					</td>

					<td>职业:</td>
					<td>
						<input name="profession" class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				
				<tr>
					<td>家庭角色:</td>
					<td>
						<!-- <input name="familymembertype" class="easyui-textbox" style="width:40px"> -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="familymembertype" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '妻子',
									value: '妻子'
								},{
									label: '丈夫',
									value: '丈夫'
								},{
									label: '(无)未婚',
									value: '(无)未婚'
								}]" />
					</td>
				
					<td>工作单位:</td>
					<td>
						<input name="workunit" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				
				<tr>
					<td>手机号:</td>
					<td>
						<input name="phonenumber" class="easyui-textbox" style="width:100px"> 
					</td>
				
					<td>微信号:</td>
					<td>
						<input name="wechat" class="easyui-textbox" style="width:145px"> 
					</td>
				</tr>
				
				<tr>
					<td>身份证号:</td>
					<td>
						<input name="idNumber" class="easyui-textbox" style="width:145px"> 
					</td>
				
					<td>户口:</td>
					<td>
						<!-- <input name="isLocal" class="easyui-textbox" style="width:60px"> -->
						<input name="isLocal"  type="radio" value="本地"/>本地
						<input name="isLocal"  type="radio" value="外地"/>外地 
					</td>
				</tr>
				
				<tr>
					<td>生育证号:</td>
					<td>
						<input name="birthcertificatenumber" class="easyui-textbox" style="width:60px"> 
					</td>
				
					<td>休养地址:</td>
					<td>
						<input name="restaddress" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				
				<tr>
					<td>孕妇标示:</td>
					<td>
						<!-- <input name="isPregnantwoman" class="easyui-textbox" style="width:60px"> -->
						<!-- <input name="isPregnantwoman"  type="radio" value="未怀孕"/>未怀孕 
						<input name="isPregnantwoman"  type="radio" value="已怀孕"/>已怀孕 
						<input name="isPregnantwoman"  type="radio" value="已生产"/>已生产 
						<input name="isPregnantwoman"  type="radio" value="未知"/>未知  -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="isPregnantwoman" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '未怀孕',
									value: '未怀孕'
								},{
									label: '已怀孕',
									value: '已怀孕'
								},{
									label: '哺乳期',
									value: '哺乳期'
								},{
									label: '未知',
									value: '未知'
								}]" />
						 
					</td>
			
					<td>生育标示:</td>
					<td>
						<!-- <input name="isBirth" class="easyui-textbox" style="width:60px"> -->
						<!-- <input name="isBirth"  type="radio" value="未生育"/>未怀孕 
						<input name="isBirth"  type="radio" value="生育期"/>已怀孕 
						<input name="isBirth"  type="radio" value="已生育"/>已生产 
						<input name="isBirth"  type="radio" value="未知"/>未知  -->
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="isBirth" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '未生育',
									value: '未生育'
								},{
									label: '生育期',
									value: '生育期'
								},{
									label: '已生育',
									value: '已生育'
								},{
									label: '未知',
									value: '未知'
								}]" />
					</td>
				</tr> 
			</table>
		</form>
	</div>
	
	<!-- 高级查询按钮 -->
	<div id="PersonBasicInfomationHightSearchButton">
		<a data-cmd="PersonBasicInfomationHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="PersonBasicInfomationHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>