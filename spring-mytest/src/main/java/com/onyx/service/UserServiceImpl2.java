package com.onyx.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 当一个接口有多个实现类的时候, 一般注入都是通过接口的,
 * 会发生冲突, @Primary表示首先注入的是这个.
 *
 * 如果不加会报错
 */
@Primary
@Service
public class UserServiceImpl2 implements UserService {

	@Override
	public boolean login(String name) {
		return false;
	}
}
