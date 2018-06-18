package project.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.dao.ProjectDAO;
import com.dmetal.tms.project.entity.Project;

import common.dao.TestBaseDAO;


public class TestProjectDAO extends TestBaseDAO{
		
		/**测试 insertObject
		 * @throws ParseException */
		@Test
		public void testInsertOjbect() throws ParseException {
			ProjectDAO projectdao=(ProjectDAO)ac.getBean("projectDAO");
			Project entity=new Project();
			entity.setId(10);
			entity.setCode("TTCN-20180508-CHN-GZ-010");
			entity.setName("广州七日游");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			entity.setBeginDate(sdf.parse("2018-05-08"));
			entity.setEndDate(sdf.parse("2018-05-15"));
			entity.setValid(1);
			entity.setNote("七日游");
			entity.setCreatedUser("DMETAL");
			entity.setModifiedUser("DMETAL");
			int n=projectdao.insertObject(entity);
			Assert.assertEquals(1, n);
		}
		
		/**测试 findObjects*/
		@Test
		public void testFindObjects() {
			ProjectDAO projectdao=(ProjectDAO)ac.getBean("projectDAO");
			List<Project> projects=projectdao.findObjects();
			System.out.println(projects);
			Assert.assertNotEquals(null, projects);
		}
		
		/**测试 findPageObjects*/
		@Test
		public void testFindPageObjects() {
			ProjectDAO projectdao=(ProjectDAO)ac.getBean("projectDAO");
			Project project=new Project();
			PageObject pageObject=new PageObject();
			//获得当前页的记录
			List<Project> projects=projectdao.findPageObjects(project,pageObject);
			//获取总记录数
			int rowCount=projectdao.getRowCount(project);
			//获取总页数(根据总记录数,pageSize计算总页数)
			pageObject.setRowCount(rowCount);
			int pageCount=pageObject.getPageCount();
			System.out.println(pageCount);
			pageObject.getPageCount();
			System.out.println(projects);
			Assert.assertEquals(3, projects.size());
		}
		
		@Test
		public void testVaildById() {
			ProjectDAO projectdao=(ProjectDAO)ac.getBean("projectDAO");
			String[] ides= {"1","2"};
			int rows=projectdao.validById(ides, 1);
			System.out.println(rows);
			Assert.assertEquals(2, rows);
		}
		
		@Test
		public void testupdateObject() throws ParseException {
			ProjectDAO projectdao=(ProjectDAO)ac.getBean("projectDAO");
			Project project=projectdao.findObjectById(11);
			project.setName("海南沙滩派对");
			project.setCode("TT-2018-05-15-CHN-HN-011");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			project.setBeginDate(sdf.parse("2018-05-15"));
			project.setEndDate(sdf.parse("2018-05-25"));
			project.setValid(1);
			project.setNote("沙滩派对");
			project.setModifiedUser("DMETAL");
			int rows=projectdao.updateObject(project);
			Assert.assertEquals(1, rows);
			
		}
		
		
}
