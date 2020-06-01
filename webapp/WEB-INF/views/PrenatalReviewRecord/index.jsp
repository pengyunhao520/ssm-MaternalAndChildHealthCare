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
<script type="text/javascript" src="/static/js/PrenatalReviewRecord/PrenatalReviewRecord.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="PrenatalReviewRecordDatagrid"></table>
	<div id="PrenatalReviewRecordDatagridToolbar">
		<a data-cmd="PrenatalReviewRecordAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="PrenatalReviewRecordEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="PrenatalReviewRecordRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="PrenatalReviewRecordReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="PrenatalReviewRecordSearchForm">
			关键字:&nbsp;&nbsp;<input id="keyword" name="q" class="easyui-textbox" style="width:100px">
			高危评定:
			<select id="highriskevaluate" name="highriskevaluate" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="正常">正常</option>   
			    <option value="高危">高危</option>
			   
			       
			</select> 
			<a data-cmd="PrenatalReviewRecordSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="PrenatalReviewRecordHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="PrenatalReviewRecordDialog">
		<form id="PrenatalReviewRecordDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>身份证号:</td>
					<td>
						<input id="preidnumberCombobox" name="preidnumber" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加人员基本信息" required="true" panelHeight="auto">
					</td>
					<td>姓名:</td>
					<td>
						<input id="prename" name="prename" labelAlign="right" class="easyui-textbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td>
						<input id="prephonenumber" name="prephonenumber" labelAlign="right" class="easyui-textbox" style="width:140px">
					</td>
					<td>保健册号:</td>
					<td>
						<input id="healthcode" name="healthcode" labelAlign="right" class="easyui-textbox" style="width:140px">
					</td>
				</tr>
				 <tr>
					<td>复查日期:</td>
					<td>
						<input name="reviewdate" class="easyui-datebox" style="width:90px">
					</td>
					<td>孕周:</td>
					<td>
						<input id="gestationalweek" name="gestationalweek" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>收缩压(kpa):</td>
					<td>
						<input id="systolicpressure" name="systolicpressure" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>舒张压(kpa):</td>
					<td>
						<input id="diastolicpressure" name="diastolicpressure" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>体重(kg):</td>
					<td>
						<input id="weight" name="weight" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>宫高(cm):</td>
					<td>
						<input id="fundalheight" name="fundalheight" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>腹围(cm):</td>
					<td>
						<input id="abdominalcircumference" name="abdominalcircumference" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
					<td>胎位</td>
					<td>
						<input id="fetalpositionCombobox" name="fetalposition.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="140px">
					</td>
				</tr>
				<tr>
					<td>胎先露:</td>
					<td>
						<input id="fetalpresentationCombobox" name="fetalpresentation.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
					<td>胎心(次/分)</td>
					<td>
						<input id="fetalheart" name="fetalheart" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>血糖(mmol/L):</td>
					<td>
						<input id="bloodsugar" name="bloodsugar" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>水肿</td>
					<td>
						<input class="easyui-combobox" id="edema" style="width:90px" panelHeight="auto" name="edema" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '过胖性水肿',
								value: '过胖性水肿'
							},{
								label: '生理性水肿',
								value: '生理性水肿'
							},{
								label: '病态性水肿',
								value: '病态性水肿'
							}]" />
					</td>
				</tr>
				<tr>
					<td>尿蛋白:</td>
					<td>
						<input class="easyui-combobox" id="urineprotein" style="width:90px" panelHeight="auto" name="urineprotein" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '功能性尿蛋白',
								value: '功能性尿蛋白'
							},{
								label: '体位性尿蛋白',
								value: '体位性尿蛋白'
							},{
								label: '病理性尿蛋白',
								value: '病理性尿蛋白'
							}]" />
					</td>
					<td>血色素(g/dl):</td>
					<td>
						<input id="hemoglobin" name="hemoglobin" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>B超筛查:</td>
					<td>
						<input class="easyui-combobox" id="bmode" style="width:90px" panelHeight="auto" name="bmode" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '异常',
								value: '异常'
							}]" />
					</td>
					<td>复查问题描述:</td>
					<td>
						<input id="reviewquestionsdescribe" name="reviewquestionsdescribe" multiline="true" class="easyui-textbox" style="width:140px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>高危评定:</td>
					<td>
						<input class="easyui-combobox" id="highriskevaluate" style="width:90px" panelHeight="auto" name="highriskevaluate" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '高危',
								value: '高危'
							}]" />
					</td>
					<td>高危详情:</td>
					<td>
						<input id="highriskdetails" name="highriskdetails" multiline="true" class="easyui-textbox" style="width:140px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>预约日期:</td>
					<td>
						<input name="appointmentdate" class="easyui-datebox" style="width:90px">
					</td>
					<td>检查医生:</td>
					<td>
						<input id="checkdoctor" name="checkdoctor" labelAlign="right" class="easyui-textbox" style="width:95px"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
		<!-- 添加修改模态框按钮 -->
	<div id="PrenatalReviewRecordDialogToolbar">
		<a data-cmd="PrenatalReviewRecordSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="PrenatalReviewRecordCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="PrenatalReviewRecordHightSearchDialog">
		<form id="PrenatalReviewRecordHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>身份证号:</td>
					<td>
						<input id="preidnumberCombobox" name="preidnumber" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加人员基本信息" panelHeight="auto">
					</td>
					<td>姓名:</td>
					<td>
						<input id="prename" name="prename" labelAlign="right" class="easyui-textbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td>
						<input id="prephonenumber" name="prephonenumber" labelAlign="right" class="easyui-textbox" style="width:140px">
					</td>
					<td>保健册号:</td>
					<td>
						<input id="healthcode" name="healthcode" labelAlign="right" class="easyui-textbox" style="width:140px">
					</td>
				</tr>
				 <tr>
					<td>复查日期:</td>
					<td>
						<input name="begintime" class="easyui-datebox" style="width:90px">
						到<input name="endtime" class="easyui-datebox" style="width:90px">
					</td>
					<td>孕周:</td>
					<td>
						<input id="gestationalweek" name="gestationalweek" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>体重(kg):</td>
					<td>
						<input id="weight" name="weight" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>宫高(cm):</td>
					<td>
						<input id="fundalheight" name="fundalheight" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>腹围(cm):</td>
					<td>
						<input id="abdominalcircumference" name="abdominalcircumference" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
					<td>水肿</td>
					<td>
						<input class="easyui-combobox" id="edema" style="width:90px" panelHeight="auto" name="edema" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '过胖性水肿',
								value: '过胖性水肿'
							},{
								label: '生理性水肿',
								value: '生理性水肿'
							},{
								label: '病态性水肿',
								value: '病态性水肿'
							}]" />
					</td>
				</tr>
				<tr>
					<td>尿蛋白:</td>
					<td>
						<input class="easyui-combobox" id="urineprotein" style="width:90px" panelHeight="auto" name="urineprotein" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '功能性尿蛋白',
								value: '功能性尿蛋白'
							},{
								label: '体位性尿蛋白',
								value: '体位性尿蛋白'
							},{
								label: '病理性尿蛋白',
								value: '病理性尿蛋白'
							}]" />
					</td>
					<td>B超筛查:</td>
					<td>
						<input class="easyui-combobox" id="bmode" style="width:90px" panelHeight="auto" name="bmode" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '异常',
								value: '异常'
							}]" />
					</td>
				</tr>
				<tr>
					<td>高危评定:</td>
					<td>
						<input class="easyui-combobox" id="highriskevaluate" style="width:90px" panelHeight="auto" name="highriskevaluate" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '高危',
								value: '高危'
							}]" />
					<td>检查医生:</td>
					<td>
						<input id="checkdoctor" name="checkdoctor" labelAlign="right" class="easyui-textbox" style="width:95px"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 高级查询按钮 -->
	<div id="PrenatalReviewRecordHightSearchButton">
		<a data-cmd="PrenatalReviewRecordHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="PrenatalReviewRecordHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>