package org.hnist.service;

import java.util.List;

import org.hnist.dao.NewsHeadDao;
import org.hnist.modul.NewsHead;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class NewsHeadService {
	
	private NewsHeadDao newsHeadDao;

	public void setNewsHeadDao(NewsHeadDao newsHeadDao) {
		this.newsHeadDao = newsHeadDao;
	}
	
	/**
	 * 是否存在新闻
	 * @param nhid
	 * @return
	 */
	public boolean existNewsHead(Integer nhid){
		if(newsHeadDao.findByNhid(nhid).size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 保存此新闻
	 * @param nh
	 * @return
	 */
	public boolean saveNewsHead(NewsHead nh){
		try{
			List<NewsHead> nhlist=newsHeadDao.findAllNewsHead();
			nh.setNhClass(nh.getNhTime().substring(0, 4));
			nh.setNhid(nhlist.size());
			nh.setUserLink("0");
			newsHeadDao.saveNewsHead(nh);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**
	 * 更新数据的方法
	 * @param nh
	 * @return
	 */
	public boolean updateNewsHead(NewsHead nh){
		try{
			nh.setNhClass(nh.getNhTime().substring(0, 4));
			newsHeadDao.updateNewHead(nh);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * **************************************未完待续*******************************
	 * 删除数据的方法
	 * @param nhid
	 * @return
	 */
	public boolean deleteNewsHead(Integer nhid){
		try{
			if(this.existNewsHead(nhid)){
				newsHeadDao.deleteNewsHead(nhid);
			}
			
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 查找所有的新闻类型
	 * @return
	 */
	public List<String> findAllnhClass(){
		return newsHeadDao.findnhClass();
	}
	
	/**
	 * 通过新闻类型查找数据
	 * @param nhClass
	 * @return
	 */
	public List<NewsHead> findBynhClass(String nhClass){
		return newsHeadDao.findBynhClass(nhClass);
	}
	
	/**
	 * 通过序号查找数据
	 * @param nhid
	 * @return
	 */
	public NewsHead findByNhid(Integer nhid){
		return newsHeadDao.findByNhid(nhid).get(0);
	}
	
	/**
	 * 调换使用链接的方法
	 * @param nhid
	 * @param userLink
	 * @return
	 */
	public boolean updateUserLink(Integer nhid,String userLink){
		try{
			NewsHead nh=this.findByNhid(nhid);
			nh.setUserLink(userLink);
			newsHeadDao.updateNewHead(nh);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
}
