package com.dmetal.tms.project.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmetal.tms.common.web.JsonResult;
import com.dmetal.tms.common.web.PageObject;
import com.dmetal.tms.project.entity.Project;
import com.dmetal.tms.project.service.ProjectService;

/**
 * 产品项目管理控制器对象
 * @author NiCo
 *
 */
@Controller
@RequestMapping("/project/")
public class ProjectController {
	@Resource
	private ProjectService projectService;
	/**
	 * 此方法用于返回项目管理的列表页面
	 * @return
	 */
	@RequestMapping("listUI")
	public String listUI() {
		return "project/project_list";
	}
	@RequestMapping("editUI")
	public String editUI() {
		return "project/project_edit";
	}

	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Project project,PageObject pageObject){
		Map<String,Object> map=projectService.findPageObjects(project,pageObject);
		return new JsonResult(map);//state=1,message=ok
		
	}
	/**启用禁用*/
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(String checkedIdes,Integer valid) {
		projectService.validById(checkedIdes, valid);
		return new JsonResult();//state=1,message=ok
	}
	/**添加*/
	@RequestMapping("doSaveProject")
	@ResponseBody
	public JsonResult doSaveProject(Project project) {
		projectService.saveObject(project);
		return new JsonResult();//state=1,message=ok
	}
	/**查找项目信息*/
	@RequestMapping("doFindProjectById")
	@ResponseBody
	public JsonResult doFindProjectById(Integer id) {
		Project project=projectService.findObjectById(id);
		return new JsonResult(project);
	}
	
	/**修改项目信息*/
	@RequestMapping("doUpdateProject")
	@ResponseBody
	public JsonResult doUpdateProject(Project project) {
		projectService.updateObjectById(project);
		return new JsonResult();//state=1,message=ok
	}
}
