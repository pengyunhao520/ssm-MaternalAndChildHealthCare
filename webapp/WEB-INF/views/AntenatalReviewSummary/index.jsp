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
<script type="text/javascript" src="/static/js/AntenatalReviewSummary/AntenatalReviewSummary.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="AntenatalReviewSummaryDatagrid"></table>
	<div id="AntenatalReviewSummaryDatagridToolbar">
		<a data-cmd="AntenatalReviewSummaryAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="AntenatalReviewSummaryEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="AntenatalReviewSummaryRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="AntenatalReviewSummaryReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="AntenatalReviewSummarySearchForm">
			关键字:&nbsp;&nbsp;<input id="keyword" name="q" class="easyui-textbox" style="width:100px">
			高危评定:
			<select id="highriskevaluate" name="highriskevaluate" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="正常">正常</option>   
			    <option value="高危">高危</option>
			   
			       
			</select> 
			<a data-cmd="AntenatalReviewSummarySearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="AntenatalReviewSummaryHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="AntenatalReviewSummaryDialog">
		<form id="AntenatalReviewSummaryDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<span style="color:blue;">13周-17周</span>
				</tr>
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
					<td>产前复查总数:</td>
					<td>
						<input id="reviewcount" name="reviewcount" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
					<td>阴道出血</td>
					<td>
						<input class="easyui-combobox" id="vaginalbleeding" style="width:90px" panelHeight="auto" name="vaginalbleeding" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '有',
								value: '有'
							}]" />
					</td>
				</tr>
				<tr>
					<td>妊高征:</td>
					<td>
						<input id="pihCombobox" name="pih.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
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
					<td>高危因素:</td>
					<td>
						<input id="highriskfactorCombobox" name="highriskfactor.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="140px">
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
					<td>高危变化</td>
					<td>
						<input id="highriskchangeCombobox" name="highriskchange.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="140px">
					</td>
				</tr>
				 <div >
					<tr style="word-break:keep-all;">
						<td style="color:blue;">28周-临产</td>
					</tr>
				</div>
				<!-- 28周-临产复查总结 -->
			 	 <tr>
					<td>产前复查总数:</td>
					<td>
						<input id="previewcount" name="previewcount" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>妊高征</td>
					<td>
						<input id="ppihCombobox" name="ppih.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
				</tr>
				<tr>
					<td>前置胎盘:</td>
					<td>
						<input id="placentapreviaCombobox" name="placentaprevia.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
					<td>胎盘早剥</td>
					<td>
						<input id="placentalabruptionCombobox" name="placentalabruption.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
				</tr>
				<tr>
					<td>胎位:</td>
					<td>
						<input id="fetalpositionCombobox" name="fetalposition.id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
					<td>多胎:</td>
					<td>
						<input class="easyui-combobox" id="multiplebirth" style="width:90px" panelHeight="auto" name="multiplebirth" data-options="
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
				</tr>
				<tr>
					<td>羊水:</td>
					<td>
						<input class="easyui-combobox" id="amnioticfluid" style="width:90px" panelHeight="auto" name="amnioticfluid" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '羊水过多',
								value: '羊水过多'
							},{
								label: '羊水过少',
								value: '羊水过少'
							}]" />
					</td>
					<td>骨盆狭窄:</td>
					<td>
						<input class="easyui-combobox" id="pelvicstenosis" style="width:90px" panelHeight="auto" name="pelvicstenosis" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '是',
								value: '是'
							},{
								label: '否',
								value: '否'
							}]" />
					</td>
				</tr>
				<tr>
					<td>胎儿发育:</td>
					<td>
						<input class="easyui-combobox" id="developmentaldelay" style="width:90px" panelHeight="auto" name="developmentaldelay" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '正常',
								value: '正常'
							},{
								label: '迟缓',
								value: '迟缓'
							}]" />
					</td>
					<td>胎儿窘迫:</td>
					<td>
						<input class="easyui-combobox" id="fetaldistress"width:90px" panelHeight="auto" name="fetaldistress" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '急性胎儿窘迫',
								value: '急性胎儿窘迫'
							},{
								label: '慢性胎儿窘迫',
								value: '慢性胎儿窘迫'
							}]" />
					</td>
				</tr>
				<tr>
					<td>心脏病:</td>
					<td>
						<input id="heartdiseaseCombobox" name="heartdisease.id" class="easyui-textbox" style="width:110px" required="true" panelHeight="auto">
					</td>
					<td>病毒性肝炎:</td>
					<td>
						<input id="viralhepatitisCombobox" name="viralhepatitis.id" class="easyui-textbox" style="width:110px" required="true" panelHeight="auto"> 
					</td>
				</tr>
				<tr>
					<td>尿蛋白:</td>
					<td>
						<input class="easyui-combobox" id="purineprotein" style="width:90px" panelHeight="auto" name="purineprotein" data-options="
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
					<td>血红蛋白:</td>
					<td>
						<input id="hemoglobin" name="hemoglobin" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
				</tr>
				<tr>
					<td>高危评定:</td>
					<td>
						<input class="easyui-combobox" id="phighriskevaluate" style="width:90px" panelHeight="auto" name="phighriskevaluate" data-options="
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
					<td>高危变化:</td>
					<td>
						<input id="phighriskchangeCombobox" name="phighriskchange,id" class="easyui-textbox" style="width:120px" required="true" panelHeight="109px">
					</td>
				</tr>
				<tr>
					<td>补充说明:</td>
					<td>
						<input id="additionalremarks" name="additionalremarks" multiline="true" class="easyui-textbox" style="width:140px;height:55px;"> 
					</td>
					<td>总结日期:</td>
					<td>
						<input id="summarydate" name="summarydate" class="easyui-datebox" style="width:90px">
					</td>
				</tr>
				<tr>
					<td>填表人:</td>
					<td>
						<input id="fillperson" name="fillperson" labelAlign="right" class="easyui-textbox" style="width:95px"> 
					</td>
					<td>录入人:</td>
					<td>
						<input id="inputperson" name="inputperson" labelAlign="right" class="easyui-textbox" style="width:95px"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
		<!-- 添加修改模态框按钮 -->
	<div id="AntenatalReviewSummaryDialogToolbar">
		<a data-cmd="AntenatalReviewSummarySave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="AntenatalReviewSummaryCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="AntenatalReviewSummaryHightSearchDialog">
		<form id="AntenatalReviewSummaryHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>产前复查总数:</td>
					<td>
						<input id="reviewcount" name="reviewcount" labelAlign="right" class="easyui-numberbox" style="width:95px"> 
					</td>
					<td>阴道出血</td>
					<td>
						<input class="easyui-combobox" id="vaginalbleeding" style="width:90px" panelHeight="auto" name="vaginalbleeding" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '无',
								value: '无'
							},{
								label: '有',
								value: '有'
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
			</table>
		</form>
	</div>
	
	<!-- 高级查询按钮 -->
	<div id="AntenatalReviewSummaryHightSearchButton">
		<a data-cmd="AntenatalReviewSummaryHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="AntenatalReviewSummaryHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>