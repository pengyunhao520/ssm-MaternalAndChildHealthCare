$(function() {
	//跨域
	jQuery.support.cors=true;
	
	//声明变量来缓存组件
	var PremaritaHealthInformationDatagrid,PremaritaHealthInformationDialog,PremaritaHealthInformationDialogForm,
	PremaritaHealthInformationSave,PremaritaHealthInformationCancel,PremaritaHealthInformationSearchForm,
	PremaritaHealthInformationHightSearch,PremaritaHealthInformationHightSearchDialog,PremaritaHealthInformationHightSearchDialogForm,
	PremaritaHealthInformationHightSearchCancel;
	//孕妇基本信息表格
	PremaritaHealthInformationDatagrid=$("#PremaritaHealthInformationDatagrid");
	//添加修改模态框
	PremaritaHealthInformationDialog=$("#PremaritaHealthInformationDialog");
	PremaritaHealthInformationDialogForm=$("#PremaritaHealthInformationDialogForm");
	PremaritaHealthInformationSave=$("#PremaritaHealthInformationSave");
	PremaritaHealthInformationCancel=$("#PremaritaHealthInformationCancel");
	//搜索表单,少量条件查询
	PremaritaHealthInformationSearchForm=$("#PremaritaHealthInformationSearchForm");
	//高级按钮
	PremaritaHealthInformationHightSearch=$("#PremaritaHealthInformationHightSearch");
	//高级查询模态框
	PremaritaHealthInformationHightSearchDialog=$("#PremaritaHealthInformationHightSearchDialog");
	//高级查询表单
	PremaritaHealthInformationHightSearchDialogForm=$("#PremaritaHealthInformationHightSearchDialogForm");
	//取消高级查询模态框按钮
	PremaritaHealthInformationHightSearchCancel=$("#PremaritaHealthInformationHightSearchCancel");
	
	var cmdObj ={
		PremaritaHealthInformationAdd : function(){
			//清空from表单
			PremaritaHealthInformationDialogForm.form("clear");
			//打开添加模态框
			PremaritaHealthInformationDialog.dialog("open").dialog("setTitle","婚前保健信息").dialog("center");
		},
		//修改
		PremaritaHealthInformationEdit : function(){
			//获取选中行
			var row = PremaritaHealthInformationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			PremaritaHealthInformationDialog.form("load",row);
			//打开模态框
			PremaritaHealthInformationDialog.dialog("open").dialog("setTitle","修改婚前保健信息").dialog("center");
			
			
		},
		//删除
		PremaritaHealthInformationRemove : function(){
			var row = PremaritaHealthInformationDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/PremaritaHealthInformation/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		PremaritaHealthInformationDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		PremaritaHealthInformationReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格
			PremaritaHealthInformationDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		PremaritaHealthInformationCancel : function () {
			PremaritaHealthInformationDialog.dialog("close");
		},
		//添加，保存婚前保健信息
		PremaritaHealthInformationSave : function () {
			//调用easyui的form组件的submit方法
			PremaritaHealthInformationDialogForm.form('submit', { 
			    url:'/PremaritaHealthInformation/save',
			    onSubmit: function(){  
			        return PremaritaHealthInformationDialogForm.form("validate");  
			    },    
			    success:function(data){
			    	console.log(data);
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   PremaritaHealthInformationDialog.dialog("close");
			    	   //刷新datagrid
			    	   PremaritaHealthInformationDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.cod+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		PremaritaHealthInformationSearch : function () {
			var param=PremaritaHealthInformationSearchForm.serializeForm();
			//刷新表格数据、
			PremaritaHealthInformationDatagrid.datagrid("load",param);
		},
		//高级查询
		PremaritaHealthInformationHightSearch : function(){
			//打开高级查询模态框
			PremaritaHealthInformationHightSearchDialog.dialog("open");
			//重置form表单
			PremaritaHealthInformationHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		PremaritaHealthInformationHightSearchSave : function(){
			var param=PremaritaHealthInformationHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			PremaritaHealthInformationDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			PremaritaHealthInformationHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		PremaritaHealthInformationHightSearchCancel : function () {
			PremaritaHealthInformationHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	PremaritaHealthInformationDatagrid.datagrid({
		title:"婚前保健信息",
		url : 'PremaritaHealthInformation/page',
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
			field : 'preidnumber',
			title : '孕妇身份证号',
			align:"center",
			//width : 105
		}, {
			field : 'prename',
			title : '孕妇姓名',
			align:"center",
			//width : 100
		}, {
			field : 'premaritalexaminationdate',
			title : '婚检日期',
			align:"center",
			//width : 45
		}, {
			field : 'premaritalexaminationaddress',
			title : '婚检地点',
			align:"center",
			//width : 45
		}, {
			field : 'consanguinity',
			title : '与配偶血缘关系',
			align:"center",
			hidden : true
		}, {
			field : 'consanguinitydetails',
			title : '与配偶血缘关系详情',
			align:"center",
			hidden : true
		}, {
			field : 'medicalhistory',
			title : '既往病史',
			align:"center",
			//width : 100,
		}, {
			field : 'medicalhistorydetails',
			title : '既往病史详情',
			align:"center",
			hidden : true
		}, {
			field : 'nowmedicalhistory',
			title : '现病史',
			align:"center",
			hidden : true
		}, {
			field : 'nowmedicalhistorydetails',
			title : '现病史详情',
			align:"center",
			hidden : true
		}, {
			field : 'menarcheage',
			title : '初潮年龄',
			//width : 50,
		}, {
			field : 'menarcheagedetails',
			title : '初潮年龄详情',
			align:"center",
			hidden : true
		}, {
			field : 'menstrualcycle',
			title : '经期周期',
			align:"center",
			//width : 100,
		}, {
			field : 'menstrualcycledetails',
			title : '经期周期详情',
			hidden : true
		}, {
			field : 'amount',
			title : '量',
			align:"center",
			//width : 100
		}, {
			field : 'amountdetails',
			title : '量详情',
			align:"center",
			hidden : true
		}, {
			field : 'pastmarriagehistory',
			title : '既往婚育史',
			align:"center",
	
		}, {
			field : 'pastmarriagehistorydetails',
			title : '既往婚育史详情',
			align:"center",
			hidden : true
		}, {
			field : 'familygenetichistory',
			title : '家族遗传史',
			align:"center",
	
		}, {
			field : 'familygenetichistorydetails',
			title : '家族遗传史详情',
			align:"center",
			hidden : true
		}, {
			field : 'familymarriage',
			title : '家族近亲婚配',
			align:"center",
		}, {
			field : 'familymarriagedetails',
			title : '家族近亲婚配详情',
			align:"center",
			hidden : true
		}, {
			field : 'specialposture',
			title : '特殊体态',
			align:"center",
			//width : 90,
		}, {
			field : 'specialposturedetails',
			title : '特殊体态详情',
			align:"center",
			hidden : true
		}, {
			field : 'mentaloutlook',
			title : '精神状态',
			align:"center",

		}, {
			field : 'mentaloutlookdetails',
			title : '精神状态详情',
			align:"center",
			hidden : true
		}, {
			field : 'specialface',
			title : '特殊面容',
			align:"center",
		
		}, {
			field : 'specialfacedetails',
			title : '特殊面容详情',
			align:"center",
			hidden : true
		}, {
			field : 'intelligence',
			title : '智力',
			align:"center",
			//width : 90,
		}, {
			field : 'intelligencedetails',
			title : '智力详情',
			align:"center",
			hidden : true
		}, {
			field : 'skinhair',
			title : '皮肤毛发',
			align:"center",
			//width : 100,
		}, {
			field : 'skinhairdetails',
			title : '皮肤毛发详情',
			align:"center",
			hidden : true
		}, {
			field : 'lung',
			title : '肺',
			align:"center",
			//width : 90,
		}, {
			field : 'lungdetails',
			title : '肺详情',
			align:"center",
			hidden : true
		}, {
			field : 'liver',
			title : '肝',
			align:"center",
			//width : 100
		}, {
			field : 'liverdetails',
			title : '肝详情',
			align:"center",
			hidden : true
		}, {
			field : 'limbsspine',
			title : '四肢脊柱',
			align:"center",
			//width : 100,
			/* formatter:isLocalFormatter */
		}, {
			field : 'limbsspinedetails',
			title : '四肢脊柱详情',
			align:"center",
			hidden : true
		}, {
			field : 'pubichair',
			title : '阴毛',
			align:"center",
			//width : 100
		}, {
			field : 'pubichairdetails',
			title : '阴毛详情',
			align:"center",
			hidden : true
		}, {
			field : 'breast',
			title : '乳房',
			align:"center",
			//width : 90,
		}, {
			field : 'breastdetails',
			title : '乳房详情',
			align:"center",
			hidden : true
		}, {
			field : 'genitals',
			title : '生殖器',
			align:"center",
			//width : 200
		}, {
			field : 'genitalsdetails',
			title : '生殖器详情',
			align:"center",
			hidden : true
		}, {
			field : 'vaginalexamination',
			title : '阴道检查',
			align:"center",
			//width : 100
		}, {
			field : 'vaginalexaminationdetails',
			title : '阴道检查详情',
			align:"center",
			hidden : true
		}, {
			field : 'laboratoryexamination',
			title : '实验室检查',
			align:"center",
			hidden : true
		}, {
			field : 'laboratoryexaminationdetails',
			title : '实验室检查详情',
			align:"center",
			hidden : true
		}, {
			field : 'premaritalexamination',
			title : '婚检结果',
			align:"center",
			//width : 100,
		}, {
			field : 'premaritalexaminationdetails',
			title : '婚检结果详情',
			align:"center",
			hidden : true
		}, {
			field : 'medicaladvice',
			title : '医学意见',
			align:"center",
			//width : 90,
		}, {
			field : 'medicaladvicedetails',
			title : '医学意见详情',
			align:"center",
			hidden : true
		}, {
			field : 'consultationguidance',
			title : '咨询指导',
			align:"center",
			hidden : true
		}, {
			field : 'consultationguidancedetails',
			title : '咨询指导详情',
			align:"center",
			hidden : true
		}, {
			field : 'folicbegintime',
			title : '叶酸开始日期',
			align:"center",
			//width : 90,
		}, {
			field : 'folicdetailsendtime',
			title : '叶酸结束日期',
			align:"center",
			//width : 100,
			formatter:MarryHistoryFormatter
		}, {
			field : 'iodinepillsbegintime',
			title : '碘丸开始日期',
			align:"center",
			//width : 90,
		}, {
			field : 'iodinepillsdosage',
			title : '碘丸用量',
			align:"center",
			//width : 90,
		}] ],
			toolbar : '#PremaritaHealthInformationDatagridToolbar'
			});
		
		//初始化添加修改模态框
		PremaritaHealthInformationDialog.dialog({     
		    width: 430,    
		    height: 370,    
		    closed: true,    
		    modal: true,
		    buttons:"#PremaritaHealthInformationDialogToolbar"
		});    
		
		//初始化高级查询模态框
		PremaritaHealthInformationHightSearchDialog.dialog({     
		    title:"高级查询",
			width: 430,    
		    height: 380,    
		    closed: true,    
		    modal: true,
		    buttons:"#PremaritaHealthInformationHightSearchButton"
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
	
	//加载孕妇身份证号下拉列表
	$('#preidnumberCombobox').combobox({    
		dataType : "html",
		url:'/PremaritaHealthInformation/idnumber',    
	    valueField:'idnumber',    
	    textField:'idnumber',
	    onSelect:function(perWoman){
	    	$("#prename").textbox('setValue',perWoman.name);
	    }
	});
	
	//初潮年龄
	$('#menarcheage').numberspinner({    
		value: 5,
		min: 5,    
	    max: 99,
	    editable: false   
	});
	//经期周期
	$('#menstrualcycle').numberspinner({    
		value: 5,
		min: 5,    
		max: 999,
		//editable: false   
	});
	//量
	$('#amount').numberspinner({    
		value: 5,
		min: 5,    
		max: 1000,
		//editable: false   
	});
	//碘丸用量/次(粒)
	$('#iodinepillsdosage').numberspinner({    
		value: 1,
		min: 1,    
		max: 100,
		editable: false   
	});
	//浏览器刷新清空少条件查询框
	$(document).ready(function(){
		$("#keyword").textbox('clear');
    });
	//双击查看详情
	PremaritaHealthInformationDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			var row = PremaritaHealthInformationDatagrid.datagrid("getSelected");
			//回显form表单
			PremaritaHealthInformationDialog.form("load",row);
			//打开模态框
			PremaritaHealthInformationDialog.dialog("open").dialog("setTitle","修改孕妇信息").dialog("center");
		}
	});
})