package org.hnist.service;

import java.util.List;

import org.hnist.dao.AdminUserDao;
import org.hnist.modul.adminUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AdminUserService {
	
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	/**
	 * 导入数据的方法
	 * @param au
	 * @return
	 */
	public boolean insertAdminUser(adminUser au){
		try{
			List<adminUser> aulist=adminUserDao.findAllAdminUser();
			au.setAduid(aulist.size());
			adminUserDao.saveAdminUser(au);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * 是否存在此类数据
	 * @param auid
	 * @return
	 */
	public boolean existAdminUser(Integer auid){
		List<adminUser> auList=adminUserDao.findByAuid(auid);
		if(auList.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除数据的方法
	 * @param auid
	 * @return
	 */
	public boolean deleteAdminUser(Integer auid){
		try{
			if(this.existAdminUser(auid)){
				adminUserDao.deleteAdminUser(auid);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 更新数据的方法
	 * @param au
	 * @return
	 */
	public boolean updateAdminUser(adminUser au){
		try{
			adminUserDao.updateAdminUser(au);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 通过姓名和联系方式查找
	 * @param adName			姓名
	 * @param adPhoneNumber		电话号码
	 * @return
	 */
	public boolean findByNamePNO(String adName,String adPhoneNumber){
		try{
			List<adminUser> aulist=adminUserDao.findByNamePNo(adName, adPhoneNumber);
			if(aulist.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<adminUser> findAllAdminUser(){
		try{
			return adminUserDao.findAllAdminUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 登陆的方法
	 * @param name		姓名
	 * @param password	密码
	 * @return
	 */
	public boolean loginAdminUser(String name,String password){
		List<adminUser> aulist=adminUserDao.findByNamePassword(name, password);
		if(aulist.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据姓名查找账号
	 * @param an 姓名
	 * @return
	 */
	public adminUser findByadName(String an){
		return adminUserDao.findByName(an).get(0);
	}

}
