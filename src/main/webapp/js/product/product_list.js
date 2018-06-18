$(function(){
	$("#queryFormId").on('click','.btn-attachement',loadAttachement);
})
//加载产品附件页面
function loadAttachement(){
	var url="attachement/uploadUI.do";
	$("#container").data("athBelong",1);//归属类型(产品附件/分销商附件/渠道商附件/...)
	$("#container").data("belongId",1);//假设归属产品1对象(是选择的checked的value值)
	$("#container").load(url);
}