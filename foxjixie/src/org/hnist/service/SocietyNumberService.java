package org.hnist.service;

import java.util.List;

import org.hnist.dao.SocietyNumberDao;
import org.hnist.modul.ContactInformation;
import org.hnist.modul.Devhistory;
import org.hnist.modul.SocietyNumber;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SocietyNumberService {

	private SocietyNumberDao societyNumberDao;

	public void setSocietyNumberDao(SocietyNumberDao societyNumberDao) {
		this.societyNumberDao = societyNumberDao;
	}
	
	/**
	 * 插入数据的方法
	 * @param societyNumber
	 * @return
	 */
	public boolean insertSocietyNumber(SocietyNumber societyNumber){
		societyNumberDao.saveSocietyNumber(societyNumber);
		return true;
	}
	
	/**
	 * 判断是否为空
	 * @param snid
	 * @return
	 */
	public boolean existSocietyNumber(Integer snid){
		if(societyNumberDao.getByid(snid).getSnId()==null || " ".equals(societyNumberDao.getByid(snid).getSnId())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除数据的方法
	 * @param snid
	 * @return
	 */
	public boolean deleteSocietyNumber(Integer snid){
		if(this.existSocietyNumber(snid)){

		}else{
			societyNumberDao.deleteSocietyNumber(snid);
			
		}
		return true;
	}
	
	/**
	 * 更新数据的方法
	 * @param sn
	 * @return
	 */
	public boolean updateSocietyNumber(SocietyNumber sn){
		societyNumberDao.updateSocietyNumber(sn);
		return true;
	}
	
	/**
	 * 通过任届查找所有任职人员情况
	 * @param societyTerm
	 * @return
	 */
	public List<SocietyNumber> findBySocietyTerm(String societyTerm){
		return societyNumberDao.findBySocietyTerm(societyTerm);
		
	}
	
	/**
	 * 查找所有的任届情况
	 * @return
	 */
	public List<String> findAllSocietyTerm(){
		return societyNumberDao.findTermYears();
	}
	
	/**
	 * 通过序号查找对象
	 * @param snid
	 * @return
	 */
	public SocietyNumber findBySnid(Integer snid){
		return societyNumberDao.findBySnid(snid).get(0);
	}
	
	/**
	 * 查找所有的社团成员
	 * @return
	 */
	public List<SocietyNumber> findAllSoicetyNumber(){
		return societyNumberDao.findAllSocietyNumber();
	}

	/************************************************
	 * 
	 * 
	 * 此处为关于我们的service 不再用另外的service进行调控
	 * 
	 * 
	 *************************************************/
	
	/**
	 * 查找所有的联系方法
	 * @return
	 */
	public List<ContactInformation> findAllContactInformat(){
		return societyNumberDao.findAllContactInformation();
	}
	
	/**
	 * 查找所有的发展历史
	 * @return
	 */
	public List<Devhistory> findAllDevhistroy(){
		return societyNumberDao.findAllDevhistory();
	}
	
}
