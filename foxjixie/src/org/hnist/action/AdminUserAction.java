package org.hnist.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.adminUser;
import org.hnist.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<adminUser> {

	private adminUser adUser=new adminUser();
	
	public adminUser getModel() {
		// TODO Auto-generated method stub
		return adUser;
	}

	public adminUser getAdUser() {
		return adUser;
	}

	public void setAdUser(adminUser adUser) {
		this.adUser = adUser;
	}
	
	@Autowired
	private AdminUserService adminUserService;
	
	
	public AdminUserService getAdminUserService() {
		return adminUserService;
	}
	@Resource
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	private List<adminUser> adUsers;

	public List<adminUser> getAdUsers() {
		return adUsers;
	}

	public void setAdUsers(List<adminUser> adUsers) {
		this.adUsers = adUsers;
	}
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//登陆状态信息
	String adminloginmessage;
		
	
		
		
	public String getAdminloginmessage() {
		return adminloginmessage;
	}

	public void setAdminloginmessage(String adminloginmessage) {
		this.adminloginmessage = adminloginmessage;
	}

	/**
	 * 注册的方法
	 * @return
	 */
	public String insertAdminUser(){
		if(adminUserService.insertAdminUser(adUser)){
			adminloginmessage="1";
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public String queryAdminUser(){
		adUsers=adminUserService.findAllAdminUser();
		return SUCCESS;
	}
	
	/**
	 * 删除数据的方法
	 * @return
	 */
	public String deleteAdminUser(){
		if(adminUserService.deleteAdminUser(Integer.valueOf(this.getParam("aduid")))){
			this.queryAdminUser();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 登陆的方法
	 * @return
	 */
	public String login(){
		if(adminUserService.loginAdminUser(adUser.getAdName(), adUser.getAdPassword())){
			adminloginmessage="1";
			return SUCCESS;
		}else{
			message="账号或密码错误";
			return ERROR;
		}
	}

	/**
	 * 重置密码
	 * @return
	 */
	public String resetPassword(){
		Integer temp=Integer.valueOf(this.getParam("temp"));
		
		if(temp==0){
			String an=this.getParam("an");
			String apo=this.getParam("apo");
			if(adminUserService.findByNamePNO(an, apo)){
				adUser=adminUserService.findByadName(an);
				return "reset";
			}else{
				message="姓名或联系方式错误";
				return ERROR;
			}
		}else if(temp==1){
			if(adminUserService.updateAdminUser(adUser)){
				adminloginmessage="1";
				return SUCCESS;
			}else{
				message="未知错误";
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	//获取页面返回数据的参数
	protected String getParam(String key){
		//System.out.print(ServletActionContext.getRequest().getParameter(key));
		return ServletActionContext.getRequest().getParameter(key);
	}
}
