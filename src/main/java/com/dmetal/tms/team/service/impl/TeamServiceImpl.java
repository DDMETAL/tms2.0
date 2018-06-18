package com.dmetal.tms.team.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmetal.tms.common.exception.SaveRuntimeException;
import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.dao.ProjectDAO;
import com.dmetal.tms.team.dao.TeamDAO;
import com.dmetal.tms.team.entity.Team;
import com.dmetal.tms.team.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	@Resource
	private TeamDAO teamdao;
	@Resource
	private ProjectDAO projectdao;
	@Override
	public Map<String, Object> findPageObjects(String projectName, Integer valid, Integer pageCurrent) {
		PageObject pageObject=new PageObject();
		//pageObject.setPageSize(3);不写默认是3，在PageObject中已定义
		pageObject.setPageCurrent(pageCurrent);
		//根据pageIndex及参数获得当前页数据
		List<Map<String,Object>> list=teamdao.findPageObjects(projectName, valid, pageObject.getPageIndex(), pageObject.getPageSize());
		//获得总页数
		int rowCount=teamdao.getRowCount(projectName, valid);
		pageObject.setRowCount(rowCount);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);

		return map;
	}
	@Override
	public void saveObject(Team team) {
		if(team==null) {
			throw new SaveRuntimeException("保存信息不能为空");
		}
		int rows=teamdao.insertObject(team);
		if(rows==-1) {
			throw new SaveRuntimeException("保存失败");
		}
	}
	@Override
	public List<Map<String, Object>> findProjectIdAndName() {
		return projectdao.findIdAndName();
		
	}

}
