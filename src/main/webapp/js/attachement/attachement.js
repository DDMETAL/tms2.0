$(function(){
	$("#uploadFormId").on('click','.btn-upload',doUpload);
	$("#uploadFormId").on('click','.btn-download',doDownload);
	doGetObjects();
})
function doDownload(){
	var id=$(this).parent().parent().data("id");
	console.log("id="+id);
	var url="attachement/downLoad.do?id="+id;
	document.location.href=url;
}
function doGetObjects(){
	var url="attachement/findObjects.do";
	$.post(url,function(result){
		if(result.state==1){
			setTableRows(result.data);
		}else{
			alert(result.message);
		}
	});
}
function setTableRows(list){
	var tBody=$("#pb");
	tBody.empty();
	var templete='<td><input type="checkbox" name="selectItem" value="[id]"</td>' +
				 '<td>[title]</td>' +
				 '<td>[fileName]</td>' +
				 '<td>[contentType]</td>' +
				 '<td><button type="button" class="btn btn-default btn-download">下载</button></td>';
	for(var i in list){
		var tr=$("<tr></tr>");
		tr.data("id",list[i].id);
		tr.append(
				templete.replace("[id]",list[i].id)
						.replace("[title]",list[i].title)
				  		.replace("[fileName]",list[i].fileName)
				  		.replace("[contentType]",list[i].contentType));
		tBody.append(tr);
	}
}
//上传
function doUpload(){
	var url="attachement/saveObject.do";
	//异步提交表单(先确保jquery.form.js已经引入)
	$("#uploadFormId").ajaxSubmit({
		url:url,
		type:'post',
		data:{'athBelong':1,'belongId':1},
		dataType:'json',
		success:function(result){
			if(result.state==1){
			alert("upload ok");
			doGetObjects();
			}else{
			alert(result.message);
			}
		}
	});
}