package org.hnist.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.NewsContent;
import org.hnist.service.NewsContentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsContentAction extends ActionSupport implements ModelDriven<NewsContent> {

	private NewsContent newsContent=new NewsContent();
	
	public NewsContent getModel() {
		// TODO Auto-generated method stub
		return newsContent;
	}
	
	@Autowired
	private NewsContentService newsContentService;

	public NewsContent getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(NewsContent newsContent) {
		this.newsContent = newsContent;
	}

	public NewsContentService getNewsContentService() {
		return newsContentService;
	}

	@Resource
	public void setNewsContentService(NewsContentService newsContentService) {
		this.newsContentService = newsContentService;
	}
	
	private List<NewsContent> newsContents;
	
	
	public List<NewsContent> getNewsContents() {
		return newsContents;
	}

	public void setNewsContents(List<NewsContent> newsContents) {
		this.newsContents = newsContents;
	}

	/**
	 * 导入数据的方法
	 * @return
	 */
	public String insertNewsContent(){
		newsContent.setNcContent(this.getParam("myEditor"));
		newsContentService.saveNewsContent(newsContent);
		newsContent=newsContentService.findAllNewsContent().get(0);
		return SUCCESS;
	}

	public String findContentShowByNcid(){
		Integer ncid=Integer.valueOf(this.getParam("ncid"));
		newsContent=newsContentService.findByNcid(ncid);
		return SUCCESS;
	}
	
	public String allNewsContent(){
		newsContents=newsContentService.findAllNewsContent();
		return SUCCESS;
	}
	//获取页面返回数据的参数
		protected String getParam(String key){
			//System.out.print(ServletActionContext.getRequest().getParameter(key));
			return ServletActionContext.getRequest().getParameter(key);
		}
}
