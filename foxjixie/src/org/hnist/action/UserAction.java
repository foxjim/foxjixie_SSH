package org.hnist.action;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hnist.modul.User;
import org.hnist.modul.pageUser;
import org.hnist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user=new User();

	//模型驱动需要写的类
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	//userService 对象用来获取Sercvice方法
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//用于存储users对象
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	//账号，当登陆成功时用于传递给jsp界面
	private String userCount;
	
	public String getUserCount() {
		return userCount;
	}

	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	
	private String currentPage;                  //前端传来的当前页码
	pageUser puser=new pageUser();		
	


	public pageUser getPuser() {
		return puser;
	}

	public void setPuser(pageUser puser) {
		this.puser = puser;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	//Excel文件存储
	private File excelFile01;
	
	
	public File getExcelFile01() {
		return excelFile01;
	}

	public void setExcelFile01(File excelFile01) {
		this.excelFile01 = excelFile01;
	}

	// 登陆失败的信息
	private String loginError;

	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}
	
	/**
	 * 账号登陆
	 * @return
	 * 		SUCCESS:  return userCount 
	 * 		ERROR:	  return ERRORMESSAGE
	 * 
	 */
	public String loginUser(){
		if(userService.existUser(user.getUserCount(), user.getUserPassword())){
			userCount=user.getUserCount();
			return SUCCESS;
		}else{
			loginError="账号不存在或密码错误！请您重新登陆";
			return ERROR;
		}
	}
	
	/**
	 * 注册的方法
	 * @return
	 */
	public String registerUser(){
		String zz=userService.insertUser(user);
		if(zz.equals("01")){
			loginError="学号已被注册！！";
			return ERROR;
		}else if(zz.equals("02")){
			loginError="账号已被注册！！";
			return ERROR;
		}else if(zz.equals("03")){
				loginError="电话号码已被注册！！";
				return ERROR;
		}else{
			userCount=user.getUserCount();
			return SUCCESS;
			
		}
	}
	
	/**
	 * 更改新密码
	 * @return
	 * temp=0 验证User是否存在
	 * temp=1 修改并保存新密码
	 * 
	 */
	public String findNewPassword(){
		Integer temp=Integer.parseInt(getParam("temp"));
		System.out.println("userDao"+user.getUserCount()+temp);
		if(temp==0){
			if(userService.existFindUser(user.getTelPhone(), user.getUserName())){
				userCount=String.valueOf(userService.findCountByUser(user.getTelPhone(), user.getUserName()));
//				System.out.println(userCount+"*********************");
//				System.out.println("temp=0");
				loginError=userService.findCountByUser(user.getTelPhone(), user.getUserName());
				return "existUser";
			}else{
				loginError="姓名或电话号码错误";
				return "unknowUser";
				
			}
		}else if(temp==1){
			if(userService.saveUserPassword(user.getUserCount(), user.getUserPassword())){
//				System.out.println("temp=1");
				return "saveSUCCESS";
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找所有的会员
	 * @return
	 */
	public String queryAllUser(){
		
		if(currentPage==null){
			currentPage="1";
		}
		pageUser pu=new pageUser();
				 
		users=userService.queryAllUser();
		
		
		pu.setUlist(users);
		pu.setEachPage(5);
		pu.setCurrentPage(Integer.valueOf(currentPage));
		pu.initPageUser();
		
		//重新设置当前页（init函数会将currentPage进行处理）
		currentPage=String.valueOf(pu.getCurrentPage());
		
		puser=pu;
		
		
		return SUCCESS;
	}
	
	/**
	 * 删除会员
	 * @return
	 */
	public String deleteUser(){
		Integer uid=Integer.valueOf(this.getParam("id"));
		userService.deleteUser(uid);
		this.queryAllUser();
		return SUCCESS;
	}
	
	/**
	 * 编辑会员信息
	 * @return
	 */
	public String editUser(){
		Integer temp=Integer.valueOf(this.getParam("temp"));
		
		/**
		 * temp=0 根据id查找会员
		 * temp=1 进行编辑
		 * 
		 */
		
		if(temp==0){
			Integer id=Integer.valueOf(this.getParam("id"));
			user=userService.findUserByid(id);
			return "edit";
		}else if(temp==1){
			if(userService.updateUser(user)){
				this.queryAllUser();
				return SUCCESS;
			}else{
				loginError="账号已存在！请确保学号或用户名或电话号码未被注册";
				return ERROR;
			}
			
		}else{
			
			loginError="系统未知错误 请联系管理员进行调试";
			return ERROR;
		}
	}
	//获取页面返回数据的参数
	protected String getParam(String key){
		//System.out.print(ServletActionContext.getRequest().getParameter(key));
		return ServletActionContext.getRequest().getParameter(key);
	}
	
	/**
	 * 通过文件导入
	 * @return
	 * @throws Exception
	 */
	public String InsertByExcel() throws IOException{
		Integer temp=Integer.valueOf(this.getParam("temp"));
		System.out.println("zz00");
		//本地保存的绝对地址
		String path="G:\\Myeclips-workspace\\apache-tomcat-8.5.12\\webapps\\foxjixie\\public\\excelfile\\";
		//云服务器地址
		//String path="C:\\Tomcat 8.0\\webapps\\foxjixie\\public\\excelfile\\";
		//初始化文件路径
		File file=new File(path);
		
		//如若不存在则创建一个地址
		if(!file.exists()){
			file.mkdir();
		}
		
		//获取当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String excelName=sdf.format(date);
		String fileName;
		
		
		System.out.println("zz01");
		
		if(temp==1){
			
			
			//将文件夹保存到当前文件夹下面
			FileUtils.copyFile(excelFile01, new File(file,excelName+".xls"));
			fileName=excelName+".xls";
			userService.saveUserByexcel(path+fileName, temp);
			
		}
		if(temp==2){
			//将文件夹保存到当前文件夹下面
			FileUtils.copyFile(excelFile01, new File(file,excelName+".xlsx"));
			fileName=excelName+".xlsx";
			userService.saveUserByexcel(path+fileName, temp);
			
		}
		return SUCCESS;
		
	}
	
	//保存excelPath文件的路径
	private String excelPath;
	
	

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	/**
	 * 获取数据库导出数据(.xlsx)
	 * @return
	 */
	public String getUserExcel(){
		String path=userService.exportUserExcel();
		excelPath=path.substring(path.indexOf("public"));
		//System.out.println("path:"+excelPath);
		if(excelPath!=null){
			return SUCCESS;
		}else{
			return SUCCESS;
		}
		
	}
}
