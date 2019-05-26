package org.hnist.modul;


import java.util.List;

/**
 * 对协会资源进行分类显示的实体类
 * @author HELLO WORLD
 *
 */

public class SocietyContentList {
	
	private String contentTerm;
	private List<SocietyContent> sclist;
	
	
	public String getContentTerm() {
		return contentTerm;
	}
	public void setContentTerm(String contentTerm) {
		this.contentTerm = contentTerm;
	}
	public List<SocietyContent> getSclist() {
		return sclist;
	}
	public void setSclist(List<SocietyContent> sclist) {
		this.sclist = sclist;
	}
	
	
	

}
