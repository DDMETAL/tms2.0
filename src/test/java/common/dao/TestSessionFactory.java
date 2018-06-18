package common.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {
	
	@Test
	public void testSessionFactory() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
		Object sessionFactory=ac.getBean("sqlSessionFactory");
		System.out.println("SessionFactory: "+sessionFactory);
		Assert.assertNotEquals(null, sessionFactory);
	}
}
