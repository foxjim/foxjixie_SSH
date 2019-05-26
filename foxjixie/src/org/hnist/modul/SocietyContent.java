package org.hnist.modul;

/**
 * 社团资源的实体
 * @author HELLO WORLD
 *
 */

public class SocietyContent {
	
	private Integer scid;						//资源序号
	private String contentClass;				//资源类型
	private String contentName;					//资源名称
	private String contentLink;					//百度网盘链接
	private String contentPassword;				//链接密码
	
	
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public String getContentClass() {
		return contentClass;
	}
	public void setContentClass(String contentClass) {
		this.contentClass = contentClass;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentLink() {
		return contentLink;
	}
	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}
	public String getContentPassword() {
		return contentPassword;
	}
	public void setContentPassword(String contentPassword) {
		this.contentPassword = contentPassword;
	}
	
	
	

}
