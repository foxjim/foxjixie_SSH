package org.hnist.dao;

import java.util.List;

import org.hnist.modul.NewsHead;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NewsHeadDao extends HibernateDaoSupport{
	
	public void saveNewsHead(NewsHead nh){
		this.getHibernateTemplate().save(nh);
	}
	
	public void updateNewHead(NewsHead nh){
		this.getHibernateTemplate().update(nh);
	}
	
	public NewsHead getNewsHead(Integer nhid){
		return this.getHibernateTemplate().load(NewsHead.class, nhid);
	}

	public void deleteNewsHead(Integer nhid){
		this.getHibernateTemplate().delete(this.getNewsHead(nhid));
	}
	
	/**
	 * 通过序号查找数据
	 * @param nhid
	 * @return
	 */
	public List<NewsHead> findByNhid(Integer nhid){
		return (List<NewsHead>)this.getHibernateTemplate().find("from NewsHead where nhid=?",nhid);
	}
	
	/**
	 * 通过类型查找数据
	 * @param nhClass
	 * @return
	 */
	public List<NewsHead> findByNhClass(String nhClass){
		return (List<NewsHead>)this.getHibernateTemplate().find("from NewsHead where nhClass=?",nhClass);
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<NewsHead> findAllNewsHead(){
		return (List<NewsHead>)this.getHibernateTemplate().find("from NewsHead order by id");
	}
	
	/**
	 * 查找所有的类型
	 * @return
	 */
	public List<String> findnhClass(){
		return (List<String>)this.getHibernateTemplate().find("select nhClass from NewsHead group by nhClass");
	}
	
	/**
	 * 通过类型查找新闻头
	 * @param nhClass
	 * @return
	 */
	public List<NewsHead> findBynhClass(String nhClass){
		return (List<NewsHead>)this.getHibernateTemplate().find("from NewsHead where nhClass=?",nhClass);
	}
}
