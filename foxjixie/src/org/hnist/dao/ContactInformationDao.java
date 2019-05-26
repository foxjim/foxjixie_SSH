package org.hnist.dao;

import java.util.List;

import org.hnist.modul.ContactInformation;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ContactInformationDao extends HibernateDaoSupport{
	
	public void saveContactInformation(ContactInformation cif){
		this.getHibernateTemplate().save(cif);
	}
	
	public void updateContactInformation(ContactInformation cif){
		this.getHibernateTemplate().update(cif);
	}
	
	public ContactInformation getId(Integer ciid){
		return this.getHibernateTemplate().load(ContactInformation.class, ciid);
	}
	
	public void deleteContactInformation(Integer ciid){
		ContactInformation cif=this.getId(ciid);
		this.getHibernateTemplate().delete(cif);
	}
	
	/**
	 * 通过id查找数据
	 * @param ciid
	 * @return
	 */
	public List<ContactInformation> findByCiId(Integer ciid){
		return (List<ContactInformation>)this.getHibernateTemplate().find("from ContactInformation where ciId=?",ciid);
	}
	
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<ContactInformation> findAllContactInformation(){
		return (List<ContactInformation>)this.getHibernateTemplate().find("from ContactInformation order by id");
	}

}
