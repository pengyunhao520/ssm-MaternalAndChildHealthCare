//对象格式化
function objectFormatter(value,row,index){
	return value!=null?(value.name||value.nationname):"未填";
}

//婚史格式化
function MarryHistoryFormatter(value,row,index){
	if(value==0){
		return "未婚";
	}else if(value==null){
		return "未填";
	}else{
		return "已婚"+value+"次"
	}
	
}


//序列化表单字段
$.fn.serializeForm = function(){
	var FormData=this.serializeArray();
	var param={};
	for(var i in FormData){
		var datas=FormData[i];
		param[datas.name]=datas.value;
	}
	return param;
}


