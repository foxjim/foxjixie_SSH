package org.hnist.modul;
/**
 * 社团发展历史的实体类
 * @author HELLO WORLD
 *
 */

public class Devhistory {
	
	private Integer dhid;		//序号
	private String dhTime;		//时间
	private String dhContent;	//内容
	
	
	public Integer getDhid() {
		return dhid;
	}
	public void setDhid(Integer dhid) {
		this.dhid = dhid;
	}
	public String getDhTime() {
		return dhTime;
	}
	public void setDhTime(String dhTime) {
		this.dhTime = dhTime;
	}
	public String getDhContent() {
		return dhContent;
	}
	public void setDhContent(String dhContent) {
		this.dhContent = dhContent;
	}
	

	

}
