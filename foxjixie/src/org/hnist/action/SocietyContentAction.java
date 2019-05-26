package org.hnist.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.SocietyContent;
import org.hnist.modul.SocietyContentList;
import org.hnist.service.SocietyContentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SocietyContentAction extends ActionSupport implements ModelDriven<SocietyContent>{

	private SocietyContent societyContent=new SocietyContent();
	
	public SocietyContent getModel() {
		// TODO Auto-generated method stub
		return societyContent;
	}
	
	public SocietyContent getSocietyContent() {
		return societyContent;
	}

	public void setSocietyContent(SocietyContent societyContent) {
		this.societyContent = societyContent;
	}

	
	@Autowired
	private SocietyContentService societyContentService;


	public SocietyContentService getSocietyContentService() {
		return societyContentService;
	}
	
	@Resource
	public void setSocietyContentService(SocietyContentService societyContentService) {
		this.societyContentService = societyContentService;
	}
	
	//存储根据分类存储社团资源的实体
	private List<SocietyContentList> sclists;
	private List<SocietyContent> sclist;
	
	
	public List<SocietyContentList> getSclists() {
		return sclists;
	}

	public void setSclists(List<SocietyContentList> sclists) {
		this.sclists = sclists;
	}
	
	/**
	 * 插入社团资源
	 * @return
	 */
	public String insertSocietyContent(){
		if(societyContentService.insertSocietyContent(societyContent)){
			this.querySocietyContent();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 *	查找所有的社团资源
	 * @return
	 */
	public String querySocietyContent(){
		List<SocietyContentList> listsc=new ArrayList<SocietyContentList>();
		List<String> contentTerm=societyContentService.findAllContentClass();
		SocietyContentList scs;
		
		
		if(contentTerm.isEmpty()){
			sclists=null;
			return SUCCESS;
		}else{
			
			for(int i=0;i<contentTerm.size();i++){
				sclist=societyContentService.findAllByContentClass(contentTerm.get(i));
				scs=new SocietyContentList();
				scs.setContentTerm(contentTerm.get(i));
				scs.setSclist(sclist);
				
				listsc.add(scs);
			}
			
			sclists=listsc;
			
			
			return SUCCESS;
		}
		
		
		
	
	}
	
	/**
	 * 删除社团资源
	 * @return
	 */
	public String deleteSocietyContent(){
		Integer sid=Integer.valueOf(this.getParam("sid"));
		if(societyContentService.deleteSocietyContent(sid)){
			this.querySocietyContent();
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	/**
	 * 编辑信息
	 * @return
	 */
	public String editSocietyContent(){
		Integer temp=Integer.valueOf(this.getParam("temp"));
		
		/**
		 * temp=0 显示所需要修改的数据
		 * temp=1 提交修改
		 */
		
		if(temp==0){
			Integer scid=Integer.valueOf(this.getParam("sid"));
			societyContent=societyContentService.findByScid(scid);
			return "edit";
		}else if(temp==1){
			if(societyContentService.updateSocietyContent(societyContent)){
				this.querySocietyContent();
				return SUCCESS;
			}else{
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
