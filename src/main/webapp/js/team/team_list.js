$(function(){
	$("#queryFormId").on('click','.btn-search',doGetObjects);
	$("#queryFormId").on('click','.btn-add',showEditDialog);
	
	//加载数据
	doGetObjects();
})
function showEditDialog(){
	var url="team/editUI.do";
	var title;
	if($(this).hasClass("btn-add")){
		title="添加团信息";
	}
	$("#modal-dialog .modal-body").load(url,function(){
		$(".modal-title").html(title);
		$("#modal-dialog").modal("show");
	})
	
	
}

function doGetObjects(){
	var url="team/findPageObjects.do";
	var params=getQueryFormData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(pageCurrent){
		params.pageCurrent=pageCurrent
		}else{
			params.pageCurrent=1;
		}
	$.post(url,params,function(result){
		if(result.state==1){
			setTableRows(result.data.list);
			setPagination(result.data.pageObject);
		}else{
			alert(result.message);
		}
	});
}
function getQueryFormData(){
	var params={
		"projectName":$("#searchProjectId").val().trim(),
		"valid":$("#searchValidId").val()
	};
	return params;
}
function setTableRows(list){
	var tBody=$("#pb");
	tBody.empty();
	var templete='<td><input type="checkbox" name="checkedItem" value="[id]"/></td>'+
	 			 '<td>[name]</td><td>[projectName]</td>'+
	 			 '<td>[valid]</td>'+
	 			 '<td><button type="button" class="btn btn-default btn-update">修改</button></td>';
	//迭代list(此集合中存储的是多个map)
	for(var i in list){
		var tr=$('<tr></tr>');
		tr.data("id",list[i].id);
		tr.append(
			templete.replace('[id]',list[i].id)
					.replace('[name]',list[i].name)
					.replace('[projectName]',list[i].projectName)
					.replace('[valid]',list[i].valid?'启用':'禁用')
				);
		tBody.append(tr);
	}
}