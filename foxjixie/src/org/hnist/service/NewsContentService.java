package org.hnist.service;

import java.util.List;

import org.hnist.dao.NewsContentDao;
import org.hnist.modul.NewsContent;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class NewsContentService{
	
	private NewsContentDao newsContentDao;

	public void setNewsContentDao(NewsContentDao newsContentDao) {
		this.newsContentDao = newsContentDao;
	}
	
	/**
	 * 是否存在这个内容
	 * @param ncid 新闻内容id
	 * @return
	 */
	public boolean existNewsContent(Integer ncid){
		if(newsContentDao.getNewsContent(ncid)!=null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 保存数据
	 * @param newsContent
	 */
	public void saveNewsContent(NewsContent newsContent){
		
		try{
			List<NewsContent> nclist=newsContentDao.findAll();
			newsContent.setNcid(nclist.size());
			newsContentDao.saveNewsContent(newsContent);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除新闻内容
	 * @param ncid
	 */
	public void deleteNewsContent(Integer ncid){
		try{
			newsContentDao.deleteNewsContent(ncid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过序号查找
	 * @param ncid
	 * @return
	 */
	public NewsContent findByNcid(Integer ncid){
		return newsContentDao.findByNcid(ncid).get(0);
	}
	
	/**
	 * 通过新闻序号查找
	 * @param nhid
	 * @return
	 */
	public NewsContent findByNhid(Integer nhid){
		return newsContentDao.findByNhid(nhid).get(0);
	}
	
	public List<NewsContent> findAllNewsContent(){
		return newsContentDao.findAll();
	}
	
}
