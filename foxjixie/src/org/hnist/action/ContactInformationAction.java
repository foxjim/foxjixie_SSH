package org.hnist.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.ContactInformation;
import org.hnist.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 联系我们的action
 * @author HELLO WORLD
 *
 */
public class ContactInformationAction extends ActionSupport implements ModelDriven<ContactInformation>{

	private ContactInformation contactInformation=new ContactInformation();
	
	public ContactInformation getModel() {
		// TODO Auto-generated method stub
		return contactInformation;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	@Autowired
	private ContactInformationService contactInformationService;

	public ContactInformationService getContactInformationService() {
		return contactInformationService;
	}
	@Resource
	public void setContactInformationService(
			ContactInformationService contactInformationService) {
		this.contactInformationService = contactInformationService;
	}
	
	private List<ContactInformation> contactInformations;

	public List<ContactInformation> getContactInformations() {
		return contactInformations;
	}

	public void setContactInformations(List<ContactInformation> contactInformations) {
		this.contactInformations = contactInformations;
	}
	
	
	/**
	 * 保存信息
	 * @return
	 */
	public String insertContactInformation(){
		if(contactInformationService.insertContactInformation(contactInformation)){
			contactInformations=contactInformationService.findAllContactInformat();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 查找所有的信息
	 * @return
	 */
	public String queryAllContactInformation(){
		contactInformations=contactInformationService.findAllContactInformat();
		return SUCCESS;
	}
	
	/**
	 * 更新数据的方法（编辑）
	 * @return
	 */
	public String editContactInformation(){
		Integer temp=Integer.parseInt(getParam("temp"));
		
		/**
		 * temp==0 显示需要修改的数据
		 * temp==1 修改数据
		 */
		if(temp==0){
			Integer ciid=Integer.parseInt(getParam("id"));
			contactInformations=contactInformationService.findByCiid(ciid);
			return "edit";
		}else if(temp==1){
			if(contactInformationService.updateContactInformation(contactInformation)){
				contactInformations=contactInformationService.findAllContactInformat();
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
	public String deleteContactInformation(){
		Integer id=Integer.parseInt(getParam("param"));
		if(contactInformationService.deleteContactInformation(id)){
			contactInformations=contactInformationService.findAllContactInformat();
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
