package project.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.team.dao.TeamDAO;
import com.dmetal.tms.team.entity.Team;

import common.dao.TestBaseDAO;

public class TestTeamDAO extends TestBaseDAO {

	 @Test
	 public void testInsertObject() {
		 TeamDAO teamdao=(TeamDAO)ac.getBean("teamDAO");
		 Team team=new Team();
		 team.setName("西安名胜古迹十日团");
		 team.setProjectId(13);
		 team.setValid(1);
		 team.setNote("十日团");
		 team.setCreatedTime(new Date());
		 team.setModifiedTime(new Date());
		 team.setCreatedUser("DMETAL");
		 team.setModifiedUser("DMETAL");
		 int rows=teamdao.insertObject(team);
		 Assert.assertEquals(1, rows); 
	 }
	 
	 @Test
	 public void testfindPageObjects() {
		 TeamDAO teamdao=(TeamDAO)ac.getBean("teamDAO");
		 String projectName="沙滩";
		 Integer valid=1;
		 int pageIndex=0;
		 int pageSize=3;
		 List<Map<String,Object>> teams=teamdao.findPageObjects(projectName,valid,pageIndex,pageSize);
		 System.out.println(teams);
		 Assert.assertNotEquals(null, teams);
		 System.out.println(teams.size());
		 
		 //根据条件获得记录数，然后计算总页数
		 int rowCount=teamdao.getRowCount(projectName, valid);
		 PageObject pageObject=new PageObject();
		 pageObject.setPageSize(pageSize);
		 pageObject.setRowCount(rowCount);
		 Assert.assertEquals(1, pageObject.getPageCount());
		 System.out.println(pageObject.getPageCount());
	 }
	 
}
