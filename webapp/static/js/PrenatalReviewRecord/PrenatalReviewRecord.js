$(function() {
	//跨域
	jQuery.support.cors=true;
	
	//声明变量来缓存组件
	var PrenatalReviewRecordDatagrid,PrenatalReviewRecordDialog,PrenatalReviewRecordDialogForm,
	PrenatalReviewRecordSave,PrenatalReviewRecordCancel,PrenatalReviewRecordSearchForm,
	PrenatalReviewRecordHightSearch,PrenatalReviewRecordHightSearchDialog,PrenatalReviewRecordHightSearchDialogForm,
	PrenatalReviewRecordHightSearchCancel;
	//孕妇基本信息表格
	PrenatalReviewRecordDatagrid=$("#PrenatalReviewRecordDatagrid");
	//添加修改模态框
	PrenatalReviewRecordDialog=$("#PrenatalReviewRecordDialog");
	PrenatalReviewRecordDialogForm=$("#PrenatalReviewRecordDialogForm");
	PrenatalReviewRecordSave=$("#PrenatalReviewRecordSave");
	PrenatalReviewRecordCancel=$("#PrenatalReviewRecordCancel");
	//搜索表单,少量条件查询
	PrenatalReviewRecordSearchForm=$("#PrenatalReviewRecordSearchForm");
	//高级按钮
	PrenatalReviewRecordHightSearch=$("#PrenatalReviewRecordHightSearch");
	//高级查询模态框
	PrenatalReviewRecordHightSearchDialog=$("#PrenatalReviewRecordHightSearchDialog");
	//高级查询表单
	PrenatalReviewRecordHightSearchDialogForm=$("#PrenatalReviewRecordHightSearchDialogForm");
	//取消高级查询模态框按钮
	PrenatalReviewRecordHightSearchCancel=$("#PrenatalReviewRecordHightSearchCancel");
	
	var cmdObj ={
		PrenatalReviewRecordAdd : function(){
			//清空from表单
			PrenatalReviewRecordDialogForm.form("clear");
			//打开添加模态框
			PrenatalReviewRecordDialog.dialog("open").dialog("setTitle","婚前保健信息").dialog("center");
		},
		//修改
		PrenatalReviewRecordEdit : function(){
			//获取选中行
			var row = PrenatalReviewRecordDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			PrenatalReviewRecordDialog.form("load",row);
			//打开模态框
			PrenatalReviewRecordDialog.dialog("open").dialog("setTitle","修改婚前保健信息").dialog("center");
			
			//回显fetalposition
			if(row.fetalposition){
				console.debug(row);
				console.debug(row.fetalposition);
				$("#fetalpositionCombobox").textbox('setText',row.fetalposition.name);
			}else{
				$("#fetalpositionCombobox").textbox('setValue',"");
				$("#fetalpositionCombobox").textbox('setText',"");
			}
			
			//回显fetalpresentation
			if(row.fetalpresentation){
				console.debug(row);
				console.debug(row.fetalpresentation);
				$("#fetalpresentationCombobox").textbox('setText',row.fetalpresentation.name);
			}else{
				$("#fetalpresentationCombobox").textbox('setValue',"");
				$("#fetalpresentationCombobox").textbox('setText',"");
			}
		},
		//删除
		PrenatalReviewRecordRemove : function(){
			var row = PrenatalReviewRecordDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/PrenatalReviewRecord/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		PrenatalReviewRecordDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		PrenatalReviewRecordReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格
			PrenatalReviewRecordDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		PrenatalReviewRecordCancel : function () {
			PrenatalReviewRecordDialog.dialog("close");
		},
		//添加，保存婚前保健信息
		PrenatalReviewRecordSave : function () {
			//调用easyui的form组件的submit方法
			PrenatalReviewRecordDialogForm.form('submit', { 
			    url:'/PrenatalReviewRecord/save',
			    onSubmit: function(){  
			        return PrenatalReviewRecordDialogForm.form("validate");  
			    },    
			    success:function(data){
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   PrenatalReviewRecordDialog.dialog("close");
			    	  
			    	   //刷新datagrid
			    	   PrenatalReviewRecordDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.cod+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		PrenatalReviewRecordSearch : function () {
			var param=PrenatalReviewRecordSearchForm.serializeForm();
			//刷新表格数据、
			PrenatalReviewRecordDatagrid.datagrid("load",param);
		},
		//高级查询
		PrenatalReviewRecordHightSearch : function(){
			//打开高级查询模态框
			PrenatalReviewRecordHightSearchDialog.dialog("open");
			//重置form表单
			PrenatalReviewRecordHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		PrenatalReviewRecordHightSearchSave : function(){
			var param=PrenatalReviewRecordHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			PrenatalReviewRecordDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			PrenatalReviewRecordHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		PrenatalReviewRecordHightSearchCancel : function () {
			PrenatalReviewRecordHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	PrenatalReviewRecordDatagrid.datagrid({
		title:"婚前保健信息",
		url : 'PrenatalReviewRecord/page',
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
			title : '身份证号',
			align:"center",
			//width : 105
		}, {
			field : 'prename',
			title : '姓名',
			align:"center",
			//width : 100
		}, {
			field : 'prephonenumber',
			title : '手机号',
			align:"center",
			//width : 45
		}, {
			field : 'healthcode',
			title : '保健册号',
			align:"center",
			//width : 45
		}, {
			field : 'reviewdate',
			title : '复查日期',
			align:"center",
			//width : 45
		}, {
			field : 'gestationalweek',
			title : '孕周',
			align:"center",
		}, {
			field : 'systolicpressure',
			title : '收缩压',
			align:"center",
		}, {
			field : 'diastolicpressure',
			title : '舒张压',
			align:"center",
			//width : 100,
		}, {
			field : 'weight',
			title : '体重',
			align:"center",
		}, {
			field : 'fundalheight',
			title : '宫高',
			align:"center",
		}, {
			field : 'abdominalcircumference',
			title : '腹围',
			align:"center",
		}, {
			field : 'fetalposition',
			title : '胎位',
			formatter:objectFormatter
		}, {
			field : 'fetalpresentation',
			title : '胎先露',
			align:"center",
			formatter:objectFormatter
		}, {
			field : 'fetalheart',
			title : '胎心',
			align:"center",
			//width : 100,
		}, {
			field : 'bloodsugar',
			title : '血糖',
		}, {
			field : 'edema',
			title : '水肿',
			align:"center",
			//width : 100
		}, {
			field : 'amountdetails',
			title : '量详情',
			align:"center",
		}, {
			field : 'urineprotein',
			title : '尿蛋白',
			align:"center",
	
		}, {
			field : 'hemoglobin',
			title : '血色素',
			align:"center",
		}, {
			field : 'bmode',
			title : 'B超筛查',
			align:"center",
	
		}, {
			field : 'reviewquestionsdescribe',
			title : '复查问题描述',
			align:"center",
		}, {
			field : 'highriskevaluate',
			title : '高危评定',
			align:"center",
		}, {
			field : 'highriskdetails',
			title : '高危详情',
			align:"center",
		}, {
			field : 'appointmentdate',
			title : '预约日期',
			align:"center",
			//width : 90,
		}, {
			field : 'checkdoctor',
			title : '检查医生',
			align:"center",
		}, {
			field : 'mentaloutlook',
			title : '精神状态',
			align:"center",

		}, {
			field : 'reviewcount',
			title : '复查次数',
			align:"center",
		}] ],
			toolbar : '#PrenatalReviewRecordDatagridToolbar'
			});
		
		//初始化添加修改模态框
		PrenatalReviewRecordDialog.dialog({     
		    width: 440,    
		    height: 370,    
		    closed: true,    
		    modal: true,
		    buttons:"#PrenatalReviewRecordDialogToolbar"
		});    
		
		//初始化高级查询模态框
		PrenatalReviewRecordHightSearchDialog.dialog({     
		    title:"高级查询",
			width: 430,    
		    height: 380,    
		    closed: true,    
		    modal: true,
		    buttons:"#PrenatalReviewRecordHightSearchButton"
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
		url:'/PrenatalReviewRecord/idnumber',    
	    valueField:'idnumber',    
	    textField:'idnumber',
	    onSelect:function(perWoman){
	    	console.debug(perWoman);
	    	$("#prename").textbox('setValue',perWoman.name);
	    	$("#prephonenumber").textbox('setValue',perWoman.phonenumber);
	    	$("#healthcode").textbox('setValue',perWoman.healthcode);
	    }
	});
	
	//加载fetalposition下拉列表
	$('#fetalpositionCombobox').combobox({    
		dataType : "html",
		url:'/PrenatalReviewRecord/fetalposition',    
	    valueField:'id',    
	    textField:'name' 
	});
	//加载fetalpresentation下拉列表
	$('#fetalpresentationCombobox').combobox({    
		dataType : "html",
		url:'/PrenatalReviewRecord/fetalpresentation',    
		valueField:'id',    
		textField:'name' 
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
	PrenatalReviewRecordDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			var row = PrenatalReviewRecordDatagrid.datagrid("getSelected");
			//回显form表单
			PrenatalReviewRecordDialog.form("load",row);
			//打开模态框
			PrenatalReviewRecordDialog.dialog("open").dialog("setTitle","修改孕妇信息").dialog("center");
		}
	});
})