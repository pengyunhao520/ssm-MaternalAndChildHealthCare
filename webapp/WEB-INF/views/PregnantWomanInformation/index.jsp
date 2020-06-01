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
<script type="text/javascript" src="/static/js/PregnantWomanInformation/PregnantWomanInformation.js">
</script>

</head>
<body>
	<!-- 列表展示所有员工的datagrid -->
	<table id="PregnantWomanInformationDatagrid"></table>
	<div id="PregnantWomanInformationDatagridToolbar">
		<a data-cmd="PregnantWomanInformationAdd" href="javascript:;" class="easyui-linkbutton c8" data-options="iconCls:'icon-add'">添加</a>
		<a data-cmd="PregnantWomanInformationEdit" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-edit'">修改</a>
		<a data-cmd="PregnantWomanInformationRemove" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-remove'">删除</a>
		<a data-cmd="PregnantWomanInformationReload" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload'">刷新</a>
		<a data-cmd="PregnantWomanInformationpreWoman" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-man'">转为普通人员</a>
		<!-- 通过序列号化表单获取表单中字段的值 -->
		<form id="PregnantWomanInformationSearchForm">
			关键字:&nbsp;<input id="keyword" name="q" class="easyui-textbox" style="width:100px;">
			孕妇标示:
			<select id="isPregnantwoman" name="ispregnantwoman" class="easyui-combobox" panelHeight="auto" style="width:100px;">   
			    <option value="">--请选择--</option>   
			    <option value="未怀孕">未怀孕</option>   
			    <option value="已怀孕">已怀孕</option>
			    <option value="已生产">已生产</option>
			    <option value="未知">未知</option>
			       
			</select> 
			<a data-cmd="PregnantWomanInformationSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height:23px;">搜索</a>
			<a data-cmd="PregnantWomanInformationHightSearch" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		</form>
	</div>
	
	<!-- 添加-添加和修改模态框 -->
	<div id="PregnantWomanInformationDialog">
		<form id="PregnantWomanInformationDialogForm" method="post">
			<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				<tr>
					<td>保健册号:</td>
					<td>
						<input name="healthcode" class="easyui-textbox" required="true" style="width:140px"> 
					</td>
				
					<td>姓名:</td>
					<td>
						<input name="name" labelAlign="right" class="easyui-textbox" style="width:90px" required="true">
						 
					</td>
				</tr>
				 <tr>
					<td>性别:</td>
					<td>
						<input id="sex" name="sex"  type="radio" value="男"/>男
						<input id="sex" name="sex"  type="radio" value="女"/>女
					</td>
				
					<td>年龄:</td>
					<td>
						<input name="age" class="easyui-textbox" style="width:30px"> 
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
					<td>学历:</td>
					<td>
    					<input id="educationCombobox" name="education.id" style="width:80px">   
					</td>
				
					<td>职业:</td>
					<td>
						<input name="profession" class="easyui-textbox" style="width:120px"> 
					</td>
				
				</tr>
				<tr>
					<td>省:</td>
					<td>
						<input id="provinceCombobox" name="province.id" style="width:110px"> 
					</td>

					<td>市:</td>
					<td>
						<input id="cityCombobox" name="city.id" style="width:110px">
						<!-- <input name="city" class="easyui-textbox" style="width:60px"> --> 
					</td>
				</tr>
				
				<tr>
					<td>县:</td>
					<td>
						<input id="countyCombobox" name="county.id" style="width:120px">
						<!-- <input name="county" class="easyui-textbox" style="width:60px">  -->
					</td>

					<td>乡镇:</td>
					<td>
						<input id="townCombobox" name="town.id" style="width:130px">
						<!-- <input name="town" class="easyui-textbox" style="width:60px"> -->
					</td>
				</tr>
				<tr>
					<td>村:</td>
					<td>
						<input name="gardon" class="easyui-textbox" style="width:60px"> 
					</td>
				
					<td>工作单位:</td>
					<td>
						<input name="workunit" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td>
						<input name="phonenumber" validType="phoneNumber" class="easyui-textbox" style="width:100px" required="true"> 
					</td>
					
					<td>微信号:</td>
					<td>
						<input name="wechat" class="easyui-textbox" style="width:145px"> 
					</td>
				</tr>
				<tr>
					<td>身份证号:</td>
					<td>
						<input name="idnumber" validType="idNumber" class="easyui-textbox" style="width:145px" required="true"> 
					</td>
					<td>配偶身份证号:</td>
					<td>
						<input id="idnumberCombobox" name="husbandid" class="easyui-textbox" style="width:160px" prompt="如若没有,请添加人员基本信息" required="true" panelHeight="auto"> 
					</td>
				</tr>
				<tr>
					<td>配偶姓名:</td>
					<td>
						<input id="husbandname" name="husbandname"  class="easyui-textbox" style="width:100px"> 
					</td>
					<td>配偶年龄:</td>
					<td>
						<input id="husbandage" name="husbandage"  class="easyui-textbox" style="width:60px"> 
					</td>
				</tr>
				<tr>
					<td>配偶电话:</td>
					<td>
						<input id="husbandphonenumber" name="husbandphonenumber"  class="easyui-textbox" style="width:120px"> 
					</td>
					
					<td>孕妇户口:</td>
					<td>
						<!-- <input name="isLocal" class="easyui-textbox" style="width:60px"> -->
						<input name="islocal"  type="radio" value="本地"/>本地
						<input name="islocal"  type="radio" value="外地"/>外地 
					</td>
				</tr>
				<tr>
					<td>生育证号:</td>
					<td>
						<input name="birthcertificatenumber" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>休养地址:</td>
					<td>
						<input name="restaddress" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				<tr>
					<td>孕妇标示:</td>
					<td>
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="ispregnantwoman" data-options="
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
					<td>婚史:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="ss" name="marryhistory" style="width:60px;">
					</td>
				</tr>
				<tr>	
					<td>检查次数:</td>
					<td>
						<input id="checkcount" name="checkcount" style="width:60px;">
					</td>
					<td>创建人:</td>
					<td>
						<input  name="establishperson" class="easyui-textbox" style="width:90px;">
					</td>
				</tr>
				 <!-- <tr>
					<td>检查时间:</td>
					<td>
						<input name="checktime" value="2019-12-09" class="easyui-datebox" style="width:90px"> 
					</td>
				</tr> -->
				
				<tr>
					<td>精神病:</td>
					<td>
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
				<!-- 孕妇异常孕产史 -->
				<tr>
					<td>自然流产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="spontaneousabortion" name="spontaneousabortion" style="width:60px;">
					</td>
					<td>自然流产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="spontaneousabortiondescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				
				<tr>
					<td>人工流产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="artificialabortion" name="artificialabortion" style="width:60px;">
					</td>
					<td>人工流产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="artificialabortiondescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>葡萄胎:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="hydatidiformmole" name="hydatidiformmole" style="width:60px;">
					</td>
					<td>葡萄胎详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="hydatidiformmoledescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>死胎死产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="stillbornfoetus" name="stillbornfoetus" style="width:60px;">
					</td>
					<td>死胎死产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="stillbornfoetusdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>生育畸形:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="birthmalformation" name="birthmalformation" style="width:60px;">
					</td>
					<td>生育畸形详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="birthmalformationdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>早产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="prematurebirth" name="prematurebirth" style="width:60px;">
					</td>
					<td>早产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="prematurebirthdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>药流:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="medicalabortion" name="medicalabortion" style="width:60px;">
					</td>
					<td>药流详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="medicalabortiondescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>引产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="inducedlabor" name="inducedlabor" style="width:60px;">
					</td>
					<td>引产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="inducedlabordescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>难产:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="difficultlabour" name="difficultlabour" style="width:60px;">
					</td>
					<td>难产详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="difficultlabourdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>宫外孕:</td>
					<td>
						<!-- <input name="marryhistory" class="easyui-textbox" style="width:60px"> --> 
						<input id="extrauterinepregnancy" name="extrauterinepregnancy" style="width:60px;">
					</td>
					<td>宫外孕详情</td>
					<td>
						<input id="geneticdiseasedescribe" name="extrauterinepregnancydescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>心脏病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="heartdisease" data-options="
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
					<td>心脏病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="heartdiseasedescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>结核:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="tuberculosis" data-options="
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
					<td>结核详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="tuberculosisdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>肾病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="nephropathy" data-options="
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
					<td>肾病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="nephropathydescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>血液病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="hematopathy" data-options="
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
					<td>血液病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="hematopathydescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>甲亢:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="hyperthyroidism" data-options="
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
					<td>甲亢详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="hyperthyroidismdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>接触有害物质:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="harmfulsubstance" data-options="
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
					<td>接触有害物质详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="harmfulsubstancedescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>肝病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="hepatopathy" data-options="
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
					<td>肝病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="hepatopathydescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>高血压:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="hypertension" data-options="
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
					<td>高血压详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="hypertensiondescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>糖尿病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="diabetes" data-options="
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
					<td>糖尿病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="diabetesdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
				<tr>
					<td>其他疾病:</td>
					<td>
						<input class="easyui-combobox" id="geneticdisease" style="width:90px" panelHeight="auto" name="otherdiseases" data-options="
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
					<td>其他疾病详情:</td>
					<td>
						<input id="geneticdiseasedescribe" name="otherdiseasesdescribe" multiline="true" class="easyui-textbox" style="width:160px;height:55px;"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	<!-- 添加修改模态框按钮 -->
	<div id="PregnantWomanInformationDialogToolbar">
		<a data-cmd="PregnantWomanInformationSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-ok'">保存</a>
		<a data-cmd="PregnantWomanInformationCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	<!-- 高级查询模态框 -->
	<div id="PregnantWomanInformationHightSearchDialog">
		<form id="PregnantWomanInformationHightSearchDialogForm" method="post">
		<input type="hidden" name="id"/>
			<table style="margin: auto;margin-top: 5px;">
				
				 <tr>
					<td>出生日期:</td>
					<td>
						<input name="begintime" class="easyui-datebox" style="width:90px"> 
						到<input name="endtime" class="easyui-datebox" style="width:90px"> 
					</td>

					<td>职业:</td>
					<td>
						<input name="profession" class="easyui-textbox" style="width:120px"> 
					</td>
				</tr>
				<tr>
				
					<td>工作单位:</td>
					<td>
						<input name="workunit" class="easyui-textbox" style="width:140px"> 
					</td>
					<td>微信号:</td>
					<td>
						<input name="wechat" class="easyui-textbox" style="width:145px"> 
					</td>
				</tr>
				<tr>
					<td>户口:</td>
					<td>
						<!-- <input name="isLocal" class="easyui-textbox" style="width:60px"> -->
						<input name="islocal"  type="radio" value="本地"/>本地
						<input name="islocal"  type="radio" value="外地"/>外地 
					</td>
					<td>休养地址:</td>
					<td>
						<input name="restaddress" class="easyui-textbox" style="width:140px"> 
					</td>
				</tr>
				
				<tr>
					<td>孕妇标示:</td>
					<td>
						<input class="easyui-combobox" style="width:90px" panelHeight="auto" name="ispregnantwoman" data-options="
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
			</table>
		</form>
	</div>
	
	
	
	<!-- 高级查询按钮 -->
	<div id="PregnantWomanInformationHightSearchButton">
		<a data-cmd="PregnantWomanInformationHightSearchSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-search'">搜索</a>
		<a data-cmd="PregnantWomanInformationHightSearchCancel" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-clear'">取消</a>
	</div>
	
	
</body>
</html>