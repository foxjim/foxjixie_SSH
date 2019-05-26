package org.hnist.service;

import java.util.List;

import org.hnist.dao.ContactInformationDao;
import org.hnist.modul.ContactInformation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ContactInformationService {
	
	private ContactInformationDao contactInformationDao;

	public void setContactInformationDao(ContactInformationDao contactInformationDao) {
		this.contactInformationDao = contactInformationDao;
	}
	
	/**
	 * 插入数据的方法
	 * @param cif
	 * @return
	 */
	public boolean insertContactInformation(ContactInformation cif){
		List<ContactInformation> ciflist=contactInformationDao.findAllContactInformation();
		cif.setCiId(ciflist.size());
		contactInformationDao.saveContactInformation(cif);
		return true;
	}
	
	public boolean existContactInformation(Integer ciid){
		if(contactInformationDao.findByCiId(ciid).get(0).getCiId()==null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 删除数据的方法
	 * @param ciid
	 * @return
	 */
	public boolean deleteContactInformation(Integer ciid){
		if(this.existContactInformation(ciid)){
			contactInformationDao.deleteContactInformation(ciid);
		}
		
		return true;
	}
	
	/**
	 * 更新数据的方法
	 * @param cif
	 * @return
	 */
	public boolean updateContactInformation(ContactInformation cif){
		contactInformationDao.updateContactInformation(cif);
		return true;
	}
	
	/**
	 * 通过id查找数据
	 * @param ciid
	 * @return
	 */
	public List<ContactInformation> findByCiid(Integer ciid){
		return contactInformationDao.findByCiId(ciid);
		
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<ContactInformation> findAllContactInformat(){
		return contactInformationDao.findAllContactInformation();
	}

}
