package org.hnist.dao;

import java.util.List;

import org.hnist.modul.Images;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ImageDao extends HibernateDaoSupport{

	/**
	 * 保存图片
	 * @param img
	 */
	public void saveImage(Images img){
		this.getHibernateTemplate().save(img);
	}
	

	/**
	 * 通过id获取Images对象
	 * @param iid 序号
	 * @return
	 */
	private Images getIid(Integer iid) {
		return (Images)this.getHibernateTemplate().load(Images.class,iid);
	}
	
	/**
	 * 删除
	 * @param iid
	 */
	public void deleteImg(Integer iid){
		Images img=getIid(iid);
		this.getHibernateTemplate().delete(img);	
	}
	
	/**
	 * 根据image对象更新
	 * @param img 更新对象
	 */
	public void updateImage(Images img){
		this.getHibernateTemplate().update(img);
	}
	
	/**
	 * 通过序号查找所有的的Images（其实也就一个）
	 * @param iid
	 * @return
	 */
	public List<Images> findImageById(int iid){
		return (List<Images>)this.getHibernateTemplate().find("from Images where iid=?",iid);
	}

	
	/**
	 * 查找所有的对象
	 * @return
	 */
	public List<Images> findAllImage(){
		return (List<Images>)this.getHibernateTemplate().find("from Images order by id");
	}
}
