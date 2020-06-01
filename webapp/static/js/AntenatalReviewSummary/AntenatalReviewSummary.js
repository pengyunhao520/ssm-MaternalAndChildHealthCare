$(function() {
	//跨域
	jQuery.support.cors=true;
	
	//声明变量来缓存组件
	var AntenatalReviewSummaryDatagrid,AntenatalReviewSummaryDialog,AntenatalReviewSummaryDialogForm,
	AntenatalReviewSummarySave,AntenatalReviewSummaryCancel,AntenatalReviewSummarySearchForm,
	AntenatalReviewSummaryHightSearch,AntenatalReviewSummaryHightSearchDialog,AntenatalReviewSummaryHightSearchDialogForm,
	AntenatalReviewSummaryHightSearchCancel;
	//孕妇基本信息表格
	AntenatalReviewSummaryDatagrid=$("#AntenatalReviewSummaryDatagrid");
	//添加修改模态框
	AntenatalReviewSummaryDialog=$("#AntenatalReviewSummaryDialog");
	AntenatalReviewSummaryDialogForm=$("#AntenatalReviewSummaryDialogForm");
	AntenatalReviewSummarySave=$("#AntenatalReviewSummarySave");
	AntenatalReviewSummaryCancel=$("#AntenatalReviewSummaryCancel");
	//搜索表单,少量条件查询
	AntenatalReviewSummarySearchForm=$("#AntenatalReviewSummarySearchForm");
	//高级按钮
	AntenatalReviewSummaryHightSearch=$("#AntenatalReviewSummaryHightSearch");
	//高级查询模态框
	AntenatalReviewSummaryHightSearchDialog=$("#AntenatalReviewSummaryHightSearchDialog");
	//高级查询表单
	AntenatalReviewSummaryHightSearchDialogForm=$("#AntenatalReviewSummaryHightSearchDialogForm");
	//取消高级查询模态框按钮
	AntenatalReviewSummaryHightSearchCancel=$("#AntenatalReviewSummaryHightSearchCancel");
	
	var cmdObj ={
		AntenatalReviewSummaryAdd : function(){
			//清空from表单
			AntenatalReviewSummaryDialogForm.form("clear");
			//打开添加模态框
			AntenatalReviewSummaryDialog.dialog("open").dialog("setTitle","产前复查总结").dialog("center");
		},
		//修改
		AntenatalReviewSummaryEdit : function(){
			//获取选中行
			var row = AntenatalReviewSummaryDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			AntenatalReviewSummaryDialog.form("load",row);
			//打开模态框
			AntenatalReviewSummaryDialog.dialog("open").dialog("setTitle","修改婚前保健信息").dialog("center");
			
			//手动回显fetalposition
			if(row.antenatalReviewSummaryParturient.fetalposition){
				$("#fetalpositionCombobox").textbox('setText',row.antenatalReviewSummaryParturient.fetalposition.name);
			}else{
				$("#fetalpositionCombobox").textbox('setValue',"");
				$("#fetalpositionCombobox").textbox('setText',"");
			}
			//手动回显pih
			if(row.pih){
				console.debug(row);
				$("#pihCombobox").textbox('setText',row.pih.name);
			}else{
				$("#pihCombobox").textbox('setValue',"");
				$("#pihCombobox").textbox('setText',"");
			}
			//手动回显highriskchange
			if(row.highriskchange){
				$("#highriskchangeCombobox").textbox('setText',row.highriskchange.name);
			}else{
				$("#highriskchangeCombobox").textbox('setValue',"");
				$("#highriskchangeCombobox").textbox('setText',"");
			}
			//手动回显phighriskchange
			if(row.antenatalReviewSummaryParturient.phighriskchange){
				$("#phighriskchangeCombobox").textbox('setText',row.antenatalReviewSummaryParturient.phighriskchange.name);
			}else{
				$("#phighriskchangeCombobox").textbox('setValue',"");
				$("#phighriskchangeCombobox").textbox('setText',"");
			}
			//手动回显highriskfactor
			if(row.highriskfactor){
				$("#highriskfactorCombobox").textbox('setText',row.highriskfactor.name);
			}else{
				$("#highriskfactorCombobox").textbox('setValue',"");
				$("#highriskfactorCombobox").textbox('setText',"");
			}
			//手动回显ppih
			if(row.antenatalReviewSummaryParturient.ppih){
				$("#ppihCombobox").textbox('setText',row.antenatalReviewSummaryParturient.ppih.name);
			}else{
				$("#ppihCombobox").textbox('setValue',"");
				$("#ppihCombobox").textbox('setText',"");
			}
			//手动回显placentaprevia
			if(row.antenatalReviewSummaryParturient.placentaprevia){
				$("#placentapreviaCombobox").textbox('setText',row.antenatalReviewSummaryParturient.placentaprevia.name);
			}else{
				$("#placentapreviaCombobox").textbox('setValue',"");
				$("#placentapreviaCombobox").textbox('setText',"");
			}
			//手动回显placentalabruption
			if(row.antenatalReviewSummaryParturient.placentalabruption){
				$("#placentalabruptionCombobox").textbox('setText',row.antenatalReviewSummaryParturient.placentalabruption.name);
			}else{
				$("#placentalabruptionCombobox").textbox('setValue',"");
				$("#placentalabruptionCombobox").textbox('setText',"");
			}
			//手动回显heartdisease
			if(row.antenatalReviewSummaryParturient.heartdisease){
				$("#heartdiseaseCombobox").textbox('setText',row.antenatalReviewSummaryParturient.heartdisease.name);
			}else{
				$("#heartdiseaseCombobox").textbox('setValue',"");
				$("#heartdiseaseCombobox").textbox('setText',"");
			}
			//手动回显viralhepatitis
			if(row.antenatalReviewSummaryParturient.viralhepatitis){
				$("#viralhepatitisCombobox").textbox('setText',row.antenatalReviewSummaryParturient.viralhepatitis.name);
			}else{
				$("#viralhepatitisCombobox").textbox('setValue',"");
				$("#viralhepatitisCombobox").textbox('setText',"");
			}
			//手动回显previewcount
			if(row.antenatalReviewSummaryParturient.previewcount){
				console.debug(row.antenatalReviewSummaryParturient.previewcount);
				$("#previewcount").textbox('setText',row.antenatalReviewSummaryParturient.previewcount);
			}else{
				$("#previewcount").textbox('setValue',"");
				$("#previewcount").textbox('setText',"");
			}
			//手动回显purineprotein
			if(row.antenatalReviewSummaryParturient.purineprotein){
				$("#purineprotein").textbox('setText',row.antenatalReviewSummaryParturient.purineprotein);
			}else{
				$("#purineprotein").textbox('setValue',"");
				$("#purineprotein").textbox('setText',"");
			}
			//手动回显phighriskevaluate
			if(row.antenatalReviewSummaryParturient.phighriskevaluate){
				$("#phighriskevaluate").textbox('setText',row.antenatalReviewSummaryParturient.phighriskevaluate);
			}else{
				$("#phighriskevaluate").textbox('setValue',"");
				$("#phighriskevaluate").textbox('setText',"");
			}
			//手动回显multiplebirth
			if(row.antenatalReviewSummaryParturient.multiplebirth){
				$("#multiplebirth").textbox('setText',row.antenatalReviewSummaryParturient.multiplebirth);
			}else{
				$("#multiplebirth").textbox('setValue',"");
				$("#multiplebirth").textbox('setText',"");
			}
			//手动回显amnioticfluid
			if(row.antenatalReviewSummaryParturient.amnioticfluid){
				$("#amnioticfluid").textbox('setText',row.antenatalReviewSummaryParturient.amnioticfluid);
			}else{
				$("#amnioticfluid").textbox('setValue',"");
				$("#amnioticfluid").textbox('setText',"");
			}
			//手动回显pelvicstenosis
			if(row.antenatalReviewSummaryParturient.pelvicstenosis){
				$("#pelvicstenosis").textbox('setText',row.antenatalReviewSummaryParturient.pelvicstenosis);
			}else{
				$("#pelvicstenosis").textbox('setValue',"");
				$("#pelvicstenosis").textbox('setText',"");
			}
			//手动回显developmentaldelay
			if(row.antenatalReviewSummaryParturient.developmentaldelay){
				$("#developmentaldelay").textbox('setText',row.antenatalReviewSummaryParturient.developmentaldelay);
			}else{
				$("#developmentaldelay").textbox('setValue',"");
				$("#developmentaldelay").textbox('setText',"");
			}
			//手动回显fetaldistress
			if(row.antenatalReviewSummaryParturient.fetaldistress){
				$("#fetaldistress").textbox('setText',row.antenatalReviewSummaryParturient.fetaldistress);
			}else{
				$("#fetaldistress").textbox('setValue',"");
				$("#fetaldistress").textbox('setText',"");
			}
			//手动回显hemoglobin
			if(row.antenatalReviewSummaryParturient.hemoglobin){
				$("#hemoglobin").textbox('setText',row.antenatalReviewSummaryParturient.hemoglobin);
			}else{
				$("#hemoglobin").textbox('setValue',"");
				$("#hemoglobin").textbox('setText',"");
			}
			//手动回显additionalremarks
			if(row.antenatalReviewSummaryParturient.additionalremarks){
				$("#additionalremarks").textbox('setText',row.antenatalReviewSummaryParturient.additionalremarks);
			}else{
				$("#additionalremarks").textbox('setValue',"");
				$("#additionalremarks").textbox('setText',"");
			}
			//手动回显summarydate
			if(row.antenatalReviewSummaryParturient.summarydate){
				$("#summarydate").textbox('setText',row.antenatalReviewSummaryParturient.summarydate);
			}else{
				$("#summarydate").textbox('setValue',"");
				$("#summarydate").textbox('setText',"");
			}
			//手动回显fillperson
			if(row.antenatalReviewSummaryParturient.fillperson){
				$("#fillperson").textbox('setText',row.antenatalReviewSummaryParturient.fillperson);
			}else{
				$("#fillperson").textbox('setValue',"");
				$("#fillperson").textbox('setText',"");
			}
			//手动回显inputperson
			if(row.antenatalReviewSummaryParturient.inputperson){
				$("#inputperson").textbox('setText',row.antenatalReviewSummaryParturient.inputperson);
			}else{
				$("#inputperson").textbox('setValue',"");
				$("#inputperson").textbox('setText',"");
			}
		},
		//删除
		AntenatalReviewSummaryRemove : function(){
			var row = AntenatalReviewSummaryDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/AntenatalReviewSummary/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		AntenatalReviewSummaryDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		AntenatalReviewSummaryReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格
			AntenatalReviewSummaryDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		AntenatalReviewSummaryCancel : function () {
			AntenatalReviewSummaryDialog.dialog("close");
		},
		//添加，保存婚前保健信息
		AntenatalReviewSummarySave : function () {
			//调用easyui的form组件的submit方法
			AntenatalReviewSummaryDialogForm.form('submit', { 
			    url:'/AntenatalReviewSummary/save',
			    onSubmit: function(){  
			        return AntenatalReviewSummaryDialogForm.form("validate");  
			    },    
			    success:function(data){
			    	var result=$.parseJSON(data);
			    	console.debug("tttttttttttt");
			       //console.debug(result);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   AntenatalReviewSummaryDialog.dialog("close");
			    	  
			    	   //刷新datagrid
			    	   AntenatalReviewSummaryDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.cod+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		AntenatalReviewSummarySearch : function () {
			var param=AntenatalReviewSummarySearchForm.serializeForm();
			//刷新表格数据、
			AntenatalReviewSummaryDatagrid.datagrid("load",param);
		},
		//高级查询
		AntenatalReviewSummaryHightSearch : function(){
			//打开高级查询模态框
			AntenatalReviewSummaryHightSearchDialog.dialog("open");
			//重置form表单
			AntenatalReviewSummaryHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		AntenatalReviewSummaryHightSearchSave : function(){
			var param=AntenatalReviewSummaryHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			AntenatalReviewSummaryDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			AntenatalReviewSummaryHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		AntenatalReviewSummaryHightSearchCancel : function () {
			AntenatalReviewSummaryHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	AntenatalReviewSummaryDatagrid.datagrid({
		title:"婚前保健信息",
		url : 'AntenatalReviewSummary/page',
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
			field : 'reviewcount',
			title : '总复查次数',
			align:"center",
			//width : 45
		}, {
			field : 'vaginalbleeding',
			title : '阴道出血',
			align:"center",
		}, {
			field : 'pih',
			title : '妊高征',
			align:"center",
			formatter:objectFormatter
		}, {
			field : 'urineprotein',
			title : '尿蛋白',
			align:"center",
			//width : 100,
		}, {
			field : 'bmode',
			title : 'B超筛查',
			align:"center",
		}, {
			field : 'highriskfactor',
			title : '高危因素',
			align:"center",
			formatter:objectFormatter
		}, {
			field : 'highriskevaluate',
			title : '高危评定',
			align:"center",
			
		}, {
			field : 'highriskchange',
			title : '高危变化',
			formatter:objectFormatter
		}, {
			field : 'antenatalReviewSummaryParturient.previewcount',
			title : '复查总数',
			align:"center",
			//width : 100,
			hidden : true
		}] ],
			toolbar : '#AntenatalReviewSummaryDatagridToolbar'
			});
		
		//初始化添加修改模态框
		AntenatalReviewSummaryDialog.dialog({     
		    width: 440,    
		    height: 370,    
		    closed: true,    
		    modal: true,
		    buttons:"#AntenatalReviewSummaryDialogToolbar"
		});    
		
		//初始化高级查询模态框
		AntenatalReviewSummaryHightSearchDialog.dialog({     
		    title:"高级查询",
			width: 430,    
		    height: 180,    
		    closed: true,    
		    modal: true,
		    buttons:"#AntenatalReviewSummaryHightSearchButton"
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
		url:'/AntenatalReviewSummary/idnumber',    
	    valueField:'idnumber',    
	    textField:'idnumber',
	    onSelect:function(perWoman){
	    	$("#prename").textbox('setValue',perWoman.name);
	    	$("#prephonenumber").textbox('setValue',perWoman.phonenumber);
	    	$("#healthcode").textbox('setValue',perWoman.healthcode);
	    }
	});
	//加载fetalposition下拉列表,胎位
	$('#fetalpositionCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=1',    
	    valueField:'id',    
	    textField:'name' 
	});
	//加载highriskchange下拉列表，高危变化13-17周
	$('#highriskchangeCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=3',    
		valueField:'id',    
		textField:'name' 
	});
	//加载phighriskchange下拉列表，高危变化28周-临产
	$('#phighriskchangeCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=3',    
		valueField:'id',    
		textField:'name' 
	});
	//加载highriskfactor下拉列表，高危因素
	$('#highriskfactorCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=4',    
		valueField:'id',
		textField:'name'
	});
	//加载pih下拉列表，妊高征13-17周
	$('#pihCombobox').combobox({
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=5',
	    valueField:'id',
	    textField:'name'
	});
	//加载ppih下拉列表，妊高征28周-临产
	$('#ppihCombobox').combobox({
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=5',
		valueField:'id',
		textField:'name'
	});
	//加载placentaprevia下拉列表，前置胎盘
	$('#placentapreviaCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=6',    
		valueField:'id',    
		textField:'name' 
	});
	//加载placentalabruption下拉列表，胎盘早剥
	$('#placentalabruptionCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=7',    
		valueField:'id',    
		textField:'name' 
	});
	//加载heartdisease下拉列表，心脏病
	$('#heartdiseaseCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=8',    
		valueField:'id',    
		textField:'name' 
	});
	//加载viralhepatitis下拉列表，病毒性肝炎
	$('#viralhepatitisCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/dictionarydetails?type=9',    
		valueField:'id',    
		textField:'name' 
	});
	
	
