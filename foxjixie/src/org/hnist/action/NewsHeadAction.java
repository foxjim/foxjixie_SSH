package org.hnist.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hnist.modul.NewsHead;
import org.hnist.modul.NewsHeadList;
import org.hnist.service.NewsHeadService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsHeadAction extends ActionSupport implements ModelDriven<NewsHead> {

	private NewsHead newsHead=new NewsHead();
	
	public NewsHead getModel() {
		// TODO Auto-generated method stub
		return newsHead;
	}
	@Autowired
	private NewsHeadService newsHeadService;

	public NewsHead getNewsHead() {
		return newsHead;
	}

	public void setNewsHead(NewsHead newsHead) {
		this.newsHead = newsHead;
	}

	public NewsHeadService getNewsHeadService() {
		return newsHeadService;
	}
	
	@Resource
	public void setNewsHeadService(NewsHeadService newsHeadService) {
		this.newsHeadService = newsHeadService;
	}
	
	//进行Newshead组装的List
	private List<NewsHead> newsHeads;
	
	//页面显示的实体类
	private List<NewsHeadList> newsHeadLists;

	public List<NewsHead> getNewsHeads() {
		return newsHeads;
	}

	public void setNewsHeads(List<NewsHead> newsHeads) {
		this.newsHeads = newsHeads;
	}

	

	public List<NewsHeadList> getNewsHeadLists() {
		return newsHeadLists;
	}

	public void setNewsHeadLists(List<NewsHeadList> newsHeadLists) {
		this.newsHeadLists = newsHeadLists;
	}

	/**
	 * 查找所有的数据
	 * @return
	 */
	public String queryNewsHead(){
		List<String> slist=newsHeadService.findAllnhClass();
		List<NewsHeadList> listNewsHeadList=new ArrayList<NewsHeadList>();
		NewsHeadList listnh;
		
		for(int i=0;i<slist.size();i++){
			listnh=new NewsHeadList();
			List<NewsHead> listnhs=newsHeadService.findBynhClass(slist.get(i));
			
			//倒叙
			Collections.reverse(listnhs);
			listnh.setNhlist(listnhs);
			listnh.setNtTime(Integer.valueOf(slist.get(i)));
			
			listNewsHeadList.add(listnh);
		}
		
		newsHeadLists=listNewsHeadList;
		
		//倒叙
		Collections.reverse(newsHeadLists);
		
		return SUCCESS;
	}
	
	/**
	 * 删除数据
	 * @return
	 */
	public String deleteNewsHead(){
		if(newsHeadService.deleteNewsHead(Integer.valueOf(this.getParam("nhid")))){
			this.queryNewsHead();
			return SUCCESS;
		}else{
			return "ERROR";
		}
	}
	
	/**
	 * 导入数据的方法
	 * @return
	 */
	public String insertNewsHead(){
		if(newsHeadService.saveNewsHead(newsHead)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 编辑新闻头的方法
	 * @return
	 */
	public String editNewsHead(){
		Integer temp=Integer.valueOf(this.getParam("temp"));
		
		if(temp==0){
			Integer nhid=Integer.valueOf(this.getParam("nhid"));
			newsHead=newsHeadService.findByNhid(nhid);
			return "edit";
		}else if(temp==1){
			if(newsHeadService.updateNewsHead(newsHead)){
				this.queryNewsHead();
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 更新 使用链接的方法
	 * @return
	 */
	public String updateUserLink(){
		Integer nhid=Integer.valueOf(this.getParam("nhid"));
		String userLink=this.getParam("userLink");
		
		if(newsHeadService.updateUserLink(nhid, userLink)){
			this.queryNewsHead();
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
