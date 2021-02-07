package com.onyx.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.stereotype.Component;

/**
 * 自定义bean的名字生成器
 */
public class MyBeanNameGenerator implements BeanNameGenerator {

	/**
	 * 对@Configuration 注解的类不能重命名, 只能修改@Service这样的普通类的重新命名
	 * @param definition the bean definition to generate a name for
	 * @param registry the bean definition registry that the given definition
	 * is supposed to be registered with
	 * @return
	 */
	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String beanClassName = definition.getBeanClassName();
		int indexOf = beanClassName.lastIndexOf(".");
		if (indexOf != -1) {
			//前面加一个 my
			return "my"+beanClassName.substring(indexOf + 1, beanClassName.length());
		}
		return null;
	}
}
