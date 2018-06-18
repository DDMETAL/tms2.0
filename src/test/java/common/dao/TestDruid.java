package common.dao;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDruid {
	
	@Test
	public void testDruid() {
		//获得ApplicationContext
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-pool.xml");
		//获得DataSource对象
		DataSource dataSource=(DataSource)ac.getBean("dataSource");
		System.out.println("dataSource :"+dataSource);
		//测试数据源对象是否为空
		Assert.assertNotEquals(null, dataSource);
	}
}
