package com.dmetal.tms.product.dao;

import java.util.List;
import java.util.Map;

import com.dmetal.tms.common.dao.BaseDAO;
import com.dmetal.tms.product.entity.ProductType;
/**产品分类*/
public interface ProductTypeDAO extends BaseDAO<ProductType>{
	int insertObject();
	List<Map<String,Object>> findObjects();
	List<Map<String,Object>> findTreeNodes();
	Map<String,Object> findObjectById(Integer id);
	
	/**获得id分类下子元素的个数*/
	int hasChilds(Integer id);
	/**根据id删除对象*/
	int deleteObject(Integer id);
	
}
