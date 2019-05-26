package org.hnist.modul;
/**
 * 社团文化实体
 * @author HELLO WORLD
 *
 */

public class SocietyCulture {
	
	private Integer scid;				//序号	
	private String cultureClass;		//类型
	private String cultureTime;			//时间
	private String cultureContent;		//内容
	private String cultureLink;			//链接
	
	
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public String getCultureClass() {
		return cultureClass;
	}
	public void setCultureClass(String cultureClass) {
		this.cultureClass = cultureClass;
	}
	public String getCultureTime() {
		return cultureTime;
	}
	public void setCultureTime(String cultureTime) {
		this.cultureTime = cultureTime;
	}
	public String getCultureContent() {
		return cultureContent;
	}
	public void setCultureContent(String cultureContent) {
		this.cultureContent = cultureContent;
	}
	public String getCultureLink() {
		return cultureLink;
	}
	public void setCultureLink(String cultureLink) {
		this.cultureLink = cultureLink;
	}
	
	

}
