package org.hnist.action;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hnist.modul.ImageFile;
import org.hnist.modul.Images;
import org.hnist.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ImageAction extends ActionSupport implements ModelDriven<ImageFile>  {
	
	private ImageFile imagefile=new ImageFile();
	private Images imge=new Images();
	
	
	
	public ImageFile getModel() {
		// TODO Auto-generated method stub
		return imagefile;
	}

	public ImageFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(ImageFile imagefile) {
		this.imagefile = imagefile;
	}

	public Images getImge() {
		return imge;
	}

	public void setImge(Images imge) {
		this.imge = imge;
	}
	
	@Autowired
	private ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}
	
	@Resource
	public void setImageService(ImageService imgService) {
		this.imageService = imgService;
	}
	
	
	
	//用于存储imges对象
	private List<Images> imges;
	

	public List<Images> getImges() {
		return imges;
	}

	public void setImges(List<Images> imges) {
		this.imges = imges;
	}

	
	
	

	 /**
	  * 保存文件	
	  * @return
	  * @throws Exception
	  */
	public String uploadImg()  throws Exception{
		
		
		//System.out.println("uploadImage start");
	
		//文件信息存放文件夹
		String path="G:\\Myeclips-workspace\\apache-tomcat-8.5.12\\webapps\\foxjixie\\images\\upload\\";
		
		//云服务器地址
		//String path="C:\\Tomcat 8.0\\webapps\\foxjixie\\images\\upload\\";
		
		System.out.println("path:"+path);
		
		//初始化文件路径
		File file=new File(path);
		
		//若不存在此文件目录则新建目录
		if(!file.exists()){
			file.mkdir();
		}
		
		//获取当前时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String newImageName=sdf.format(date);
		String fileName=null;
	
			
			//将文件保存在此目录下
			FileUtils.copyFile(imagefile.getImge01(), new File(file,"01"+newImageName+".jpg"));
			fileName="/images/upload/"+"01"+newImageName+".jpg";
			imge.setImg01(fileName);
			
			FileUtils.copyFile(imagefile.getImge02(), new File(file,"02"+newImageName+".jpg"));
			fileName="/images/upload/"+"02"+newImageName+".jpg";
			imge.setImg02(fileName);
			
			FileUtils.copyFile(imagefile.getImge03(), new File(file,"03"+newImageName+".jpg"));
			fileName="/images/upload/"+"03"+newImageName+".jpg";
			imge.setImg03(fileName);
			
			FileUtils.copyFile(imagefile.getImge04(), new File(file,"04"+newImageName+".jpg"));
			fileName="/images/upload/"+"04"+newImageName+".jpg";
			imge.setImg04(fileName);
			
			FileUtils.copyFile(imagefile.getImge05(), new File(file,"05"+newImageName+".jpg"));
			fileName="/images/upload/"+"05"+newImageName+".jpg";
			imge.setImg05(fileName);
			
			SimpleDateFormat sdft=new SimpleDateFormat("yyyyMMdd");
			imge.setImgTime(sdft.format(date));
			
			imageService.saveImage(imge);
			
			System.out.println("date "+newImageName);
			System.out.println("fileName "+fileName);
			
			return SUCCESS;
	}
	 

	/**
	 * 显示首页图片
	 * @return
	 */
	public String queryPictures(){
		imges=imageService.findIndexImages();
		return SUCCESS;
	}
	
	/**
	 * 显示所有的首页图片选项列表
	 * @return
	 */
	public String queryAllPictures(){
		imges=imageService.findAllImages();
		return SUCCESS;
	}

	/**
	 * 通过序号删除图片
	 * @return
	 */
	public String deleteImages(){
		Integer id=Integer.parseInt(getParam("param"));
		Images img=imageService.findImagById(id);
		
		//String path="G:\\Myeclips-workspace\\apache-tomcat-8.5.12\\webapps\\foxjixie\\images\\upload\\";
		
		//云服务器地址
		String path="C:\\Tomcat 8.0\\webapps\\foxjixie\\images\\upload\\";
		
		//先删除目录中的图片
		File file01=new File(path,img.getImg01().substring(img.getImg01().length()-20,img.getImg01().length()));
		if(file01.exists()){
			file01.delete();
		}
		File file02=new File(path,img.getImg02().substring(img.getImg02().length()-20,img.getImg02().length()));
		if(file02.exists()){
			file02.delete();
		}
		File file03=new File(path,img.getImg03().substring(img.getImg03().length()-20,img.getImg03().length()));
		if(file03.exists()){
			file03.delete();
		}
		File file04=new File(path,img.getImg04().substring(img.getImg04().length()-20,img.getImg04().length()));
		if(file04.exists()){
			file04.delete();
		}
		File file05=new File(path,img.getImg05().substring(img.getImg05().length()-20,img.getImg05().length()));
		if(file05.exists()){
			file05.delete();
		}
		
		//删除数据库记录
		if(imageService.deleteImages(id)){
			
			imges=imageService.findAllImages();
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	/**
	 * 更改首页照片
	 * @return
	 */
	public String setupImages(){
		Integer id=Integer.parseInt(getParam("param"));
		if(imageService.setupImages(id)){
			imges=imageService.findAllImages();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	

	//获取页面返回数据的参数
	protected String getParam(String key){
		//System.out.print(ServletActionContext.getRequest().getParameter(key));
		return ServletActionContext.getRequest().getParameter(key);
	}
}
