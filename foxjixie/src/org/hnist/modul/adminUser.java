package org.hnist.modul;
/**
 * 管理员登陆的实体
 * @author HELLO WORLD
 *
 */

public class adminUser {
	
	private Integer aduid;			//序号
	private String adName;			//姓名
	private String adPassword;		//密码
	private String adDepartment;	//部门
	private String adPosition;		//职位
	private String adPhoneNumber;	//电话号码
	
	
	public Integer getAduid() {
		return aduid;
	}
	public void setAduid(Integer aduid) {
		this.aduid = aduid;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	public String getAdDepartment() {
		return adDepartment;
	}
	public void setAdDepartment(String adDepartment) {
		this.adDepartment = adDepartment;
	}
	public String getAdPosition() {
		return adPosition;
	}
	public void setAdPosition(String adPosition) {
		this.adPosition = adPosition;
	}
	public String getAdPhoneNumber() {
		return adPhoneNumber;
	}
	public void setAdPhoneNumber(String adPhoneNumber) {
		this.adPhoneNumber = adPhoneNumber;
	}
	
	

}
