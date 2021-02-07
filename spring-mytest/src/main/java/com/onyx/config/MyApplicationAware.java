package com.onyx.config;

import com.onyx.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 这里一定要有@Component, 否则就是个独立的个体, 无法注入.
 */
@Component
public class MyApplicationAware implements ApplicationContextAware {

	/**
	 * 第 2种获取application的方式, 直接注入
	 */
	@Autowired
	private ApplicationContext app2;


	/**
	 * 第一种获取application的方式, 直接实现此接口.
	 *
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		boolean cc = applicationContext.getBean(UserDao.class).login("cc");
		System.out.println("2" + cc);

		boolean cc3 = app2.getBean(UserDao.class).login("cc");
		System.out.println("3" + cc3);


	}
}
