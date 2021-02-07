package com.onyx;


import com.onyx.config.TestConfig;
import com.onyx.service.UserService;
import com.onyx.service.UserServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TestConfig.class);
		UserService bean = context.getBean(UserService.class);
		System.out.println("1" + bean.login("cc"));

		//aop代理
		System.out.println("5" + (bean instanceof UserService));
		System.out.println("6" + (bean instanceof UserServiceImpl2));


	}

}
