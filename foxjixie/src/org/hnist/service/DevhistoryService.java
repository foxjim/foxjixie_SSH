package org.hnist.service;

import java.util.List;

import org.hnist.dao.DevhistoryDao;
import org.hnist.modul.Devhistory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DevhistoryService {

	private DevhistoryDao devhistoryDao;

	public void setDevhistoryDao(DevhistoryDao devhistoryDao) {
		this.devhistoryDao = devhistoryDao;
	}
	
	
	/**
	 * 保存数据的方法
	 * @param devhistory
	 * @return
	 */
	public boolean saveDevhistory(Devhistory devhistory){
		List<Devhistory> dlist=devhistoryDao.findAllDevhistory();
		devhistory.setDhid(dlist.size());
		devhistoryDao.savaDevhistoryDao(devhistory);
		return true;
	}
	
	public boolean existDevhistory(Integer dhid){
		if(devhistoryDao.findByHdid(dhid).isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 删除对象
	 * @param dhid
	 * @return
	 */
	public boolean deleteDevhistory(Integer dhid){
		if(this.existDevhistory(dhid)){
			devhistoryDao.deleteDevhistory(dhid);
		}
		return true;
	}
	
	/**
	 * 更新数据的方法
	 * @param devhistory
	 * @return
	 */
	public boolean updateDevhistory(Devhistory devhistory){
		devhistoryDao.updateDevhistory(devhistory);
		return true;
	}
	
	/**
	 * 通过id查找数据
	 * @param dhid
	 * @return
	 */
	public List<Devhistory> findByDhid(Integer dhid){
		return devhistoryDao.findByHdid(dhid);
		
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<Devhistory> findAllDevhistroy(){
		return devhistoryDao.findAllDevhistory();
	}
}
