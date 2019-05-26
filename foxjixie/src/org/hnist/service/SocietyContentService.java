package org.hnist.service;

import java.util.List;

import org.hnist.dao.SocietyContentDao;
import org.hnist.modul.SocietyContent;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SocietyContentService {

	private SocietyContentDao societyContentDao;

	public void setSocietyContentDao(SocietyContentDao societyContentDao) {
		this.societyContentDao = societyContentDao;
	}
	
	
	/**
	 * 插入数据的方法
	 * @param societyContent
	 * @return
	 */
	public boolean insertSocietyContent(SocietyContent societyContent){
		
		try{
			List<SocietyContent> sclist=societyContentDao.findAllSocietyContent();
			societyContent.setScid(sclist.size());
			societyContentDao.saveSocietyContent(societyContent);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 更新数据的方法
	 * @param societyContent
	 * @return
	 */
	public boolean updateSocietyContent(SocietyContent societyContent){
		
		try{
			societyContentDao.updateSocietyContent(societyContent);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除数据的方法
	 * @param scid
	 * @return
	 */
	public boolean deleteSocietyContent(Integer scid){
		try{
			if(this.existSocietyContent(scid)){
				societyContentDao.deleteSocietyContent(scid);
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 查找所有的资源类型
	 * @return
	 */
	public List<String> findAllContentClass(){
		return societyContentDao.findContentClass();
	}
	
	/**
	 * 通过资源类型查找资源
	 * @param contentClass
	 * @return
	 */
	public List<SocietyContent> findAllByContentClass(String contentClass){
		return societyContentDao.findByContentClass(contentClass);
	}
	
	/**
	 * 通过序号查找资源
	 * @param scid
	 * @return
	 */
	public SocietyContent findByScid(Integer scid){
		return societyContentDao.findByScid(scid).get(0);
	}
	
	/**
	 * 判断是否存在 
	 * @param scid
	 * @return
	 */
	public boolean existSocietyContent(Integer scid){
		List<SocietyContent> sclist=societyContentDao.findByScid(scid);
		if(sclist.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
}
