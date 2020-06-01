$(function() {
	//跨域
	jQuery.support.cors=true;
	
	//声明变量来缓存组件
	var AntenatalInitialInspectionDatagrid,AntenatalInitialInspectionDialog,AntenatalInitialInspectionDialogForm,
	AntenatalInitialInspectionSave,AntenatalInitialInspectionCancel,AntenatalInitialInspectionSearchForm,
	AntenatalInitialInspectionHightSearch,AntenatalInitialInspectionHightSearchDialog,AntenatalInitialInspectionHightSearchDialogForm,
	AntenatalInitialInspectionHightSearchCancel;
	//孕妇基本信息表格
	AntenatalInitialInspectionDatagrid=$("#AntenatalInitialInspectionDatagrid");
	//添加修改模态框
	AntenatalInitialInspectionDialog=$("#AntenatalInitialInspectionDialog");
	AntenatalInitialInspectionDialogForm=$("#AntenatalInitialInspectionDialogForm");
	AntenatalInitialInspectionSave=$("#AntenatalInitialInspectionSave");
	AntenatalInitialInspectionCancel=$("#AntenatalInitialInspectionCancel");
	//搜索表单,少量条件查询
	AntenatalInitialInspectionSearchForm=$("#AntenatalInitialInspectionSearchForm");
	//高级按钮
	AntenatalInitialInspectionHightSearch=$("#AntenatalInitialInspectionHightSearch");
	//高级查询模态框
	AntenatalInitialInspectionHightSearchDialog=$("#AntenatalInitialInspectionHightSearchDialog");
	//高级查询表单
	AntenatalInitialInspectionHightSearchDialogForm=$("#AntenatalInitialInspectionHightSearchDialogForm");
	//取消高级查询模态框按钮
	AntenatalInitialInspectionHightSearchCancel=$("#AntenatalInitialInspectionHightSearchCancel");
	
	var cmdObj ={
		AntenatalInitialInspectionAdd : function(){
			//清空from表单
			AntenatalInitialInspectionDialogForm.form("clear");
			//打开添加模态框
			AntenatalInitialInspectionDialog.dialog("open").dialog("setTitle","婚前保健信息").dialog("center");
		},
		//修改
		AntenatalInitialInspectionEdit : function(){
			//获取选中行
			var row = AntenatalInitialInspectionDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert("提示:","请选择一行进行修改",'info');
				return;
			}
			//回显form表单
			AntenatalInitialInspectionDialog.form("load",row);
			//打开模态框
			AntenatalInitialInspectionDialog.dialog("open").dialog("setTitle","修改婚前保健信息").dialog("center");
			
			
		},
		//删除
		AntenatalInitialInspectionRemove : function(){
			var row = AntenatalInitialInspectionDatagrid.datagrid("getSelected");
			//判断是否选中行
			if(!row){
				$.messager.alert('确认删除','请选择一行进行删除!','info');
				return;
			}
			//提示是否确认删除
			$.messager.confirm('确认删除', '您确定要删除【'+row.name+'】吗？', function(r){
				if (r){
				    //执行删除操作,发送ajax请求
				    $.get("/AntenatalInitialInspection/delete",{id:row.id},function(result){
				    	if(result.success){
				    		//成功,刷新datagrid
				    		$.messager.alert('已删除','删除成功!','info');
				    		AntenatalInitialInspectionDatagrid.datagrid("reload");
				    	}else{
				    		$.messager.alert('温馨提示',result.code+"-"+result.message,'error');
				    	}
				    },"json");
				}
			});
		},
		//刷新
		AntenatalInitialInspectionReload : function(){
			//清空条件搜索框
			$("#keyword").textbox('clear');
			//刷新表格
			AntenatalInitialInspectionDatagrid.datagrid("reload",{
				q: '',
				isPregnantwoman: ''
			});
		},
		//关闭添加修改模态框
		AntenatalInitialInspectionCancel : function () {
			AntenatalInitialInspectionDialog.dialog("close");
		},
		//添加，保存婚前保健信息
		AntenatalInitialInspectionSave : function () {
			//调用easyui的form组件的submit方法
			AntenatalInitialInspectionDialogForm.form('submit', { 
			    url:'/AntenatalInitialInspection/save',
			    onSubmit: function(){  
			        return AntenatalInitialInspectionDialogForm.form("validate");  
			    },    
			    success:function(data){
			    	console.log(data);
			       var result=$.parseJSON(data);
			       if(result.success){
			    	   //成功
			    	   $.messager.alert('提示:','保存成功!','info');
			    	   //关闭模态框
			    	   AntenatalInitialInspectionDialog.dialog("close");
			    	   //刷新datagrid
			    	   AntenatalInitialInspectionDatagrid.datagrid("reload");
			       }else{
			    	   $.message.alert('提示:',result.cod+"-"+result.message,'error');
			       }
			    }    
			});  

		},
		//少量条件查询
		AntenatalInitialInspectionSearch : function () {
			var param=AntenatalInitialInspectionSearchForm.serializeForm();
			//刷新表格数据、
			AntenatalInitialInspectionDatagrid.datagrid("load",param);
		},
		//高级查询
		AntenatalInitialInspectionHightSearch : function(){
			//打开高级查询模态框
			AntenatalInitialInspectionHightSearchDialog.dialog("open");
			//重置form表单
			AntenatalInitialInspectionHightSearchDialogForm.form("reset");
		},
		//提交高级查询
		AntenatalInitialInspectionHightSearchSave : function(){
			var param=AntenatalInitialInspectionHightSearchDialogForm.serializeForm();
			//刷新表格数据、
			AntenatalInitialInspectionDatagrid.datagrid("load",param);
			//关闭高级查询模态框
			AntenatalInitialInspectionHightSearchDialog.dialog("close");
		},
		//关闭添加修改模态框
		AntenatalInitialInspectionHightSearchCancel : function () {
			AntenatalInitialInspectionHightSearchDialog.dialog("close");
		},
	}
	
	// 初始化组件
	// 初始化datagrid组件
	AntenatalInitialInspectionDatagrid.datagrid({
		title:"婚前保健信息",
		url : 'AntenatalInitialInspection/page',
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
			hidden:true
		}, {
			field : 'peidnumber',
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
			field : 'lastmenstruationdate',
			title : '末次月经日期',
			align:"center",
			hidden:true
		}, {
			field : 'initialinspectionweek',
			title : '初检孕周',
			align:"center",
			
		}, {
			field : 'epectedchildbirthdate',
			title : '预产期',
			align:"center",
			
		}, {
			field : 'pegnantcount',
			title : '孕次',
			align:"center",
			//width : 100,
		}, {
			field : 'productioncount',
			title : '产次',
			align:"center",
			
		}, {
			field : 'height',
			title : '身高',
			align:"center",
			hidden:true
		}, {
			field : 'weight',
			title : '体重',
			align:"center",
			hidden:true
		}, {
			field : 'systolicpressure',
			title : '收缩压',
			hidden:true
		}, {
			field : 'diastolicpressure',
			title : '舒张压',
			align:"center",
			hidden:true
		}, {
			field : 'heart',
			title : '心脏',
			align:"center",
			hidden:true
		}, {
			field : 'heartdetails',
			title : '心脏详情',
			hidden:true
		}, {
			field : 'lung',
			title : '肺部',
			align:"center",
			hidden:true
		}, {
			field : 'lungdetails',
			title : '肺部详情',
			align:"center",
			hidden:true
		}, {
			field : 'vaginitis',
			title : '阴道炎',
			align:"center",
	
		}, {
			field : 'vaginitisdetails',
			title : '阴道炎详情',
			align:"center",
			hidden:true
		}, {
			field : 'cervicitis',
			title : '宫颈炎',
			align:"center",
	
		}, {
			field : 'cervicitisdetails',
			title : '宫颈炎详情',
			align:"center",
			hidden:true
		}, {
			field : 'dublevaginaanduterus',
			title : '双阴道双子宫',
			align:"center",
			hidden:true
		}, {
			field : 'dublevaginaanduterusdetails',
			title : '双阴道双子宫详情',
			align:"center",
			hidden:true
		}, {
			field : 'myomauterus',
			title : '子宫肌瘤',
			align:"center",
			//width : 90,
		}, {
			field : 'myomauterusdetails',
			title : '子宫肌瘤详情',
			align:"center",
			hidden:true
		}, {
			field : 'anexalmass',
			title : '附件肿物',
			align:"center",

		}, {
			field : 'aexalmassdetails',
			title : '附件肿物详情',
			align:"center",
			hidden:true
		}, {
			field : 'uterussizeationalweek',
			title : '子宫大小与孕周相符',
			align:"center",
			hidden:true
		}, {
			field : 'uterussizeationalweekdetails',
			title : '子宫大小与孕周相符详情',
			align:"center",
			hidden:true
		}, {
			field : 'otherquestions',
			title : '其他问题',
			align:"center",
			//width : 90,
		}, {
			field : 'vaginalbleeding',
			title : '阴道出血',
			align:"center",
			
		}, {
			field : 'vomiting ',
			title : '剧吐',
			align:"center",
			//width : 100,
		}, {
			field : 'fever',
			title : '体温≥38.5持续24小时以上',
			align:"center",
			hidden:true
		}, {
			field : 'viralinfection',
			title : '病毒性感染',
			align:"center",
			//width : 90,
		}, {
			field : 'acyeterion',
			title : '孕前六个月内服用避孕药',
			align:"center",
			hidden:true
		}, {
			field : 'urineprotein',
			title : '尿蛋白',
			align:"center",
			//width : 100
		}, {
			field : 'leucorrhea',
			title : '白带',
			align:"center",
			
		}, {
			field : 'bloodsugar',
			title : '血糖',
			align:"center",
			//width : 100,
			/* formatter:isLocalFormatter */
		}, {
			field : 'toxoplasma',
			title : '弓形体',
			align:"center",
			
		}, {
			field : 'alphafetoprotein',
			title : '甲胎蛋白',
			align:"center",
			//width : 100
		}, {
			field : 'cytomegalovirus',
			title : '巨细胞病毒',
			align:"center",
			
		}, {
			field : 'GPTorALT',
			title : 'GPT或ALT',
			align:"center",
			//width : 90,
		}, {
			field : 'rubellavirus',
			title : '风疹病毒',
			align:"center",
			
		}, {
			field : 'hbsag',
			title : 'HBsAg',
			align:"center",
			//width : 200
		}, {
			field : 'syphilis',
			title : '梅毒',
			align:"center",
			
		}, {
			field : 'bloodtype',
			title : '血型',
			align:"center",
		}, {
			field : 'othercheckdetails',
			title : '其他检查详情',
			align:"center",
			hidden:true
		}, {
			field : 'highriskevaluate',
			title : '高危评定',
			align:"center",
			
		}, {
			field : 'highriskdetails',
			title : '高危详情',
			align:"center",
			hidden:true
		}, {
			field : 'anteriorsuperiorspine',
			title : '髂前上棘间径',
			align:"center",
			hidden:true
		}, {
			field : 'Anterioriliac',
			title : '髂前间径',
			align:"center",
			hidden:true
		}, {
			field : 'sacroiliacexternaldiameter',
			title : '骶耻外径',
			align:"center",
			hidden:true
		}, {
			field : 'sciatictubercle',
			title : '坐骨结节间径',
			align:"center",
			hidden:true
		}, {
			field : 'checkdate',
			title : '检查日期',
			align:"center",
			
		}, {
			field : 'fillperson',
			title : '填表人',
			align:"center",
		}, {
			field : 'inputperson',
			title : '录入人',
			align:"center",
		}] ],
			toolbar : '#AntenatalInitialInspectionDatagridToolbar'
			});
		
		//初始化添加修改模态框
		AntenatalInitialInspectionDialog.dialog({     
		    width: 430,    
		    height: 370,    
		    closed: true,    
		    modal: true,
		    buttons:"#AntenatalInitialInspectionDialogToolbar"
		});    
		
		//初始化高级查询模态框
		AntenatalInitialInspectionHightSearchDialog.dialog({     
		    title:"高级查询",
			width: 430,    
		    height: 380,    
		    closed: true,    
		    modal: true,
		    top:20,
		    buttons:"#AntenatalInitialInspectionHightSearchButton"
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
	$('#peidnumberCombobox').combobox({    
		dataType : "html",
		url:'/AntenatalInitialInspection/idnumber',    
	    valueField:'idnumber',    
	    textField:'idnumber',
	    onSelect:function(perWoman){
	    	$("#prename").textbox('setValue',perWoman.name);
	    	$("#prephonenumber").textbox('setValue',perWoman.phonenumber);
	    	$("#healthcode").textbox('setValue',perWoman.healthcode);
	    }
	});
	
	//孕次
	$('#pegnantcount').numberspinner({    
		value: 0,
		min: 0,    
	    max: 20,
	    editable: false   
	});
	//产次
	$('#productioncount').numberspinner({    
		value: 0,
		min: 0,    
		max: 20,
		//editable: false   
	});
	//高级搜索中的孕次
	$('#pegnantcountSearch').numberspinner({    
		value: 0,
		min: 0,    
		max: 20,
		editable: false   
	});
	//高级搜索中的产次
	$('#productioncountSearch').numberspinner({    
		value: 0,
		min: 0,    
		max: 20,
		//editable: false   
	});
	//浏览器刷新清空少条件查询框
	$(document).ready(function(){
		$("#keyword").textbox('clear');
    });
	//双击查看详情
	AntenatalInitialInspectionDatagrid.datagrid({
		onDblClickCell: function(index,field,value){
			var row = AntenatalInitialInspectionDatagrid.datagrid("getSelected");
			//回显form表单
			AntenatalInitialInspectionDialog.form("load",row);
			//打开模态框
			AntenatalInitialInspectionDialog.dialog("open").dialog("setTitle","修改孕妇信息").dialog("center");
		}
	});
})