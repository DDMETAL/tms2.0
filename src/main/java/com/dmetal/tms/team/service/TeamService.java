package com.dmetal.tms.team.service;

import java.util.List;
import java.util.Map;

import com.dmetal.tms.team.entity.Team;

public interface TeamService {
	/**执行分页查询，参数来自TeamController
	 * @param projectName 根据项目名称执行查询操作
	 * @param valid 根据禁用启用执行查询操作
	 * @param pageCurrent 表示当前页(要查询的第几页)*/
	Map<String,Object> findPageObjects(String projectName,Integer valid,Integer pageCurrent);
	
	/**添加表单team信息*/
	void saveObject(Team team);
	/**查询项目的id和名字*/
	List<Map<String,Object>> findProjectIdAndName();
}
