package com.kanbujian.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kanbujian.model.user;

public class userService {
	SessionFactory sessionFactory;
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void add(user u){
		Session userSession=sessionFactory.getCurrentSession();
		userSession.beginTransaction();
		userSession.save(u);
		userSession.getTransaction().commit();
		System.out.println(u.getUsername()+"保存成功！");
	}
	

}
