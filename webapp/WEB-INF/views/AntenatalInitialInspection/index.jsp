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
<script type="text/javascript" src="/static/js/AntenatalInitialInspection/AntenatalInitialInspection.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="AntenatalInitialInspectionDatagrid"></table>
	<div id="AntenatalInitialInspectionDatagridToolbar">
		<a data-cmd="AntenatalInitialInspectionAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="AntenatalInitialInspectionEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="AntenatalInitialInspectionRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="AntenatalInitialInspectionReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="AntenatalInitialInspectionSearchForm">
			关键字:&nbsp;&nbsp;<input id="keyword" name="q" class="easyui-textbox" style="width:100px">
			高危评定:
			<select id="highriskevaluate" name="highriskevaluate" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="正常">正常</option>   
			    <option value="高危">高危</option>
			   
			       
			</select> 
			<a data-cmd="AntenatalInitialInspectionSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="AntenatalInitialInspectionHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="AntenatalInitialInspectionDialog">
		<form id="AntenatalInitialInspectionDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>孕妇身份证号:</td>
					<td>
						<input id="peidnumberCombobox" name="peidnumber" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加人员基本信息" required="true" panelHeight="auto">
					</td>
					<td>孕妇姓名:</td>
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
					<td>末次月经日期:</td>
					<td>
						<input name="lastmenstruationdate" class="easyui-datebox" style="width:90px"> 
					</td>
					<td>初检孕周:</td>
					<td>
						<input id="initialinspectionweek" name="initialinspectionweek" class="easyui-numberbox" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>预产期:</td>
					<td>
						<input name="epectedchildbirthdate" class="easyui-datebox" style="width:90px"> 
					</td>
					<td>孕次:</td>
					<td>
						<input id="pegnantcount" name="pegnantcount" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>产次:</td>
					<td>
						<input id="productioncount" name="productioncount" style="width:60px;">
					</td>
					<td>身高:</td>
					<td>
						<input id="height" name="height" class="easyui-numberbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>体重:</td>
					<td>
						<input id="weight" name="weight" class="easyui-numberbox" style="width:95px">
					</td>
					<td>收缩压(kpa):</td>
					<td>
						<input id="systolicpressure" name="systolicpressure" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>舒张压(kpa):</td>
					<td>
						<input id="diastolicpressure" name="diastolicpressure" labelAlign="right" class="easyui-numberbox" style="width:95px">
					</td>
					<td>心脏:</td>
					<td>
						<input class="easyui-combobox" id="heart" style="width:90px" panelHeight="auto" name="heart" data-options="
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
					<td>心脏详情</td>
					<td>
						<input id="heartdetails" name="heartdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>肺:</td>
					<td>
						<input class="easyui-combobox" id="lung" style="width:90px" panelHeight="auto" name="lung" data-options="
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
					<td>肺详情</td>
					<td>
						<input id="lungdetails" name="lungdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>阴道炎:</td>
					<td>
						<input class="easyui-combobox" id="vaginitis" style="width:90px" panelHeight="auto" name="vaginitis" data-options="
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
					<td>阴道炎详情</td>
					<td>
						<input id="vaginitisdetails" name="vaginitisdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>宫颈炎:</td>
					<td>
						<input class="easyui-combobox" id="cervicitis" style="width:90px" panelHeight="auto" name="cervicitis" data-options="
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
					<td>宫颈炎详情</td>
					<td>
						<input id="cervicitisdetails" name="cervicitisdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>双阴道双子宫:</td>
					<td>
						<input class="easyui-combobox" id="dublevaginaanduterus" style="width:90px" panelHeight="auto" name="dublevaginaanduterus" data-options="
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
					<td>双阴道双子宫详情</td>
					<td>
						<input id="dublevaginaanduterusdetails" name="dublevaginaanduterusdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>子宫肌瘤:</td>
					<td>
						<input class="easyui-combobox" id="myomauterus" style="width:90px" panelHeight="auto" name="myomauterus" data-options="
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
					<td>子宫肌瘤详情</td>
					<td>
						<input id="myomauterusdetails" name="myomauterusdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>附件肿物:</td>
					<td>
						<input class="easyui-combobox" id="anexalmass" style="width:90px" panelHeight="auto" name="anexalmass" data-options="
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
					<td>附件肿物详情</td>
					<td>
						<input id="aexalmassdetails" name="aexalmassdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>子宫大小与孕周相符:</td>
					<td>
						<input class="easyui-combobox" id="uterussizeationalweek" style="width:90px" panelHeight="auto" name="uterussizeationalweek" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '是',
								value: '是'
							},{
								label: '不是',
								value: '不是'
							}]" />
					</td>
				</tr>
				<tr>
					<td>子宫大小与孕周相符详情</td>
					<td>
						<input id="uterussizeationalweekdetails" name="uterussizeationalweekdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>其他问题:</td>
					<td>
						<input id="otherquestions" name="otherquestions" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>阴道出血:</td>
					<td>
						<input class="easyui-combobox" id="vaginalbleeding" style="width:90px" panelHeight="auto" name="vaginalbleeding" data-options="
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
					<td>剧吐:</td>
					<td>
						<input class="easyui-combobox" id="vomiting " style="width:90px" panelHeight="auto" name="vomiting" data-options="
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
					<td>体温≥38.5持续24小时以上:</td>
					<td>
						<input class="easyui-combobox" id="fever" style="width:90px" panelHeight="auto" name="fever" data-options="
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
					<td>病毒性感染:</td>
					<td>
						<input class="easyui-combobox" id="viralinfection " style="width:90px" panelHeight="auto" name="viralinfection" data-options="
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
					<td>孕前六个月内服用避孕药:</td>
					<td>
						<input class="easyui-combobox" id="acyeterion " style="width:90px" panelHeight="auto" name="acyeterion" data-options="
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
					<td>尿蛋白:</td>
					<td>
						<input class="easyui-combobox" id="urineprotein" style="width:90px" panelHeight="auto" name="urineprotein" data-options="
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
					<td>白带:</td>
					<td>
						<input class="easyui-combobox" id="leucorrhea" style="width:90px" panelHeight="auto" name="leucorrhea" data-options="
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
					<td>血糖:</td>
					<td>
						<input class="easyui-combobox" id="bloodsugar" style="width:90px" panelHeight="auto" name="bloodsugar" data-options="
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
				<td>弓形体:</td>
						<td>
							<input class="easyui-combobox" id="toxoplasma" style="width:90px" panelHeight="auto" name="toxoplasma" data-options="
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
					<td>甲胎蛋白:</td>
					<td>
						<input class="easyui-combobox" id="alphafetoprotein" style="width:90px" panelHeight="auto" name="alphafetoprotein" data-options="
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
					<td>巨细胞病毒:</td>
					<td>
						<input class="easyui-combobox" id="cytomegalovirus" style="width:90px" panelHeight="auto" name="cytomegalovirus" data-options="
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
					<td>GPT或ALT:</td>
					<td>
						<input class="easyui-combobox" id="GPTorALT" style="width:90px" panelHeight="auto" name="GPTorALT" data-options="
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
					<td>HBsAg:</td>
					<td>
						<input class="easyui-combobox" id="hbsag" style="width:90px" panelHeight="auto" name="hbsag" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '阳性',
								value: '阳性'
							},{
								label: '阴性',
								value: '阴性'
							}]" />
					</td>
					<td>风疹病毒:</td>
					<td>
						<input class="easyui-combobox" id="rubellavirus" style="width:90px" panelHeight="auto" name="rubellavirus" data-options="
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
					<td>梅毒:</td>
					<td>
						<input class="easyui-combobox" id="syphilis" style="width:90px" panelHeight="auto" name="syphilis" data-options="
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
					<td>血型:</td>
					<td>
						<input class="easyui-combobox" id="bloodtype" style="width:90px" panelHeight="auto" name="bloodtype" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: 'A型',
								value: 'A型'
							},{
								label: 'B型',
								value: 'B型'
							},{
								label: 'AB型',
								value: 'AB型'
							},{
								label: 'O型',
								value: 'O型'
							},{
								label: 'Rh阳性',
								value: 'Rh阳性'
							},{
								label: 'Rh阴性',
								value: 'Rh阴性'
							}]" />
					</td>
				</tr>
				<tr>
					<td>其他检查详情:</td>
					<td>
						<input id="othercheckdetails" name="othercheckdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>高危评定:</td>
					<td>
						<input class="easyui-combobox" id="highriskevaluate" style="width:90px" panelHeight="auto" name="highriskevaluate" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: '高危',
								value: '高危'
							},{
								label: '正常',
								value: '正常'
							}]" />
					</td>
				</tr>
				<tr>
					<td>高危详情:</td>
					<td>
						<input id="highriskdetails" name="highriskdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
					<td>髂前上棘间径(cm):</td>
					<td>
						<input id="anteriorsuperiorspine" name="anteriorsuperiorspine" class="easyui-numberbox" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>髂前间径(cm):</td>
					<td>
						<input id="Anterioriliac" name="Anterioriliac" class="easyui-numberbox" style="width:60px;">
					</td>
					<td>骶耻外径(cm):</td>
					<td>
						<input id="sacroiliacexternaldiameter" name="sacroiliacexternaldiameter" class="easyui-numberbox" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>坐骨结节间径(cm):</td>
					<td>
						<input id="sciatictubercle" name="sciatictubercle" class="easyui-numberbox" style="width:60px;">
					</td>
					<td>检查日期:</td>
					<td>
						<input name="checkdate" class="easyui-datebox" style="width:90px"> 
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
	<div id="AntenatalInitialInspectionDialogToolbar">
		<a data-cmd="AntenatalInitialInspectionSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="AntenatalInitialInspectionCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="AntenatalInitialInspectionHightSearchDialog">
		<form id="AntenatalInitialInspectionHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>预产期:</td>
					<td>
						<input name="begintime" class="easyui-datebox" style="width:90px"> 
						到<input name="endtime" class="easyui-datebox" style="width:90px"> 
					</td>
					<td>孕次:</td>
					<td>
						<input id="pegnantcountSearch" name="pegnantcount" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>产次:</td>
					<td>
						<input id="productioncountSearch" name="productioncount" style="width:60px;">
					</td>
					<td>阴道炎:</td>
					<td>
						<input class="easyui-combobox" id="vaginitis" style="width:90px" panelHeight="auto" name="vaginitis" data-options="
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
					<td>宫颈炎:</td>
					<td>
						<input class="easyui-combobox" id="cervicitis" style="width:90px" panelHeight="auto" name="cervicitis" data-options="
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
					<td>子宫肌瘤:</td>
					<td>
						<input class="easyui-combobox" id="myomauterus" style="width:90px" panelHeight="auto" name="myomauterus" data-options="
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
					<td>附件肿物:</td>
					<td>
						<input class="easyui-combobox" id="anexalmass" style="width:90px" panelHeight="auto" name="anexalmass" data-options="
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
					<td>阴道出血:</td>
					<td>
						<input class="easyui-combobox" id="vaginalbleeding" style="width:90px" panelHeight="auto" name="vaginalbleeding" data-options="
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
				<tr/>
				<tr>
					<td>剧吐:</td>
					<td>
						<input class="easyui-combobox" id="vomiting " style="width:90px" panelHeight="auto" name="vomiting" data-options="
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
					<td>病毒性感染:</td>
					<td>
						<input class="easyui-combobox" id="viralinfection " style="width:90px" panelHeight="auto" name="viralinfection" data-options="
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
				<tr/>
				<tr>
					<td>尿蛋白:</td>
					<td>
						<input class="easyui-combobox" id="urineprotein" style="width:90px" panelHeight="auto" name="urineprotein" data-options="
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
					<td>白带:</td>
					<td>
						<input class="easyui-combobox" id="leucorrhea" style="width:90px" panelHeight="auto" name="leucorrhea" data-options="
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
				<tr/>
				<tr>
					<td>血糖:</td>
					<td>
						<input class="easyui-combobox" id="bloodsugar" style="width:90px" panelHeight="auto" name="bloodsugar" data-options="
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
					<td>甲胎蛋白:</td>
					<td>
						<input class="easyui-combobox" id="alphafetoprotein" style="width:90px" panelHeight="auto" name="alphafetoprotein" data-options="
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
				<tr/>
				<tr>
					<td>巨细胞病毒:</td>
					<td>
						<input class="easyui-combobox" id="cytomegalovirus" style="width:90px" panelHeight="auto" name="cytomegalovirus" data-options="
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
					<td>GPT或ALT:</td>
					<td>
						<input class="easyui-combobox" id="GPTorALT" style="width:90px" panelHeight="auto" name="GPTorALT" data-options="
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
				<tr/>
				<tr>
					<td>梅毒:</td>
					<td>
						<input class="easyui-combobox" id="syphilis" style="width:90px" panelHeight="auto" name="syphilis" data-options="
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
					<td>血型:</td>
					<td>
						<input class="easyui-combobox" id="bloodtype" style="width:90px" panelHeight="auto" name="bloodtype" data-options="
							valueField: 'label',
							textField: 'value',
							data: [{
								label: 'A型',
								value: 'A型'
							},{
								label: 'B型',
								value: 'B型'
							},{
								label: 'AB型',
								value: 'AB型'
							},{
								label: 'O型',
								value: 'O型'
							},{
								label: 'Rh阳性',
								value: 'Rh阳性'
							},{
								label: 'Rh阴性',
								value: 'Rh阴性'
							}]" />
					</td>
				<tr/>
				<tr>
					<td>HBsAg:</td>
						<td>
							<input class="easyui-combobox" id="hbsag" style="width:90px" panelHeight="auto" name="hbsag" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '阳性',
									value: '阳性'
								},{
									label: '阴性',
									value: '阴性'
								}]" />
						</td>
						<td>高危评定:</td>
						<td>
							<input class="easyui-combobox" id="highriskevaluate" style="width:90px" panelHeight="auto" name="highriskevaluate" data-options="
								valueField: 'label',
								textField: 'value',
								data: [{
									label: '高危',
									value: '高危'
								},{
									label: '正常',
									value: '正常'
								}]" />
						</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 高级查询按钮 -->
	<div id="AntenatalInitialInspectionHightSearchButton">
		<a data-cmd="AntenatalInitialInspectionHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="AntenatalInitialInspectionHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>