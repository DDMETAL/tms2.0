package com.dmetal.tms.product.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductType implements Serializable{
	private static final long serialVersionUID = -5349624623135016433L;
	
	/**分类id*/
	private Integer id;
	/**分类名称*/
	private String name;
	/**序号*/
	private Integer sort;
	/**备注*/
	private String note;
	/**上一级分类id*/
	private Integer parentId;
	/**分类创建时间*/
	private Date createdTime;
	/**分类修改时间*/
	private Date modifiedTime;
	/**分类创建人*/
	private String createdUser;
	/**分类修改人*/
	private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", sort=" + sort + ", note=" + note + ", parentId="
				+ parentId + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + "]";
	}

	
}
