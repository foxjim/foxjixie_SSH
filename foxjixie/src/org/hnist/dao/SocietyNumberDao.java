package org.hnist.dao;

import java.util.List;

import org.hnist.modul.ContactInformation;
import org.hnist.modul.Devhistory;
import org.hnist.modul.SocietyNumber;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SocietyNumberDao extends HibernateDaoSupport{

	public void saveSocietyNumber(SocietyNumber sn){
		this.getHibernateTemplate().save(sn);
	}
	
	public SocietyNumber getByid(Integer snid){
		return (SocietyNumber)this.getHibernateTemplate().load(SocietyNumber.class, snid);
	}
		
	
	public void deleteSocietyNumber(Integer snid){
		SocietyNumber sn=this.getByid(snid);
		this.getHibernateTemplate().delete(sn);
	}
	
	public void updateSocietyNumber(SocietyNumber sn){
		this.getHibernateTemplate().update(sn);
	}
	
	/**
	 * 查找所有的任届
	 * @return
	 */
	public List<String> findTermYears(){
		return (List<String>)this.getHibernateTemplate().find("select societyTerm from SocietyNumber group by societyTerm ");
	}
	
	/**
	 * 通过序号查找对象
	 * @param snid
	 * @return
	 */
	public List<SocietyNumber> findBySnid(Integer snid){
		return (List<SocietyNumber>)this.getHibernateTemplate().find("from SocietyNumber where snId=?",snid);
	}
	
	/**
	 * 根据任届查找所有的对象
	 * @param societyTerm
	 * @return
	 */
	public List<SocietyNumber> findBySocietyTerm(String societyTerm){
		return (List<SocietyNumber>)this.getHibernateTemplate().find("from SocietyNumber where societyTerm=?",societyTerm);
	}
	
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<SocietyNumber> findAllSocietyNumber(){
		return (List<SocietyNumber>)this.getHibernateTemplate().find("from SocietyNumber order by id");
	}
	
	/*****************************************************
	 * 
	 * 此处之后为关于社团的信息，不另外起action进行代码编辑
	 * 
	 ****************************************************/
	
	/**
	 * 查找所有的发展历史
	 * @return
	 */
	public List<Devhistory> findAllDevhistory(){
		return (List<Devhistory>)this.getHibernateTemplate().find("from Devhistory order by id");
	}
	
	/**
	 * 查找所有的联系方法
	 * @return
	 */
	public List<ContactInformation> findAllContactInformation(){
		return (List<ContactInformation>)this.getHibernateTemplate().find("from ContactInformation order by id");
	}
	
}
