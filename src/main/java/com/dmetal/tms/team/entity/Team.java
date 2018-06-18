package com.dmetal.tms.team.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 实体对象 团(一个项目下可以创建多个团)
 * 对应表名:tms_teams
 * @author NiCo
 *
 */
public class Team implements Serializable{
	private static final long serialVersionUID = -3562787009845021815L;
	/**团id,对应表中的物理主键*/
	private Integer id;
	/**团名称*/
	private String name;
	/**项目id*/
	private Integer projectId;
	/**团的有效性*/
	private Integer valid;
	/**团备注*/
	private String note;
	/**团的创建时间*/
	private Date createdTime;
	/**团的修改时间*/
	private Date modifiedTime;
	/**团信息创建人*/
	private String createdUser;
	/**团信息修改人*/
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
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
		return "Team [id=" + id + ", name=" + name + ", projectId=" + projectId + ", valid=" + valid + ", note=" + note
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + "]";
	}
	
	
}
