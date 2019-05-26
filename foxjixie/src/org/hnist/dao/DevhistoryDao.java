package org.hnist.dao;

import java.util.List;

import org.hnist.modul.Devhistory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DevhistoryDao extends HibernateDaoSupport{

	
	/**
	 * 插入对象
	 * @param devhistory
	 */
	public void savaDevhistoryDao(Devhistory devhistory){
		this.getHibernateTemplate().save(devhistory);
		}
	
	/**
	 * 通过id获取Devhistory对象
	 * @param dhid	序号
	 * @return
	 */
	public Devhistory getIid(Integer dhid){
		return (Devhistory)this.getHibernateTemplate().load(Devhistory.class , dhid);
	}
	
	/**
	 * 根据序号删除对象
	 * @param dhid 序号
	 */
	public void deleteDevhistory(Integer dhid){
		Devhistory dh=getIid(dhid);
		this.getHibernateTemplate().delete(dh);
	}
	
	/**
	 * 更新
	 * @param dh
	 */
	public void updateDevhistory(Devhistory dh){
		this.getHibernateTemplate().update(dh);
	}
	
	/**
	 * 通过id查找对象
	 * @param dhid 序号
	 * @return
	 */
	public List<Devhistory> findByHdid(Integer dhid){
		return (List<Devhistory>)this.getHibernateTemplate().find("from Devhistory where dhid=?",dhid);
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<Devhistory> findAllDevhistory(){
		return (List<Devhistory>)this.getHibernateTemplate().find("from Devhistory order by id");
	}
}
