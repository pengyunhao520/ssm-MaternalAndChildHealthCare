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
	        message: '请输入正确的身份证号'   
	    }
	});
	
	//声明变量来缓存组件
	var PersonBasicInfomationDatagrid,PersonBasicInfomationDialog,PersonBasicInfomationDialogForm,
	PersonBasicInfomationSave,PersonBasicInfomationCancel,PersonBasicInfomationSearchForm,
	PersonBasicInfomationHightSearch,PersonBasicInfomationHightSearchDialog,PersonBasicInfomationHightSearchDialogForm,
	PersonBasicInfomationHightSearchCancel;
	//人员基本信息表格
	PersonBasicInfomationDatagrid=$("#PersonBasicInfomationDatagrid");
	//添加修改模态框
	PersonBasicInfomationDialog=$("#PersonBasicInfomationDialog");
	PersonBasicInfomationDialogForm=$("#PersonBasicInfomationDialogForm");
	PersonBasicInfomationSave=$("#PersonBasicInfomationSave");
	PersonBasicInfomationCancel=$("#PersonBasicInfomationCancel");
	//搜索表单,少量条件查询
	PersonBasicInfomationSearchForm=$("#PersonBasicInfomationSearchForm");
	//高级按钮
	PersonBasicInfomationHightSearch=$("#PersonBasicInfomationHightSearch");
	//高级查询模态框
	PersonBasicInfomationHightSearchDialog=$("#PersonBasicInfomationHightSearchDialog");
	//高级查询表单
	PersonBasicInfomationHightSearchDialogForm=$("#PersonBasicInfomationHightSearchDialogForm");
	//取消高级查询模态框按钮
	PersonBasicInfomationHightSearchCancel=$("#PersonBasicInfomationHightSearchCancel");
	
	var cmdObj ={
		
			PersonBasicInfomationpreWoman : function(){
				//获取选中行
				var row = PersonBasicInfomationDatagrid.datagrid("getSelected");
				//判断是否选中行
				if(!row){
					$.messager.alert("提示:","请先选择一行",'info');
					return;
				}
				//提示是否确认删除
				$.messager.confirm('确认转换', '您确定要将【'+row.name+'】转为孕妇吗？该信息可能不完整 ,部分需要您手动完善', function(r){
					if (r){
					    //执行删除操作,发送ajax请求
					    $.post("/PregnantWomanInformation/pretoper",{id:row.id},function(result){
					    	if(result.success){
					    		//成功,刷新datagrid
					    		$.messager.alert('转换成功','已成功转为孕妇!','info');
					    		PersonBasicInfomationDatagrid.datagrid("reload");
					    	}else{
					    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
					    	}
					    },"json");
					}
				});
			},
		
		//添加
		PersonBasicInfomationAdd : function(){
			//清空from表单
			PersonBasicInfomationDialogForm.form("clear");
			//打开添加模态框
			PersonBasicInfomationDialog.dialog("open").dialog("setTitle","添加人员信息").dialog("center");
		},
		//修改
		PersonBasicInfomationEdit : function(){
			//获取选中行
			var row = PersonBasicInfomationDatagrid.datagrid("getSelected");
			console.debug(row);
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			PersonBasicInfomationDialog.form("load",row);
			//打开模态框
			PersonBasicInfomationDialog.dialog("open").dialog("setTitle","修改人员信息").dialog("center");
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
			if(row.geneticHistory.psychosis){
				$("#psychosis").textbox('setValue',row.geneticHistory.psychosis);
			}else{
				$("#psychosis").textbox('setValue',"");
				$("#psychosis").textbox('setText',"");
			}
			//psychosisdescribe回显
			if(row.geneticHistory.psychosisdescribe){
				$("#psychosisdescribe").textbox('setValue',row.geneticHistory.psychosisdescribe);
			}else{
				$("#psychosisdescribe").textbox('setValue',"");
				$("#psychosisdescribe").textbox('setText',"");
			}
			
			//dementia回显
			if(row.geneticHistory.dementia){
				$("#dementia").textbox('setValue',row.geneticHistory.dementia);
			}else{
				$("#dementia").textbox('setValue',"");
				$("#dementia").textbox('setText',"");
			}
			//dementiadescribe回显
			if(row.geneticHistory.dementiadescribe){
				$("#dementiadescribe").textbox('setValue',row.geneticHistory.dementiadescribe);
			}else{
				$("#dementiadescribe").textbox('setValue',"");
				$("#dementiadescribe").textbox('setText',"");
			}
			
			//malformation回显
			if(row.geneticHistory.malformation){
				$("#malformation").textbox('setValue',row.geneticHistory.malformation);
			}else{
				$("#malformation").textbox('setValue',"");
				$("#malformation").textbox('setText',"");
			}
			
			//malformationdescribe回显
			if(row.geneticHistory.malformationdescribe){
				$("#malformationdescribe").textbox('setValue',row.geneticHistory.malformationdescribe);
			}else{
				$("#malformationdescribe").textbox('setValue',"");
				$("#malformationdescribe").textbox('setText',"");
			}
			
			//geneticdisease回显
			if(row.geneticHistory.geneticdisease){
				$("#geneticdisease").textbox('setValue',row.geneticHistory.geneticdisease);
			}else{
				$("#geneticdisease").textbox('setValue',"");
				$("#geneticdisease").textbox('setText',"");
			}
			//geneticdiseasedescribe回显
			if(row.geneticHistory.geneticdiseasedescribe){
				$("#geneticdiseasedescribe").textbox('setValue',row.geneticHistory.geneticdiseasedescribe);
				//
			}else{
				$("#geneticdiseasedescribe").textbox('setValue',"");
				$("#geneticdiseasedescribe").textbox('setText',"");
			}
		},
		//删除
		PersonBasicInfomationRemove : function(){
			var row = PersonBasicInfomationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/PersonBasicInformation/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		PersonBasicInfomationDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		PersonBasicInfomationReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格数据
			PersonBasicInfomationDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		PersonBasicInfomationCancel : function () {
			PersonBasicInfomationDialog.dialog("close");
		},
		//添加，保存人员信息
		PersonBasicInfomationSave : function () {
			//调用easyui的form组件的submit方法
			PersonBasicInfomationDialogForm.form('submit', { 
			    url:'/PersonBasicInformation/save',
			    onSubmit: function(){  
			        return PersonBasicInfomationDialogForm.form("validate");  
			    },    
			    success:function(data){
			    	console.log(data);
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   PersonBasicInfomationDialog.dialog("close");
			    	   //刷新datagrid
			    	   PersonBasicInfomationDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.code+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		PersonBasicInfomationSearch : function () {
			var param=PersonBasicInfomationSearchForm.serializeForm();
			//刷新表格数据、
			PersonBasicInfomationDatagrid.datagrid("load",param);
		},
		//高级查询
		PersonBasicInfomationHightSearch : function(){
			//打开高级查询模态框
			PersonBasicInfomationHightSearchDialog.dialog("open");
			//重置form表单
			PersonBasicInfomationHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		PersonBasicInfomationHightSearchSave : function(){
			var param=PersonBasicInfomationHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			PersonBasicInfomationDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			PersonBasicInfomationHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		PersonBasicInfomationHightSearchCancel : function () {
			PersonBasicInfomationHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	PersonBasicInfomationDatagrid.datagrid({
		title:"人员基本信息",
		url : 'PersonBasicInformation/page',
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
			field : 'profession',
			title : '职业',
			align:"center",
			//width : 100,
		}, {
			field : 'education',
			title : '学历',
			align:"center",
			//width : 80,
			formatter : objectFormatter
		}, {
			field : 'familymembertype',
			title : '家庭角色',
			align:"center",
			//width : 80,
			/* formatter : FamilyMemberTypeFormatter */
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
			field : 'idNumber',
			title : '身份证号',
			align:"center",
			//width : 200
		}, {
			field : 'isLocal',
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
			field : 'isPregnantwoman',
			title : '孕妇标识',
			align:"center",
			//width : 90,
			/* formatter:isPregnantWomanFormatter */
		}, {
			field : 'isBirth',
			title : '生育标识',
			align:"center",
			//width : 90,
			/* formatter:isBirthFormatter */
		}, {
			field : 'marryhistory',
			title : '婚史',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}, {
			field : 'geneticHistory.psychosis',
			title : '精神病',
			align:"center",
			//width : 100,
			hidden : true
		}] ],
		toolbar : '#PersonBasicInfomationDatagridToolbar'

	});
	
	//初始化添加修改模态框
	PersonBasicInfomationDialog.dialog({     
	    width: 430,    
	    height: 370,    
	    closed: true,    
	    modal: true,
	    buttons:"#PersonBasicInfomationDialogToolbar"
	});    
	
	//初始化高级查询模态框
	PersonBasicInfomationHightSearchDialog.dialog({     
	    title:"高级查询",
		width: 430,    
	    height: 380,    
	    closed: true,    
	    modal: true,
	    buttons:"#PersonBasicInfomationHightSearchButton"
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
		url:'/PersonBasicInformation/education',    
	    valueField:'id',    
	    textField:'name' 
	   
	});
	
	//加载民族下拉列表
	$('#nationCombobox').combobox({    
		dataType : "html",
		url:'/PersonBasicInformation/nation',    
	    valueField:'nationid',    
	    textField:'nationname' 
	});
	
	//加载省下拉列表
	$('#provinceCombobox').combobox({    
		dataType : "html",
		url:'/PersonBasicInformation/province',    
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(province){
	    	$('#cityCombobox').combobox("clear");
	    	$('#countyCombobox').combobox("clear");
	    	$('#townCombobox').combobox("clear");
            $('#cityCombobox').combobox('reload','/PersonBasicInformation/city?provinceid='+province.id)
            }
	});
	
	//加载市下拉列表
	$('#cityCombobox').combobox({    
		dataType : "html",
		/* url:'/PersonBasicInformation/city',   */  
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(city){
	    	$('#countyCombobox').combobox("clear");
	    	$('#townCombobox').combobox("clear");
            $('#countyCombobox').combobox('reload','/PersonBasicInformation/area?cityid='+city.id)
            }
	});
	
	//加载乡镇下拉列表
	$('#countyCombobox').combobox({    
		dataType : "html",
		/* url:'/PersonBasicInformation/area', */  
	    valueField:'id',    
	    textField:'name',
	    onSelect:function(county){
	    	$('#townCombobox').combobox("clear");
            $('#townCombobox').combobox('reload','/PersonBasicInformation/street?countyid='+county.id)
            }
	});
	
	//加载街道下拉列表
	$('#townCombobox').combobox({    
		dataType : "html",
		/* url:'/PersonBasicInformation/street', */    
	    valueField:'id',    
	    textField:'name',
	    
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
	
	//浏览器刷新清空少条件查询搜索框
	$(document).ready(function(){
		$("#keyword").textbox('clear');
    });
	
	//双击查看详情
	PersonBasicInfomationDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			console.debug(field);
			var row = PersonBasicInfomationDatagrid.datagrid("getSelected");
			//回显form表单
			PersonBasicInfomationDialog.form("load",row);
			//打开模态框
			PersonBasicInfomationDialog.dialog("open").dialog('refresh').dialog("setTitle","修改人员信息").dialog("center");
//			/PersonBasicInfomationDialog.dialog('open').dialog('refresh');

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
			if(row.geneticHistory.psychosis){
				$("#psychosis").textbox('setValue',row.geneticHistory.psychosis);
			}else{
				$("#psychosis").textbox('setValue',"");
				$("#psychosis").textbox('setText',"");
			}
			//psychosisdescribe回显
			if(row.geneticHistory.psychosisdescribe){
				$("#psychosisdescribe").textbox('setValue',row.geneticHistory.psychosisdescribe);
			}else{
				$("#psychosisdescribe").textbox('setValue',"");
				$("#psychosisdescribe").textbox('setText',"");
			}
			
			//dementia回显
			if(row.geneticHistory.dementia){
				$("#dementia").textbox('setValue',row.geneticHistory.dementia);
			}else{
				$("#dementia").textbox('setValue',"");
				$("#dementia").textbox('setText',"");
			}
			//dementiadescribe回显
			if(row.geneticHistory.dementiadescribe){
				$("#dementiadescribe").textbox('setValue',row.geneticHistory.dementiadescribe);
			}else{
				$("#dementiadescribe").textbox('setValue',"");
				$("#dementiadescribe").textbox('setText',"");
			}
			
			//malformation回显
			if(row.geneticHistory.malformation){
				$("#malformation").textbox('setValue',row.geneticHistory.malformation);
			}else{
				$("#malformation").textbox('setValue',"");
				$("#malformation").textbox('setText',"");
			}
			
			//malformationdescribe回显
			if(row.geneticHistory.malformationdescribe){
				$("#malformationdescribe").textbox('setValue',row.geneticHistory.malformationdescribe);
			}else{
				$("#malformationdescribe").textbox('setValue',"");
				$("#malformationdescribe").textbox('setText',"");
			}
			
			//geneticdisease回显
			if(row.geneticHistory.geneticdisease){
				$("#geneticdisease").textbox('setValue',row.geneticHistory.geneticdisease);
			}else{
				$("#geneticdisease").textbox('setValue',"");
				$("#geneticdisease").textbox('setText',"");
			}
			//geneticdiseasedescribe回显
			if(row.geneticHistory.geneticdiseasedescribe){
				$("#geneticdiseasedescribe").textbox('setValue',row.geneticHistory.geneticdiseasedescribe);
			}else{
				$("#geneticdiseasedescribe").textbox('setValue',"");
				$("#geneticdiseasedescribe").textbox('setText',"");
			}
		}
	});


})
