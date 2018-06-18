package com.dmetal.tms.team.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmetal.tms.common.web.JsonResult;
import com.dmetal.tms.team.entity.Team;
import com.dmetal.tms.team.service.TeamService;

@Controller
@RequestMapping("/team/")
public class TeamController {
	@Resource
	private TeamService teamService;
	
	@RequestMapping("listUI")
	public String listUI() {
		return "team/team_list";
	}
	@RequestMapping("editUI")
	public String editUI() {
		return "team/team_edit";
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String projectName,Integer valid,Integer pageCurrent){
		Map<String,Object> map=teamService.findPageObjects(projectName, valid, pageCurrent);
		return new JsonResult(map);
		
	}
	
	@RequestMapping("saveObject")
	@ResponseBody
	public JsonResult doSaveObject(Team team) {
		teamService.saveObject(team);
		return new JsonResult();
	}
	
	@RequestMapping("findProjectIdAndName")
	@ResponseBody
	public JsonResult doFindProjectIdAndName() {
		List<Map<String,Object>> map=teamService.findProjectIdAndName();
		return new JsonResult(map);
	}
}
