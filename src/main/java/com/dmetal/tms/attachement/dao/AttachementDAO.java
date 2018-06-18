package com.dmetal.tms.attachement.dao;

import java.util.List;

import com.dmetal.tms.attachement.entity.Attachement;
import com.dmetal.tms.common.dao.BaseDAO;

public interface AttachementDAO extends BaseDAO<Attachement>{
	List<Attachement> findObjects();
	/**根据摘要信息判断文件是否已存在*/
	int findObjectByDisgest(String fileDisgest);
	Attachement findObjectById(Integer id);
}
