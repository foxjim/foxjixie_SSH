package org.hnist.dao;

import java.util.List;

import org.hnist.modul.adminUser;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminUserDao extends HibernateDaoSupport{

	/**
	 * 保存数据的方法
	 * @param au
	 */
	public void saveAdminUser(adminUser au){
		this.getHibernateTemplate().save(au);
	}
	
	/**
	 * 更新数据的方法
	 * @param au
	 */
	public void updateAdminUser(adminUser au){
		this.getHibernateTemplate().update(au);
	}
	
	/**
	 * 通过序号查找-惰性查找
	 * @param auid
	 * @return
	 */
	public adminUser getAdminUser(Integer auid){
		return this.getHibernateTemplate().load(adminUser.class, auid);
	}
	
	/**
	 * 删除数据的方法
	 * @param auid
	 */
	public void deleteAdminUser(Integer auid){
		this.getHibernateTemplate().delete(this.getAdminUser(auid));				
	}
	
	/**
	 * 通过序号查找
	 * @param auid
	 * @return
	 */
	public List<adminUser> findByAuid(Integer auid){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser where aduid=?",auid);
	}
	
	/**
	 * 通过部门和职位查找
	 * @param adDepartment 部门
	 * @param adPosition 职位
	 * @return
	 */
	public List<adminUser> findByDePo(String adDepartment,String adPosition){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser where adDepartment=? and adPosition=?",adDepartment,adPosition);
	}
	
	/**
	 * 通过电话号码和姓名查找
	 * @param adName 姓名
	 * @param adPhoneNumber 电话号码
	 * @return
	 */
	public List<adminUser> findByNamePNo(String adName,String adPhoneNumber){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser where adName=? and adPhoneNumber=?",adName,adPhoneNumber);
	}
	
	/**
	 * 通过姓名和密码登陆
	 * @param name			姓名
	 * @param password		密码
	 * @return
	 */
	public List<adminUser> findByNamePassword(String name,String password){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser where adName=? and adPassword=?",name,password);
	}
	
	public List<adminUser> findByName(String an){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser where adName=?",an);
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<adminUser> findAllAdminUser(){
		return (List<adminUser>)this.getHibernateTemplate().find("from adminUser order by id");
	}
}
