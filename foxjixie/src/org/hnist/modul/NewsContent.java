package org.hnist.modul;
/**
 * 新闻内容的实体_数据库存储
 * @author HELLO WORLD
 *
 */

public class NewsContent {
	
	private Integer ncid;				//序号
	private Integer nhid;				//所属新闻序号
	private String ncContent;			//内容
	
	
	public Integer getNcid() {
		return ncid;
	}
	public void setNcid(Integer ncid) {
		this.ncid = ncid;
	}
	public Integer getNhid() {
		return nhid;
	}
	public void setNhid(Integer nhid) {
		this.nhid = nhid;
	}
	public String getNcContent() {
		return ncContent;
	}
	public void setNcContent(String ncContent) {
		this.ncContent = ncContent;
	}
	
	

}
