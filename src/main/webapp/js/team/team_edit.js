$(function(){
	$("#modal-dialog").on('click','.ok',doSaveOrUpdate);
	doInitProjectIdAndName();
})
//初始化项目id和名字列表
function doInitProjectIdAndName(){
	var url="team/findProjectIdAndName.do";
	$.getJSON(url,function(result){
		if(result.state==1){
			setProjectSelectOptions(result.data);
		}else{
			alert(result.message);
		}
	})
}
//填充select选项
function setProjectSelectOptions(list){
	var selectObj=$("#selectProjectId");
	var optionObj="<option value=[id]>[name]</option>";
	for(var i in list){
		selectObj.append(
				optionObj.replace("[id]",list[i].id)
						 .replace("[name]",list[i].name));
	}
}
//添加或修改数据
function doSaveOrUpdate(){
	var url="team/saveObject.do";
	var params=getEditFormData();
	$.post(url,params,function(result){
		if(result.state==1){
			$("#modal-dialog").modal("hide");
			doGetObjects();
		}else{
			alert(result.message);
		}
	});
}
//获取编辑框中数据
function getEditFormData(){
	var params={
			"name":$("#nameId").val(),
			"projectId":$("#selectProjectId").val(),
			"valid":$('input[name="valid]:checked').val(),
			"note":$("#noteId").val()
	};
	console.log(JSON.stringify(params));
	return params;
}