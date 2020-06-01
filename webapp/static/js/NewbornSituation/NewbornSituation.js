$(function() {
	jQuery.support.cors=true;
	//声明变量来缓存组件
	var NewbornSituationDatagrid,NewbornSituationDialog,NewbornSituationDialogForm,
	NewbornSituationSave,NewbornSituationCancel,NewbornSituationSearchForm,
	NewbornSituationHightSearch,NewbornSituationHightSearchDialog,NewbornSituationHightSearchDialogForm,
	NewbornSituationHightSearchCancel;
	//产时新生儿情况表格
	NewbornSituationDatagrid=$("#NewbornSituationDatagrid");
	//添加修改模态框
	NewbornSituationDialog=$("#NewbornSituationDialog");
	NewbornSituationDialogForm=$("#NewbornSituationDialogForm");
	NewbornSituationSave=$("#NewbornSituationSave");
	NewbornSituationCancel=$("#NewbornSituationCancel");
	//搜索表单,少量条件查询
	NewbornSituationSearchForm=$("#NewbornSituationSearchForm");
	//高级按钮
	NewbornSituationHightSearch=$("#NewbornSituationHightSearch");
	//高级查询模态框
	NewbornSituationHightSearchDialog=$("#NewbornSituationHightSearchDialog");
	//高级查询表单
	NewbornSituationHightSearchDialogForm=$("#NewbornSituationHightSearchDialogForm");
	//取消高级查询模态框按钮
	NewbornSituationHightSearchCancel=$("#NewbornSituationHightSearchCancel");
	
	var cmdObj ={
		
			NewbornSituationpreWoman : function(){
				//获取选中行
				var row = NewbornSituationDatagrid.datagrid("getSelected");
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
					    		NewbornSituationDatagrid.datagrid("reload");
					    	}else{
					    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
					    	}
					    },"json");
					}
				});
			},
		
		//添加
		NewbornSituationAdd : function(){
			//清空from表单
			NewbornSituationDialogForm.form("clear");
			//打开添加模态框
			NewbornSituationDialog.dialog("open").dialog("setTitle","添加人员信息").dialog("center");
		},
		//修改
		NewbornSituationEdit : function(){
			//获取选中行
			var row = NewbornSituationDatagrid.datagrid("getSelected");
			console.debug(row);
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			NewbornSituationDialog.form("load",row);
			//打开模态框
			NewbornSituationDialog.dialog("open").dialog("setTitle","修改人员信息").dialog("center");
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
		},
		//删除
		NewbornSituationRemove : function(){
			var row = NewbornSituationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/NewbornSituation/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		NewbornSituationDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		NewbornSituationReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格数据
			NewbornSituationDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		NewbornSituationCancel : function () {
			NewbornSituationDialog.dialog("close");
		},
		//添加，保存人员信息
		NewbornSituationSave : function () {
			//调用easyui的form组件的submit方法
			NewbornSituationDialogForm.form('submit', { 
			    url:'/NewbornSituation/save',
			    onSubmit: function(){  
			        return NewbornSituationDialogForm.form("validate");  
			    },    
			    success:function(data){
			    	console.log(data);
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   NewbornSituationDialog.dialog("close");
			    	   //刷新datagrid
			    	   NewbornSituationDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.code+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		NewbornSituationSearch : function () {
			var param=NewbornSituationSearchForm.serializeForm();
			//刷新表格数据、
			NewbornSituationDatagrid.datagrid("load",param);
		},
		//高级查询
		NewbornSituationHightSearch : function(){
			//打开高级查询模态框
			NewbornSituationHightSearchDialog.dialog("open");
			//重置form表单
			NewbornSituationHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		NewbornSituationHightSearchSave : function(){
			var param=NewbornSituationHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			NewbornSituationDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			NewbornSituationHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		NewbornSituationHightSearchCancel : function () {
			NewbornSituationHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	NewbornSituationDatagrid.datagrid({
		title:"产时新生儿情况",
		url : 'NewbornSituation/page',
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
			field : 'birthorder',
			title : '出生顺序',
			align:"center",
			//width : 105
		}, {
			field : 'birthdate',
			title : '出生时间',
			align:"center",
			//width : 100
		}, {
			field : 'sex',
			title : '性别',
			align:"center",
			//width : 100
		}, {
			field : 'apgaone',
			title : 'Apga一分钟评分',
			align:"center",
			//width : 90,
			/* formatter:isPregnantWomanFormatter */
		}, {
			field : 'apgarfive',
			title : 'Apga五分钟评分',
			align:"center",
			//width : 45
		}, {
			field : 'birthdefect',
			title : '出生缺陷',
			align:"center",
			//width : 45
		}, {
			field : 'pathologicjaundice',
			title : '病理性黄疸',
			align:"center",
			//width : 110
		}, {
			field : 'respiratorydistress',
			title : '呼吸窘迫综合症',
			align:"center",
			//width : 100,
			formatter : objectFormatter
		}, {
			field : 'deliveryposition',
			title : '分娩胎位',
			align:"center",
			//width : 100,
		}, {
			field : 'deliverypositiondetails',
			title : '分娩胎位详情',
			align:"center",
			//width : 100,
		}, {
			field : 'modeofdelivery',
			title : '分娩方式',
			align:"center",
			//width : 80,
			formatter : objectFormatter
		}, {
			field : 'modeofdeliverydetails',
			title : '分娩方式详情',
			align:"center",
			//width : 100,
		}, {
			field : 'pneumonia',
			title : '肺炎',
			align:"center",
			//width : 80,
			/* formatter : FamilyMemberTypeFormatter */
		}, {
			field : 'scleroma',
			title : '硬肿症',
			align:"center",
			//width : 60,
			formatter : objectFormatter
		}, {
			field : 'birthinjury',
			title : '产伤',
			//width : 50,
			formatter : objectFormatter
		}, {
			field : 'birthinjurydetails',
			title : '产伤详情',
			align:"center",
			//width : 50,
			formatter : objectFormatter
		}, {
			field : 'encephalopathyhie',
			title : '缺氧缺血性脑病',
			align:"center",
			//width : 100,
			formatter : objectFormatter
		}, {
			field : 'umbilicalinfection',
			title : '脐部感染',
			align:"center",
			//width : 100
		}, {
			field : 'externalgenitalorgans',
			title : '外生殖器',
			align:"center",
			//width : 100
		}, {
			field : 'wechat',
			title : '微信',
			align:"center",
			//width : 100
		}, {
			field : 'septicemia',
			title : '败血症',
			align:"center",
			//width : 200
		}, {
			field : 'tetanus',
			title : '破伤风',
			align:"center",
			//width : 100,
			/* formatter:isLocalFormatter */
		}, {
			field : 'indigestion',
			title : '消化不良',
			align:"center",
			//width : 100
		}, {
			field : 'weight',
			title : '体重(g)',
			align:"center",
			//width : 100
		}, {
			field : 'height',
			title : '体长(cm)',
			align:"center",
			//width : 90,
			/* formatter:isPregnantWomanFormatter */
		}, {
			field : 'birthoutcomes',
			title : '出生结局',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}, {
			field : 'birthoutcomesdetails',
			title : '出生结局详情',
			align:"center",
			//width : 100,
			hidden : true
		}, {
			field : 'neonatalsurvival',
			title : '新生儿存活',
			align:"center",
			//width : 100
		}, {
			field : 'stillbirthcause',
			title : '死胎死产原因',
			align:"center",
			//width : 200
		}, {
			field : 'stillbirthcausedetails',
			title : '死胎死产原因详情',
			align:"center",
			//width : 100,
			/* formatter:isLocalFormatter */
		}, {
			field : 'indigestion',
			title : '消化不良',
			align:"center",
			//width : 100
		}, {
			field : 'neonataldeathcause',
			title : '新生儿死亡原因',
			align:"center",
			//width : 100
		}, {
			field : 'breastfeeding',
			title : '母乳喂养',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}, {
			field : 'neonataslscreening',
			title : '新生儿疾病筛查',
			align:"center",
			//width : 100,
			hidden : true
		}, {
			field : 'neonatalscreeningdetails',
			title : '新生儿疾病筛查详情',
			align:"center",
			//width : 90,
			/* formatter:isBirthFormatter */
		}, {
			field : 'filler',
			title : '填表人',
			align:"center",
			//width : 100
		}, {
			field : 'enter',
			title : '录入人',
			align:"center",
			//width : 90,
			/* formatter:isPregnantWomanFormatter */
		}, {
			field : 'healthguidance',
			title : '保健指导',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}] ],
		
		toolbar : '#NewbornSituationDatagridToolbar',
	});
	
	//初始化添加修改模态框
	NewbornSituationDialog.dialog({     
	    width: 430,    
	    height: 370,    
	    closed: true,    
	    modal: true,
	    buttons:"#NewbornSituationDialogToolbar"
	});    
	
	//初始化高级查询模态框
	NewbornSituationHightSearchDialog.dialog({     
	    title:"高级查询",
		width: 430,    
	    height: 380,    
	    closed: true,    
	    modal: true,
	    buttons:"#NewbornSituationHightSearchButton"
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
	NewbornSituationDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			console.debug(field);
			var row = NewbornSituationDatagrid.datagrid("getSelected");
			//回显form表单
			NewbornSituationDialog.form("load",row);
			//打开模态框
			NewbornSituationDialog.dialog("open").dialog('refresh').dialog("setTitle","修改人员信息").dialog("center");
//			/NewbornSituationDialog.dialog('open').dialog('refresh');

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
