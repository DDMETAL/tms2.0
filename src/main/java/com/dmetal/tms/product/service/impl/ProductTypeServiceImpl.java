package com.dmetal.tms.product.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmetal.tms.common.exception.SaveRuntimeException;
import com.dmetal.tms.common.exception.UpdateRuntimeException;
import com.dmetal.tms.product.dao.ProductTypeDAO;
import com.dmetal.tms.product.entity.ProductType;
import com.dmetal.tms.product.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	@Resource
	private ProductTypeDAO productTypeDAO;
	@Override
	public List<Map<String, Object>> findObjects() {
		
		return productTypeDAO.findObjects();
	}
	@Override
	public List<Map<String, Object>> findTreeNodes() {
		return productTypeDAO.findTreeNodes();
	}
	@Override
	public void saveObject(ProductType productType) {
		int rows=productTypeDAO.insertObject(productType);
		if(rows==-1) {
			throw new SaveRuntimeException("save error");
		}
		
	}
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null) {
			throw new RuntimeException("id can not be null");
		}
		Map<String,Object> map=productTypeDAO.findObjectById(id);
		return map;
	}
	@Override
	public void updateOjbect(ProductType producType) {
		int rows=productTypeDAO.updateObject(producType);
		if(rows==-1) {
			throw new UpdateRuntimeException("更新失败");
		}
		
	}
	@Override
	public void deleteObject(Integer id) {
		//根据id查询子元素个数
		int counts=productTypeDAO.hasChilds(id);
		if(counts>0) {
			throw new UpdateRuntimeException("请先删除子元素");
		}
		//执行删除动作
		int rows=productTypeDAO.deleteObject(id);
		if(rows==-1) {
			throw new UpdateRuntimeException("删除失败");
		}
	}

}
