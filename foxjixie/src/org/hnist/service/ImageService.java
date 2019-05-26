package org.hnist.service;

import java.util.List;

import org.hnist.dao.ImageDao;
import org.hnist.modul.Images;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ImageService {

	private ImageDao imageDao;


	public void setImageDao(ImageDao imgDao) {
		this.imageDao = imgDao;
	}
	
	
	/**
	 * 保存数据的方法
	 * @param img
	 * @return
	 */
	public boolean saveImage(Images img){
		List<Images> ilist=imageDao.findAllImage();
		img.setIid(ilist.size());
		img.setImgOk("0");
		imageDao.saveImage(img);
		return true;
	}
	
	/**
	 * 查找首页轮播图片
	 * @return
	 */
	public List<Images> findIndexImages(){
		List<Images> ilist=imageDao.findAllImage();
		if(ilist.size()==0){
			Images img=new Images();
			img.setIid(0);
			img.setImg01("/front/img/img1.jpg");
			img.setImg02("/front/img/img2.jpg");
			img.setImg03("/front/img/img3.jpg");
			img.setImg04("/front/img/img4.jpg");
			img.setImg05("/front/img/img5.jpg");
			
			ilist.add(img);
			return ilist;
		}else{
			//设置初始值为数据库的初始值
			int chooseId=ilist.get(0).getIid();
			for(int i=0;i<ilist.size();i++){
				Images showimage=ilist.get(i);
				if(showimage.getImgOk().equals("1")){
					chooseId=showimage.getIid();
				}
			}
			//System.out.println("chooseId:"+chooseId);
			return imageDao.findImageById(chooseId);
		}
		
	}
	
	/**
	 * 查找所有的首页图片选项
	 * @return
	 */
	public List<Images> findAllImages(){
		return imageDao.findAllImage();
	}
	
	/**
	 * 判断是否存在
	 * @param iid
	 * @return
	 */
	public boolean existDeleteImages(Integer iid){
		if(imageDao.findImageById(iid).isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 删除图片
	 * @param iid 序号
	 * @return
	 */
	public boolean deleteImages(Integer iid){
		if(this.existDeleteImages(iid)){
			imageDao.deleteImg(iid);
		}
		
		return true;
	}
	
	/**
	 * 设置更改首页照片
	 * @param iid 图片Id
	 * @return
	 */
	public boolean setupImages(Integer iid){
		
		//查询所有的Images
		List<Images> ilist=imageDao.findAllImage();
		
		//设置imageOk=1的图片为0
		for(int i=0;i<ilist.size();i++){
			Images img=ilist.get(i);
			if(img.getImgOk().equals("1")){
				img.setImgOk("0");
			}
		}
		
		//通过id设置需要设置启用的images的ok值为1
		List<Images> imgs=imageDao.findImageById(iid);
		Images img=imgs.get(0);
		img.setImgOk("1");
		imageDao.updateImage(img);
		
		return true;
	}
	
	public Images findImagById(Integer iid){
		List<Images> imgs=imageDao.findImageById(iid);
		
		return imgs.get(0);
		
	}
}
