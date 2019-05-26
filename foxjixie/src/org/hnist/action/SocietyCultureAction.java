package org.hnist.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.SocietyCulture;
import org.hnist.modul.SocietyCultureList;
import org.hnist.service.SocietyCultureService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SocietyCultureAction extends ActionSupport implements ModelDriven<SocietyCulture> {

	private SocietyCulture societyCulture=new SocietyCulture();
	
	public SocietyCulture getModel() {
		// TODO Auto-generated method stub
		return societyCulture;
	}

	public SocietyCulture getSocietyCulture() {
		return societyCulture;
	}

	public void setSocietyCulture(SocietyCulture societyCulture) {
		this.societyCulture = societyCulture;
	}
	
	@Autowired
	private SocietyCultureService societyCultureService;
	
	public SocietyCultureService getSocietyCultureService() {
		return societyCultureService;
	}
	
	@Resource
	public void setSocietyCultureService(SocietyCultureService societyCultureService) {
		this.societyCultureService = societyCultureService;
	}

	
	
	private List<SocietyCultureList> scllist;


	public List<SocietyCultureList> getScllist() {
		return scllist;
	}

	public void setScllist(List<SocietyCultureList> scllist) {
		this.scllist = scllist;
	}
	
	/**
	 * 导入新的数据
	 * @return
	 */
	public String insertSocietyCulture(){
		if(societyCultureService.insertSocietyCulture(societyCulture)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public String queryAllSocietyCulture(){
		List<String> slist=societyCultureService.queryAllCultureClass();
		List<SocietyCultureList> listsc=new ArrayList<SocietyCultureList>();
		SocietyCultureList sclistsss;
		for(int i=0;i<slist.size();i++){
			sclistsss=new SocietyCultureList();
			sclistsss.setCultureClass(slist.get(i));
			sclistsss.setCultureClassList(societyCultureService.querySocietyCultureBySC(slist.get(i)));
			
			listsc.add(sclistsss);
			
			
		}
		
		scllist=listsc;
		
		
		return SUCCESS;
	}
	
	/**
	 * 编辑数据的方法
	 * @return
	 */
	public String editSocietyCulture(){
		
		Integer temp=Integer.valueOf(this.getParam("temp"));
		if(temp==0){
			Integer scid=Integer.valueOf(this.getParam("scid"));
			societyCulture=societyCultureService.findSCByScid(scid);
			return "edit";
		}else if(temp==1){
			if(societyCultureService.updateSocietyCulture(societyCulture)){
				this.queryAllSocietyCulture();
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
	public String deleteSocietyCulture(){
		Integer scid=Integer.valueOf(this.getParam("scid"));
		if(societyCultureService.deleteSocietyCulture(scid)){
			this.queryAllSocietyCulture();
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
