package common.dao;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dmetal.tms.project.dao.ProjectDAO;

public class TestBaseDAO {
	public ClassPathXmlApplicationContext ac;
	@Before
	public void init() {
		ac=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
		
	}
	
	
	@After
	public void destory() {
		ac.close();
	}
}
