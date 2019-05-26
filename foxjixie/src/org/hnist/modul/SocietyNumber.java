package org.hnist.modul;

/**
 * 社团成员的实体
 * @author HELLO WORLD
 *		用于数据库的存储
 */

public class SocietyNumber {
	
	private Integer snId;			//序号
	private String societyTerm;		//任届
	private String department;		//部门	
	private String oldMember;		//部长
	private String youngerMember;	//副部长
	
	public Integer getSnId() {
		return snId;
	}
	public void setSnId(Integer snId) {
		this.snId = snId;
	}
	public String getSocietyTerm() {
		return societyTerm;
	}
	public void setSocietyTerm(String societyTerm) {
		this.societyTerm = societyTerm;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOldMember() {
		return oldMember;
	}
	public void setOldMember(String oldMember) {
		this.oldMember = oldMember;
	}
	public String getYoungerMember() {
		return youngerMember;
	}
	public void setYoungerMember(String youngerMember) {
		this.youngerMember = youngerMember;
	}
	
	
	

	

}
