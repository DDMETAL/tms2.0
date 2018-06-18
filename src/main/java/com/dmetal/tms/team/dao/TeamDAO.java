package com.dmetal.tms.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dmetal.tms.common.dao.BaseDAO;
import com.dmetal.tms.team.entity.Team;

public interface TeamDAO extends BaseDAO<Team>{
	/**向表中写入数据*/
	//int insertObject(Team team);
	/**查询数据
	 * 一条数据对应一个Map
	 * 多条记录是多个map对象，然后多个map放到list集合 
	 */
	List<Map<String,Object>> findPageObjects(
						@Param("projectName")String projectName,
						@Param("valid")Integer valid,
						@Param("pageIndex")int pageIndex,
						@Param("pageSize")int pageSize);
	/**统计有多少条记录*/
	int getRowCount(
			@Param("projectName")String projectName,
			@Param("valid")Integer valid);
}
