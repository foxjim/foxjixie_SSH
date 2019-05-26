package org.hnist.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.Devhistory;
import org.hnist.service.DevhistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DevhistoryAction extends ActionSupport implements ModelDriven<Devhistory>{

	private Devhistory devhistory=new Devhistory();

	public Devhistory getModel() {
		// TODO Auto-generated method stub
		return devhistory;
	}

	public Devhistory getDevhistory() {
		return devhistory;
	}

	public void setDevhistory(Devhistory devhistory) {
		this.devhistory = devhistory;
	}
	
	@Autowired
	private DevhistoryService devhistoryService;

	public DevhistoryService getDevhistoryService() {
		return devhistoryService;
	}

	@Resource
	public void setDevhistoryService(DevhistoryService devhistoryService) {
		this.devhistoryService = devhistoryService;
	}
	
	
	private List<Devhistory> devhistorys;

	public List<Devhistory> getDevhistorys() {
		return devhistorys;
	}

	public void setDevhistorys(List<Devhistory> devhistorys) {
		this.devhistorys = devhistorys;
	}
	
	
	
	/**
	 * 保存数据的方法
	 * @return
	 */
	public String saveDevhistory(){
		if(devhistoryService.saveDevhistory(devhistory)){
			devhistorys=devhistoryService.findAllDevhistroy();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public String queryAllDevhistory(){
		devhistorys=devhistoryService.findAllDevhistroy();
		return SUCCESS;
	}
	
	/**
	 * 更新数据的方法
	 * @return
	 */
	public String editDevhistory(){
		Integer temp=Integer.parseInt(getParam("temp"));
		/**
		 * temp==0 显示需要修改的数据
		 * temp==1 修改数据
		 */
		if(temp==0){
			Integer dhid=Integer.parseInt(getParam("id"));
			devhistorys=devhistoryService.findByDhid(dhid);
			return "edit";
		}else if(temp==1){
			if(devhistoryService.updateDevhistory(devhistory)){
				devhistorys=devhistoryService.findAllDevhistroy();
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
		
	}
	
	/**
	 * 删除数据的方法
	 * @return
	 */
	public String deleteDevhistory(){
		Integer id=Integer.parseInt(getParam("param"));
		if(devhistoryService.deleteDevhistory(id)){
			devhistorys=devhistoryService.findAllDevhistroy();
			return SUCCESS;
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
