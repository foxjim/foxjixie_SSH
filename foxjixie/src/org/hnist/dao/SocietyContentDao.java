package org.hnist.dao;

import java.util.List;

import org.hnist.modul.SocietyContent;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SocietyContentDao extends HibernateDaoSupport{
	
	public void saveSocietyContent(SocietyContent sc){
		this.getHibernateTemplate().save(sc);
	}
	
	public void updateSocietyContent(SocietyContent sc){
		this.getHibernateTemplate().update(sc);
	}
	
	public SocietyContent getById(Integer scid){
		return (SocietyContent)this.getHibernateTemplate().load(SocietyContent.class, scid);
	}

	public void deleteSocietyContent(Integer scid){
		this.getHibernateTemplate().delete(this.getById(scid));
	}
	
	/**
	 * 查找所有的资源类型
	 * @return
	 */
	public List<String> findContentClass(){
		return (List<String>)this.getHibernateTemplate().find("select contentClass from SocietyContent group by contentClass  ");
	}
	
	/**
	 * 通过资源类型查找资源
	 * @param contentClass
	 * @return
	 */
	public List<SocietyContent> findByContentClass(String contentClass){
		return (List<SocietyContent>)this.getHibernateTemplate().find("from SocietyContent where contentClass=?",contentClass);
	}
	
	/**
	 * 通过id查找序号
	 * @param scid
	 * @return
	 */
	public List<SocietyContent> findByScid(Integer scid){
		return (List<SocietyContent>)this.getHibernateTemplate().find("from SocietyContent where scid=?",scid);
	}
	
	
	/**
	 * 查找所有的资源
	 * @return
	 */
	public List<SocietyContent> findAllSocietyContent(){
		return (List<SocietyContent>)this.getHibernateTemplate().find("from SocietyContent order by id");
	}
}
