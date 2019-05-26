package org.hnist.dao;

import java.util.List;

import org.hnist.modul.NewsContent;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NewsContentDao extends HibernateDaoSupport{
	
	public void saveNewsContent(NewsContent nc){
		this.getHibernateTemplate().save(nc);
	}
	
	public void updateNewsContent(NewsContent nc){
		this.getHibernateTemplate().update(nc);
	}
	
	public NewsContent getNewsContent(Integer ncid){
		return this.getHibernateTemplate().load(NewsContent.class, ncid);
	}
	
	public void deleteNewsContent(Integer ncid){
		this.getHibernateTemplate().delete(this.getNewsContent(ncid));
	}
	
	public List<NewsContent> findByNcid(Integer ncid){
		return (List<NewsContent>)this.getHibernateTemplate().find("from NewsContent where ncid=?",ncid);
	}
	
	public List<NewsContent> findByNhid(Integer nhid){
		return (List<NewsContent>)this.getHibernateTemplate().find("from NewsContent where nhid=?",nhid);
	}
	
	public List<NewsContent> findAll(){
		return (List<NewsContent>)this.getHibernateTemplate().find("from NewsContent order by id");
	}
}
