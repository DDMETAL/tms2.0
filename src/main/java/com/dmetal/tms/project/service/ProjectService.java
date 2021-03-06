package com.dmetal.tms.project.service;

import java.util.List;
import java.util.Map;

import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.entity.Project;

public interface ProjectService {
	List<Project> findObjects();
	
	/**返回分页记录
	 * 1.记录信息
	 * 2.分页信息
	 * */
	Map<String,Object> findPageObjects(Project project,PageObject pageObject);
	/**
	 * 启用禁用记录
	 * @param checkedIdes
	 * @param valid
	 */
	void validById(String checkedIdes,Integer valid);
	
	/**添加project对象*/
	void saveObject(Project project);
	
	/**根据id查找project对象*/
	Project findObjectById(Integer id);
	/**修改项目信息*/
	void updateObjectById(Project project);
}
