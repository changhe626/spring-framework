package com.onyx.service;

import com.onyx.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {

	/**
	 * @Autowired 默认使用type的, 如果type没有找到, 就根据属性名再找,
	 * 否则就报错了,
	 * 在属性上的时候, 通过反射的方式进行属性的注入,不适用set方法
	 * 可以配合 @Qualifier使用 设置bean的名字
	 * 这是spring的注解
	 * @Resource() 可以指定名字和类型, 根据属性名注入.跟set方法的名字无关
	 * 这是java标准的注解
	 */
	//@Autowired
	@Resource
	private UserDao userDao;

	public boolean login(String name) {
		boolean login = userDao.login(name);
		return login;
	}

}
