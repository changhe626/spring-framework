package com.onyx.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class UserDao {


	public boolean login(String username){
		return "cc".equals(username);
	}

	public UserDao() {
		System.out.println("userdao 构造方法");
	}

	/**
	 * 初始化方法, 再构造方法后执行, 每个只执行一次
	 */
	@PostConstruct
	public void init(){
		System.out.println("userdao 的 init 的方法");
	}

	/**
	 * 摧毁前执行的方法
	 */
	@PreDestroy
	public void redDestroy(){
		System.out.println("userdao preDestroy");
	}

}
