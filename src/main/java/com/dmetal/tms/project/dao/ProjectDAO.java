package com.dmetal.tms.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dmetal.tms.common.dao.BaseDAO;
import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.entity.Project;

/**
 * 此接口是一个数据访问对象(关联一个mapper)
 * 所在层:DAL 数据访问层
 * @author NiCo
 *
 */
public interface ProjectDAO extends BaseDAO<Project>{
	/**
	 * 
	 * @param entity 代表一个project对象
	 * @return	表示insert记录的行数
	 */
	//public int insertObject(Project entity);
	
	/** 查询项目信息*/
	public List<Project> findObjects();
	
	/** 分页查询项目信息*/
	public List<Project> findPageObjects(
			@Param("project")Project project,
			@Param("pageObject")PageObject pageObject);
	
	/**获得表中记录总数*/
	public int getRowCount(@Param("project")Project project);
	
	/**
	 * 启用禁用记录数
	 * @param ides
	 * @param valid
	 * @return 表示更新的行数，若返回-1表示更新失败
	 */
	public int validById(@Param("ides")String[] ides,@Param("valid")Integer valid);
	
	/**根据id查找project对象*/
	Project findObjectById(Integer id);
	/**根据id修改project对象*/
	//int updateObject(Project project);
	/**查询项目的id和名字*/
	List<Map<String,Object>> findIdAndName();
	
}
