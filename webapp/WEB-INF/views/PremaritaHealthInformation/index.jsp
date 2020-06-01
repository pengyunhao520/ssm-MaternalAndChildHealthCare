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
<script type="text/javascript" src="/static/js/PremaritaHealthInformation/PremaritaHealthInformation.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="PremaritaHealthInformationDatagrid"></table>
	<div id="PremaritaHealthInformationDatagridToolbar">
		<a data-cmd="PremaritaHealthInformationAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="PremaritaHealthInformationEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="PremaritaHealthInformationRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="PremaritaHealthInformationReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="PremaritaHealthInformationSearchForm">
			关键字:&nbsp;&nbsp;<input id="keyword" name="q" class="easyui-textbox" style="width:100px">
			婚检结果:
			<select id="premaritalexamination" name="premaritalexamination" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="正常">正常</option>   
			    <option value="异常">异常</option>
			   
			       
			</select> 
			<a data-cmd="PremaritaHealthInformationSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a data-cmd="PremaritaHealthInformationHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="PremaritaHealthInformationDialog">
		<form id="PremaritaHealthInformationDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>孕妇身份证号:</td>
					<td>
						<input id="preidnumberCombobox" name="preidnumber" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加人员基本信息" required="true" panelHeight="auto">
					</td>
					<td>孕妇姓名:</td>
					<td>
						<input id="prename" name="prename" labelAlign="right" class="easyui-textbox" style="width:95px">
					</td>
				</tr>
				 <tr>
					<td>与配偶血缘关系:</td>
					<td>
						<input class="easyui-combobox" id="consanguinity" style="width:90px" panelHeight="auto" name="consanguinity" data-options="
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
					<td>与配偶血缘关系详情:</td>
					<td>
						<input id="consanguinitydetails" name="consanguinitydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>既往病史:</td>
					<td>
						<input class="easyui-combobox" id="medicalHistory" style="width:90px" panelHeight="auto" name="medicalhistory" data-options="
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
					<td>既往病史详情:</td>
					<td>
						<input id="medicalhistorydetails" name="medicalhistorydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>现病史:</td>
					<td>
						<input class="easyui-combobox" id="nowmedicalhistory" style="width:90px" panelHeight="auto" name="nowMedicalHistory" data-options="
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
					<td>现病史详情:</td>
					<td>
						<input id="nowmedicalhistorydetails" name="nowmedicalhistorydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>初潮年龄:</td>
					<td>
						<input id="menarcheage" name="menarcheage" style="width:60px;">
					</td>
					<td>初潮年龄详情</td>
					<td>
						<input id="menarcheagedetails" name="menarcheagedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>经期周期(天):</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="menstrualcycle" name="menstrualcycle" style="width:60px;">
					</td>
					<td>经期周期详情</td>
					<td>
						<input id="menstrualcycleDetails" name="menstrualcycleDetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>量(ml):</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="amount" name="amount" style="width:60px;">
					</td>
					<td>量详情</td>
					<td>
						<input id="amountdetails" name="amountdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>既往婚育史:</td>
					<td>
						<input class="easyui-combobox" id="pastmarriagehistory" style="width:90px" panelHeight="auto" name="pastmarriagehistory" data-options="
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
					<td>既往婚育史详情:</td>
					<td>
						<input id="pastmarriagehistorydetails" name="pastmarriagehistorydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>家族遗传史:</td>
					<td>
						<input class="easyui-combobox" id="familygenetichistory" style="width:90px" panelHeight="auto" name="familygenetichistory" data-options="
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
					<td>家族遗传史详情:</td>
					<td>
						<input id="familygenetichistorydetails" name="familygenetichistorydetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>家族近亲婚配:</td>
					<td>
						<input class="easyui-combobox" id="familymarriage" style="width:90px" panelHeight="auto" name="familymarriage" data-options="
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
					<td>家族近亲婚配详情:</td>
					<td>
						<input id="familymarriagedetails" name="familymarriagedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>特殊体态:</td>
					<td>
						<input class="easyui-combobox" id="specialposture" style="width:90px" panelHeight="auto" name="specialposture" data-options="
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
					<td>特殊体态详情:</td>
					<td>
						<input id="specialposturedetails" name="specialposturedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>精神状态:</td>
					<td>
						<input class="easyui-combobox" id="mentaloutlook" style="width:90px" panelHeight="auto" name="mentaloutlook" data-options="
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
					<td>精神状态详情:</td>
					<td>
						<input id="mentaloutlookdetails" name="mentaloutlookdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>特殊面容:</td>
					<td>
						<input class="easyui-combobox" id="specialface" style="width:90px" panelHeight="auto" name="specialface" data-options="
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
					<td>特殊面容详情:</td>
					<td>
						<input id="specialfacedetails" name="specialfacedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>智力:</td>
					<td>
						<input class="easyui-combobox" id="intelligence" style="width:90px" panelHeight="auto" name="intelligence" data-options="
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
					<td>智力详情:</td>
					<td>
						<input id="intelligencedetails" name="intelligencedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>皮肤毛发:</td>
					<td>
						<input class="easyui-combobox" id="skinhair" style="width:90px" panelHeight="auto" name="skinhair" data-options="
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
					<td>皮肤毛发详情:</td>
					<td>
						<input id="skinhairdetails" name="skinhairdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
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
					<td>肺详情:</td>
					<td>
						<input id="lungdetails" name="lungdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>肝:</td>
					<td>
						<input class="easyui-combobox" id="liver" style="width:90px" panelHeight="auto" name="liver" data-options="
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
					<td>肝详情:</td>
					<td>
						<input id="liverdetails" name="liverdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>四肢脊柱:</td>
					<td>
						<input class="easyui-combobox" id="limbsspine" style="width:90px" panelHeight="auto" name="limbsspine" data-options="
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
					<td>四肢脊柱详情:</td>
					<td>
						<input id="limbsspinedetails" name="limbsspinedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>阴毛:</td>
					<td>
						<input class="easyui-combobox" id="pubichair" style="width:90px" panelHeight="auto" name="pubichair" data-options="
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
					<td>阴毛详情:</td>
					<td>
						<input id="pubichairdetails" name="pubichairdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>乳房:</td>
					<td>
						<input class="easyui-combobox" id="breast" style="width:90px" panelHeight="auto" name="breast" data-options="
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
					<td>乳房详情:</td>
					<td>
						<input id="breastdetails" name="breastdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>生殖器:</td>
					<td>
						<input class="easyui-combobox" id="genitals" style="width:90px" panelHeight="auto" name="genitals" data-options="
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
					<td>生殖器详情:</td>
					<td>
						<input id="genitalsdetails" name="genitalsdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>阴道检查:</td>
					<td>
						<input class="easyui-combobox" id="vaginalexamination" style="width:90px" panelHeight="auto" name="vaginalexamination" data-options="
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
					<td>阴道检查详情:</td>
					<td>
						<input id="vaginalexaminationdetails" name="vaginalexaminationdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>实验室检查:</td>
					<td>
						<input class="easyui-combobox" id="laboratoryexamination" style="width:90px" panelHeight="auto" name="laboratoryexamination" data-options="
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
					<td>实验室检查详情:</td>
					<td>
						<input id="laboratoryexaminationdetails" name="laboratoryexaminationdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>婚检结果:</td>
					<td>
						<input class="easyui-combobox" id="premaritalexamination" style="width:90px" panelHeight="auto" name="premaritalexamination" data-options="
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
					<td>婚检结果详情:</td>
					<td>
						<input id="premaritalexaminationdetails" name="premaritalexaminationdetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>医学意见:</td>
					<td>
						<input class="easyui-combobox" id="medicaladvice" style="width:90px" panelHeight="auto" name="medicaladvice" data-options="
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
					<td>医学意见详情:</td>
					<td>
						<input id="medicaladvicedetails" name="medicaladvicedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>咨询指导:</td>
					<td>
						<input class="easyui-combobox" id="consultationguidance" style="width:90px" panelHeight="auto" name="consultationguidance" data-options="
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
					<td>咨询指导详情:</td>
					<td>
						<input id="consultationguidancedetails" name="consultationguidancedetails" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				 <tr>
					<td>叶酸开始日期:</td>
					<td>
						<input name="folicbegintime" class="easyui-datebox" style="width:90px"> 
					</td>
					<td>叶酸结束日期:</td>
					<td>
						<input name="folicdetailsendtime" class="easyui-datebox" style="width:90px"> 
					</td>
				</tr>
				 <tr>
					<td>碘丸开始日期:</td>
					<td>
						<input name="iodinepillsbegintime" class="easyui-datebox" style="width:90px"> 
					</td>
					<td>碘丸用量(粒/次):</td>
					<td>
						<input id="iodinepillsdosage" name="iodinepillsdosage" style="width:60px;">
					</td>
				</tr>
			</table>
		</form>
	</div>
		<!-- 添加修改模态框按钮 -->
	<div id="PremaritaHealthInformationDialogToolbar">
		<a data-cmd="PremaritaHealthInformationSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="PremaritaHealthInformationCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="PremaritaHealthInformationHightSearchDialog">
		<form id="PremaritaHealthInformationHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>孕妇身份证号:</td>
					<td>
						<input id="preidnumberCombobox" name="preidnumber" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加孕妇基本信息" panelHeight="auto">
					</td>
				
					<td>孕妇姓名:</td>
					<td>
						<input id="prename" name="prename" labelAlign="right" class="easyui-textbox" style="width:95px">
					</td>
				</tr>
				<tr>
					<td>婚检地点:</td>
					<td>
						<input name="premaritalexaminationaddress" labelAlign="right" class="easyui-textbox" style="width:140px">
					</td>
					<td>既往病史:</td>
					<td>
						<input class="easyui-combobox" id="medicalHistory" style="width:90px" panelHeight="auto" name="medicalhistory" data-options="
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
					<td>初潮年龄:</td>
					<td>
						<input id="menarcheage" name="menarcheage" style="width:60px;">
					</td>
					<td>经期周期(天):</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="menstrualcycle" name="menstrualcycle" style="width:60px;">
					</td>
				</tr>
				<tr>
					<td>量(ml):</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="amount" name="amount" style="width:60px;">
					</td>
					<td>既往婚育史:</td>
					<td>
						<input class="easyui-combobox" id="pastmarriagehistory" style="width:90px" panelHeight="auto" name="pastmarriagehistory" data-options="
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
					<td>家族遗传史:</td>
					<td>
						<input class="easyui-combobox" id="familygenetichistory" style="width:90px" panelHeight="auto" name="familygenetichistory" data-options="
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
					<td>家族近亲婚配:</td>
					<td>
						<input class="easyui-combobox" id="familymarriage" style="width:90px" panelHeight="auto" name="familymarriage" data-options="
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
					<td>特殊体态:</td>
					<td>
						<input class="easyui-combobox" id="specialposture" style="width:90px" panelHeight="auto" name="specialposture" data-options="
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
					<td>精神状态:</td>
					<td>
						<input class="easyui-combobox" id="mentaloutlook" style="width:90px" panelHeight="auto" name="mentaloutlook" data-options="
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
					<td>特殊面容:</td>
					<td>
						<input class="easyui-combobox" id="specialface" style="width:90px" panelHeight="auto" name="specialface" data-options="
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
					<td>智力:</td>
					<td>
						<input class="easyui-combobox" id="intelligence" style="width:90px" panelHeight="auto" name="intelligence" data-options="
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
					<td>皮肤毛发:</td>
					<td>
						<input class="easyui-combobox" id="skinhair" style="width:90px" panelHeight="auto" name="skinhair" data-options="
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
					<td>肝:</td>
					<td>
						<input class="easyui-combobox" id="liver" style="width:90px" panelHeight="auto" name="liver" data-options="
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
					<td>四肢脊柱:</td>
					<td>
						<input class="easyui-combobox" id="limbsspine" style="width:90px" panelHeight="auto" name="limbsspine" data-options="
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
					<td>阴毛:</td>
					<td>
						<input class="easyui-combobox" id="pubichair" style="width:90px" panelHeight="auto" name="pubichair" data-options="
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
					<td>乳房:</td>
					<td>
						<input class="easyui-combobox" id="breast" style="width:90px" panelHeight="auto" name="breast" data-options="
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
					<td>生殖器:</td>
					<td>
						<input class="easyui-combobox" id="genitals" style="width:90px" panelHeight="auto" name="genitals" data-options="
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
					<td>婚检结果:</td>
					<td>
						<input class="easyui-combobox" id="premaritalexamination" style="width:90px" panelHeight="auto" name="premaritalexamination" data-options="
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
	<div id="PremaritaHealthInformationHightSearchButton">
		<a data-cmd="PremaritaHealthInformationHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="PremaritaHealthInformationHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	

</body>
</html>