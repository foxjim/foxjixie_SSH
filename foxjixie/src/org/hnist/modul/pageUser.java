package org.hnist.modul;

import java.util.List;

/**
 * 会员的分页功能的实现
 * @author HELLO WORLD
 *
 */

public class pageUser {
	
	private List<User> ulist;	//数据集合
	private Integer eachPage;	//每页的个数
	private Integer allNumber;	//所有的数据
	
	private Integer currentPage;	//当前页
	private Integer upPage;		//上一页
	private Integer nextPage;	//下一页
	private Integer lastPage;	//尾页
	
	public void initPageUser(){
		
		//设置尾页 也是设置总页数
		if(ulist.size()%eachPage==0){
			this.lastPage=ulist.size()/eachPage;
		}else{
			this.lastPage=ulist.size()/(eachPage)+1;
		}
		//设置当前页
		if(currentPage<1){
			this.currentPage=1;
		}
		
		if(currentPage>lastPage){
			this.currentPage=lastPage;
		}
		
		//设置上一页
		if(currentPage==1){
			this.upPage=1;
			
		}else{
			this.upPage=currentPage-1;
		}
		
		//设置下一页
		if(currentPage==lastPage){
			this.nextPage=lastPage;
		}else{
			this.nextPage=currentPage+1;
		}
		
		//设置所有的数据
		this.allNumber =ulist.size();
	}
	
	
	
	
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setEachPage(Integer eachPage) {
		this.eachPage = eachPage;
	}
	

	public Integer getEachPage() {
		return eachPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public Integer getAllNumber() {
		return allNumber;
	}
	public Integer getUpPage() {
		return upPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public List<User> getUlist() {
		return ulist;
	}

	

}
