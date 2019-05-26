package org.hnist.modul;
/**
 * 新闻标题的实体
 * @author HELLO WORLD
 *
 */

public class NewsHead {
	
	private Integer nhid;			//序号
	private String nhClass;			//类型
	private String nhTitle;			//标题
	private String nhTime;			//时间
	private String nhPerson;		//发布人
	
	private String otherLink;		//其他链接
	private String onlionLink;		//内部链接
	private String userLink;		//使用链接
	
	public Integer getNhid() {
		return nhid;
	}
	public void setNhid(Integer nhid) {
		this.nhid = nhid;
	}
	public String getNhClass() {
		return nhClass;
	}
	public void setNhClass(String nhClass) {
		this.nhClass = nhClass;
	}
	public String getNhTitle() {
		return nhTitle;
	}
	public void setNhTitle(String nhTitle) {
		this.nhTitle = nhTitle;
	}
	public String getNhTime() {
		return nhTime;
	}
	public void setNhTime(String nhTime) {
		this.nhTime = nhTime;
	}
	public String getNhPerson() {
		return nhPerson;
	}
	public void setNhPerson(String nhPerson) {
		this.nhPerson = nhPerson;
	}
	public String getOtherLink() {
		return otherLink;
	}
	public void setOtherLink(String otherLink) {
		this.otherLink = otherLink;
	}
	public String getOnlionLink() {
		return onlionLink;
	}
	public void setOnlionLink(String onlionLink) {
		this.onlionLink = onlionLink;
	}
	public String getUserLink() {
		return userLink;
	}
	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}
	
	
	
	
	
}
