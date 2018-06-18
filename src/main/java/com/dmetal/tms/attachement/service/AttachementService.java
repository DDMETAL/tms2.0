package com.dmetal.tms.attachement.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dmetal.tms.attachement.entity.Attachement;

public interface AttachementService {
	
	List<Attachement> findObjects();
	/**
	 * 
	 * @param title 附件标题
	 * @param athType 附件归属类型
	 * @param belongId 附件归属id
	 * @param mFile 上传的文件对象
	 */
	void saveObject(String title,Integer athBelong,Integer belongId,MultipartFile mFile,String serverPath);
	
	File findObjectById(Integer id);
}
