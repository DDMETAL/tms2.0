package com.dmetal.tms.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dmetal.tms.common.exception.SaveRuntimeException;
import com.dmetal.tms.common.exception.UpdateRuntimeException;
import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.dao.ProjectDAO;
import com.dmetal.tms.project.entity.Project;
import com.dmetal.tms.project.service.ProjectService;

/**
 * 项目中所有与业务有关的事情一般都要放在service中
 * 例如：判定参数是否符合业务要求
 * 		 判断dao返回的数据是否是需要的结果
 * 		 执行日志记录/事务处理
 * 		 .....
 * @author NiCo
 *
 */
@Service
@Transactional //此注解写在类上表示类中所有方法都执行事务
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectDAO projectdao;
	
	/**获得多条项目信息*/
	@Transactional(readOnly=true,isolation=Isolation.READ_COMMITTED )
	@Override
	public List<Project> findObjects() {
		//...
		return projectdao.findObjects();
	}
	
	/**
	 * @param pageObject 用于接收控制层传递过来的分页信息
	 * 此参数中包含有pageIndex,pageSize
	 */
	@Cacheable(value="projectCache",key="#project.name")//此处由于key会改变,若要缓存则给定key
	@Override
	public Map<String, Object> findPageObjects(Project project,PageObject pageObject) {
		
		//1.获取页面表格重要显示的数据
		List<Project> projects=projectdao.findPageObjects(project,pageObject);
		//2.获取记录总数并计算页数
		int rowCount=projectdao.getRowCount(project);
		pageObject.setRowCount(rowCount);
		//3.构建map对象封装从dao层获得的数据
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("list", projects);//记录信息
		map.put("pageObject", pageObject);//分页数据
		return map;
	}
	
	@Transactional(rollbackFor={UpdateRuntimeException.class})
	@Override
	public void validById(String checkedIdes, Integer valid) {
		//判定参数
		if(checkedIdes==null||checkedIdes.length()==0) {
			throw new NullPointerException("必须有选中的id值");
		}
		if(valid!=1&&valid!=0) {
			throw new IllegalArgumentException("无效的valid值");
		}
		//解析字符串(1,2,3,4)
		String ides[]=checkedIdes.split(",");
		
		//访问dao层方法执行启用禁用的更新操作
		int rows=projectdao.validById(ides,valid);
		if(rows==-1) {
			throw new RuntimeException("更新失败");
		}
	}
	
	@Override
	public void saveObject(Project project) {
		int rows=projectdao.insertObject(project);
		if(rows==-1) {
			throw new SaveRuntimeException("save error");
		}
		
	}
	
	@Cacheable(value="projectCache",key="#id")//默认key为方法签名
	@Override
	public Project findObjectById(Integer id) {
		System.out.println("findObjectById");
		if(id==null) {
			throw new NullPointerException("id can not be null");
		}
		Project project=projectdao.findObjectById(id);
		if(project==null) {
			throw new RuntimeException("project does not exists");
		}
		return project;
	}
	@CacheEvict(value="projectCache",key="#project.id")
	@Override
	public void updateObjectById(Project project) {
		int rows=projectdao.updateObject(project);
		if(rows==-1) {
			throw new UpdateRuntimeException("update error");
		}
		
	}
	
}
