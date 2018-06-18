$(function(){
	$("#queryFormId").on('click','.btn-search',doGetObjects);
	$("#queryFormId").on('click','.btn-valid,.btn-invalid',doValidById);
	$("#queryFormId").on('click','.btn-add',showEditDialog);
	$("#queryFormId").on('click','.btn-update',showEditDialog);
	//页面加载完成后执行
	//发起ajax请求findObject.do
	//将返回结果填充到content位置
	doGetObjects();
});

function showEditDialog(){
	var url="project/editUI.do";
	var title;
	if($(this).hasClass("btn-add")){
		title="添加项目";	
	}
	if($(this).hasClass("btn-update")){
		title="修改项目";
		//将要修改的记录的id值绑定到模态框上
		//目的是通过一个模块实现添加或更新操作
		$("#modal-dialog").data("id",$(this).parent().parent().data("id"));
	}
	//在模态框的.moday-body位置异步加载url
	$("#modal-dialog .modal-body").load(url,
			function(){//加载完成执行此
		 $(".modal-title").html(title);
		 $("#modal-dialog").modal("show");
	})
}

//获取项目信息
function doGetObjects(){
	var url="project/findPageObjects.do";
	//获得查询参数
	var params=getQueryFormData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(pageCurrent){params.pageCurrent=pageCurrent};
	$.post(url,params,function(result){
		if(result.state==1){
			//填充表格
			setTableRows(result.data.list);//map中的list
			//设置分页
			setPagination(result.data.pageObject);
		}else{
			alert(result.message);
		}
		
	});  
}
//获得查询表单中的数据
function getQueryFormData(){
	var params={
		"name":$("#searchNameId").val().trim(),
		"valid":$("#searchValidId").val()
	}
	return params;
}
//将从服务端获得的列表数据填充到表格中
function setTableRows(list){
	//获取tbody对应的dom节点
	var tBody=$("#pb");
	//先清空tbody中数据
	tBody.empty();
	var templete='<td><input type="checkbox" name="checkedItem" value="[id]"/></td>'+
	 '<td>[code]</td><td>[name]</td>'+
	 '<td>[beginDate]</td><td>[endDate]</td>'+
	 '<td>[valid]</td>'+
	 '<td><button type="button" class="btn btn-default btn-update">修改</button></td>';
	//追加新数据
	for(var i in list){//循环一次取一行数据对应一对tr对象
	var tr=$('<tr></<tr>');//创建一对tr对象
	//	var tds='<td>'+list[i].code+'</td><td>'+list[i].name+'</td><td>'+list[i].beginDate+'</td><td>'+list[i].note+'</td>';
	//	tr.append(tds);//将td对象添加到tr对象中
	tr.data("id",list[i].id);//绑定数据，便于后续获得此数据进行修改等操作
	tr.append(
	templete.replace('[id]',list[i].id)
			.replace('[code]',list[i].code)
			.replace('[name]',list[i].name)
			.replace('[beginDate]',list[i].beginDate)
			.replace('[endDate]',list[i].endDate)
			.replace('[valid]',list[i].valid?'启用':'禁用')
		);
	tBody.append(tr);//将tr对象添加到tbody对象中
	}
}
//启动&禁用
function doValidById(){
	//状态值
	var state;
	//判定触发的是启用还是禁用按钮(根据类选择器)
	if($(this).hasClass("btn-valid")){
		//启用
		state=1;//将选中的记录的valid修改为1
	}else{
		//禁用
		state=0;
	}
	//获得选中的记录id值
	var checkedIdes=getCheckedIdes();
	if(checkedIdes==''){
		alert("至少选择一个");
		return;
	}
	console.log("checkedIdes:"+checkedIdes);
	var params={"checkedIdes":checkedIdes,"valid":state};
	//获得的数据通过ajax发送异步请求到服务器执行更新操作
	var url="project/doValidById.do";
	$.post(url,params,function(result){
		if(result.state==1){
			doGetObjects();
		}else{
			alert(result.message);
		}
		
	})
}
function getCheckedIdes(){
	var checkedIdes='';
	$('tbody input[name="checkedItem"]')
	.each(function(){
		if($(this).is(":checked")){//$(this).prop("checked")
			if(checkedIdes==''){
				checkedIdes+=$(this).val();
			}else{
				checkedIdes+=","+$(this).val();
			}
		}
	})
	return checkedIdes;
}