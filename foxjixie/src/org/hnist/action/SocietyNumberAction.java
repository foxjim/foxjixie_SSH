package org.hnist.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.ContactInformation;
import org.hnist.modul.Devhistory;
import org.hnist.modul.SocietyNumber;
import org.hnist.modul.SocietyNumberTerm;
import org.hnist.service.SocietyNumberService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SocietyNumberAction extends ActionSupport implements ModelDriven<SocietyNumber> {


	private SocietyNumber societyNumber=new SocietyNumber();
	
	public SocietyNumber getModel() {
		// TODO Auto-generated method stub
		return societyNumber;
	}

	public SocietyNumber getSocietyNumber() {
		return societyNumber;
	}

	public void setSocietyNumber(SocietyNumber societyNumber) {
		this.societyNumber = societyNumber;
	}

	@Autowired
	private SocietyNumberService societyNumberService;

	public SocietyNumberService getSocietyNumberService() {
		return societyNumberService;
	}
	
	@Resource
	public void setSocietyNumberService(SocietyNumberService societyNumberService) {
		this.societyNumberService = societyNumberService;
	}
	
	/**
	 * 用于装载所有的SocietyNumber
	 */
	private List<SocietyNumber> societyNumbers;
	
	/**
	 * 根据任届分类装载societyNumber
	 */
	private List<SocietyNumberTerm> societyNumberTerm;

	public List<SocietyNumber> getSocietyNumbers() {
		return societyNumbers;
	}

	public void setSocietyNumbers(List<SocietyNumber> societyNumbers) {
		this.societyNumbers = societyNumbers;
	}

	public List<SocietyNumberTerm> getSocietyNumberTerm() {
		return societyNumberTerm;
	}

	public void setSocietyNumberTerm(List<SocietyNumberTerm> societyNumberTerm) {
		this.societyNumberTerm = societyNumberTerm;
	}
	
	/**
	 * 插入所有的成员
	 * @return
	 */
	public String insertSocietyNumber(){
		if(societyNumberService.insertSocietyNumber(societyNumber)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找历届的社团成员
	 * @return
	 */
	public String queryAllSocietyNumber(){
		List<SocietyNumberTerm> societyNumberTerms =new ArrayList<SocietyNumberTerm>();
		List<String> ls=societyNumberService.findAllSocietyTerm();
		SocietyNumberTerm snt;
		
		if(ls.isEmpty()){
			societyNumberTerm=null;
		}else{
			for(int i=0;i<ls.size();i++){
				
				//从数据库查找数据
				societyNumbers=societyNumberService.findBySocietyTerm(ls.get(i));
				//初始化
				snt=new SocietyNumberTerm();
				//set传值
				snt.setSocietyTerm(ls.get(i));
				//System.out.println("xxxxxxxxxxxxxxxxxx"+snt.getSocietyTerm());
				snt.setSnlist(societyNumbers);
				//System.out.println(snt.getSnlist());
				//添加至list队列
				societyNumberTerms.add(snt);
				
			}	
			
			societyNumberTerm=societyNumberTerms;
		}
		
		return SUCCESS;
		
	}
	
	/**
	 * 编辑社团成员
	 * @return
	 */
	public String editSocietyNumber(){
		Integer temp=Integer.parseInt(this.getParam("temp"));
		/**
		 * 当temp=0时 显示需要更改的东西
		 * 当temp=1时 进行保存修改
		 */
		
		if(temp==0){
			Integer snid=Integer.parseInt(this.getParam("id"));
			societyNumber=societyNumberService.findBySnid(snid);
			return "edit";
		}else if(temp==1){
			if(societyNumberService.updateSocietyNumber(societyNumber)){
				this.queryAllSocietyNumber();
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
		
	}
	
	/**
	 * 根据序号进行删除
	 * @return
	 */
	public String deleteSocietyNumber(){
		Integer snid=Integer.valueOf(this.getParam("id"));
		if(societyNumberService.deleteSocietyNumber(snid)){
			this.queryAllSocietyNumber();
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
	
	
	/*******************************************************
	 * 
	 * 此后功能主要是显示关于社团的所有信息 不另弄action进行
	 * 
	 ******************************************************/
	
	//联系我们的信息
	private List<ContactInformation> contactInformations;

	public List<ContactInformation> getContactInformations() {
		return contactInformations;
	}

	public void setContactInformations(List<ContactInformation> contactInformations) {
		this.contactInformations = contactInformations;
	}
	
	//发展历史的信息
	private List<Devhistory> devhistorys;

	public List<Devhistory> getDevhistorys() {
		return devhistorys;
	}

	public void setDevhistorys(List<Devhistory> devhistorys) {
		this.devhistorys = devhistorys;
	}
	
	/**
	 * 关于我们信息显示
	 * @return
	 */
	public String contactInformation(){
		List<SocietyNumberTerm> societyNumberTerms =new ArrayList<SocietyNumberTerm>();
		List<String> ls=societyNumberService.findAllSocietyTerm();
		SocietyNumberTerm snt;
		
		if(ls.isEmpty()){
			societyNumberTerm=null;
		}else{
			for(int i=0;i<ls.size();i++){
				
				//从数据库查找数据
				societyNumbers=societyNumberService.findBySocietyTerm(ls.get(i));
				//初始化
				snt=new SocietyNumberTerm();
				//set传值
				snt.setSocietyTerm(ls.get(i));
				//System.out.println("xxxxxxxxxxxxxxxxxx"+snt.getSocietyTerm());
				snt.setSnlist(societyNumbers);
				//System.out.println(snt.getSnlist());
				//添加至list队列
				societyNumberTerms.add(snt);
				
			}	
			devhistorys=societyNumberService.findAllDevhistroy();
			contactInformations=societyNumberService.findAllContactInformat();
			societyNumberTerm=societyNumberTerms;
			//倒叙
			Collections.reverse(societyNumberTerm);
			Collections.reverse(devhistorys);
		}
		
		return SUCCESS;
		
	}
}
