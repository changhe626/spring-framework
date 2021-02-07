package com.onyx.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


	public boolean login(String username){
		return "cc".equals(username);
	}

}
