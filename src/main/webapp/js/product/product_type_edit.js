var zTree;
var setting = {
	data : {
		    simpleData : {
			enable : true,
			idKey : "id",  //节点数据中保存唯一标识的属性名称
			pIdKey : "parentId",  //节点数据中保存其父节点唯一标识的属性名称
			rootPId : null  //根节点id
		}
	}
}
$(function(){
	$("#editTypeForm").on('click','.load-product-type',loadTypeTree);
	$("#typeLayer").on('click','.btn-cancle',hideTypeTree);
	$("#typeLayer").on('click','.btn-confirm',setSelectedTypeNode);
	$("#btn-save").click(doSaveOrUpdate);
	//判定当前页面中有无id值，若有根据id查询产品分类
	//并将信息填充到表单中
	var typeId=$("#container").data("typeId");
	if(typeId)doGetObjectById(typeId);
						
					  
})
function doGetObjectById(typeId){
	var url="productType/findObjectById.do";
	var params={"id":typeId};
	$.post(url,params,function(result){
		if(result.state==1){
			setEditFormData(result.data);
		}else{
			alert(result.message);
		}
	});
}
function setEditFormData(data){
	$("#editTypeForm").data("parentId",data.parentId);
	$("#typeNameId").val(data.name);
	$("#parentNameId").val(data.parentName);
	$("#typeSortId").val(data.sort);
	$("#typeNoteId").html(data.note);
}
function doSaveOrUpdate(){
	//获取表单数据
	var params=getEditFormData();
	//提交表单数据
	var id=$("#container").data("typeId");
	if(id)params.id=id;//修改时id应该有值
	var saveUrl="productType/saveObject.do";
	var updateUrl="productType/updateObject.do";
	var url=id?updateUrl:saveUrl;
	$.post(url,params,function(result){
		if(result.state==1){
			doClearFormData();
			$("#container").load("productType/listUI.do?t="+Math.random(1000));
		}else{
			alert(result.message);
		}
	})
}
//清空表单数据
function doClearFormData(){
	//技巧性应用(给每个表单中需要清空数据的地方添加一个dynamicClear选择器)
	$(".dynamicClear").val("");
	$("#container").removeData("typeId");
	$("#editTypeForm").removeData("parentId");
	
}
//获得表单数据
function getEditFormData(){
	var params={
			"name":$("#typeNameId").val(),
			"parentId":$("#editTypeForm").data("parentId"),
			"sort":$("#typeSortId").val(),
			"note":$("#typeNoteId").val()	
	};
	return params;
}
function loadTypeTree(){
	//显示zTree树
	$("#typeLayer").css("display","block");
	//初始化zTree
	 var url="productType/findTreeNodes.do";
	 $.getJSON(url,function(result){
		 if(result.state==1){
			 //初始化zTree
			 zTree=$.fn.zTree.init($("#typeTree"),//显示树的位置
					 		setting,//树的基本配置
					 		result.data);//树的基本数据
		 }else{
			 alert(result.message);
		 }
	 });
}
//隐藏zTree
function hideTypeTree(){
	$("#typeLayer").css("display","none");
}
//设置选中的节点
function setSelectedTypeNode(){
	var nodes=zTree.getSelectedNodes();
	//获得选中的第一个节点(此处是单选,也可以多选)
	var node=nodes[0];
	//给parentNameId赋值
	$("#parentNameId").val(node.name);//显示的name
	//将id的值绑定到editTypeForm对象上
	$("#editTypeForm").data("parentId",node.id);//保存到数据库的是parentId
	//隐藏zTree
	$("#typeLayer").css("display","none");
}