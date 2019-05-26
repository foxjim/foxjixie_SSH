package org.hnist.modul;
/**
 * 联系我们的实体
 * @author HELLO WORLD
 *		用于管理社团简介中联系我们的实体
 *
 */

public class ContactInformation {
	
	private Integer ciId;			//序号
	private String ciName;			//联系名称
	private String ciContant;		//联系内容
	
	public Integer getCiId() {
		return ciId;
	}
	public void setCiId(Integer ciId) {
		this.ciId = ciId;
	}
	public String getCiName() {
		return ciName;
	}
	public void setCiName(String ciName) {
		this.ciName = ciName;
	}
	public String getCiContant() {
		return ciContant;
	}
	public void setCiContant(String ciContant) {
		this.ciContant = ciContant;
	}
	
	
	
}
