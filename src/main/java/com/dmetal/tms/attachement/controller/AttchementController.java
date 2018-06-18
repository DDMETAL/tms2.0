package com.dmetal.tms.attachement.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dmetal.tms.attachement.entity.Attachement;
import com.dmetal.tms.attachement.service.AttachementService;
import com.dmetal.tms.common.web.JsonResult;

@Controller
@RequestMapping("/attachement/")
public class AttchementController {
	@Resource
	private AttachementService attachementService;
	
	@RequestMapping("uploadUI")
	public String uploadUI() {
		return "attachement/attachement";
	}
	@RequestMapping("saveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			String title,
			Integer athBelong,
			Integer belongId,
			MultipartFile mFile,//<input type="file" name="mFile">
			HttpServletRequest request) {
		String realPath=request.getServletContext().getRealPath("/");
		attachementService.saveObject(title, athBelong, belongId, mFile,realPath);
		return new JsonResult();
	}
	@RequestMapping("findObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		List<Attachement> list=attachementService.findObjects();
		return new JsonResult(list);
	}
	@RequestMapping("downLoad")
	@ResponseBody
	public byte[] doDownload(Integer id,
		HttpServletResponse response)throws IOException{
		File file=
		attachementService.findObjectById(id);
		//设置响应消息头(下载时的固定写法)
		response.setContentType(
		"appliction/octet-stream");
		response.setHeader(
		"Content-disposition",
		"attachment;filename="+file.getName());
		//根据文件真实路径构建一个Path对象　
		Path path=Paths.get(file.getPath());
		//将文件的字节返回(spring mvc 会自动将这字节写入到文件)
        return Files.readAllBytes(path);
		//return file;
	}
	
}
