package product.dao;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.dmetal.tms.product.dao.ProductTypeDAO;
import com.dmetal.tms.product.entity.ProductType;

import common.dao.TestBaseDAO;

public class TestProductTypeDAO extends TestBaseDAO{
	
	@Test
	public void testFindObjects() {
		ProductTypeDAO producttypedao=(ProductTypeDAO)ac.getBean("productTypeDAO");
		List<Map<String,Object>> list=producttypedao.findObjects();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	@Test
	public void testInsertObject() {
		ProductTypeDAO producttypedao=(ProductTypeDAO)ac.getBean("productTypeDAO");
		ProductType producttype=new ProductType();
		producttype.setName("亲子游");
		producttype.setSort(3);
		producttype.setNote("亲子游");
		producttype.setParentId(124);
		producttype.setCreatedUser("DMETAL");
		producttype.setModifiedUser("DMETAL");
		int rows=producttypedao.insertObject(producttype);
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testFindTreeNodes() {
		ProductTypeDAO producttypedao=(ProductTypeDAO)ac.getBean("productTypeDAO");
		List<Map<String,Object>> list=producttypedao.findTreeNodes();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
		
	}
	
	@Test
	public void testUpdateObject() {
		ProductTypeDAO producttypedao=(ProductTypeDAO)ac.getBean("productTypeDAO");
		Map<String,Object> map=producttypedao.findObjectById(145);//必须是存在的id
		ProductType producttype=new ProductType();
		producttype.setId((Integer)map.get("id"));
		producttype.setName("欧美游");
		producttype.setParentId(124);
		producttype.setNote("欧美游");
		producttype.setSort(3);//必须在id这一列存在
		int rows=producttypedao.updateObject(producttype);
		Assert.assertEquals(1, rows);
	}
	
}
