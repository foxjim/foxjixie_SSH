package org.hnist.dao;

import java.util.List;

import org.hnist.modul.SocietyCulture;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SocietyCultureDao extends HibernateDaoSupport{
	
	/**
	 * 导入社团文化的dao
	 * @param sc
	 */
	public void saveSocietyCuluture(SocietyCulture sc){
		this.getHibernateTemplate().save(sc);
	}
	
	/**
	 * 更新数据的方法
	 * @param sc
	 */
	public void updateSocietyCulture(SocietyCulture sc){
		this.getHibernateTemplate().update(sc);
	}
	/**
	 * 通过序号查找
	 * @param scid
	 * @return
	 */
	public SocietyCulture getSocietyCulture(Integer scid){
		return this.getHibernateTemplate().load(SocietyCulture.class, scid);
	}
	
	/**
	 * 删除数据的方法
	 * @param scid
	 */
	public void deleteSocietyCulture(Integer scid){
		SocietyCulture sc=this.getSocietyCulture(scid);
		this.getHibernateTemplate().delete(sc);
	}
	
	/**
	 * 通过序号查找数据
	 * @param scid
	 * @return
	 */
	public List<SocietyCulture> findByScid(Integer scid){
		return (List<SocietyCulture>)this.getHibernateTemplate().find("from SocietyCulture where scid=?",scid);
	}
	
	/**
	 * 查找所有的社团文化类型
	 * @return
	 */
	public List<String> findAllCultureClass(){
		return (List<String>)this.getHibernateTemplate().find("select cultureClass from SocietyCulture group by cultureClass");
	}
	
	/**
	 * 通过文化类型查找所有的文化
	 * @param cultureClass
	 * @return
	 */
	public List<SocietyCulture> findByCultureClass(String cultureClass){
		return (List<SocietyCulture>)this.getHibernateTemplate().find("from SocietyCulture where cultureClass=?",cultureClass);
	}
	
	/**
	 * 查找所有的社团文化
	 * @return
	 */
	public List<SocietyCulture> findAllSocietyCulture(){
		return (List<SocietyCulture>)this.getHibernateTemplate().find("from SocietyCulture order by id");
	}
	
	
}
