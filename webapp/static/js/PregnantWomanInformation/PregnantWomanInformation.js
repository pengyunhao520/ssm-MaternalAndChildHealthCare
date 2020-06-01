$(function() {
	jQuery.support.cors=true;
	//手机号的验证
	$.extend($.fn.validatebox.defaults.rules, {    
	    phoneNumber: {    
	        validator: function(value, param){
	        	//js的正则验证
	        	var regex=/^1[3456789]\d{9}$/;
	            return regex.test(value)    
	        },    
	        message: '请输入正确的手机号'   
	    }    
	});
	//身份证号码的验证
	$.extend($.fn.validatebox.defaults.rules, {    
	    idNumber: {    
	        validator: function(value, param){
	        	//js的正则验证
	        	var regex2=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	            return regex2.test(value)    
	        },    
	        message: '请输入正确的身份证号!'   
	    }
	});
	
	//声明变量来缓存组件
	var PregnantWomanInformationDatagrid,PregnantWomanInformationDialog,PregnantWomanInformationDialogForm,
	PregnantWomanInformationSave,PregnantWomanInformationCancel,PregnantWomanInformationSearchForm,
	PregnantWomanInformationHightSearch,PregnantWomanInformationHightSearchDialog,PregnantWomanInformationHightSearchDialogForm,
	PregnantWomanInformationHightSearchCancel,PregnantWomanInformationpreWoman;
	//孕妇基本信息表格
	PregnantWomanInformationDatagrid=$("#PregnantWomanInformationDatagrid");
	//添加修改模态框
	PregnantWomanInformationDialog=$("#PregnantWomanInformationDialog");
	PregnantWomanInformationDialogForm=$("#PregnantWomanInformationDialogForm");
	PregnantWomanInformationSave=$("#PregnantWomanInformationSave");
	PregnantWomanInformationCancel=$("#PregnantWomanInformationCancel");
	//搜索表单,少量条件查询
	PregnantWomanInformationSearchForm=$("#PregnantWomanInformationSearchForm");
	//高级按钮
	PregnantWomanInformationHightSearch=$("#PregnantWomanInformationHightSearch");
	//高级查询模态框
	PregnantWomanInformationHightSearchDialog=$("#PregnantWomanInformationHightSearchDialog");
	//高级查询表单
	PregnantWomanInformationHightSearchDialogForm=$("#PregnantWomanInformationHightSearchDialogForm");
	//取消高级查询模态框按钮
	PregnantWomanInformationHightSearchCancel=$("#PregnantWomanInformationHightSearchCancel");
	//转为孕妇
	PregnantWomanInformationpreWoman=$("PregnantWomanInformationpreWoman");
	var cmdObj ={
		PregnantWomanInformationpreWoman : function(){
			//获取选中行
			var row = PregnantWomanInformationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请先选择一行",'info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认转换', '您确定要将【'+row.name+'】转为普通人员信息吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.post("/PersonBasicInformation/pretoper",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('转换成功','已成功转为普通人员!','info');
				    		PregnantWomanInformationDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		
		//添加
		PregnantWomanInformationAdd : function(){
			//清空from表单
			PregnantWomanInformationDialogForm.form("clear");
			//打开添加模态框
			PregnantWomanInformationDialog.dialog("open").dialog("setTitle","添加孕妇信息").dialog("center");
		},
		//修改
		PregnantWomanInformationEdit : function(){
			//获取选中行
			var row = PregnantWomanInformationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			
			//回显form表单
			PregnantWomanInformationDialog.form("load",row);
			//打开模态框
			PregnantWomanInformationDialog.dialog("open").dialog("setTitle","修改孕妇信息").dialog("center");
			//手动回显学历
			if(row.education){
				$("#educationCombobox").textbox('setText',row.education.name);
			}else{
				$("#educationCombobox").textbox('setValue',"");
				$("#educationCombobox").textbox('setText',"");
			}
			
			//手动回显民族
			if(row.nation){
				$("#nationCombobox").textbox('setText',row.nation.nationname);
			}else{
				$("#nationCombobox").textbox('setValue',"");
				$("#nationCombobox").textbox('setText',"");
			}
			
			//手动回显省
			if(row.province){
				$("#provinceCombobox").textbox('setText',row.province.name);
			}else{
				$("#provinceCombobox").textbox('setValue',"");
				$("#provinceCombobox").textbox('setText',"");
			}
			
			//手动回显市
			if(row.city){
				$("#cityCombobox").textbox('setText',row.city.name);
			}else{
				$("#cityCombobox").textbox('setValue',"");
				$("#cityCombobox").textbox('setText',"");
			}
			
			//手动回显乡镇
			if(row.county){
				$("#countyCombobox").textbox('setText',row.county.name);
			}else{
				$("#countyCombobox").textbox('setValue',"");
				$("#countyCombobox").textbox('setText',"");
			}
			
			//手动回显街道
			if(row.town){
				$("#townCombobox").textbox('setText',row.town.name);
			}else{
				$("#townCombobox").textbox('setValue',"");
				$("#townCombobox").textbox('setText',"");
			}
			
			//psychosis回显
			if(row.prewomanGeneticHistory.psychosis){
				console.debug(row);
				$("#psychosis").textbox('setValue',row.prewomanGeneticHistory.psychosis);
			}else{
				$("#psychosis").textbox('setValue',"");
				$("#psychosis").textbox('setText',"");
			}
			//psychosisdescribe回显
			if(row.prewomanGeneticHistory.psychosisdescribe){
				$("#psychosisdescribe").textbox('setValue',row.prewomanGeneticHistory.psychosisdescribe);
			}else{
				$("#psychosisdescribe").textbox('setValue',"");
				$("#psychosisdescribe").textbox('setText',"");
			}
			
			//dementia回显
			if(row.prewomanGeneticHistory.dementia){
				$("#dementia").textbox('setValue',row.prewomanGeneticHistory.dementia);
			}else{
				$("#dementia").textbox('setValue',"");
				$("#dementia").textbox('setText',"");
			}
			//dementiadescribe回显
			if(row.prewomanGeneticHistory.dementiadescribe){
				$("#dementiadescribe").textbox('setValue',row.prewomanGeneticHistory.dementiadescribe);
			}else{
				$("#dementiadescribe").textbox('setValue',"");
				$("#dementiadescribe").textbox('setText',"");
			}
			
			//malformation回显
			if(row.prewomanGeneticHistory.malformation){
				$("#malformation").textbox('setValue',row.prewomanGeneticHistory.malformation);
			}else{
				$("#malformation").textbox('setValue',"");
				$("#malformation").textbox('setText',"");
			}
			
			//malformationdescribe回显
			if(row.prewomanGeneticHistory.malformationdescribe){
				$("#malformationdescribe").textbox('setValue',row.prewomanGeneticHistory.malformationdescribe);
			}else{
				$("#malformationdescribe").textbox('setValue',"");
				$("#malformationdescribe").textbox('setText',"");
			}
			
			//geneticdisease回显
			if(row.prewomanGeneticHistory.geneticdisease){
				$("#geneticdisease").textbox('setValue',row.prewomanGeneticHistory.geneticdisease);
			}else{
				$("#geneticdisease").textbox('setValue',"");
				$("#geneticdisease").textbox('setText',"");
			}
			//geneticdiseasedescribe回显
			if(row.prewomanGeneticHistory.geneticdiseasedescribe){
				
				$("#geneticdiseasedescribe").textbox('setValue',row.prewomanGeneticHistory.geneticdiseasedescribe);
				//
			}else{
				$("#geneticdiseasedescribe").textbox('setValue',"");
				$("#geneticdiseasedescribe").textbox('setText',"");
			}
		},
		//删除
		PregnantWomanInformationRemove : function(){
			var row = PregnantWomanInformationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/PregnantWomanInformation/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		PregnantWomanInformationDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		PregnantWomanInformationReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格
			PregnantWomanInformationDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		PregnantWomanInformationCancel : function () {
			PregnantWomanInformationDialog.dialog("close");
		},

		//添加，保存孕妇信息
		PregnantWomanInformationSave : function () {
			//调用easyui的form组件的submit方法
			PregnantWomanInformationDialogForm.form('submit', { 
			    url:'/PregnantWomanInformation/save',
			    onSubmit: function(){  
			        return PregnantWomanInformationDialogForm.form("validate");  
			    },    
			    success:function(data){
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   PregnantWomanInformationDialog.dialog("close");
			    	   //刷新datagrid
			    	   PregnantWomanInformationDatagrid.datagrid("reload");
			       }else{
			    	   $.messager.alert('提示:',result.code+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		PregnantWomanInformationSearch : function () {
			var param=PregnantWomanInformationSearchForm.serializeForm();
			//刷新表格数据、
			PregnantWomanInformationDatagrid.datagrid("load",param);
		},
		//高级查询
		PregnantWomanInformationHightSearch : function(){
			//打开高级查询模态框
			PregnantWomanInformationHightSearchDialog.dialog("open");
			//重置form表单
			PregnantWomanInformationHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		PregnantWomanInformationHightSearchSave : function(){
			var param=PregnantWomanInformationHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			PregnantWomanInformationDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			PregnantWomanInformationHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		PregnantWomanInformationHightSearchCancel : function () {
			PregnantWomanInformationHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	PregnantWomanInformationDatagrid.datagrid({
		title:"孕妇基本信息",
		url : 'PregnantWomanInformation/page',
		pagination : true,
		fit : true,
		fitColumns : true,
		striped : true,
		singleSelect : true,
		autoScroll:true,
		shrinkToFit:false,
		rownumbers : true,
		columns : [ [ {
			field : 'id',
			title : '编号',
			//width : 100,
			hidden : true
		}, {
			field : 'healthcode',
			title : '保健册号',
			align:"center",
			//width : 105
		}, {
			field : 'name',
			title : '姓名',
			align:"center",
			//width : 100
		}, {
			field : 'sex',
			title : '性别',
			align:"center",
			//width : 45
		}, {
			field : 'age',
			title : '年龄',
			align:"center",
			//width : 45
		}, {
			field : 'birthdate',
			title : '出生日期',
			align:"center",
			//width : 110
		}, {
			field : 'nation',
			title : '民族',
			align:"center",
			//width : 100,
			formatter : objectFormatter
		}, {
			field : 'education',
			title : '学历',
			align:"center",
			//width : 80,
			formatter : objectFormatter
		}, {
			field : 'profession',
			title : '职业',
			align:"center",
			//width : 100,
		}, {
			field : 'province',
			title : '省',
			align:"center",
			//width : 60,
			formatter : objectFormatter
		}, {
			field : 'city',
			title : '市',
			//width : 50,
			formatter : objectFormatter
		}, {
			field : 'county',
			title : '县',
			align:"center",
			//width : 50,
			formatter : objectFormatter
		}, {
			field : 'town',
			title : '乡镇',
			align:"center",
			//width : 100,
			formatter : objectFormatter
		}, {
			field : 'gardon',
			title : '村',
			//width : 50
		}, {
			field : 'workunit',
			title : '工作单位',
			align:"center",
			//width : 100
		}, {
			field : 'phonenumber',
			title : '手机号',
			align:"center",
			//width : 100
		}, {
			field : 'wechat',
			title : '微信',
			align:"center",
			//width : 100
		}, {
			field : 'idnumber',
			title : '身份证号',
			align:"center",
			//width : 200
		},{
			field : 'husbandid',
			title : '配偶id',
			align:"center",
			hidden:true
			//width : 100
		}, {
			field : 'husbandname',
			title : '配偶姓名',
			align:"center",
			//width : 100
		}, {
			field : 'husbandage',
			title : '配偶年龄',
			align:"center",
			//width : 100
		}, {
			field : 'husbandphonenumber',
			title : '配偶电话',
			align:"center",
			//width : 100
		}, {
			field : 'islocal',
			title : '户口',
			align:"center",
			//width : 100,
			/* formatter:isLocalFormatter */
		}, {
			field : 'birthcertificatenumber',
			title : '生育证号',
			align:"center",
			//width : 100
		}, {
			field : 'restaddress',
			title : '休养地址',
			align:"center",
			//width : 100
		}, {
			field : 'ispregnantwoman',
			title : '孕妇标识',
			align:"center",
			//width : 90,
			/* formatter:isPregnantWomanFormatter */
		}, {
			field : 'marryhistory',
			title : '婚史',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}, {
			field : 'checkcount',
			title : '检查次数',
			align:"center",
			//width : 100
		}, {
			field : 'establishperson',
			title : '创建人',
			align:"center",
			hidden:true
			//width : 100
		}, {
			field : 'checktime',
			title : '检查时间',
			align:"center",
			hidden:true
			//width : 100
		}, {
			field : 'prewomanGeneticHistory.psychosis',
			title : '精神病',
			align:"center",
			//width : 100,
			hidden : true
		}] ],
		toolbar : '#PregnantWomanInformationDatagridToolbar'
		
	});
	
	
	//初始化添加修改模态框
	PregnantWomanInformationDialog.dialog({     
	    width: 430,    
	    height: 370,    
	    closed: true,    
	    modal: true,
	    buttons:"#PregnantWomanInformationDialogToolbar"
	});    
	
	//初始化高级查询模态框
	PregnantWomanInformationHightSearchDialog.dialog({     
	    title:"高级查询",
		width: 430,    
	    height: 380,    
	    closed: true,    
	    modal: true,
	    buttons:"#PregnantWomanInformationHightSearchButton"
	});    
	
	//为页面中所有的按钮统一添加点击事件
	$("a").on("click",function(){
		//获取到data-cmd的值
		var cmd=$(this).data("cmd");
		if(cmd){
			//监听
			cmdObj[cmd]();
		}
	});


	//加载学历下拉列表
	$('#educationCombobox').combobox({    
		dataType : "html",
		url:'/PregnantWomanInformation/education',    
	    valueField:'id',    
	    textField:'name' 
	   
	});
	
	//加载民族下拉列表
	$('#nationCombobox').combobox({    
		dataType : "html",
		url:'/PregnantWomanInformation/nation',    
	    valueField:'nationid',    
	    textField:'nationname' 
	});
	
	//加载省下拉列表
	$('#provinceCombobox').combobox({    
		dataType : "html",
		url:'/PregnantWomanInformation/province',    
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(province){
	    	$('#cityCombobox').combobox("clear");
	    	$('#countyCombobox').combobox("clear");
	    	$('#townCombobox').combobox("clear");
            $('#cityCombobox').combobox('reload','/PregnantWomanInformation/city?provinceid='+province.id)
            }
	});
	
	//加载市下拉列表
	$('#cityCombobox').combobox({    
		dataType : "html",
		/* url:'/PregnantWomanInformation/city',   */  
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(city){
	    	$('#countyCombobox').combobox("clear");
	    	$('#townCombobox').combobox("clear");
            $('#countyCombobox').combobox('reload','/PregnantWomanInformation/area?cityid='+city.id)
            }
	});
	
	//加载乡镇下拉列表
	$('#countyCombobox').combobox({    
		dataType : "html",
		/* url:'/PregnantWomanInformation/area', */  
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(county){
	    	$('#townCombobox').combobox("clear");
            $('#townCombobox').combobox('reload','/PregnantWomanInformation/street?countyid='+county.id)
            }
	});
	
	//加载街道下拉列表
	$('#townCombobox').combobox({    
		dataType : "html",
		/* url:'/PregnantWomanInformation/street', */    
	    valueField:'id',    
	    textField:'name',
	    
	});
	
	//加载配偶身份证号下拉列表
	$('#idnumberCombobox').combobox({    
		dataType : "html",
		url:'/PregnantWomanInformation/idnumber',    
	    valueField:'id',    
	    textField:'idNumber',
	    onSelect:function(per){
	    	$("#husbandname").textbox('setValue',per.name);
	    	$("#husbandage").textbox('setValue',per.age);
	    	$("#husbandphonenumber").textbox('setValue',per.phonenumber);
	    }
	});
	
	$('#cc').combo({    
	    required:true,    
	    multiple:true,
	   
	});  
	//婚史，数字
	$('#ss').numberspinner({    
		value: 0,
		min: 0,    
	    max: 20,
	    editable: false   
	});
	//检查次数，数字
	$('#checkcount').numberspinner({    
		value: 0,
		min: 0,    
	    max: 99,
	    editable: false   
	});
	//自然流产
	$('#spontaneousabortion').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//人工流产
	$('#artificialabortion').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//葡萄胎
	$('#hydatidiformmole').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//死胎死产
	$('#stillbornfoetus').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//生育畸形
	$('#birthmalformation').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//早产
	$('#prematurebirth').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//药流
	$('#medicalabortion').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//引产
	$('#inducedlabor').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//难产
	$('#difficultlabour').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	//宫外孕
	$('#extrauterinepregnancy').numberspinner({    
		value: 0,
		min: 0,    
		max: 99,
		editable: false   
	});
	
	//浏览器刷新清空少条件查询框
	$(document).ready(function(){
		$("#keyword").textbox('clear');
    });

	
	//双击查看详情
	PregnantWomanInformationDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			var row = PregnantWomanInformationDatagrid.datagrid("getSelected");
			//回显form表单
			PregnantWomanInformationDialog.form("load",row);
			//打开模态框
			PregnantWomanInformationDialog.dialog("open").dialog("setTitle","修改孕妇信息").dialog("center");
			//手动回显学历
			if(row.education){
				$("#educationCombobox").textbox('setText',row.education.name);
			}else{
				$("#educationCombobox").textbox('setValue',"");
				$("#educationCombobox").textbox('setText',"");
			}
			
			//手动回显民族
			if(row.nation){
				$("#nationCombobox").textbox('setText',row.nation.nationname);
			}else{
				$("#nationCombobox").textbox('setValue',"");
				$("#nationCombobox").textbox('setText',"");
			}
			
			//手动回显省
			if(row.province){
				$("#provinceCombobox").textbox('setText',row.province.name);
			}else{
				$("#provinceCombobox").textbox('setValue',"");
				$("#provinceCombobox").textbox('setText',"");
			}
			
			//手动回显市
			if(row.city){
				$("#cityCombobox").textbox('setText',row.city.name);
			}else{
				$("#cityCombobox").textbox('setValue',"");
				$("#cityCombobox").textbox('setText',"");
				}
			
			//手动回显乡镇
			if(row.county){
				$("#countyCombobox").textbox('setText',row.county.name);
			}else{
				$("#countyCombobox").textbox('setValue',"");
				$("#countyCombobox").textbox('setText',"");
			}
			
			//手动回显街道
			if(row.town){
				$("#townCombobox").textbox('setText',row.town.name);
			}else{
				$("#townCombobox").textbox('setValue',"");
				$("#townCombobox").textbox('setText',"");
			}
			
			//psychosis回显
			if(row.prewomanGeneticHistory.psychosis){
				$("#psychosis").textbox('setValue',row.prewomanGeneticHistory.psychosis);
			}else{
				$("#psychosis").textbox('setValue',"");
				$("#psychosis").textbox('setText',"");
			}
			//psychosisdescribe回显
			if(row.prewomanGeneticHistory.psychosisdescribe){
				$("#psychosisdescribe").textbox('setValue',row.prewomanGeneticHistory.psychosisdescribe);
			}else{
				$("#psychosisdescribe").textbox('setValue',"");
				$("#psychosisdescribe").textbox('setText',"");
			}
			
			//dementia回显
			if(row.prewomanGeneticHistory.dementia){
				$("#dementia").textbox('setValue',row.prewomanGeneticHistory.dementia);
			}else{
				$("#dementia").textbox('setValue',"");
				$("#dementia").textbox('setText',"");
			}
			//dementiadescribe回显
			if(row.prewomanGeneticHistory.dementiadescribe){
				$("#dementiadescribe").textbox('setValue',row.prewomanGeneticHistory.dementiadescribe);
			}else{
				$("#dementiadescribe").textbox('setValue',"");
				$("#dementiadescribe").textbox('setText',"");
			}
			
			//malformation回显
			if(row.prewomanGeneticHistory.malformation){
				$("#malformation").textbox('setValue',row.prewomanGeneticHistory.malformation);
			}else{
				$("#malformation").textbox('setValue',"");
				$("#malformation").textbox('setText',"");
			}
			
			//malformationdescribe回显
			if(row.prewomanGeneticHistory.malformationdescribe){
				$("#malformationdescribe").textbox('setValue',row.prewomanGeneticHistory.malformationdescribe);
			}else{
				$("#malformationdescribe").textbox('setValue',"");
				$("#malformationdescribe").textbox('setText',"");
			}
			
			//geneticdisease回显
			if(row.prewomanGeneticHistory.geneticdisease){
				$("#geneticdisease").textbox('setValue',row.prewomanGeneticHistory.geneticdisease);
			}else{
				$("#geneticdisease").textbox('setValue',"");
				$("#geneticdisease").textbox('setText',"");
			}
			//geneticdiseasedescribe回显
			if(row.prewomanGeneticHistory.geneticdiseasedescribe){
				$("#geneticdiseasedescribe").textbox('setValue',row.prewomanGeneticHistory.geneticdiseasedescribe);
			}else{
				$("#geneticdiseasedescribe").textbox('setValue',"");
				$("#geneticdiseasedescribe").textbox('setText',"");
			}
		}
	});
})

