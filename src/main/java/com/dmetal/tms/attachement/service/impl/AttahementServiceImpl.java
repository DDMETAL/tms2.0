package com.dmetal.tms.attachement.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dmetal.tms.attachement.dao.AttachementDAO;
import com.dmetal.tms.attachement.entity.Attachement;
import com.dmetal.tms.attachement.service.AttachementService;

@Service
public class AttahementServiceImpl implements AttachementService{
	
	@Resource
	private AttachementDAO attachementDAO;
	@Override
	public void saveObject(String title, Integer athBelong, Integer belongId, MultipartFile mFile,String serverPath) {
		//上传文件
		String oFileName=mFile.getOriginalFilename();//获得文件名
		System.out.println("oFileName="+oFileName);
		byte[] fileBytes;
		File dest;//目标文件(上传后存储的文件)
		String fileDisgest;
		try {
			fileBytes=mFile.getBytes();//获得文件字节
			fileDisgest=DigestUtils.md5Hex(fileBytes);//生成摘要信息
			//根据文件摘要判定文件是否存在
			int count=attachementDAO.findObjectByDisgest(fileDisgest);
			if(count>0) {
				throw new RuntimeException("文件已存在");
			}
			//执行上传动作
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			String dateStr=sdf.format(new Date());
			String newFileName=UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(oFileName);//获取文件扩展名
			String realPath=serverPath+"/uploads/"+dateStr+"/"+newFileName;
			dest=new File(realPath);
			File parent=dest.getParentFile();
			if(!parent.exists()) {
				parent.mkdirs();
			}
			mFile.transferTo(dest);//上传
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("upload error");
		}
		
		//保存文件信息到数据库
		Attachement t=new Attachement();
		t.setTitle(title);
		t.setFileName(oFileName);
		t.setFilePath(dest.getPath());
		t.setAthBelong(athBelong);
		t.setBelongId(belongId);
		t.setContentType(mFile.getContentType());
		t.setFileDisgest(fileDisgest);
		t.setCreatedUser("DMETAL");
		t.setModifiedUser("DMETAL");
		attachementDAO.insertObject(t);
		
		
		
	}
	@Override
	public List<Attachement> findObjects() {
		
		return attachementDAO.findObjects();
	}
	@Override
	public File findObjectById(Integer id) {
		//根据id查找记录
		if(id==null)throw new RuntimeException("id can not be null");
		Attachement a=attachementDAO.findObjectById(id);
		if(a==null)throw new RuntimeException("数据库中没有对应记录");
		//获得文件的真实路径，构建文件对象关联真实路径
		File file=new File(a.getFilePath());
		//检测我呢见是否存在，存在则下载
		if(!file.exists())throw new RuntimeException("文件已不存在");
		return file;
	}

}
