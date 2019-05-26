package org.hnist.service;

import java.util.List;

import org.hnist.dao.SocietyCultureDao;
import org.hnist.modul.SocietyCulture;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SocietyCultureService {

	private SocietyCultureDao societyCultureDao;

	public void setSocietyCultureDao(SocietyCultureDao societyCultureDao) {
		this.societyCultureDao = societyCultureDao;
	}
	
	/**
	 * 导入数据的方法
	 * @param sc
	 * @return
	 */
	public boolean insertSocietyCulture(SocietyCulture sc){
		try{
			List<SocietyCulture> sclist=societyCultureDao.findAllSocietyCulture();
			sc.setScid(sclist.size());
			societyCultureDao.saveSocietyCuluture(sc);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 是否存在社团文化
	 * @param scid
	 * @return
	 */
	public boolean existSocietyCulture(Integer scid){
		List<SocietyCulture> sclist=societyCultureDao.findByScid(scid);
		if(sclist.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除社团文化
	 * @param scid
	 * @return
	 */
	public boolean deleteSocietyCulture(Integer scid){
		if(this.existSocietyCulture(scid)){
			societyCultureDao.deleteSocietyCulture(scid);
		}
		
		return true;
	}
	
	/**
	 * 更新数据的方法
	 * @param sc
	 * @return
	 */
	public boolean updateSocietyCulture(SocietyCulture sc){
		try{
			societyCultureDao.updateSocietyCulture(sc);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 *	通过序号查找数据
	 * @param scid
	 * @return
	 */
	public SocietyCulture findSCByScid(Integer scid){
		return societyCultureDao.findByScid(scid).get(0);
	}
	
	/**
	 * 查找所有的文化类型
	 * @return
	 */
	public List<String> queryAllCultureClass(){
		return societyCultureDao.findAllCultureClass();
	}
	
	/**
	 * 通过文化资源类型查找资源
	 * @param cultureClass
	 * @return
	 */
	public List<SocietyCulture> querySocietyCultureBySC(String cultureClass){
		return societyCultureDao.findByCultureClass(cultureClass);
	}
	
	
	/**
	 * 查找所有的资源
	 * @return
	 */
	public List<SocietyCulture> queryAllSocietyCulture(){
		return societyCultureDao.findAllSocietyCulture();
	}
}
