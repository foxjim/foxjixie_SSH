package org.hnist.dao;

import java.util.List;

import org.hnist.modul.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户基本注册信息的DAO
 * @author liuyun
 *
 */

public class UserDao extends HibernateDaoSupport{
	
	/**
	 * 保存用户的方法
	 * @param user 用户对象
	 * 主要用于注册使用
	 * 
	 */
	public void saveUser(User user){
		this.getHibernateTemplate().save(user);
	}
	
	/**
	 * 删除用户的方法
	 * @param uid 序号
	 */
	public void deleteUser(Integer uid){
		User user=getUserId(uid);
		this.getHibernateTemplate().delete(user);
	}
	
	/**
	 * 更新用户信息的方法
	 * @param uid
	 */
	public void updateUser(User user){
		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * 根据序号获取用户对象
	 * @param uid 序号
	 * @return
	 */
	public User getUserId(Integer uid){
		return (User)this.getHibernateTemplate().load(User.class, uid);
	}
	
	/**
	 * 通过序号查找该用户
	 * @param uid
	 * @return
	 */
	public List<User> findUserById(Integer uid){
		return (List<User>)this.getHibernateTemplate().find("from User where userid=?",uid);
	}
	
	/**
	 * 通过学号查找用户
	 * @param userCount
	 * @return
	 */
	public List<User> findByUserNo(String userNo){
		return (List<User>)this.getHibernateTemplate().find("from User where userNo=?",userNo);
	}
	
	/**
	 * 通过账号查找用户
	 * @param userCount
	 * @return
	 */
	public List<User> findByUserCount(String userCount){
		return (List<User>)this.getHibernateTemplate().find("from User where userCount=?",userCount);
	}
	
	/**
	 * 通过用户真实姓名查找账号
	 * @param userName
	 * @return
	 */
	public List<User> findByUserName(String userName){
		return (List<User>)this.getHibernateTemplate().find("from User where userName=?",userName);
	}
	
	/**
	 * 通过用户电话号码查找账号
	 * @param userName
	 * @return
	 */
	public List<User> findBytelPhone(String telPhone){
		return (List<User>)this.getHibernateTemplate().find("from User where telPhone=?",telPhone);
	}
	
	/**
	 * 通过账号密码获取User
	 * @param userCount 账号
	 * @param password  密码
	 * @return
	 */
	public List<User> findByUser(String userCount,String password){
		return (List<User>)this.getHibernateTemplate().find("from User where userCount=? and password=?",userCount,password);
	}
	
	
	
	
	/**
	 * 查找账号
	 * @param telPhone 手机号码
	 * @param userName	姓名
	 * @return
	 */
	public List<User> findUser(String telPhone,String userName){
		return (List<User>)this.getHibernateTemplate().find("from User where userName=?  and telPhone=?",userName,telPhone);
	}
	
	
	/**
	 * 找到所有的User对象
	 * @return
	 */
	public List<User> findAllUser(){
		return (List<User>)this.getHibernateTemplate().find("from User order by id");
	}

}
