package com.dmetal.tms.product.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmetal.tms.common.web.JsonResult;
import com.dmetal.tms.product.entity.ProductType;
import com.dmetal.tms.product.service.ProductTypeService;

@Controller
@RequestMapping("/productType/")
public class ProductTypeController {
	@Resource
	private ProductTypeService productTypeService;
	@RequestMapping("listUI")
	public String listUI() {
		return "product/product_type_list";
	}
	@RequestMapping("editUI")
	public String editUI() {
		return "product/product_type_edit";
	}
	@RequestMapping("findObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		List<Map<String,Object>> list=productTypeService.findObjects();
		return new JsonResult(list);
	}
	
	@RequestMapping("findTreeNodes")
	@ResponseBody
	public JsonResult doFindTreeNodes() {
		List<Map<String,Object>> list=productTypeService.findTreeNodes();
		return new JsonResult(list);
	}
	
	@RequestMapping("saveObject")
	@ResponseBody
	public JsonResult doSaveObject(ProductType productType) {
		productTypeService.saveObject(productType);
		return new JsonResult();
	}
	
	@RequestMapping("findObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		Map<String,Object> map=productTypeService.findObjectById(id);
		return new JsonResult(map);
	}
	
	@RequestMapping("updateObject")
	@ResponseBody
	public JsonResult doUpdateObject(ProductType productType) {
		productTypeService.updateOjbect(productType);
		return new JsonResult();
	}

	@RequestMapping("deleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		productTypeService.deleteObject(id);
		return new JsonResult();
	}
}
