package com.dmetal.tms.product.service;

import java.util.List;
import java.util.Map;

import com.dmetal.tms.product.entity.ProductType;

public interface ProductTypeService {
	/**查询产品分类一级相关子分类，并在treeGrid中进行数据呈现*/
	List<Map<String,Object>> findObjects();
	/**查询分类信息在zTree中进行数据呈现*/
	List<Map<String,Object>> findTreeNodes();
	void saveObject(ProductType productType);
	Map<String,Object> findObjectById(Integer id);
	void updateOjbect(ProductType productType);
	/**根据id删除对象*/
	void deleteObject(Integer id);
}