/*	//
	$('#pihCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalReviewSummary/fetalposition',    
		valueField:'id',    
		textField:'name'
	});*/
	//浏览器刷新清空少条件查询框
	$(document).ready(function(){
		$("#keyword").textbox('clear');
    });
	//双击查看详情
	AntenatalReviewSummaryDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			var row = AntenatalReviewSummaryDatagrid.datagrid("getSelected");
			
			//打开模态框
			AntenatalReviewSummaryDialog.dialog("open").dialog("refresh").dialog('refresh').dialog("setTitle","修改孕妇信息").dialog("center");
			//回显form表单
			AntenatalReviewSummaryDialog.form("load",row);
			
			//手动回显fetalposition
			if(row.antenatalReviewSummaryParturient.fetalposition){
				$("#fetalpositionCombobox").textbox('setText',row.antenatalReviewSummaryParturient.fetalposition.name);
			}else{
				$("#fetalpositionCombobox").textbox('setValue',"");
				$("#fetalpositionCombobox").textbox('setText',"");
			}
			//手动回显pih
			if(row.pih){
				console.debug(row);
				$("#pihCombobox").textbox('setText',row.pih.name);
			}else{
				$("#pihCombobox").textbox('setValue',"");
				$("#pihCombobox").textbox('setText',"");
			}
			//手动回显highriskchange
			if(row.highriskchange){
				$("#highriskchangeCombobox").textbox('setText',row.highriskchange.name);
			}else{
				$("#highriskchangeCombobox").textbox('setValue',"");
				$("#highriskchangeCombobox").textbox('setText',"");
			}
			//手动回显phighriskchange
			if(row.antenatalReviewSummaryParturient.phighriskchange){
				$("#phighriskchangeCombobox").textbox('setText',row.antenatalReviewSummaryParturient.phighriskchange.name);
			}else{
				$("#phighriskchangeCombobox").textbox('setValue',"");
				$("#phighriskchangeCombobox").textbox('setText',"");
			}
			//手动回显highriskfactor
			if(row.highriskfactor){
				$("#highriskfactorCombobox").textbox('setText',row.highriskfactor.name);
			}else{
				$("#highriskfactorCombobox").textbox('setValue',"");
				$("#highriskfactorCombobox").textbox('setText',"");
			}
			//手动回显ppih
			if(row.antenatalReviewSummaryParturient.ppih){
				$("#ppihCombobox").textbox('setText',row.antenatalReviewSummaryParturient.ppih.name);
			}else{
				$("#ppihCombobox").textbox('setValue',"");
				$("#ppihCombobox").textbox('setText',"");
			}
			//手动回显placentaprevia
			if(row.antenatalReviewSummaryParturient.placentaprevia){
				$("#placentapreviaCombobox").textbox('setText',row.antenatalReviewSummaryParturient.placentaprevia.name);
			}else{
				$("#placentapreviaCombobox").textbox('setValue',"");
				$("#placentapreviaCombobox").textbox('setText',"");
			}
			//手动回显placentalabruption
			if(row.antenatalReviewSummaryParturient.placentalabruption){
				$("#placentalabruptionCombobox").textbox('setText',row.antenatalReviewSummaryParturient.placentalabruption.name);
			}else{
				$("#placentalabruptionCombobox").textbox('setValue',"");
				$("#placentalabruptionCombobox").textbox('setText',"");
			}
			//手动回显heartdisease
			if(row.antenatalReviewSummaryParturient.heartdisease){
				$("#heartdiseaseCombobox").textbox('setText',row.antenatalReviewSummaryParturient.heartdisease.name);
			}else{
				$("#heartdiseaseCombobox").textbox('setValue',"");
				$("#heartdiseaseCombobox").textbox('setText',"");
			}
			//手动回显viralhepatitis
			if(row.antenatalReviewSummaryParturient.viralhepatitis){
				$("#viralhepatitisCombobox").textbox('setText',row.antenatalReviewSummaryParturient.viralhepatitis.name);
			}else{
				$("#viralhepatitisCombobox").textbox('setValue',"");
				$("#viralhepatitisCombobox").textbox('setText',"");
			}
			//手动回显previewcount
			if(row.antenatalReviewSummaryParturient.previewcount){
				console.debug(row.antenatalReviewSummaryParturient.previewcount);
				$("#previewcount").textbox('setText',row.antenatalReviewSummaryParturient.previewcount);
			}else{
				$("#previewcount").textbox('setValue',"");
				$("#previewcount").textbox('setText',"");
			}
			//手动回显purineprotein
			if(row.antenatalReviewSummaryParturient.purineprotein){
				$("#purineprotein").textbox('setText',row.antenatalReviewSummaryParturient.purineprotein);
			}else{
				$("#purineprotein").textbox('setValue',"");
				$("#purineprotein").textbox('setText',"");
			}
			//手动回显phighriskevaluate
			if(row.antenatalReviewSummaryParturient.phighriskevaluate){
				$("#phighriskevaluate").textbox('setText',row.antenatalReviewSummaryParturient.phighriskevaluate);
			}else{
				$("#phighriskevaluate").textbox('setValue',"");
				$("#phighriskevaluate").textbox('setText',"");
			}
			//手动回显multiplebirth
			if(row.antenatalReviewSummaryParturient.multiplebirth){
				$("#multiplebirth").textbox('setText',row.antenatalReviewSummaryParturient.multiplebirth);
			}else{
				$("#multiplebirth").textbox('setValue',"");
				$("#multiplebirth").textbox('setText',"");
			}
			//手动回显amnioticfluid
			if(row.antenatalReviewSummaryParturient.amnioticfluid){
				$("#amnioticfluid").textbox('setText',row.antenatalReviewSummaryParturient.amnioticfluid);
			}else{
				$("#amnioticfluid").textbox('setValue',"");
				$("#amnioticfluid").textbox('setText',"");
			}
			//手动回显pelvicstenosis
			if(row.antenatalReviewSummaryParturient.pelvicstenosis){
				$("#pelvicstenosis").textbox('setText',row.antenatalReviewSummaryParturient.pelvicstenosis);
			}else{
				$("#pelvicstenosis").textbox('setValue',"");
				$("#pelvicstenosis").textbox('setText',"");
			}
			//手动回显developmentaldelay
			if(row.antenatalReviewSummaryParturient.developmentaldelay){
				$("#developmentaldelay").textbox('setText',row.antenatalReviewSummaryParturient.developmentaldelay);
			}else{
				$("#developmentaldelay").textbox('setValue',"");
				$("#developmentaldelay").textbox('setText',"");
			}
			//手动回显fetaldistress
			if(row.antenatalReviewSummaryParturient.fetaldistress){
				$("#fetaldistress").textbox('setText',row.antenatalReviewSummaryParturient.fetaldistress);
			}else{
				$("#fetaldistress").textbox('setValue',"");
				$("#fetaldistress").textbox('setText',"");
			}
			//手动回显hemoglobin
			if(row.antenatalReviewSummaryParturient.hemoglobin){
				$("#hemoglobin").textbox('setText',row.antenatalReviewSummaryParturient.hemoglobin);
			}else{
				$("#hemoglobin").textbox('setValue',"");
				$("#hemoglobin").textbox('setText',"");
			}
			//手动回显additionalremarks
			if(row.antenatalReviewSummaryParturient.additionalremarks){
				$("#additionalremarks").textbox('setText',row.antenatalReviewSummaryParturient.additionalremarks);
			}else{
				$("#additionalremarks").textbox('setValue',"");
				$("#additionalremarks").textbox('setText',"");
			}
			//手动回显summarydate
			if(row.antenatalReviewSummaryParturient.summarydate){
				$("#summarydate").textbox('setText',row.antenatalReviewSummaryParturient.summarydate);
			}else{
				$("#summarydate").textbox('setValue',"");
				$("#summarydate").textbox('setText',"");
			}
			//手动回显fillperson
			if(row.antenatalReviewSummaryParturient.fillperson){
				$("#fillperson").textbox('setText',row.antenatalReviewSummaryParturient.fillperson);
			}else{
				$("#fillperson").textbox('setValue',"");
				$("#fillperson").textbox('setText',"");
			}
			//手动回显inputperson
			if(row.antenatalReviewSummaryParturient.inputperson){
				$("#inputperson").textbox('setText',row.antenatalReviewSummaryParturient.inputperson);
			}else{
				$("#inputperson").textbox('setValue',"");
				$("#inputperson").textbox('setText',"");
			}
		}
	});
})