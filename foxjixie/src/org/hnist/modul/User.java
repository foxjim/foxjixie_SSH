package org.hnist.modul;

import java.io.File;

public class User {
	
	private Integer userid;			//序号
	private String userNo;			//学号
	private String userCount;		//账号
	private String userName;		//姓名
	private String userPassword;	//密码
	
	private String userCollege;		//学院
	private String telPhone;		//电话号码
	private String email;			//邮箱
	
	
	/**
	 * 原始构造函数
	 */
	public User(){
		
	}
	
	/**
	 * 构造函数 
	 * @param userid
	 * @param userNo
	 * @param userCount
	 * @param userName
	 * @param userPassword
	 * @param userCollege
	 * @param telPhone
	 * @param email
	 * 
	 * 本处主要用于excels表格的批量操作
	 */
	public User(Integer userid,String userNo,String userCount,String userName,String userPassword,String userCollege, String telPhone ,String email){
		this.userid=userid;
		this.userNo=userNo;
		this.userCount=userCount;
		this.userName=userName;
		this.userPassword=userPassword;
		
		this.userCollege=userCollege;
		this.telPhone=telPhone;
		this.email=email;
		
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getUserCollege() {
		return userCollege;
	}
	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
}
