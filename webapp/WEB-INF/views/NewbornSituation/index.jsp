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
<script type="text/javascript" src="/static/js/NewbornSituation/NewbornSituation.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="NewbornSituationDatagrid"></table>
	<div id="NewbornSituationDatagridToolbar">
		<a data-cmd="NewbornSituationAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="NewbornSituationEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="NewbornSituationRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="NewbornSituationReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<a data-cmd="NewbornSituationpreWoman" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-reload'">转为孕妇</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="NewbornSituationSearchForm">
			关键字:<input id="keyword" name="q" class="easyui-textbox" style="width:100px;">
			孕妇标示:
			<select id="isPregnantwoman" name="isPregnantwoman" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="未怀孕">未怀孕</option>   
			    <option value="已怀孕">已怀孕</option>
			    <option value="已生产">已生产</option>
			    <option value="未知">未知</option>
			       
			</select> 
			<a data-cmd="NewbornSituationSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="NewbornSituationHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="NewbornSituationDialog">
		<form id="NewbornSituationDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>出生顺序:</td>
					<td>
						<input name="birthorder" class="easyui-textbox" required="true"  style="width:140px"> 
					</td>
				
					<td>出生时间:</td>
					<td>
						<input name="birthdate" labelAlign="right" class="easyui-textbox" style="width:90px" required="true">
						 
					</td>
				</tr>
				 <tr>
					<td>性别:</td>
					<td>
						<input name="sex"  type="radio" value="男"/>男
						<input name="sex"  type="radio" value="女"/>女
					</td>
				
					<td>Apga一分钟评分:</td>
					<td>
						<input name="apgaone" class="easyui-textbox" style="width:30px" required="true"> 
					</td>
				</tr>
				 <tr>
					<td>Apga五分钟评分:</td>
					<td>
						<input name="apgarfive" class="easyui-datebox" style="width:90px"> 
					</td>
				
					<td>出生缺陷:</td>
					<td>
						<input name="birthdefect" style="width:100px"> 
					</td>
				</tr>
				 <tr>
					<td>病理性黄疸:</td>
					<td>
						<input name="pathologicjaundice" class="easyui-textbox" style="width:60px"> 
					</td>
			
					<td>呼吸窘迫综合症:</td>
					<td>
    					<input name="respiratorydistress" style="width:80px">   
					</td>
				</tr>
				
				<tr>
					<td>分娩胎位:</td>
					<td>
						<input name="deliveryposition" style="width:80px">
					</td>
		
					<td>分娩胎位详情:</td>
					<td>
    					<input id="deliverypositiondetails" name="malformationdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;">
					</td>
				</tr>
				
				<tr>
					<td>分娩方式:</td>
					<td>
						<input name="modeofdelivery" style="width:110px">
					</td>
				
					<td>分娩方式详情:</td>
					<td>
    					<input name="modeofdeliverydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;">
					</td>
				</tr>
				<tr>
					<td>肺炎:</td>
					<td>
						<input name="pneumonia" style="width:130px">
						<!-- <input name="town" class="easyui-textbox" style="width:60px"> -->
					</td>
			
					<td>硬肿症:</td>
					<td>
						<input name="scleroma" class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				
				<tr>
					<td>产伤:</td>
					<td>
						<input name="birthinjury" class="easyui-textbox" style="width:140px"> 
					</td>
			
					<td>产伤详情:</td>
					<td>
    					<input name="birthinjurydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;">
					</td>
				</tr>
				
				<tr>
					<td>缺氧缺血性脑病:</td>
					<td>
						<input name="encephalopathyhie" class="easyui-textbox" style="width:145px"> 
					</td>
			
					<td>脐部感染:</td>
					<td>
						<input name="umbilicalinfection" validType="idNumber" class="easyui-textbox" style="width:145px" required="true"> 
					</td>
				</tr>
				
				<tr>
					<td>外生殖器:</td>
					<td>
						<!-- <input name="isLocal" class="easyui-textbox" style="width:60px"> -->
						<input name="externalgenitalorgans"  type="radio" value="本地"/>本地
					</td>
			
					<td>败血症:</td>
					<td>
						<input name="septicemia" class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				
				<tr>
					<td>破伤风:</td>
					<td>
						<input name="tetanus" class="easyui-textbox" style="width:140px"> 
					</td>
			
					<td>消化不良:</td>
					<td>
						<input name="indigestion" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				
				<tr>
					<td>体重(g):</td>
					<td>
						<input name="weight" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				<tr>
					<td>精神病:</td>
					<td>
						<input name="tetanus" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>体长(cm):</td>
					<td>
						<input name="height" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				 <tr>
					<td>出生结局:</td>
					<td>
						<input name="birthoutcomes" class="easyui-textbox" style="width:140px"> 
					</td>
				
					<td>出生结局详情:</td>
					<td>
						<input id="birthoutcomesdetails" name="dementiadescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				 <tr>
					<td>新生儿存活:</td>
					<td>
						<input name="neonatalsurvival" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>死胎死产原因:</td>
					<td>
						<input name="stillbirthcause" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				
				<tr>
					<td>死胎死产原因详情:</td>
					<td>
						<input id="stillbirthcausedetails" name="geneticdiseasedescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
		
					<td>新生儿死亡原因:</td>
					<td>
						<input id="neonataldeathcause" name="geneticdiseasedescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				<tr>
					<td>新生儿存活:</td>
					<td>
						<input name="neonatalsurvival" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>母乳喂养:</td>
					<td>
						<input name="breastfeeding" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				<tr>
					<td>新生儿疾病筛查:</td>
					<td>
						<input name="neonataslscreening" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>新生儿疾病筛查详情:</td>
					<td>
						<input name="neonatalscreeningdetails" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr> 
				<tr>
					<td>填表人:</td>
					<td>
						<input name="filler" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>录入人:</td>
					<td>
						<input name="enter" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr> 
				<tr>
					<td>保健指导:</td>
					<td>
						<input name="healthguidance" class="easyui-textbox" style="width:140px"> 
					</td>
					
				</tr>  
			</table>
		</form>
	</div>
	
	
	<!-- 添加修改模态框按钮 -->
	<div id="NewbornSituationDialogToolbar">
		<a data-cmd="NewbornSituationSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="NewbornSituationCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="NewbornSituationHightSearchDialog">
		<form id="NewbornSituationHightSearchDialogForm" method="post">
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
	<div id="NewbornSituationHightSearchButton">
		<a data-cmd="NewbornSituationHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="NewbornSituationHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>